/*
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 * 
 * $Id: UML22UMLResourceHandler.java,v 1.2 2006/03/08 21:58:02 khussey Exp $
 */
package org.eclipse.uml2.uml.resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

public class UML22UMLResourceHandler
		extends BasicResourceHandler {

	protected static final boolean DEBUG = false;

	protected AnyType getExtension(XMLResource resource, EObject eObject) {
		return (AnyType) resource.getEObjectToExtensionMap().get(eObject);
	}

	protected AnyType putExtension(XMLResource resource, EObject eObject,
			AnyType extension) {
		return (AnyType) resource.getEObjectToExtensionMap().put(eObject,
			extension);
	}

	protected AnyType removeExtension(XMLResource resource, EObject eObject) {
		return (AnyType) resource.getEObjectToExtensionMap().remove(eObject);
	}

	protected Object getValue(FeatureMap featureMap, String name) {

		for (Iterator entries = featureMap.iterator(); entries.hasNext();) {
			FeatureMap.Entry entry = (FeatureMap.Entry) entries.next();

			if (name.equals(entry.getEStructuralFeature().getName())) {
				return entry.getValue();
			}
		}

		return null;
	}

	protected Collection getValues(FeatureMap featureMap, String name) {
		Collection values = new UniqueEList.FastCompare();

		for (Iterator entries = featureMap.iterator(); entries.hasNext();) {
			FeatureMap.Entry entry = (FeatureMap.Entry) entries.next();

			if (name.equals(entry.getEStructuralFeature().getName())) {
				values.add(entry.getValue());
			}
		}

		return values;
	}

	protected InternalEObject handleProxy(InternalEObject internalEObject) {

		if (internalEObject != null && internalEObject.eIsProxy()) {
			URI eProxyURI = internalEObject.eProxyURI();
			URI uri = (URI) UML22UMLExtendedMetadata.getURIMap().get(
				eProxyURI.trimFragment());

			if (uri != null) {
				String fragment = (String) UML22UMLExtendedMetadata
					.getFragmentMap().get(eProxyURI.fragment());

				if (fragment != null) {
					internalEObject.eSetProxyURI(uri.appendFragment(fragment));
				}
			}
		}

		return internalEObject;
	}

	public void postLoad(final XMLResource resource, InputStream inputStream,
			Map options) {
		final EList resourceContents = resource.getContents();
		final List annotationsToRemove = new ArrayList();

		UMLSwitch umlSwitch = new UMLSwitch() {

			public Object caseElement(Element element) {
				EAnnotation keywordsAnnotation = element
					.getEAnnotation("keywords"); //$NON-NLS-1$

				if (keywordsAnnotation != null) {
					keywordsAnnotation.setSource(UMLPackage.eNS_URI);
				}

				EAnnotation appliedStereotypesAnnotation = element
					.getEAnnotation("appliedStereotypes"); //$NON-NLS-1$

				if (appliedStereotypesAnnotation != null) {
					annotationsToRemove.add(appliedStereotypesAnnotation);

					EList contents = appliedStereotypesAnnotation.getContents();

					for (int i = contents.size(); i > 0;) {
						InternalEObject stereotypeApplication = (InternalEObject) contents
							.get(--i);

						UMLUtil.setBaseElement(stereotypeApplication, element);

						resourceContents.add(stereotypeApplication);
					}
				}

				return super.caseElement(element);
			}

			public Object caseExtensionEnd(ExtensionEnd extensionEnd) {
				String name = extensionEnd.getName();

				if (!UML2Util.isEmpty(name) && name.startsWith("extension$")) { //$NON-NLS-1$
					extensionEnd.setName(Extension.STEREOTYPE_ROLE_PREFIX
						+ name.substring(10));
				}

				AnyType extension = getExtension(resource, extensionEnd);

				if (extension != null
					&& getValue(extension.getMixed(), "lowerValue") == null) { //$NON-NLS-1$

					extensionEnd.setLower(1);
				}

				return super.caseExtensionEnd(extensionEnd);
			}

			public Object caseMultiplicityElement(
					MultiplicityElement multiplicityElement) {
				AnyType extension = getExtension(resource, multiplicityElement);

				if (extension != null) {
					ValueSpecification lowerValue = (ValueSpecification) getValue(
						extension.getMixed(), "lowerValue"); //$NON-NLS-1$

					if (lowerValue != null) {

						if (lowerValue instanceof LiteralInteger) {
							multiplicityElement
								.setLower(((LiteralInteger) lowerValue)
									.integerValue());
						} else {
							multiplicityElement.setLowerValue(lowerValue);
						}
					}

					ValueSpecification upperValue = (ValueSpecification) getValue(
						extension.getMixed(), "upperValue"); //$NON-NLS-1$

					if (upperValue != null) {

						if (upperValue instanceof LiteralUnlimitedNatural) {
							multiplicityElement
								.setUpper(((LiteralUnlimitedNatural) upperValue)
									.unlimitedValue());
						} else {
							multiplicityElement.setUpperValue(upperValue);
						}
					}
				}

				return super.caseMultiplicityElement(multiplicityElement);

			}

			public Object caseParameter(Parameter parameter) {
				AnyType extension = getExtension(resource, parameter);

				if (extension != null) {
					ValueSpecification defaultValue = (ValueSpecification) getValue(
						extension.getMixed(), "defaultValue"); //$NON-NLS-1$

					if (defaultValue != null) {
						String stringValue = defaultValue.stringValue();

						if (stringValue != null) {
							parameter.setDefault(stringValue);
						} else {
							parameter.setDefaultValue(defaultValue);
						}
					}
				}

				return super.caseParameter(parameter);
			}

			public Object caseProfileApplication(
					ProfileApplication profileApplication) {
				String profileName = null;
				InternalEObject internalEObject = (InternalEObject) profileApplication
					.eGet(
						UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE,
						false);

				if (internalEObject != null && internalEObject.eIsProxy()) {
					URI eProxyURI = internalEObject.eProxyURI();

					if (eProxyURI.segmentCount() > 0) {
						String segment0 = eProxyURI.segment(0);

						int index = segment0.indexOf('.');
						profileName = index == -1
							? segment0
							: segment0.substring(0, index);
					}
				}

				defaultCase(profileApplication);

				EAnnotation attributesAnnotation = profileApplication
					.getEAnnotation("attributes"); //$NON-NLS-1$

				if (attributesAnnotation != null) {
					attributesAnnotation.setSource(UMLPackage.eNS_URI);

					EMap details = attributesAnnotation.getDetails();
					String version = (String) details.get("version"); //$NON-NLS-1$

					if (!UML2Util.isEmpty(version)) {
						Profile appliedProfile = profileApplication
							.getAppliedProfile();

						if (profileName == null) {
							profileName = appliedProfile.getName();
						}

						if (appliedProfile != null) {
							EAnnotation eAnnotation = appliedProfile
								.getEAnnotation(UMLPackage.eNS_URI);

							if (eAnnotation != null) {
								EList contents = eAnnotation.getContents();

								for (int i = contents.size(); i > 0;) {
									EPackage ePackage = (EPackage) contents
										.get(--i);

									if (ePackage
										.getNsPrefix()
										.endsWith(
											UML2Util
												.getValidJavaIdentifier(profileName)
												+ '_' + version)) {

										attributesAnnotation.getReferences()
											.add(0, ePackage);
										break;
									}
								}
							}
						}
					}

					details.clear();
				}

				caseElement(profileApplication);

				return profileApplication;
			}

			public Object caseProfile(Profile profile) {
				defaultCase(profile);

				EAnnotation attributesAnnotation = profile
					.getEAnnotation("attributes"); //$NON-NLS-1$

				if (attributesAnnotation != null) {
					annotationsToRemove.add(attributesAnnotation);
				}

				EAnnotation ePackagesAnnotation = profile
					.getEAnnotation("ePackages"); //$NON-NLS-1$

				if (ePackagesAnnotation != null) {
					ePackagesAnnotation.setSource(UMLPackage.eNS_URI);

					new EcoreSwitch() {

						public Object caseEClass(EClass eClass) {
							EAnnotation stereotypeAnnotation = eClass
								.getEAnnotation("stereotype"); //$NON-NLS-1$

							if (stereotypeAnnotation != null) {
								stereotypeAnnotation
									.setSource(UMLPackage.eNS_URI);

								EList references = stereotypeAnnotation
									.getReferences();

								if (!references.isEmpty()) {
									Object reference = references.get(0);

									if (reference instanceof Stereotype) {
										Stereotype stereotype = (Stereotype) reference;

										for (Iterator ownedAttributes = stereotype
											.getOwnedAttributes().iterator(); ownedAttributes
											.hasNext();) {

											Property ownedAttribute = (Property) ownedAttributes
												.next();
											String name = ownedAttribute
												.getName();

											if (!UML2Util.isEmpty(name)
												&& name
													.startsWith(Extension.METACLASS_ROLE_PREFIX)) {

												Type type = ownedAttribute
													.getType();

												if (type instanceof org.eclipse.uml2.uml.Class) {
													org.eclipse.uml2.uml.Class class_ = (org.eclipse.uml2.uml.Class) type;

													if (class_.isMetaclass()) {
														EReference eReference = EcoreFactory.eINSTANCE
															.createEReference();
														eReference
															.setName(UML2Util
																.getValidJavaIdentifier(name));
														eReference
															.setEType(UMLPackage.eINSTANCE
																.getEClassifier(class_
																	.getName()));

														eClass
															.getEStructuralFeatures()
															.add(0, eReference);
													}
												}
											}
										}
									}
								}
							}

							return super.caseEClass(eClass);
						}

						public Object caseEEnum(EEnum eEnum) {

							for (Iterator eLiterals = eEnum.getELiterals()
								.iterator(); eLiterals.hasNext();) {

								EAnnotation enumerationLiteralAnnotation = ((EEnumLiteral) eLiterals
									.next())
									.getEAnnotation("enumerationLiteral"); //$NON-NLS-1$

								if (enumerationLiteralAnnotation != null) {
									annotationsToRemove
										.add(enumerationLiteralAnnotation);

									EList eEnumReferences = UML2Util
										.getEAnnotation(eEnum,
											UMLPackage.eNS_URI, true)
										.getReferences();

									if (eEnumReferences.isEmpty()) {
										EList eEnumLiteralReferences = enumerationLiteralAnnotation
											.getReferences();

										if (!eEnumLiteralReferences.isEmpty()) {
											Object reference = eEnumLiteralReferences
												.get(0);

											if (reference instanceof EnumerationLiteral) {
												eEnumReferences
													.add(((EnumerationLiteral) reference)
														.getEnumeration());
											}
										}
									}
								}
							}

							return super.caseEEnum(eEnum);
						}

						public Object defaultCase(EObject eObject) {

							for (Iterator eContents = eObject.eContents()
								.iterator(); eContents.hasNext();) {

								doSwitch((EObject) eContents.next());
							}

							return eObject;
						}
					}.doSwitch(ePackagesAnnotation);
				}

				caseElement(profile);

				return profile;
			}

			public Object caseProperty(Property property) {

				if (property.eGet(UMLPackage.Literals.PROPERTY__ASSOCIATION,
					false) instanceof Extension) {

					String name = property.getName();

					if (!UML2Util.isEmpty(name) && name.startsWith("base$")) { //$NON-NLS-1$
						property.setName(Extension.METACLASS_ROLE_PREFIX
							+ name.substring(5));
					}
				}

				AnyType extension = getExtension(resource, property);

				if (extension != null) {
					ValueSpecification defaultValue = (ValueSpecification) getValue(
						extension.getMixed(), "defaultValue"); //$NON-NLS-1$

					if (defaultValue != null) {
						String stringValue = defaultValue.stringValue();

						if (stringValue != null) {
							property.setDefault(stringValue);
						} else {
							property.setDefaultValue(defaultValue);
						}
					}
				}

				return super.caseProperty(property);
			}

			public Object defaultCase(EObject eObject) {
				AnyType extension = removeExtension(resource, eObject);

				if (extension != null && DEBUG) {
					System.out.println(eObject);
					System.out.println("->"); //$NON-NLS-1$
					System.out.println(extension);

					EAnnotation eAnnotation = UML2Util.createEAnnotation(null,
						ExtendedMetaData.ANNOTATION_URI);

					eAnnotation.getContents().add(extension);
					eAnnotation.getReferences().add(eObject);

					resourceContents.add(eAnnotation);
				}

				for (Iterator eAllReferences = eObject.eClass()
					.getEAllReferences().iterator(); eAllReferences.hasNext();) {

					EReference eReference = (EReference) eAllReferences.next();

					if (!eReference.isDerived() && !eReference.isContainer()
						&& !eReference.isContainment()
						&& eObject.eIsSet(eReference)) {

						if (eReference.isMany()) {

							for (Iterator values = ((InternalEList) eObject
								.eGet(eReference)).basicIterator(); values
								.hasNext();) {

								handleProxy((InternalEObject) values.next());
							}
						} else {
							handleProxy((InternalEObject) eObject.eGet(
								eReference, false));
						}
					}
				}

				for (Iterator eContents = eObject.eContents().iterator(); eContents
					.hasNext();) {

					doSwitch((EObject) eContents.next());
				}

				return eObject;
			}
		};

		for (int i = 0, size = resourceContents.size(); i < size; i++) {
			umlSwitch.doSwitch((EObject) resourceContents.get(i));
		}

		for (Iterator atr = annotationsToRemove.iterator(); atr.hasNext();) {
			((EAnnotation) atr.next()).setEModelElement(null);
		}

		EcoreUtil.resolveAll(resource);
	}

}