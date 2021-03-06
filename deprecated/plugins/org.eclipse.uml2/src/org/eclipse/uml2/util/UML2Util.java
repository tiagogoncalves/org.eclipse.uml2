/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: UML2Util.java,v 1.67 2006/10/03 15:26:07 khussey Exp $
 */
package org.eclipse.uml2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.AggregationKind;
import org.eclipse.uml2.Artifact;
import org.eclipse.uml2.Association;
import org.eclipse.uml2.BehavioredClassifier;
import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.Comment;
import org.eclipse.uml2.Constraint;
import org.eclipse.uml2.DataType;
import org.eclipse.uml2.DirectedRelationship;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.Enumeration;
import org.eclipse.uml2.EnumerationLiteral;
import org.eclipse.uml2.Feature;
import org.eclipse.uml2.Generalization;
import org.eclipse.uml2.Implementation;
import org.eclipse.uml2.Interface;
import org.eclipse.uml2.LiteralInteger;
import org.eclipse.uml2.LiteralUnlimitedNatural;
import org.eclipse.uml2.Model;
import org.eclipse.uml2.MultiplicityElement;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.Namespace;
import org.eclipse.uml2.Operation;
import org.eclipse.uml2.PackageMerge;
import org.eclipse.uml2.PackageableElement;
import org.eclipse.uml2.Parameter;
import org.eclipse.uml2.ParameterDirectionKind;
import org.eclipse.uml2.PrimitiveType;
import org.eclipse.uml2.Profile;
import org.eclipse.uml2.Property;
import org.eclipse.uml2.RedefinableElement;
import org.eclipse.uml2.Signal;
import org.eclipse.uml2.Stereotype;
import org.eclipse.uml2.StructuralFeature;
import org.eclipse.uml2.StructuredClassifier;
import org.eclipse.uml2.Type;
import org.eclipse.uml2.TypedElement;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.UML2Plugin;
import org.eclipse.uml2.ValueSpecification;
import org.eclipse.uml2.VisibilityKind;

/**
 * 
 */
public class UML2Util
		extends org.eclipse.uml2.common.util.UML2Util {

	protected UML2Util() {
		super();
	}

	public static class QualifiedTextProvider
			extends org.eclipse.uml2.common.util.UML2Util.QualifiedTextProvider {

		public static final QualifiedTextProvider DEFAULT = new QualifiedTextProvider();

		public String getText(EObject eObject) {
			return eObject instanceof NamedElement
				? ((NamedElement) eObject).getName()
				: super.getText(eObject);
		}

		public String getSeparator() {
			return NamedElement.SEPARATOR;
		}

	}

	public static class Ecore2UML2Converter
			extends EcoreSwitch
			implements Converter {

		public static final String OPTION__ECORE_TAGGED_VALUES = "ECORE_TAGGED_VALUES"; //$NON-NLS-1$

		public static final String OPTION__REDEFINES_ANNOTATIONS = "REDEFINES_ANNOTATIONS"; //$NON-NLS-1$

		public static final String OPTION__SUBSETS_ANNOTATIONS = "SUBSETS_ANNOTATIONS"; //$NON-NLS-1$

		public static final String OPTION__UNION_ANNOTATIONS = "UNION_ANNOTATIONS"; //$NON-NLS-1$

		public static final String OPTION__ANNOTATION_DETAILS = "ANNOTATION_DETAILS"; //$NON-NLS-1$

		private static final int DIAGNOSTIC_CODE_OFFSET = 3000;

		public static final int ECORE_TAGGED_VALUE = DIAGNOSTIC_CODE_OFFSET + 1;

		public static final int REDEFINES_ANNOTATION = DIAGNOSTIC_CODE_OFFSET + 2;

		public static final int SUBSETS_ANNOTATION = DIAGNOSTIC_CODE_OFFSET + 3;

		public static final int UNION_ANNOTATION = DIAGNOSTIC_CODE_OFFSET + 4;

		public static final int ANNOTATION_DETAILS = DIAGNOSTIC_CODE_OFFSET + 4;

		protected final Map eModelElementToElementMap = new HashMap();

		protected Collection ePackages = null;

		protected Model getEcorePrimitiveTypesLibrary(
				EModelElement eModelElement) {
			Resource resource = eModelElement.eResource();

			if (null != resource) {
				ResourceSet resourceSet = resource.getResourceSet();

				if (null != resourceSet) {
					return (Model) load(
						resourceSet,
						URI
							.createURI(UML2Resource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI));
				}
			}

			return null;
		}

		protected PrimitiveType getEcorePrimitiveType(
				EModelElement eModelElement, String name) {
			Model ecorePrimitiveTypesLibrary = getEcorePrimitiveTypesLibrary(eModelElement);

			return null != ecorePrimitiveTypesLibrary
				? (PrimitiveType) ecorePrimitiveTypesLibrary.getOwnedType(name)
				: null;
		}

		protected Type getType(EModelElement eModelElement, EClassifier eType) {
			Type type = null;

			if (null != eType) {
				String name = eType.getName();

				if (!isEmpty(name) && eType instanceof EDataType) {
					type = getEcorePrimitiveType(eModelElement, name);
				}

				if (null == type) {
					type = (Type) doSwitch(eType);
				}
			}

			return type;
		}

		protected Type getType(ETypedElement eTypedElement) {
			return getType(eTypedElement, eTypedElement.getEType());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEAttribute(org.eclipse.emf.ecore.EAttribute)
		 */
		public Object caseEAttribute(EAttribute eAttribute) {
			Property property = UML2Factory.eINSTANCE.createProperty();
			eModelElementToElementMap.put(eAttribute, property);

			Classifier classifier = (Classifier) doSwitch(eAttribute
				.getEContainingClass());
			getOwnedAttributes(classifier).add(property);

			property.setName(eAttribute.getName());
			property.setIsReadOnly(!eAttribute.isChangeable());
			property.setIsDerived(eAttribute.isDerived());
			property.setVisibility(VisibilityKind.PUBLIC_LITERAL);

			caseETypedElement(eAttribute);

			defaultCase(eAttribute);

			return property;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEClass(org.eclipse.emf.ecore.EClass)
		 */
		public Object caseEClass(EClass eClass) {
			Classifier classifier = eClass.isInterface()
				? (Classifier) UML2Factory.eINSTANCE.createInterface()
				: (Classifier) UML2Factory.eINSTANCE.createClass();
			eModelElementToElementMap.put(eClass, classifier);

			org.eclipse.uml2.Package package_ = (org.eclipse.uml2.Package) doSwitch(eClass
				.getEPackage());
			package_.getOwnedMembers().add(classifier);

			classifier.setName(eClass.getName());

			if (!eClass.isInterface()) {
				((org.eclipse.uml2.Class) classifier).setIsAbstract(eClass
					.isAbstract());
			}

			for (Iterator eSuperTypes = eClass.getESuperTypes().iterator(); eSuperTypes
				.hasNext();) {

				EClass eSuperType = (EClass) eSuperTypes.next();

				if (eSuperType.isInterface()) {
					((BehavioredClassifier) classifier)
						.createImplementation((Interface) doSwitch(eSuperType));
				} else {
					Classifier generalClassifier = (Classifier) doSwitch(eSuperType);

					if (null != generalClassifier
						&& !classifier.allParents().contains(generalClassifier)) {

						classifier.createGeneralization(generalClassifier);
					}
				}
			}

			defaultCase(eClass);

			return classifier;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEDataType(org.eclipse.emf.ecore.EDataType)
		 */
		public Object caseEDataType(EDataType eDataType) {
			PrimitiveType primitiveType = UML2Factory.eINSTANCE
				.createPrimitiveType();
			eModelElementToElementMap.put(eDataType, primitiveType);

			org.eclipse.uml2.Package package_ = (org.eclipse.uml2.Package) doSwitch(eDataType
				.getEPackage());
			package_.getOwnedMembers().add(primitiveType);

			primitiveType.setName(eDataType.getName());

			defaultCase(eDataType);

			return primitiveType;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEEnum(org.eclipse.emf.ecore.EEnum)
		 */
		public Object caseEEnum(EEnum eEnum) {
			Enumeration enumeration = UML2Factory.eINSTANCE.createEnumeration();
			eModelElementToElementMap.put(eEnum, enumeration);

			org.eclipse.uml2.Package package_ = (org.eclipse.uml2.Package) doSwitch(eEnum
				.getEPackage());
			package_.getOwnedMembers().add(enumeration);

			enumeration.setName(eEnum.getName());

			defaultCase(eEnum);

			return enumeration;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEEnumLiteral(org.eclipse.emf.ecore.EEnumLiteral)
		 */
		public Object caseEEnumLiteral(EEnumLiteral eEnumLiteral) {
			EnumerationLiteral enumerationLiteral = UML2Factory.eINSTANCE
				.createEnumerationLiteral();
			eModelElementToElementMap.put(eEnumLiteral, enumerationLiteral);

			Enumeration enumeration = (Enumeration) doSwitch(eEnumLiteral
				.getEEnum());
			enumeration.getOwnedLiterals().add(enumerationLiteral);

			enumerationLiteral.setName(eEnumLiteral.getName());

			defaultCase(eEnumLiteral);

			return enumerationLiteral;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEModelElement(org.eclipse.emf.ecore.EModelElement)
		 */
		public Object caseEModelElement(EModelElement eModelElement) {
			return eModelElement;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEOperation(org.eclipse.emf.ecore.EOperation)
		 */
		public Object caseEOperation(EOperation eOperation) {
			Operation operation = UML2Factory.eINSTANCE.createOperation();
			eModelElementToElementMap.put(eOperation, operation);

			Classifier classifier = (Classifier) doSwitch(eOperation
				.getEContainingClass());
			getOwnedOperations(classifier).add(operation);

			operation.setName(eOperation.getName());

			if (null != eOperation.getEType()) {
				operation.createReturnResult().setDirection(
					ParameterDirectionKind.RETURN_LITERAL);
			}

			for (Iterator eExceptions = eOperation.getEExceptions().iterator(); eExceptions
				.hasNext();) {

				operation.getRaisedExceptions().add(
					getType(eOperation, (EClassifier) eExceptions.next()));
			}

			operation.setVisibility(VisibilityKind.PUBLIC_LITERAL);

			caseETypedElement(eOperation);

			defaultCase(eOperation);

			return operation;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEPackage(org.eclipse.emf.ecore.EPackage)
		 */
		public Object caseEPackage(EPackage ePackage) {
			org.eclipse.uml2.Package package_ = null == ePackage
				.getESuperPackage()
				? UML2Factory.eINSTANCE.createModel()
				: UML2Factory.eINSTANCE.createPackage();
			eModelElementToElementMap.put(ePackage, package_);

			if (!ePackages.contains(ePackage)) {
				EPackage eSuperPackage = ePackage.getESuperPackage();

				if (null != eSuperPackage) {
					((org.eclipse.uml2.Package) doSwitch(eSuperPackage))
						.getOwnedMembers().add(package_);
				}
			}

			package_.setName(ePackage.getName());

			defaultCase(ePackage);

			return package_;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEParameter(org.eclipse.emf.ecore.EParameter)
		 */
		public Object caseEParameter(EParameter eParameter) {
			Parameter parameter = UML2Factory.eINSTANCE.createParameter();
			eModelElementToElementMap.put(eParameter, parameter);

			Operation operation = (Operation) doSwitch(eParameter
				.getEOperation());
			operation.getOwnedParameters().add(parameter);

			parameter.setName(eParameter.getName());

			caseETypedElement(eParameter);

			defaultCase(eParameter);

			return parameter;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseEReference(org.eclipse.emf.ecore.EReference)
		 */
		public Object caseEReference(EReference eReference) {
			Property property = UML2Factory.eINSTANCE.createProperty();
			eModelElementToElementMap.put(eReference, property);

			EClass eContainingClass = eReference.getEContainingClass();
			Classifier classifier = (Classifier) doSwitch(eContainingClass);
			getOwnedAttributes(classifier).add(property);

			property.setName(eReference.getName());
			property.setAggregation(eReference.isContainment()
				? AggregationKind.COMPOSITE_LITERAL
				: AggregationKind.NONE_LITERAL);
			property.setIsDerived(eReference.isDerived());
			property.setIsReadOnly(!eReference.isChangeable());

			property.setVisibility(VisibilityKind.PUBLIC_LITERAL);

			caseETypedElement(eReference);

			EReference eOpposite = eReference.getEOpposite();

			if (eOpposite == null) {
				Association association = (Association) ((org.eclipse.uml2.Package) doSwitch(eContainingClass
					.getEPackage()))
					.createOwnedMember(UML2Package.Literals.ASSOCIATION);

				property.setAssociation(association);

				association.createOwnedEnd().setType(classifier);
			} else {
				Property opposite = (Property) doSwitch(eOpposite);
				Association association = opposite.getAssociation();

				if (association == null) {

					if (eReference.isContainer()) {
						opposite
							.setAssociation(association = (Association) ((org.eclipse.uml2.Package) doSwitch(eOpposite
								.getEContainingClass().getEPackage()))
								.createOwnedMember(UML2Package.Literals.ASSOCIATION));

						property.setAssociation(association);
					} else {
						property
							.setAssociation(association = (Association) ((org.eclipse.uml2.Package) doSwitch(eContainingClass
								.getEPackage()))
								.createOwnedMember(UML2Package.Literals.ASSOCIATION));

						opposite.setAssociation(association);
					}
				} else {
					property.setAssociation(association);
				}
			}

			defaultCase(eReference);

			return property;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#caseETypedElement(org.eclipse.emf.ecore.ETypedElement)
		 */
		public Object caseETypedElement(ETypedElement eTypedElement) {
			Object element = eModelElementToElementMap.get(eTypedElement);

			if (null == element) {
				return super.caseETypedElement(eTypedElement);
			} else {

				if (element instanceof TypedElement) {
					((TypedElement) element).setType(getType(eTypedElement));
				}

				if (element instanceof MultiplicityElement) {
					MultiplicityElement multiplicityElement = (MultiplicityElement) element;

					int upperBound = eTypedElement.getUpperBound();

					if (upperBound != ETypedElement.UNSPECIFIED_MULTIPLICITY
						&& upperBound != multiplicityElement.getUpper()) {

						multiplicityElement.setUpperBound(upperBound);
					}

					int lowerBound = eTypedElement.getLowerBound();

					if (lowerBound != multiplicityElement.getLower()) {
						multiplicityElement.setLowerBound(lowerBound);
					}

					multiplicityElement.setIsOrdered(eTypedElement.isOrdered());
					multiplicityElement.setIsUnique(eTypedElement.isUnique());
				}

				return element;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		public Object defaultCase(EObject eObject) {

			for (Iterator eContents = eObject.eContents().iterator(); eContents
				.hasNext();) {

				doSwitch((EObject) eContents.next());
			}

			return super.defaultCase(eObject);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.ecore.util.EcoreSwitch#doSwitch(org.eclipse.emf.ecore.EObject)
		 */
		public Object doSwitch(EObject eObject) {
			Object element = eModelElementToElementMap.get(eObject);

			return null == element
				? super.doSwitch(eObject)
				: element;
		}

		protected Profile getEcoreProfile(EModelElement eModelElement) {
			Resource resource = eModelElement.eResource();

			if (null != resource) {
				ResourceSet resourceSet = resource.getResourceSet();

				if (null != resourceSet) {
					return (Profile) load(resourceSet, URI
						.createURI(UML2Resource.ECORE_PROFILE_URI));
				}
			}

			return null;
		}

		protected Stereotype getEcoreStereotype(EModelElement eModelElement,
				String name) {
			Profile ecoreProfile = getEcoreProfile(eModelElement);

			return null != ecoreProfile
				? ecoreProfile.getOwnedStereotype(name)
				: null;
		}

		protected void processEcoreTaggedValue(Element element,
				Stereotype stereotype, String propertyName,
				EModelElement eModelElement,
				EStructuralFeature eStructuralFeature, Map options,
				DiagnosticChain diagnostics, Map context) {
			Object value = null;

			if (null != eStructuralFeature) {
				value = eModelElement.eGet(eStructuralFeature);

				if (safeEquals(eStructuralFeature.getDefaultValue(), value)) {
					return;
				}
			} else {

				if (PROPERTY_NAME__XML_CONTENT_KIND == propertyName) {
					Enumeration contentKindEnumeration = (Enumeration) getEcoreProfile(
						eModelElement).getOwnedType(
						ENUMERATION_NAME__CONTENT_KIND);

					if (null != contentKindEnumeration) {

						switch (ExtendedMetaData.INSTANCE
							.getContentKind((EClass) eModelElement)) {

							case ExtendedMetaData.EMPTY_CONTENT :
								value = contentKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__EMPTY);
								break;
							case ExtendedMetaData.SIMPLE_CONTENT :
								value = contentKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__SIMPLE);
								break;
							case ExtendedMetaData.MIXED_CONTENT :
								value = contentKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__MIXED);
								break;
							case ExtendedMetaData.ELEMENT_ONLY_CONTENT :
								value = contentKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT_ONLY);
								break;
						}

					}

					if (null == value) {
						return;
					}
				} else if (PROPERTY_NAME__XML_FEATURE_KIND == propertyName) {
					Enumeration featureKindEnumeration = (Enumeration) getEcoreProfile(
						eModelElement).getOwnedType(
						ENUMERATION_NAME__FEATURE_KIND);

					if (null != featureKindEnumeration) {

						switch (ExtendedMetaData.INSTANCE
							.getFeatureKind((EStructuralFeature) eModelElement)) {

							case ExtendedMetaData.SIMPLE_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__SIMPLE);
								break;
							case ExtendedMetaData.ATTRIBUTE_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ATTRIBUTE);
								break;
							case ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ATTRIBUTE_WILDCARD);
								break;
							case ExtendedMetaData.ELEMENT_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT);
								break;
							case ExtendedMetaData.ELEMENT_WILDCARD_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT_WILDCARD);
								break;
							case ExtendedMetaData.GROUP_FEATURE :
								value = featureKindEnumeration
									.getOwnedLiteral(ENUMERATION_LITERAL_NAME__GROUP);
								break;
						}
					}

					if (null == value) {
						return;
					}
				} else if (PROPERTY_NAME__XML_NAME == propertyName) {

					if (eModelElement instanceof EClassifier) {
						value = ExtendedMetaData.INSTANCE
							.getName((EClassifier) eModelElement);
					} else if (eModelElement instanceof EStructuralFeature) {
						value = ExtendedMetaData.INSTANCE
							.getName((EStructuralFeature) eModelElement);
					}

					if (safeEquals(((ENamedElement) eModelElement).getName(),
						value)) {

						return;
					}
				} else if (PROPERTY_NAME__XML_NAMESPACE == propertyName) {
					value = ExtendedMetaData.INSTANCE
						.getNamespace((EStructuralFeature) eModelElement);

					if (null == value) {
						return;
					}
				} else if (PROPERTY_NAME__VISIBILITY == propertyName) {
					Enumeration visibilityKindEnumeration = (Enumeration) getEcoreProfile(
						eModelElement).getOwnedType(
						ENUMERATION_NAME__VISIBILITY_KIND);

					if (null != visibilityKindEnumeration) {
						eStructuralFeature = (EStructuralFeature) eModelElement;

						if (EcoreUtil.isSuppressedVisibility(
							eStructuralFeature, EcoreUtil.GET)) {

							value = visibilityKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__NONE);
						} else {

							if (EcoreUtil.isSuppressedVisibility(
								eStructuralFeature, EcoreUtil.SET)) {

								if (EcoreUtil.isSuppressedVisibility(
									eStructuralFeature, EcoreUtil.IS_SET)) {

									value = visibilityKindEnumeration
										.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_ONLY);
								} else {
									value = visibilityKindEnumeration
										.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_ONLY_UNSETTABLE);
								}
							} else {

								if (EcoreUtil.isSuppressedVisibility(
									eStructuralFeature, EcoreUtil.UNSET)) {

									value = visibilityKindEnumeration
										.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_WRITE);
								}
							}
						}
					}

					if (null == value) {
						return;
					}
				}
			}

			if (OPTION__PROCESS
				.equals(options.get(OPTION__ECORE_TAGGED_VALUES))) {

				if (null != diagnostics) {
					diagnostics
						.add(new BasicDiagnostic(
							Diagnostic.INFO,
							UML2Validator.DIAGNOSTIC_SOURCE,
							ECORE_TAGGED_VALUE,
							UML2Plugin.INSTANCE
								.getString(
									"_UI_Ecore2UML2Converter_ProcessEcoreTaggedValue_diagnostic", //$NON-NLS-1$
									getMessageSubstitutions(context, element,
										getTagDefinition(stereotype,
											propertyName), value)),
							new Object[]{element}));
				}

				setTaggedValue(element, stereotype, propertyName, value);
			} else if (OPTION__REPORT.equals(options
				.get(OPTION__ECORE_TAGGED_VALUES))
				&& null != diagnostics) {

				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.WARNING,
						UML2Validator.DIAGNOSTIC_SOURCE,
						ECORE_TAGGED_VALUE,
						UML2Plugin.INSTANCE
							.getString(
								"_UI_Ecore2UML2Converter_ReportEcoreTaggedValue_diagnostic", //$NON-NLS-1$
								getMessageSubstitutions(context, element,
									getTagDefinition(stereotype, propertyName),
									value)), new Object[]{element}));
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(
				org.eclipse.uml2.Package package_, EPackage ePackage,
				Map options, DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues((Element) package_, ePackage, options,
				diagnostics, context);
		}

		protected void processEcoreTaggedValues(Element element,
				EPackage ePackage, Map options, DiagnosticChain diagnostics,
				Map context) {
			Stereotype ePackageStereotype = getEcoreStereotype(ePackage,
				STEREOTYPE_NAME__E_PACKAGE);

			if (null != ePackageStereotype) {
				safeApplyStereotype(element, ePackageStereotype);

				processEcoreTaggedValue(element, ePackageStereotype,
					PROPERTY_NAME__NS_PREFIX, ePackage, EcorePackage.eINSTANCE
						.getEPackage_NsPrefix(), options, diagnostics, context);

				processEcoreTaggedValue(element, ePackageStereotype,
					PROPERTY_NAME__NS_URI, ePackage, EcorePackage.eINSTANCE
						.getEPackage_NsURI(), options, diagnostics, context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(Classifier classifier,
				EClassifier eClassifier, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues((Element) classifier, eClassifier,
				options, diagnostics, context);
		}

		protected void processEcoreTaggedValues(Element element,
				final EClassifier eClassifier, final Map options,
				final DiagnosticChain diagnostics, final Map context) {
			Stereotype eClassifierStereotype = (Stereotype) new UML2Switch() {

				public Object caseClass(org.eclipse.uml2.Class class_) {
					Stereotype eClassStereotype = getEcoreStereotype(
						eClassifier, STEREOTYPE_NAME__E_CLASS);

					if (null != eClassStereotype) {
						safeApplyStereotype(class_, eClassStereotype);

						processEcoreTaggedValue(class_, eClassStereotype,
							PROPERTY_NAME__XML_CONTENT_KIND, eClassifier, null,
							options, diagnostics, context);
					}

					return eClassStereotype;
				}

				public Object caseDataType(DataType dataType) {
					Stereotype eDataTypeStereotype = getEcoreStereotype(
						eClassifier, STEREOTYPE_NAME__E_DATA_TYPE);

					if (eDataTypeStereotype != null) {
						safeApplyStereotype(dataType, eDataTypeStereotype);
					}

					return eDataTypeStereotype;
				}

				public Object caseInterface(Interface interface_) {
					Stereotype eClassStereotype = getEcoreStereotype(
						eClassifier, STEREOTYPE_NAME__E_CLASS);

					if (null != eClassStereotype) {
						safeApplyStereotype(interface_, eClassStereotype);

						processEcoreTaggedValue(interface_, eClassStereotype,
							PROPERTY_NAME__XML_CONTENT_KIND, eClassifier, null,
							options, diagnostics, context);
					}

					return eClassStereotype;
				}
			}.doSwitch(element);

			if (null != eClassifierStereotype) {
				processEcoreTaggedValue(element, eClassifierStereotype,
					PROPERTY_NAME__XML_NAME, eClassifier, null, options,
					diagnostics, context);

				processEcoreTaggedValue(element, eClassifierStereotype,
					PROPERTY_NAME__INSTANCE_CLASS_NAME, eClassifier,
					EcorePackage.eINSTANCE.getEClassifier_InstanceClassName(),
					options, diagnostics, context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(Property property,
				EStructuralFeature eStructuralFeature, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues((Element) property, eStructuralFeature,
				options, diagnostics, context);
		}

		protected void processEcoreTaggedValues(final Element element,
				EStructuralFeature eStructuralFeature, final Map options,
				final DiagnosticChain diagnostics, final Map context) {
			Stereotype eStructuralFeatureStereotype = (Stereotype) new EcoreSwitch() {

				public Object caseEAttribute(EAttribute eAttribute) {
					Stereotype eAttributeStereotype = getEcoreStereotype(
						eAttribute, STEREOTYPE_NAME__E_ATTRIBUTE);

					if (null != eAttributeStereotype) {
						safeApplyStereotype(element, eAttributeStereotype);

						processEcoreTaggedValue(element, eAttributeStereotype,
							PROPERTY_NAME__IS_ID, eAttribute,
							EcorePackage.eINSTANCE.getEAttribute_ID(), options,
							diagnostics, context);
					}

					return eAttributeStereotype;
				}

				public Object caseEReference(EReference eReference) {
					Stereotype eReferenceStereotype = getEcoreStereotype(
						eReference, STEREOTYPE_NAME__E_REFERENCE);

					if (null != eReferenceStereotype) {
						safeApplyStereotype(element, eReferenceStereotype);

						processEcoreTaggedValue(element, eReferenceStereotype,
							PROPERTY_NAME__IS_RESOLVE_PROXIES, eReference,
							EcorePackage.eINSTANCE
								.getEReference_ResolveProxies(), options,
							diagnostics, context);
					}

					return eReferenceStereotype;
				}
			}.doSwitch(eStructuralFeature);

			if (null != eStructuralFeatureStereotype) {
				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_TRANSIENT, eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Transient(),
					options, diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_UNSETTABLE, eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Unsettable(),
					options, diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_VOLATILE, eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Volatile(),
					options, diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__XML_FEATURE_KIND, eStructuralFeature, null,
					options, diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__XML_NAME, eStructuralFeature, null, options,
					diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__XML_NAMESPACE, eStructuralFeature, null,
					options, diagnostics, context);

				processEcoreTaggedValue(element, eStructuralFeatureStereotype,
					PROPERTY_NAME__VISIBILITY, eStructuralFeature, null,
					options, diagnostics, context);
			}
		}

		protected void processEcoreTaggedValues(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = eModelElementToElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getKey();
				final Element element = (Element) entry.getValue();

				new EcoreSwitch() {

					public Object caseEClassifier(EClassifier eClassifier) {
						processEcoreTaggedValues(element, eClassifier, options,
							diagnostics, context);

						return eClassifier;
					}

					public Object caseEDataType(EDataType eDataType) {
						processEcoreTaggedValues(element, eDataType, options,
							diagnostics, context);

						return eDataType;
					}

					public Object caseEEnum(EEnum eEnum) {
						Stereotype eEnumStereotype = getEcoreStereotype(eEnum,
							STEREOTYPE_NAME__E_ENUM);

						if (null != eEnumStereotype) {
							safeApplyStereotype(element, eEnumStereotype);
						}

						return eEnum;
					}

					public Object caseEEnumLiteral(EEnumLiteral eEnumLiteral) {
						Stereotype eEnumLiteralStereotype = getEcoreStereotype(
							eEnumLiteral, STEREOTYPE_NAME__E_ENUM_LITERAL);

						if (null != eEnumLiteralStereotype) {
							safeApplyStereotype(element, eEnumLiteralStereotype);
						}

						return eEnumLiteral;
					}

					public Object caseEOperation(EOperation eOperation) {
						Stereotype eOperationStereotype = getEcoreStereotype(
							eOperation, STEREOTYPE_NAME__E_OPERATION);

						if (null != eOperationStereotype) {
							safeApplyStereotype(element, eOperationStereotype);
						}

						return eOperation;
					}

					public Object caseEPackage(EPackage ePackage) {
						processEcoreTaggedValues(element, ePackage, options,
							diagnostics, context);

						return ePackage;
					}

					public Object caseEParameter(EParameter eParameter) {
						Stereotype eParameterStereotype = getEcoreStereotype(
							eParameter, STEREOTYPE_NAME__E_PARAMETER);

						if (null != eParameterStereotype) {
							safeApplyStereotype(element, eParameterStereotype);
						}

						return eParameter;
					}

					public Object caseEStructuralFeature(
							EStructuralFeature eStructuralFeature) {
						processEcoreTaggedValues(element, eStructuralFeature,
							options, diagnostics, context);

						return eStructuralFeature;
					}

				}.doSwitch(eModelElement);
			}
		}

		protected void processRedefinesAnnotations(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = eModelElementToElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getKey();

				if (eModelElement instanceof ETypedElement) {
					EAnnotation redefinesEAnnotation = getEAnnotation(
						eModelElement, ANNOTATION_SOURCE__REDEFINES, false);

					if (null != redefinesEAnnotation) {
						Feature feature = (Feature) entry.getValue();

						for (Iterator references = redefinesEAnnotation
							.getReferences().iterator(); references.hasNext();) {

							Feature redefinedFeature = (Feature) eModelElementToElementMap
								.get(references.next());

							if (null != redefinedFeature
								&& findValidRedefinitions(feature,
									redefinedFeature.getName()).contains(
									redefinedFeature)) {

								if (OPTION__PROCESS.equals(options
									.get(OPTION__REDEFINES_ANNOTATIONS))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.INFO,
												UML2Validator.DIAGNOSTIC_SOURCE,
												REDEFINES_ANNOTATION,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_Ecore2UML2Converter_ProcessRedefinesAnnotation_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context, feature,
															redefinedFeature)),
												new Object[]{feature,
													redefinedFeature}));
									}

									getRedefinedFeatures(feature).add(
										redefinedFeature);
								} else if (OPTION__REPORT.equals(options
									.get(OPTION__REDEFINES_ANNOTATIONS))
									&& null != diagnostics) {

									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.WARNING,
											UML2Validator.DIAGNOSTIC_SOURCE,
											REDEFINES_ANNOTATION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_Ecore2UML2Converter_ReportRedefinesAnnotation_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, feature,
														redefinedFeature)),
											new Object[]{feature,
												redefinedFeature}));
								}
							}
						}
					}
				}
			}
		}

		protected void processSubsetsAnnotations(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = eModelElementToElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getKey();

				if (eModelElement instanceof EStructuralFeature) {
					EAnnotation subsetsEAnnotation = getEAnnotation(
						eModelElement, ANNOTATION_SOURCE__SUBSETS, false);

					if (null != subsetsEAnnotation) {
						Property property = (Property) entry.getValue();

						for (Iterator references = subsetsEAnnotation
							.getReferences().iterator(); references.hasNext();) {

							Property subsettedProperty = (Property) eModelElementToElementMap
								.get(references.next());

							if (null != subsettedProperty
								&& findValidSubsets(property,
									subsettedProperty.getName()).contains(
									subsettedProperty)) {

								if (OPTION__PROCESS.equals(options
									.get(OPTION__SUBSETS_ANNOTATIONS))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.INFO,
												UML2Validator.DIAGNOSTIC_SOURCE,
												SUBSETS_ANNOTATION,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_Ecore2UML2Converter_ProcessSubsetsAnnotation_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context, property,
															subsettedProperty)),
												new Object[]{property,
													subsettedProperty}));
									}

									property.getSubsettedProperties().add(
										subsettedProperty);
								} else if (OPTION__REPORT.equals(options
									.get(OPTION__SUBSETS_ANNOTATIONS))
									&& null != diagnostics) {

									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.WARNING,
											UML2Validator.DIAGNOSTIC_SOURCE,
											SUBSETS_ANNOTATION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_Ecore2UML2Converter_ReportSubsetsAnnotation_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, property,
														subsettedProperty)),
											new Object[]{property,
												subsettedProperty}));
								}
							}
						}
					}
				}
			}
		}

		protected void processUnionAnnotations(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = eModelElementToElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getKey();

				if (eModelElement instanceof EStructuralFeature) {
					EAnnotation unionEAnnotation = getEAnnotation(
						eModelElement, ANNOTATION_SOURCE__UNION, false);

					if (null != unionEAnnotation) {
						Property property = (Property) entry.getValue();

						if (OPTION__PROCESS.equals(options
							.get(OPTION__UNION_ANNOTATIONS))) {

							if (null != diagnostics) {
								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.INFO,
										UML2Validator.DIAGNOSTIC_SOURCE,
										UNION_ANNOTATION,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_Ecore2UML2Converter_ProcessUnionAnnotation_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, property)),
										new Object[]{property}));
							}

							property.setIsDerivedUnion(true);
						} else if (OPTION__REPORT.equals(options
							.get(OPTION__UNION_ANNOTATIONS))
							&& null != diagnostics) {

							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.WARNING,
									UML2Validator.DIAGNOSTIC_SOURCE,
									UNION_ANNOTATION,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_Ecore2UML2Converter_ReportUnionAnnotation_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												property)),
									new Object[]{property}));
						}
					}
				}
			}
		}

		protected void processAnnotationDetails(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = eModelElementToElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				final Map.Entry entry = (Map.Entry) entries.next();
				Element element = (Element) entry.getValue();

				if (null != element) {
					EModelElement eModelElement = (EModelElement) entry
						.getKey();

					for (Iterator eAnnotations = eModelElement
						.getEAnnotations().iterator(); eAnnotations.hasNext();) {

						EAnnotation eAnnotation = (EAnnotation) eAnnotations
							.next();
						EMap details = eAnnotation.getDetails();

						if (!details.isEmpty()) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__ANNOTATION_DETAILS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											ANNOTATION_DETAILS,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_Ecore2UML2Converter_ProcessAnnotationDetails_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, element,
														eAnnotation.getSource())),
											new Object[]{element}));
								}

								getEAnnotation(element,
									eAnnotation.getSource(), true).getDetails()
									.putAll(details.map());
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__ANNOTATION_DETAILS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										ANNOTATION_DETAILS,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_Ecore2UML2Converter_ReportAnnotationDetails_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, element,
													eAnnotation.getSource())),
										new Object[]{element}));
							}
						}
					}
				}
			}
		}

		/**
		 * @deprecated
		 */
		protected void processOptions(EPackage ePackage, Map options,
				DiagnosticChain diagnostics, Map context) {
			processOptions(options, diagnostics, context);
		}

		protected void processOptions(Map options,
				final DiagnosticChain diagnostics, Map context) {

			if (!OPTION__IGNORE
				.equals(options.get(OPTION__ECORE_TAGGED_VALUES))) {

				processEcoreTaggedValues(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__REDEFINES_ANNOTATIONS))) {

				processRedefinesAnnotations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE
				.equals(options.get(OPTION__SUBSETS_ANNOTATIONS))) {

				processSubsetsAnnotations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__UNION_ANNOTATIONS))) {
				processUnionAnnotations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__ANNOTATION_DETAILS))) {
				processAnnotationDetails(options, diagnostics, context);
			}
		}

		public Collection convert(Collection eObjects, Map options,
				DiagnosticChain diagnostics, Map context) {
			ePackages = EcoreUtil.getObjectsByType(eObjects,
				EcorePackage.eINSTANCE.getEPackage());

			for (Iterator ep = ePackages.iterator(); ep.hasNext();) {
				doSwitch((EPackage) ep.next());
			}

			if (null != options) {
				processOptions(options, diagnostics, context);
			}

			return getRootContainers(EcoreUtil.getObjectsByType(
				eModelElementToElementMap.values(),
				UML2Package.Literals.PACKAGE));
		}
	}

	public static class UML22EcoreConverter
			extends UML2Switch
			implements Converter {

		protected class NameMatcher
				extends EClassMatcher {

			protected NameMatcher(ENamedElement eNamedElement) {
				super(eNamedElement);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((ENamedElement) eObject)
						.getName().equalsIgnoreCase(
							((ENamedElement) otherEObject).getName()));
			}
		}

		protected class ETypeMatcher
				extends NameMatcher {

			protected ETypeMatcher(ETypedElement eTypedElement) {
				super(eTypedElement);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || safeEquals(
						((ETypedElement) eObject).getEType(),
						((ETypedElement) otherEObject).getEType()));
			}
		}

		protected class SignatureMatcher
				extends ETypeMatcher {

			protected SignatureMatcher(EOperation eOperation) {
				super(eOperation);
			}

			public boolean matches(EObject otherEObject) {

				if (super.matches(otherEObject)) {
					List eParameters = ((EOperation) eObject).getEParameters();
					int eParametersSize = eParameters.size();
					List otherEParameters = ((EOperation) otherEObject)
						.getEParameters();

					if (eParametersSize == otherEParameters.size()) {

						for (int i = 0; i < eParametersSize; i++) {

							if (!new ETypeMatcher((ETypedElement) eParameters
								.get(i)).matches((EObject) otherEParameters
								.get(i))) {

								return false;
							}
						}

						return true;
					}
				}

				return false;
			}
		}

		public static final String OPTION__ECORE_TAGGED_VALUES = "ECORE_TAGGED_VALUES"; //$NON-NLS-1$

		public static final String OPTION__REDEFINING_OPERATIONS = "REDEFINING_OPERATIONS"; //$NON-NLS-1$

		public static final String OPTION__REDEFINING_PROPERTIES = "REDEFINING_PROPERTIES"; //$NON-NLS-1$

		public static final String OPTION__SUBSETTING_PROPERTIES = "SUBSETTING_PROPERTIES"; //$NON-NLS-1$

		public static final String OPTION__UNION_PROPERTIES = "UNION_PROPERTIES"; //$NON-NLS-1$

		public static final String OPTION__DERIVED_FEATURES = "DERIVED_FEATURES"; //$NON-NLS-1$

		public static final String OPTION__DUPLICATE_OPERATIONS = "DUPLICATE_OPERATIONS"; //$NON-NLS-1$

		public static final String OPTION__DUPLICATE_OPERATION_INHERITANCE = "DUPLICATE_OPERATION_INHERITANCE"; //$NON-NLS-1$

		public static final String OPTION__DUPLICATE_FEATURES = "DUPLICATE_FEATURES"; //$NON-NLS-1$

		public static final String OPTION__DUPLICATE_FEATURE_INHERITANCE = "DUPLICATE_FEATURE_INHERITANCE"; //$NON-NLS-1$

		public static final String OPTION__SUPER_CLASS_ORDER = "SUPER_CLASS_ORDER"; //$NON-NLS-1$

		public static final String OPTION__ANNOTATION_DETAILS = "ANNOTATION_DETAILS"; //$NON-NLS-1$

		private static final int DIAGNOSTIC_CODE_OFFSET = 2000;

		public static final int ECORE_TAGGED_VALUE = DIAGNOSTIC_CODE_OFFSET + 1;

		public static final int REDEFINING_OPERATION = DIAGNOSTIC_CODE_OFFSET + 2;

		public static final int REDEFINING_PROPERTY = DIAGNOSTIC_CODE_OFFSET + 3;

		public static final int SUBSETTING_PROPERTY = DIAGNOSTIC_CODE_OFFSET + 4;

		public static final int UNION_PROPERTY = DIAGNOSTIC_CODE_OFFSET + 5;

		public static final int DERIVED_FEATURE = DIAGNOSTIC_CODE_OFFSET + 6;

		public static final int DUPLICATE_OPERATION = DIAGNOSTIC_CODE_OFFSET + 7;

		public static final int DUPLICATE_OPERATION_INHERITANCE = DIAGNOSTIC_CODE_OFFSET + 8;

		public static final int DUPLICATE_FEATURE = DIAGNOSTIC_CODE_OFFSET + 9;

		public static final int DUPLICATE_FEATURE_INHERITANCE = DIAGNOSTIC_CODE_OFFSET + 10;

		public static final int SUPER_CLASS_ORDER = DIAGNOSTIC_CODE_OFFSET + 11;

		public static final int ANNOTATION_DETAILS = DIAGNOSTIC_CODE_OFFSET + 12;

		protected final Map elementToEModelElementMap = new HashMap();

		protected Collection packages = null;

		protected void setName(ENamedElement eNamedElement, String name,
				boolean validate) {
			eNamedElement.setName(validate
				? getValidJavaIdentifier(name)
				: name);
		}

		protected void setName(ENamedElement eNamedElement,
				NamedElement namedElement) {
			setName(eNamedElement, namedElement.getName(), true);
		}

		protected EClassifier getEType(Type type) {
			EClassifier eType = null;

			if (null != type) {
				String qualifiedName = type.getQualifiedName();

				if (!isEmpty(qualifiedName) && type instanceof PrimitiveType) {

					if ("UML2::Boolean".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEBoolean();
					} else if ("UML2::Integer".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEInt();
					} else if ("UML2::String".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEString();
					} else if ("UML2::UnlimitedNatural".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEInt();
					} else if ("Java::boolean".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEBoolean();
					} else if ("Java::byte".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEByte();
					} else if ("Java::char".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEChar();
					} else if ("Java::double".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEDouble();
					} else if ("Java::float".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEFloat();
					} else if ("Java::int".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEInt();
					} else if ("Java::long".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getELong();
					} else if ("Java::short".equals(qualifiedName)) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEShort();
					} else if (qualifiedName.startsWith("Ecore::")) { //$NON-NLS-1$
						eType = EcorePackage.eINSTANCE.getEClassifier(type
							.getName());
					}
				}

				if (null == eType) {
					eType = (EClassifier) doSwitch(type);
				}
			}

			return eType;
		}

		protected EClassifier getEType(TypedElement typedElement) {
			return getEType(typedElement.getType());
		}

		protected Stereotype getAppliedEcoreStereotype(Element element,
				String name) {

			return element.getAppliedStereotype("Ecore" //$NON-NLS-1$
				+ NamedElement.SEPARATOR + name);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseClass(org.eclipse.uml2.Class)
		 */
		public Object caseClass(org.eclipse.uml2.Class class_) {
			org.eclipse.uml2.Package package_ = class_.getNearestPackage();

			if (null == package_) {
				return super.caseClass(class_);
			} else {
				EClass eClass = EcoreFactory.eINSTANCE.createEClass();
				elementToEModelElementMap.put(class_, eClass);

				EPackage ePackage = (EPackage) doSwitch(package_);
				ePackage.getEClassifiers().add(eClass);

				setName(eClass, class_);

				eClass.setAbstract(class_.isAbstract());

				defaultCase(class_);

				return eClass;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseComment(org.eclipse.uml2.Comment)
		 */
		public Object caseComment(Comment comment) {

			for (Iterator annotatedElements = comment.getAnnotatedElements()
				.iterator(); annotatedElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) doSwitch((Element) annotatedElements
					.next());

				if (null != eModelElement) {
					addDocumentation(eModelElement, comment.getBody());
				}
			}

			return super.caseComment(comment);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseConstraint(org.eclipse.uml2.Constraint)
		 */
		public Object caseConstraint(Constraint constraint) {
			Namespace context = constraint.getContext();

			if (null != context) {
				EModelElement eModelElement = (EModelElement) doSwitch(context);

				if (null != eModelElement) {
					String name = constraint.getName();

					if (!isEmpty(name)) {

						if (eModelElement instanceof EClass) {
							EOperation eOperation = EcoreFactory.eINSTANCE
								.createEOperation();
							elementToEModelElementMap.put(constraint,
								eOperation);

							((EClass) eModelElement).getEOperations().add(
								eOperation);

							setName(eOperation, name, true);

							eOperation.setEType(EcorePackage.eINSTANCE
								.getEBoolean());

							EParameter eParameter = EcoreFactory.eINSTANCE
								.createEParameter();

							eOperation.getEParameters().add(eParameter);

							setName(eParameter, "diagnostics", false); //$NON-NLS-1$
							eParameter.setEType(EcorePackage.eINSTANCE
								.getEDiagnosticChain());

							eParameter = EcoreFactory.eINSTANCE
								.createEParameter();

							eOperation.getEParameters().add(eParameter);

							setName(eParameter, "context", false); //$NON-NLS-1$
							eParameter.setEType(EcorePackage.eINSTANCE
								.getEMap());

							defaultCase(constraint);

							eModelElement = eOperation;
						} else {
							addConstraint(eModelElement, name);

							if (DEBUG) {
								System.out
									.println(getQualifiedText(eModelElement)
										+ " is constrained with '" //$NON-NLS-1$
										+ name + "'"); //$NON-NLS-1$
							}
						}
					}

					ValueSpecification specification = constraint
						.getSpecification();

					if (null != specification) {
						addDocumentation(eModelElement, specification
							.stringValue());
					}

					return eModelElement;
				}
			}

			return super.caseConstraint(constraint);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseEModelElement(org.eclipse.emf.ecore.EModelElement)
		 */
		public Object caseEModelElement(EModelElement eModelElement) {
			return eModelElement;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseEnumeration(org.eclipse.uml2.Enumeration)
		 */
		public Object caseEnumeration(Enumeration enumeration) {
			org.eclipse.uml2.Package package_ = enumeration.getNearestPackage();

			if (null == package_) {
				return super.caseEnumeration(enumeration);
			} else {
				EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
				elementToEModelElementMap.put(enumeration, eEnum);

				EPackage ePackage = (EPackage) doSwitch(package_);
				ePackage.getEClassifiers().add(eEnum);

				setName(eEnum, enumeration);

				defaultCase(enumeration);

				return eEnum;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseEnumerationLiteral(org.eclipse.uml2.EnumerationLiteral)
		 */
		public Object caseEnumerationLiteral(
				EnumerationLiteral enumerationLiteral) {
			Enumeration enumeration = enumerationLiteral.getEnumeration();

			if (null == enumeration) {
				return super.caseEnumerationLiteral(enumerationLiteral);
			} else {
				EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE
					.createEEnumLiteral();
				elementToEModelElementMap.put(enumerationLiteral, eEnumLiteral);

				EEnum eEnum = (EEnum) doSwitch(enumeration);
				eEnum.getELiterals().add(eEnumLiteral);

				setName(eEnumLiteral, enumerationLiteral);

				eEnumLiteral.setValue(enumeration.getOwnedLiterals().indexOf(
					enumerationLiteral));

				defaultCase(enumerationLiteral);

				return eEnumLiteral;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseGeneralization(org.eclipse.uml2.Generalization)
		 */
		public Object caseGeneralization(Generalization generalization) {
			Classifier specific = generalization.getSpecific();

			if (null != specific) {
				EClassifier specificEClassifier = (EClassifier) doSwitch(specific);

				if (specificEClassifier instanceof EClass) {
					EClass specificEClass = (EClass) specificEClassifier;
					Classifier general = generalization.getGeneral();

					if (null != general) {
						EClassifier generalEClassifier = (EClassifier) doSwitch(general);

						if (generalEClassifier instanceof EClass) {
							EClass generalEClass = (EClass) generalEClassifier;

							if (!specificEClass.isSuperTypeOf(generalEClass)) {
								specificEClass.getESuperTypes().add(
									generalEClass);
							}
						}
					}
				}
			}

			return super.caseGeneralization(generalization);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseImplementation(org.eclipse.uml2.Implementation)
		 */
		public Object caseImplementation(Implementation implementation) {
			BehavioredClassifier implementingClassifier = implementation
				.getImplementingClassifier();

			if (null != implementingClassifier) {
				EClassifier implementingEClassifier = (EClassifier) doSwitch(implementingClassifier);

				if (implementingEClassifier instanceof EClass) {
					EClass implementingEClass = (EClass) implementingEClassifier;
					Interface contract = implementation.getContract();

					if (null != contract) {
						EClass contractEClass = (EClass) doSwitch(contract);

						if (null != contractEClass) {
							implementingEClass.getESuperTypes().add(
								contractEClass);
						}
					}
				}
			}

			return super.caseImplementation(implementation);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseInterface(org.eclipse.uml2.Interface)
		 */
		public Object caseInterface(Interface interface_) {
			org.eclipse.uml2.Package package_ = interface_.getNearestPackage();

			if (null == package_) {
				return super.caseInterface(interface_);
			} else {
				EClass eClass = EcoreFactory.eINSTANCE.createEClass();
				elementToEModelElementMap.put(interface_, eClass);

				EPackage ePackage = (EPackage) doSwitch(package_);
				ePackage.getEClassifiers().add(eClass);

				setName(eClass, interface_);

				eClass.setAbstract(true);
				eClass.setInterface(true);

				defaultCase(interface_);

				return eClass;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseMultiplicityElement(org.eclipse.uml2.MultiplicityElement)
		 */
		public Object caseMultiplicityElement(
				MultiplicityElement multiplicityElement) {
			Object eModelElement = elementToEModelElementMap
				.get(multiplicityElement);

			if (eModelElement instanceof ETypedElement) {
				ETypedElement eTypedElement = (ETypedElement) eModelElement;

				int upper = multiplicityElement.getUpper();

				if (upper != eTypedElement.getUpperBound()) {
					eTypedElement.setUpperBound(upper);
				}

				int lower = multiplicityElement.getLower();

				if (lower != eTypedElement.getLowerBound()) {
					eTypedElement.setLowerBound(lower);
				}

				eTypedElement.setOrdered(multiplicityElement.isOrdered());
				eTypedElement.setUnique(multiplicityElement.isUnique());

				return eTypedElement;
			} else {
				return super.caseMultiplicityElement(multiplicityElement);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseOperation(org.eclipse.uml2.Operation)
		 */
		public Object caseOperation(Operation operation) {
			Namespace namespace = operation.getNamespace();

			if (!org.eclipse.uml2.Class.class.isInstance(namespace)
				&& !Interface.class.isInstance(namespace)) {

				return super.caseOperation(operation);
			} else {
				EOperation eOperation = EcoreFactory.eINSTANCE
					.createEOperation();
				elementToEModelElementMap.put(operation, eOperation);

				EClass eClass = (EClass) doSwitch(namespace);
				eClass.getEOperations().add(eOperation);

				setName(eOperation, operation);

				EList eExceptions = eOperation.getEExceptions();

				for (Iterator raisedExceptions = operation
					.getRaisedExceptions().iterator(); raisedExceptions
					.hasNext();) {

					eExceptions.add(getEType((Type) raisedExceptions.next()));
				}

				caseTypedElement(operation);
				caseMultiplicityElement(operation);

				defaultCase(operation);

				return eOperation;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#casePackage(org.eclipse.uml2.Package)
		 */
		public Object casePackage(org.eclipse.uml2.Package package_) {
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			elementToEModelElementMap.put(package_, ePackage);

			if (!packages.contains(package_)) {
				org.eclipse.uml2.Package nestingPackage = package_
					.getNestingPackage();

				if (null != nestingPackage) {
					((EPackage) doSwitch(nestingPackage)).getESubpackages()
						.add(ePackage);
				}
			}

			setName(ePackage, package_);

			if (isEmpty(ePackage.getNsPrefix())) {
				EPackage eSuperPackage = ePackage.getESuperPackage();

				ePackage.setNsPrefix((null == eSuperPackage
					? EMPTY_STRING
					: eSuperPackage.getNsPrefix() + '.') + ePackage.getName());
			}

			if (isEmpty(ePackage.getNsURI())) {
				ePackage.setNsURI("http:///" //$NON-NLS-1$
					+ ePackage.getNsPrefix().replace('.', '/') + ".ecore"); //$NON-NLS-1$
			}

			defaultCase(package_);

			return ePackage;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseParameter(org.eclipse.uml2.Parameter)
		 */
		public Object caseParameter(Parameter parameter) {
			Operation operation = parameter.getOperation();

			if (null == operation) {
				return super.caseParameter(parameter);
			} else {
				EParameter eParameter = EcoreFactory.eINSTANCE
					.createEParameter();
				elementToEModelElementMap.put(parameter, eParameter);

				EOperation eOperation = (EOperation) doSwitch(operation);
				eOperation.getEParameters().add(eParameter);

				setName(eParameter, parameter);

				caseTypedElement(parameter);
				caseMultiplicityElement(parameter);

				defaultCase(parameter);

				return eParameter;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#casePrimitiveType(org.eclipse.uml2.PrimitiveType)
		 */
		public Object casePrimitiveType(PrimitiveType primitiveType) {
			org.eclipse.uml2.Package package_ = primitiveType
				.getNearestPackage();

			if (null == package_) {
				return super.casePrimitiveType(primitiveType);
			} else {
				EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
				elementToEModelElementMap.put(primitiveType, eDataType);

				EPackage ePackage = (EPackage) doSwitch(package_);
				ePackage.getEClassifiers().add(eDataType);

				setName(eDataType, primitiveType);

				eDataType.setInstanceClassName(eDataType.getName());

				defaultCase(primitiveType);

				return eDataType;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseProperty(org.eclipse.uml2.Property)
		 */
		public Object caseProperty(Property property) {
			Namespace namespace = property.getNamespace();

			if (!org.eclipse.uml2.Class.class.isInstance(namespace)
				&& !Interface.class.isInstance(namespace)) {

				return super.caseProperty(property);
			} else {
				EStructuralFeature eStructuralFeature = null;

				if (property.getType() instanceof DataType) {
					EAttribute eAttribute = (EAttribute) (eStructuralFeature = EcoreFactory.eINSTANCE
						.createEAttribute());
					elementToEModelElementMap.put(property, eAttribute);

					ValueSpecification defaultValue = property
						.getDefaultValue();

					if (null != defaultValue && !defaultValue.isNull()) {
						String default_ = defaultValue.stringValue();

						if (!isEmpty(default_)) {
							eAttribute.setDefaultValueLiteral(default_);
						}
					}
				} else {
					EReference eReference = (EReference) (eStructuralFeature = EcoreFactory.eINSTANCE
						.createEReference());
					elementToEModelElementMap.put(property, eStructuralFeature);

					eReference.setContainment(property.isComposite());
				}

				EClass eClass = (EClass) doSwitch(namespace);
				eClass.getEStructuralFeatures().add(eStructuralFeature);

				setName(eStructuralFeature, property);

				eStructuralFeature.setChangeable(!property.isReadOnly());

				eStructuralFeature.setDerived(property.isDerived());

				Property opposite = property.getOpposite();

				if (null != opposite) {
					EReference eOpposite = (EReference) doSwitch(opposite);

					if (property.isDerived() && !eOpposite.isDerived()) {
						eOpposite.setDerived(true);

						if (DEBUG) {
							System.out.println("Made opposite " //$NON-NLS-1$
								+ getQualifiedText(eOpposite) + " derived"); //$NON-NLS-1$
						}
					}

					((EReference) eStructuralFeature).setEOpposite(eOpposite);
				}

				caseTypedElement(property);
				caseMultiplicityElement(property);

				defaultCase(property);

				return eStructuralFeature;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#caseTypedElement(org.eclipse.uml2.TypedElement)
		 */
		public Object caseTypedElement(TypedElement typedElement) {
			Object eModelElement = elementToEModelElementMap.get(typedElement);

			if (eModelElement instanceof ETypedElement) {
				ETypedElement eTypedElement = (ETypedElement) eModelElement;

				eTypedElement.setEType(getEType(typedElement));

				return eTypedElement;
			} else {
				return super.caseTypedElement(typedElement);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		public Object defaultCase(EObject eObject) {

			for (Iterator eContents = eObject.eContents().iterator(); eContents
				.hasNext();) {

				doSwitch((EObject) eContents.next());
			}

			return super.defaultCase(eObject);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.uml2.util.UML2Switch#doSwitch(org.eclipse.emf.ecore.EObject)
		 */
		public Object doSwitch(EObject eObject) {
			Object eModelElement = elementToEModelElementMap.get(eObject);

			return null == eModelElement
				? super.doSwitch(eObject)
				: eModelElement;
		}

		protected void processEcoreTaggedValue(EModelElement eModelElement,
				EStructuralFeature eStructuralFeature, Element element,
				Stereotype stereotype, String propertyName, Map options,
				DiagnosticChain diagnostics, Map context) {

			if (element.hasValue(stereotype, propertyName)) {
				Object value = element.getValue(stereotype, propertyName);

				if (OPTION__PROCESS.equals(options
					.get(OPTION__ECORE_TAGGED_VALUES))) {

					if (null != diagnostics) {
						diagnostics
							.add(new BasicDiagnostic(
								Diagnostic.INFO,
								UML2Validator.DIAGNOSTIC_SOURCE,
								ECORE_TAGGED_VALUE,
								UML2Plugin.INSTANCE
									.getString(
										"_UI_UML22EcoreConverter_ProcessEcoreTaggedValue_diagnostic", //$NON-NLS-1$
										getMessageSubstitutions(context,
											eModelElement, getTagDefinition(
												stereotype, propertyName),
											value)),
								new Object[]{eModelElement}));
					}

					if (null != eStructuralFeature) {
						eModelElement
							.eSet(eStructuralFeature, EcorePackage.eINSTANCE
								.getENamedElement_Name() == eStructuralFeature
								? getValidJavaIdentifier((String) value)
								: value);
					} else {

						if (PROPERTY_NAME__XML_CONTENT_KIND == propertyName) {
							Enumeration contentKindEnumeration = ((EnumerationLiteral) value)
								.getEnumeration();

							if (contentKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__EMPTY) == value) {

								ExtendedMetaData.INSTANCE.setContentKind(
									(EClass) eModelElement,
									ExtendedMetaData.EMPTY_CONTENT);
							} else if (contentKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__SIMPLE) == value) {

								ExtendedMetaData.INSTANCE.setContentKind(
									(EClass) eModelElement,
									ExtendedMetaData.SIMPLE_CONTENT);
							} else if (contentKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__MIXED) == value) {

								ExtendedMetaData.INSTANCE.setContentKind(
									(EClass) eModelElement,
									ExtendedMetaData.MIXED_CONTENT);
							} else if (contentKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT_ONLY) == value) {

								ExtendedMetaData.INSTANCE.setContentKind(
									(EClass) eModelElement,
									ExtendedMetaData.ELEMENT_ONLY_CONTENT);
							}
						} else if (PROPERTY_NAME__XML_FEATURE_KIND == propertyName) {
							Enumeration featureKindEnumeration = ((EnumerationLiteral) value)
								.getEnumeration();

							if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__SIMPLE) == value) {

								ExtendedMetaData.INSTANCE.setFeatureKind(
									(EStructuralFeature) eModelElement,
									ExtendedMetaData.SIMPLE_FEATURE);
							} else if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ATTRIBUTE) == value) {

								ExtendedMetaData.INSTANCE.setFeatureKind(
									(EStructuralFeature) eModelElement,
									ExtendedMetaData.ATTRIBUTE_FEATURE);
							} else if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ATTRIBUTE_WILDCARD) == value) {

								ExtendedMetaData.INSTANCE
									.setFeatureKind(
										(EStructuralFeature) eModelElement,
										ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE);
							} else if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT) == value) {

								ExtendedMetaData.INSTANCE.setFeatureKind(
									(EStructuralFeature) eModelElement,
									ExtendedMetaData.ELEMENT_FEATURE);
							} else if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__ELEMENT_WILDCARD) == value) {

								ExtendedMetaData.INSTANCE.setFeatureKind(
									(EStructuralFeature) eModelElement,
									ExtendedMetaData.ELEMENT_WILDCARD_FEATURE);
							} else if (featureKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__GROUP) == value) {

								ExtendedMetaData.INSTANCE.setFeatureKind(
									(EStructuralFeature) eModelElement,
									ExtendedMetaData.GROUP_FEATURE);
							}
						} else if (PROPERTY_NAME__XML_NAME == propertyName) {

							if (eModelElement instanceof EClassifier) {
								ExtendedMetaData.INSTANCE
									.setName((EClassifier) eModelElement,
										(String) value);
							} else if (eModelElement instanceof EStructuralFeature) {
								ExtendedMetaData.INSTANCE.setName(
									(EStructuralFeature) eModelElement,
									(String) value);
							}
						} else if (PROPERTY_NAME__XML_NAMESPACE == propertyName) {
							ExtendedMetaData.INSTANCE.setNamespace(
								(EStructuralFeature) eModelElement,
								(String) value);
						} else if (PROPERTY_NAME__VISIBILITY == propertyName) {
							eStructuralFeature = (EStructuralFeature) eModelElement;
							boolean isChangeable = eStructuralFeature
								.isChangeable();
							boolean isMany = eStructuralFeature.isMany();
							boolean isUnsettable = eStructuralFeature
								.isUnsettable();

							Enumeration visibilityKindEnumeration = ((EnumerationLiteral) value)
								.getEnumeration();

							if (visibilityKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__NONE) == value) {

								EcoreUtil.setSuppressedVisibility(
									eStructuralFeature, EcoreUtil.GET, true);

								if (isChangeable && !isMany) {
									EcoreUtil
										.setSuppressedVisibility(
											eStructuralFeature, EcoreUtil.SET,
											true);
								}

								if (isUnsettable) {
									EcoreUtil.setSuppressedVisibility(
										eStructuralFeature, EcoreUtil.IS_SET,
										true);

									if (isChangeable) {
										EcoreUtil.setSuppressedVisibility(
											eStructuralFeature,
											EcoreUtil.UNSET, true);
									}
								}
							} else if (visibilityKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_ONLY) == value) {

								if (!isMany && isChangeable) {
									EcoreUtil
										.setSuppressedVisibility(
											eStructuralFeature, EcoreUtil.SET,
											true);
								}

								if (isUnsettable) {
									EcoreUtil.setSuppressedVisibility(
										eStructuralFeature, EcoreUtil.IS_SET,
										true);

									if (isChangeable) {
										EcoreUtil.setSuppressedVisibility(
											eStructuralFeature,
											EcoreUtil.UNSET, true);
									}
								}
							} else if (visibilityKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_WRITE) == value) {

								if (isUnsettable) {
									EcoreUtil.setSuppressedVisibility(
										eStructuralFeature, EcoreUtil.IS_SET,
										true);

									if (isChangeable) {
										EcoreUtil.setSuppressedVisibility(
											eStructuralFeature,
											EcoreUtil.UNSET, true);
									}
								}
							} else if (visibilityKindEnumeration
								.getOwnedLiteral(ENUMERATION_LITERAL_NAME__READ_ONLY_UNSETTABLE) == value) {

								if (!isMany && isChangeable) {
									EcoreUtil
										.setSuppressedVisibility(
											eStructuralFeature, EcoreUtil.SET,
											true);
								}

								if (isUnsettable && isChangeable) {
									EcoreUtil.setSuppressedVisibility(
										eStructuralFeature, EcoreUtil.UNSET,
										true);
								}
							}
						}
					}
				} else if (OPTION__REPORT.equals(options
					.get(OPTION__ECORE_TAGGED_VALUES))
					&& null != diagnostics) {

					diagnostics
						.add(new BasicDiagnostic(
							Diagnostic.WARNING,
							UML2Validator.DIAGNOSTIC_SOURCE,
							ECORE_TAGGED_VALUE,
							UML2Plugin.INSTANCE
								.getString(
									"_UI_UML22EcoreConverter_ReportEcoreTaggedValue_diagnostic", //$NON-NLS-1$
									getMessageSubstitutions(context,
										eModelElement, getTagDefinition(
											stereotype, propertyName), value)),
							new Object[]{eModelElement}));
				}
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EClassifier eClassifier,
				Classifier classifier, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues(eClassifier, (Element) classifier,
				options, diagnostics, context);
		}

		protected void processEcoreTaggedValues(EClassifier eClassifier,
				final Element element, final Map options,
				final DiagnosticChain diagnostics, final Map context) {
			Stereotype eClassifierStereotype = (Stereotype) new EcoreSwitch() {

				public Object caseEClass(EClass eClass) {
					Stereotype eClassStereotype = getAppliedEcoreStereotype(
						element, STEREOTYPE_NAME__E_CLASS);

					if (null != eClassStereotype) {
						processEcoreTaggedValue(eClass, EcorePackage.eINSTANCE
							.getENamedElement_Name(), element,
							eClassStereotype, PROPERTY_NAME__CLASS_NAME,
							options, diagnostics, context);

						processEcoreTaggedValue(eClass, null, element,
							eClassStereotype, PROPERTY_NAME__XML_CONTENT_KIND,
							options, diagnostics, context);
					}

					return eClassStereotype;
				}

				public Object caseEDataType(EDataType eDataType) {
					Stereotype eDataTypeStereotype = getAppliedEcoreStereotype(
						element, STEREOTYPE_NAME__E_DATA_TYPE);

					if (null != eDataTypeStereotype) {
						processEcoreTaggedValue(eDataType,
							EcorePackage.eINSTANCE.getENamedElement_Name(),
							element, eDataTypeStereotype,
							PROPERTY_NAME__DATA_TYPE_NAME, options,
							diagnostics, context);
					}

					return eDataTypeStereotype;
				}
			}.doSwitch(eClassifier);

			if (null != eClassifierStereotype) {
				processEcoreTaggedValue(eClassifier, null, element,
					eClassifierStereotype, PROPERTY_NAME__XML_NAME, options,
					diagnostics, context);

				processEcoreTaggedValue(eClassifier, EcorePackage.eINSTANCE
					.getEClassifier_InstanceClassName(), element,
					eClassifierStereotype, PROPERTY_NAME__INSTANCE_CLASS_NAME,
					options, diagnostics, context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EEnum eEnum,
				Enumeration enumeration, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues(eEnum, (Element) enumeration, options,
				diagnostics, context);
		}

		protected void processEcoreTaggedValues(EEnum eEnum, Element element,
				Map options, DiagnosticChain diagnostics, Map context) {
			Stereotype eEnumStereotype = getAppliedEcoreStereotype(element,
				STEREOTYPE_NAME__E_ENUM);

			if (null != eEnumStereotype) {
				processEcoreTaggedValue(eEnum, EcorePackage.eINSTANCE
					.getENamedElement_Name(), element, eEnumStereotype,
					PROPERTY_NAME__ENUM_NAME, options, diagnostics, context);

				processEcoreTaggedValue(eEnum, null, element, eEnumStereotype,
					PROPERTY_NAME__XML_NAME, options, diagnostics, context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EEnumLiteral eEnumLiteral,
				EnumerationLiteral enumerationLiteral, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues(eEnumLiteral,
				(Element) enumerationLiteral, options, diagnostics, context);
		}

		protected void processEcoreTaggedValues(EEnumLiteral eEnumLiteral,
				Element element, Map options, DiagnosticChain diagnostics,
				Map context) {
			Stereotype eEnumLiteralStereotype = getAppliedEcoreStereotype(
				element, STEREOTYPE_NAME__E_ENUM_LITERAL);

			if (null != eEnumLiteralStereotype) {
				processEcoreTaggedValue(eEnumLiteral, EcorePackage.eINSTANCE
					.getENamedElement_Name(), element, eEnumLiteralStereotype,
					PROPERTY_NAME__ENUM_LITERAL_NAME, options, diagnostics,
					context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EOperation eOperation,
				Operation operation, Map options, DiagnosticChain diagnostics,
				Map context) {
			processEcoreTaggedValues(eOperation, (Element) operation, options,
				diagnostics, context);
		}

		protected void processEcoreTaggedValues(EOperation eOperation,
				Element element, Map options, DiagnosticChain diagnostics,
				Map context) {
			Stereotype eOperationStereotype = getAppliedEcoreStereotype(
				element, STEREOTYPE_NAME__E_OPERATION);

			if (null != eOperationStereotype) {
				processEcoreTaggedValue(eOperation, EcorePackage.eINSTANCE
					.getENamedElement_Name(), element, eOperationStereotype,
					PROPERTY_NAME__OPERATION_NAME, options, diagnostics,
					context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EPackage ePackage,
				org.eclipse.uml2.Package package_, Map options,
				DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues(ePackage, (Element) package_, options,
				diagnostics, context);
		}

		protected void processEcoreTaggedValues(EPackage ePackage,
				Element element, Map options, DiagnosticChain diagnostics,
				Map context) {
			Stereotype ePackageStereotype = getAppliedEcoreStereotype(element,
				STEREOTYPE_NAME__E_PACKAGE);

			if (null != ePackageStereotype) {
				processEcoreTaggedValue(ePackage, EcorePackage.eINSTANCE
					.getENamedElement_Name(), element, ePackageStereotype,
					PROPERTY_NAME__PACKAGE_NAME, options, diagnostics, context);

				processEcoreTaggedValue(ePackage, EcorePackage.eINSTANCE
					.getEPackage_NsPrefix(), element, ePackageStereotype,
					PROPERTY_NAME__NS_PREFIX, options, diagnostics, context);

				if (isEmpty(ePackage.getNsPrefix())) {
					processEcoreTaggedValue(ePackage, EcorePackage.eINSTANCE
						.getEPackage_NsPrefix(), element, ePackageStereotype,
						PROPERTY_NAME__BASE_PACKAGE, options, diagnostics,
						context);

					String nsPrefix = ePackage.getNsPrefix();

					if (!isEmpty(nsPrefix)) {
						ePackage.setNsPrefix(nsPrefix + '.'
							+ ePackage.getName());
					}
				}

				processEcoreTaggedValue(ePackage, EcorePackage.eINSTANCE
					.getEPackage_NsURI(), element, ePackageStereotype,
					PROPERTY_NAME__NS_URI, options, diagnostics, context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(EParameter eParameter,
				Parameter parameter, Map options, DiagnosticChain diagnostics,
				Map context) {
			processEcoreTaggedValues(eParameter, (Element) parameter, options,
				diagnostics, context);
		}

		protected void processEcoreTaggedValues(EParameter eParameter,
				Element element, Map options, DiagnosticChain diagnostics,
				Map context) {
			Stereotype eParameterStereotype = getAppliedEcoreStereotype(
				element, STEREOTYPE_NAME__E_PARAMETER);

			if (null != eParameterStereotype) {
				processEcoreTaggedValue(eParameter, EcorePackage.eINSTANCE
					.getENamedElement_Name(), element, eParameterStereotype,
					PROPERTY_NAME__PARAMETER_NAME, options, diagnostics,
					context);
			}
		}

		/**
		 * @deprecated
		 */
		protected void processEcoreTaggedValues(
				EStructuralFeature eStructuralFeature, Property property,
				Map options, DiagnosticChain diagnostics, Map context) {
			processEcoreTaggedValues(eStructuralFeature, (Element) property,
				options, diagnostics, context);
		}

		protected void processEcoreTaggedValues(
				EStructuralFeature eStructuralFeature, final Element element,
				final Map options, final DiagnosticChain diagnostics,
				final Map context) {
			Stereotype eStructuralFeatureStereotype = (Stereotype) new EcoreSwitch() {

				public Object caseEAttribute(EAttribute eAttribute) {
					Stereotype eAttributeStereotype = getAppliedEcoreStereotype(
						element, STEREOTYPE_NAME__E_ATTRIBUTE);

					if (null != eAttributeStereotype) {
						processEcoreTaggedValue(eAttribute,
							EcorePackage.eINSTANCE.getENamedElement_Name(),
							element, eAttributeStereotype,
							PROPERTY_NAME__ATTRIBUTE_NAME, options,
							diagnostics, context);

						processEcoreTaggedValue(eAttribute,
							EcorePackage.eINSTANCE.getEAttribute_ID(), element,
							eAttributeStereotype, PROPERTY_NAME__IS_ID,
							options, diagnostics, context);
					}

					return eAttributeStereotype;
				}

				public Object caseEReference(EReference eReference) {
					Stereotype eReferenceStereotype = getAppliedEcoreStereotype(
						element, STEREOTYPE_NAME__E_REFERENCE);

					if (null != eReferenceStereotype) {
						processEcoreTaggedValue(eReference,
							EcorePackage.eINSTANCE.getENamedElement_Name(),
							element, eReferenceStereotype,
							PROPERTY_NAME__REFERENCE_NAME, options,
							diagnostics, context);

						processEcoreTaggedValue(eReference,
							EcorePackage.eINSTANCE
								.getEReference_ResolveProxies(), element,
							eReferenceStereotype,
							PROPERTY_NAME__IS_RESOLVE_PROXIES, options,
							diagnostics, context);
					}

					return eReferenceStereotype;
				}
			}.doSwitch(eStructuralFeature);

			if (null != eStructuralFeatureStereotype) {
				processEcoreTaggedValue(eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Transient(),
					element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_TRANSIENT, options, diagnostics, context);

				processEcoreTaggedValue(eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Unsettable(),
					element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_UNSETTABLE, options, diagnostics, context);

				processEcoreTaggedValue(eStructuralFeature,
					EcorePackage.eINSTANCE.getEStructuralFeature_Volatile(),
					element, eStructuralFeatureStereotype,
					PROPERTY_NAME__IS_VOLATILE, options, diagnostics, context);

				processEcoreTaggedValue(eStructuralFeature, null, element,
					eStructuralFeatureStereotype, PROPERTY_NAME__XML_NAME,
					options, diagnostics, context);

				processEcoreTaggedValue(eStructuralFeature, null, element,
					eStructuralFeatureStereotype, PROPERTY_NAME__XML_NAMESPACE,
					options, diagnostics, context);

				processEcoreTaggedValue(eStructuralFeature, null, element,
					eStructuralFeatureStereotype,
					PROPERTY_NAME__XML_FEATURE_KIND, options, diagnostics,
					context);

				processEcoreTaggedValue(eStructuralFeature, null, element,
					eStructuralFeatureStereotype, PROPERTY_NAME__VISIBILITY,
					options, diagnostics, context);
			}
		}

		protected void processEcoreTaggedValues(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				final Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				new EcoreSwitch() {

					public Object caseEClassifier(EClassifier eClassifier) {
						processEcoreTaggedValues(eClassifier, (Element) entry
							.getKey(), options, diagnostics, context);

						return eClassifier;
					}

					public Object caseEEnum(EEnum eEnum) {
						processEcoreTaggedValues(eEnum, (Element) entry
							.getKey(), options, diagnostics, context);

						return eEnum;
					}

					public Object caseEEnumLiteral(EEnumLiteral eEnumLiteral) {
						processEcoreTaggedValues(eEnumLiteral, (Element) entry
							.getKey(), options, diagnostics, context);

						return eEnumLiteral;
					}

					public Object caseEOperation(EOperation eOperation) {
						processEcoreTaggedValues(eOperation, (Element) entry
							.getKey(), options, diagnostics, context);

						return eOperation;
					}

					public Object caseEPackage(EPackage ePackage) {
						processEcoreTaggedValues(

						ePackage, (Element) entry.getKey(), options,
							diagnostics, context);

						return ePackage;
					}

					public Object caseEParameter(EParameter eParameter) {
						processEcoreTaggedValues(eParameter, (Element) entry
							.getKey(), options, diagnostics, context);

						return eParameter;
					}

					public Object caseEStructuralFeature(
							EStructuralFeature eStructuralFeature) {
						processEcoreTaggedValues(eStructuralFeature,
							(Element) entry.getKey(), options, diagnostics,
							context);

						return eStructuralFeature;
					}

				}.doSwitch(eModelElement);
			}
		}

		protected void processRedefiningOperations(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Element element = (Element) entry.getKey();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				if (eModelElement instanceof EOperation
					&& element instanceof Operation) {

					Operation operation = (Operation) element;

					for (Iterator redefinedOperations = operation
						.getRedefinedOperations().iterator(); redefinedOperations
						.hasNext();) {

						Operation redefinedOperation = (Operation) redefinedOperations
							.next();

						EOperation eOperation = (EOperation) elementToEModelElementMap
							.get(redefinedOperation);

						if (DEBUG) {
							System.out.println(getQualifiedText(eModelElement)
								+ " redefines " + getQualifiedText(eOperation)); //$NON-NLS-1$
						}

						if (OPTION__PROCESS.equals(options
							.get(OPTION__REDEFINING_OPERATIONS))) {

							if (null != diagnostics) {
								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.INFO,
										UML2Validator.DIAGNOSTIC_SOURCE,
										REDEFINING_OPERATION,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ProcessRedefiningOperation_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eModelElement,
													eOperation)), new Object[]{
											eModelElement, eOperation}));
							}

							getEAnnotation(eModelElement,
								ANNOTATION_SOURCE__REDEFINES, true)
								.getReferences().add(eOperation);
						} else if (OPTION__REPORT.equals(options
							.get(OPTION__REDEFINING_OPERATIONS))
							&& null != diagnostics) {

							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.WARNING,
									UML2Validator.DIAGNOSTIC_SOURCE,
									REDEFINING_OPERATION,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_UML22EcoreConverter_ReportRedefiningOperation_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												eModelElement, eOperation)),
									new Object[]{eModelElement, eOperation}));
						}
					}
				}
			}
		}

		protected void processRedefiningProperties(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Element element = (Element) entry.getKey();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				if (eModelElement instanceof EStructuralFeature
					&& element instanceof Property) {

					Property property = (Property) element;

					for (Iterator redefinedProperties = property
						.getRedefinedProperties().iterator(); redefinedProperties
						.hasNext();) {

						Property redefinedProperty = (Property) redefinedProperties
							.next();

						if (null == redefinedProperty.getAssociation()
							|| redefinedProperty.isNavigable()) {

							EStructuralFeature eStructuralFeature = (EStructuralFeature) elementToEModelElementMap
								.get(redefinedProperty);

							if (DEBUG) {
								System.out
									.println(getQualifiedText(eModelElement)
										+ " redefines " //$NON-NLS-1$
										+ getQualifiedText(eStructuralFeature));
							}

							if (OPTION__PROCESS.equals(options
								.get(OPTION__REDEFINING_PROPERTIES))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											REDEFINING_PROPERTY,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_UML22EcoreConverter_ProcessRedefiningProperty_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, eModelElement,
														eStructuralFeature)),
											new Object[]{eModelElement,
												eStructuralFeature}));
								}

								getEAnnotation(eModelElement,
									ANNOTATION_SOURCE__REDEFINES, true)
									.getReferences().add(eStructuralFeature);
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__REDEFINING_PROPERTIES))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										REDEFINING_PROPERTY,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ReportRedefiningProperty_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eModelElement,
													eStructuralFeature)),
										new Object[]{eModelElement,
											eStructuralFeature}));
							}
						}
					}
				}
			}
		}

		protected boolean isCompositeSubset(Property property) {

			for (Iterator subsettedProperties = property
				.getSubsettedProperties().iterator(); subsettedProperties
				.hasNext();) {

				Property subsettedProperty = (Property) subsettedProperties
					.next();

				if (subsettedProperty.isComposite()
					|| isCompositeSubset(subsettedProperty)) {

					return true;
				}
			}

			return false;
		}

		protected void processSubsettingProperties(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Element element = (Element) entry.getKey();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				if (eModelElement instanceof EStructuralFeature
					&& element instanceof Property) {

					Property property = (Property) element;

					for (Iterator subsettedProperties = property
						.getSubsettedProperties().iterator(); subsettedProperties
						.hasNext();) {

						Property subsettedProperty = (Property) subsettedProperties
							.next();

						if (null == subsettedProperty.getAssociation()
							|| subsettedProperty.isNavigable()) {

							EStructuralFeature subsettedEStructuralFeature = (EStructuralFeature) elementToEModelElementMap
								.get(subsettedProperty);

							if (DEBUG) {
								System.out
									.println(getQualifiedText(eModelElement)
										+ " subsets " //$NON-NLS-1$
										+ getQualifiedText(subsettedEStructuralFeature));
							}

							if (OPTION__PROCESS.equals(options
								.get(OPTION__SUBSETTING_PROPERTIES))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											SUBSETTING_PROPERTY,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_UML22EcoreConverter_ProcessSubsettingProperty_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, eModelElement,
														subsettedEStructuralFeature)),
											new Object[]{eModelElement,
												subsettedEStructuralFeature}));
								}

								if (!subsettedEStructuralFeature.isDerived()
									&& subsettedEStructuralFeature instanceof EReference) {

									EReference subsettedEReference = (EReference) subsettedEStructuralFeature;
									EReference eReference = (EReference) eModelElement;

									if (subsettedEReference.isContainment()
										|| isCompositeSubset(subsettedProperty)) {

										eReference.setContainment(false);
									}

									if (!eReference.isContainment()) {
										eReference
											.setResolveProxies(subsettedEReference
												.isResolveProxies());
									}
								}

								getEAnnotation(eModelElement,
									ANNOTATION_SOURCE__SUBSETS, true)
									.getReferences().add(
										elementToEModelElementMap
											.get(subsettedProperty));
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__SUBSETTING_PROPERTIES))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										SUBSETTING_PROPERTY,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ReportSubsettingProperty_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eModelElement,
													subsettedEStructuralFeature)),
										new Object[]{eModelElement,
											subsettedEStructuralFeature}));
							}
						}
					}
				}
			}
		}

		protected void processUnionProperties(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Element element = (Element) entry.getKey();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				if (eModelElement instanceof EStructuralFeature
					&& element instanceof Property
					&& ((Property) element).isDerivedUnion()) {

					EStructuralFeature eStructuralFeature = (EStructuralFeature) eModelElement;

					if (DEBUG) {
						System.out.println(getQualifiedText(eStructuralFeature)
							+ " is a union"); //$NON-NLS-1$
					}

					if (OPTION__PROCESS.equals(options
						.get(OPTION__UNION_PROPERTIES))) {

						if (null != diagnostics) {
							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.INFO,
									UML2Validator.DIAGNOSTIC_SOURCE,
									UNION_PROPERTY,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_UML22EcoreConverter_ProcessUnionProperty_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												eStructuralFeature)),
									new Object[]{eStructuralFeature}));
						}

						getEAnnotation(eStructuralFeature,
							ANNOTATION_SOURCE__UNION, true);

						eStructuralFeature.setChangeable(false);
						eStructuralFeature.setVolatile(false);
					} else if (OPTION__REPORT.equals(options
						.get(OPTION__UNION_PROPERTIES))
						&& null != diagnostics) {

						diagnostics
							.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								UML2Validator.DIAGNOSTIC_SOURCE,
								UNION_PROPERTY,
								UML2Plugin.INSTANCE
									.getString(
										"_UI_UML22EcoreConverter_ReportUnionProperty_diagnostic", //$NON-NLS-1$
										getMessageSubstitutions(context,
											eModelElement)),
								new Object[]{eModelElement}));
					}
				}
			}
		}

		protected void processDerivedFeatures(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator eModelElements = elementToEModelElementMap.values()
				.iterator(); eModelElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) eModelElements
					.next();

				if (eModelElement instanceof EStructuralFeature) {
					EStructuralFeature.Internal eStructuralFeature = (EStructuralFeature.Internal) eModelElement;

					if (eStructuralFeature.isDerived()
						&& (eStructuralFeature.isContainment() || !eStructuralFeature
							.isVolatile())) {

						if (OPTION__PROCESS.equals(options
							.get(OPTION__DERIVED_FEATURES))) {

							if (null != diagnostics) {
								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.INFO,
										UML2Validator.DIAGNOSTIC_SOURCE,
										DERIVED_FEATURE,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ProcessDerivedFeature_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eStructuralFeature)),
										new Object[]{eStructuralFeature}));
							}

							if (eStructuralFeature instanceof EReference) {
								((EReference) eStructuralFeature)
									.setContainment(false);
							}

							eStructuralFeature.setVolatile(true);
						} else if (OPTION__REPORT.equals(options
							.get(OPTION__DERIVED_FEATURES))
							&& null != diagnostics) {

							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.WARNING,
									UML2Validator.DIAGNOSTIC_SOURCE,
									DERIVED_FEATURE,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_UML22EcoreConverter_ReportDerivedFeature_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												eStructuralFeature)),
									new Object[]{eStructuralFeature}));
						}
					}
				}
			}
		}

		protected void ensureConformity(ETypedElement eTypedElement,
				ETypedElement otherETypedElement) {

			if (eTypedElement.isRequired() != otherETypedElement.isRequired()) {
				int lowerBound = eTypedElement.getLowerBound();
				int otherLowerBound = otherETypedElement.getLowerBound();

				int lesserLowerBound = getLesserLowerBound(otherLowerBound,
					lowerBound);

				if (lesserLowerBound != otherLowerBound) {

					if (DEBUG) {
						System.err.println("Changed lower bound of " //$NON-NLS-1$
							+ getQualifiedText(otherETypedElement) + " from " //$NON-NLS-1$
							+ otherLowerBound + " to " //$NON-NLS-1$
							+ lesserLowerBound);
					}

					otherETypedElement.setLowerBound(lesserLowerBound);
				}

				if (lesserLowerBound != lowerBound) {

					if (DEBUG) {
						System.out.println("Changed lower bound of " //$NON-NLS-1$
							+ getQualifiedText(eTypedElement) + " from " //$NON-NLS-1$
							+ lowerBound + " to " //$NON-NLS-1$
							+ lesserLowerBound);
					}

					eTypedElement.setLowerBound(lesserLowerBound);
				}
			}

			boolean isMany = eTypedElement.isMany();
			boolean otherIsMany = otherETypedElement.isMany();

			if (isMany != otherIsMany) {
				int upperBound = eTypedElement.getUpperBound();
				int otherUpperBound = otherETypedElement.getUpperBound();

				int greaterUpperBound = getGreaterUpperBound(otherUpperBound,
					upperBound);

				if (greaterUpperBound != otherUpperBound) {

					if (DEBUG) {
						System.err.println("Changed upper bound of " //$NON-NLS-1$
							+ getQualifiedText(otherETypedElement) + " from " //$NON-NLS-1$
							+ otherUpperBound + " to " //$NON-NLS-1$
							+ greaterUpperBound);
					}

					otherETypedElement.setUpperBound(greaterUpperBound);
				}

				if (greaterUpperBound != upperBound) {

					if (DEBUG) {
						System.out.println("Changed upper bound of " //$NON-NLS-1$
							+ getQualifiedText(eTypedElement) + " from " //$NON-NLS-1$
							+ upperBound + " to " //$NON-NLS-1$
							+ greaterUpperBound);
					}

					eTypedElement.setUpperBound(greaterUpperBound);
				}
			}

			if (!isMany && !otherIsMany) {
				EClassifier eType = eTypedElement.getEType();
				EClassifier otherEType = otherETypedElement.getEType();

				EClassifier commonEType = getCommonEType(otherEType, eType);

				if (commonEType != otherEType) {

					if (DEBUG) {
						System.err.println("Changed type of " //$NON-NLS-1$
							+ getQualifiedText(otherETypedElement)
							+ " from " //$NON-NLS-1$
							+ getQualifiedText(otherEType)
							+ " to " + getQualifiedText(commonEType)); //$NON-NLS-1$
					}

					otherETypedElement.setEType(commonEType);
				}

				if (commonEType != eType) {

					if (DEBUG) {
						System.out.println("Changed type of " //$NON-NLS-1$
							+ getQualifiedText(eTypedElement)
							+ " from " //$NON-NLS-1$
							+ getQualifiedText(eType)
							+ " to " + getQualifiedText(commonEType)); //$NON-NLS-1$
					}

					eTypedElement.setEType(commonEType);
				}
			}

			eTypedElement.setOrdered(otherETypedElement.isOrdered());

			eTypedElement.setUnique(otherETypedElement.isUnique());
		}

		protected void qualifyName(ENamedElement eNamedElement) {
			EObject eContainer = eNamedElement.eContainer();

			if (eContainer instanceof ENamedElement) {
				String qualifiedName = ((ENamedElement) eContainer).getName()
					+ '_' + eNamedElement.getName();

				if (DEBUG) {
					System.err.println("Qualified " //$NON-NLS-1$
						+ getQualifiedText(eNamedElement) + " as " //$NON-NLS-1$
						+ qualifiedName);
				}

				eNamedElement.setName(qualifiedName);
			}
		}

		protected void processDuplicateOperations(Map options,
				DiagnosticChain diagnostics, Map context) {
			List operationsToDuplicate = new UniqueEList.FastCompare();

			for (Iterator eModelElements = elementToEModelElementMap.values()
				.iterator(); eModelElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) eModelElements
					.next();

				if (eModelElement instanceof EClass) {
					EClass eClass = (EClass) eModelElement;

					for (Iterator eOperations = eClass.getEOperations()
						.iterator(); eOperations.hasNext();) {

						EOperation eOperation = (EOperation) eOperations.next();

						for (Iterator eAllOperations = eClass
							.getEAllOperations().iterator(); eAllOperations
							.hasNext();) {

							EOperation eAllOperation = (EOperation) eAllOperations
								.next();

							if (eOperation == eAllOperation) {
								break;
							} else if (new SignatureMatcher(eOperation)
								.matches(eAllOperation)) {

								if (OPTION__PROCESS.equals(options
									.get(OPTION__DUPLICATE_OPERATIONS))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.INFO,
												UML2Validator.DIAGNOSTIC_SOURCE,
												DUPLICATE_OPERATION,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_UML22EcoreConverter_ProcessDuplicateOperation_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context,
															eOperation,
															eAllOperation)),
												new Object[]{eClass,
													eAllOperation}));
									}

									operationsToDuplicate.add(eOperation);

									ensureConformity(eOperation, eAllOperation);

									List redefinedOperations = getEAnnotation(
										eOperation,
										ANNOTATION_SOURCE__REDEFINES, true)
										.getReferences();

									if (!redefinedOperations
										.contains(eAllOperation)) {

										redefinedOperations.add(eAllOperation);
									}
								} else if (OPTION__DISCARD.equals(options
									.get(OPTION__DUPLICATE_OPERATIONS))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.WARNING,
												UML2Validator.DIAGNOSTIC_SOURCE,
												DUPLICATE_OPERATION,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_UML22EcoreConverter_DiscardDuplicateOperation_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context,
															eOperation,
															eAllOperation)),
												new Object[]{eClass,
													eAllOperation}));
									}

									eOperations.remove();
									break;
								} else if (OPTION__REPORT.equals(options
									.get(OPTION__DUPLICATE_OPERATIONS))
									&& null != diagnostics) {

									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.ERROR,
											UML2Validator.DIAGNOSTIC_SOURCE,
											DUPLICATE_OPERATION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_UML22EcoreConverter_ReportDuplicateOperation_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, eOperation,
														eAllOperation)),
											new Object[]{eOperation,
												eAllOperation}));
								}
							}
						}
					}

				}
			}

			for (Iterator eOperations = operationsToDuplicate.iterator(); eOperations
				.hasNext();) {

				EOperation eOperation = (EOperation) eOperations.next();

				getEAnnotation(eOperation.getEContainingClass(),
					ANNOTATION_SOURCE__DUPLICATES, true).getContents().add(
					eOperation);
			}
		}

		protected void processDuplicateOperationInheritance(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator eModelElements = elementToEModelElementMap.values()
				.iterator(); eModelElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) eModelElements
					.next();

				if (eModelElement instanceof EClass) {
					EClass eClass = (EClass) eModelElement;

					if (eClass.getESuperTypes().size() > 1) {
						Iterator eSuperTypes = eClass.getESuperTypes()
							.iterator();
						eSuperTypes.next();

						while (eSuperTypes.hasNext()) {
							EClass mixinEClass = (EClass) eSuperTypes.next();

							mixinEOperationsLoop : for (Iterator mixinEOperations = mixinEClass
								.getEAllOperations().iterator(); mixinEOperations
								.hasNext();) {

								EOperation mixinEOperation = (EOperation) mixinEOperations
									.next();

								for (Iterator eOperations = eClass
									.getEAllOperations().iterator(); eOperations
									.hasNext();) {

									EOperation eOperation = (EOperation) eOperations
										.next();

									if (mixinEOperation == eOperation) {
										break;
									} else if (new SignatureMatcher(
										mixinEOperation).matches(eOperation)) {

										if (OPTION__PROCESS
											.equals(options
												.get(OPTION__DUPLICATE_OPERATION_INHERITANCE))) {

											if (null != diagnostics) {
												diagnostics
													.add(new BasicDiagnostic(
														Diagnostic.INFO,
														UML2Validator.DIAGNOSTIC_SOURCE,
														DUPLICATE_OPERATION_INHERITANCE,
														UML2Plugin.INSTANCE
															.getString(
																"_UI_UML22EcoreConverter_ProcessDuplicateOperationInheritance_diagnostic", //$NON-NLS-1$
																getMessageSubstitutions(
																	context,
																	eClass,
																	eOperation,
																	mixinEOperation)),
														new Object[]{eClass,
															eOperation,
															mixinEOperation}));
											}

											qualifyName(mixinEOperation);

											List redefinedOperations = getEAnnotation(
												mixinEOperation,
												ANNOTATION_SOURCE__REDEFINES,
												true).getReferences();

											if (!redefinedOperations
												.contains(eOperation)) {

												redefinedOperations
													.add(eOperation);
											}
										} else if (OPTION__DISCARD
											.equals(options
												.get(OPTION__DUPLICATE_OPERATION_INHERITANCE))) {

											if (null != diagnostics) {
												diagnostics
													.add(new BasicDiagnostic(
														Diagnostic.WARNING,
														UML2Validator.DIAGNOSTIC_SOURCE,
														DUPLICATE_OPERATION_INHERITANCE,
														UML2Plugin.INSTANCE
															.getString(
																"_UI_UML22EcoreConverter_DiscardDuplicateOperationInheritance_diagnostic", //$NON-NLS-1$
																getMessageSubstitutions(
																	context,
																	eClass,
																	eOperation,
																	mixinEOperation)),
														new Object[]{eClass,
															eOperation,
															mixinEOperation}));
											}

											eSuperTypes.remove();
											break mixinEOperationsLoop;
										} else if (OPTION__REPORT
											.equals(options
												.get(OPTION__DUPLICATE_OPERATION_INHERITANCE))
											&& null != diagnostics) {

											diagnostics
												.add(new BasicDiagnostic(
													Diagnostic.ERROR,
													UML2Validator.DIAGNOSTIC_SOURCE,
													DUPLICATE_OPERATION_INHERITANCE,
													UML2Plugin.INSTANCE
														.getString(
															"_UI_UML22EcoreConverter_ReportDuplicateOperationInheritance_diagnostic", //$NON-NLS-1$
															getMessageSubstitutions(
																context,
																eClass,
																eOperation,
																mixinEOperation)),
													new Object[]{eClass,
														eOperation,
														mixinEOperation}));
										}
									}
								}
							}
						}
					}
				}
			}
		}

		protected void processDuplicateFeatures(Map options,
				DiagnosticChain diagnostics, Map context) {
			List featuresToDuplicate = new UniqueEList.FastCompare();
			List featuresToRemove = new UniqueEList.FastCompare();

			for (Iterator eModelElements = elementToEModelElementMap.values()
				.iterator(); eModelElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) eModelElements
					.next();

				if (eModelElement instanceof EClass) {
					EClass eClass = (EClass) eModelElement;

					for (Iterator eStructuralFeatures = eClass
						.getEStructuralFeatures().iterator(); eStructuralFeatures
						.hasNext();) {

						EStructuralFeature eStructuralFeature = (EStructuralFeature) eStructuralFeatures
							.next();

						for (Iterator eAllStructuralFeatures = eClass
							.getEAllStructuralFeatures().iterator(); eAllStructuralFeatures
							.hasNext();) {

							EStructuralFeature eAllStructuralFeature = (EStructuralFeature) eAllStructuralFeatures
								.next();

							if (eStructuralFeature == eAllStructuralFeature) {
								break;
							} else if (new NameMatcher(eStructuralFeature)
								.matches(eAllStructuralFeature)) {

								if (OPTION__PROCESS.equals(options
									.get(OPTION__DUPLICATE_FEATURES))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.INFO,
												UML2Validator.DIAGNOSTIC_SOURCE,
												DUPLICATE_FEATURE,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_UML22EcoreConverter_ProcessDuplicateFeature_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context,
															eStructuralFeature,
															eAllStructuralFeature)),
												new Object[]{
													eStructuralFeature,
													eAllStructuralFeature}));
									}

									if (!featuresToDuplicate
										.contains(eStructuralFeature)) {

										EStructuralFeature duplicateEStructuralFeature = eAllStructuralFeature
											.isDerived()
											&& !eStructuralFeature.isDerived()
											? eAllStructuralFeature
											: eStructuralFeature;

										if (DEBUG
											&& eAllStructuralFeature == duplicateEStructuralFeature) {

											System.err
												.println("Non-derived feature " //$NON-NLS-1$
													+ getQualifiedText(eStructuralFeature)
													+ " is a duplicate of derived feature " //$NON-NLS-1$
													+ getQualifiedText(eAllStructuralFeature));
										}

										featuresToDuplicate
											.add(duplicateEStructuralFeature);

										ensureConformity(eStructuralFeature,
											eAllStructuralFeature);
									}

									List redefinedFeatures = getEAnnotation(
										eStructuralFeature,
										ANNOTATION_SOURCE__REDEFINES, true)
										.getReferences();

									if (!redefinedFeatures
										.contains(eAllStructuralFeature)) {

										redefinedFeatures
											.add(eAllStructuralFeature);
									}
								} else if (OPTION__DISCARD.equals(options
									.get(OPTION__DUPLICATE_FEATURES))) {

									if (null != diagnostics) {
										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.WARNING,
												UML2Validator.DIAGNOSTIC_SOURCE,
												DUPLICATE_FEATURE,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_UML22EcoreConverter_DiscardDuplicateFeature_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context,
															eStructuralFeature,
															eAllStructuralFeature)),
												new Object[]{eClass,
													eAllStructuralFeature}));
									}

									if (eStructuralFeature instanceof EReference) {
										EReference eOpposite = ((EReference) eStructuralFeature)
											.getEOpposite();

										if (null != eOpposite) {
											featuresToRemove.add(eOpposite);
										}
									}

									eStructuralFeatures.remove();
									break;
								} else if (OPTION__REPORT.equals(options
									.get(OPTION__DUPLICATE_FEATURES))
									&& null != diagnostics) {

									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.ERROR,
											UML2Validator.DIAGNOSTIC_SOURCE,
											DUPLICATE_FEATURE,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_UML22EcoreConverter_ReportDuplicateFeature_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context,
														eStructuralFeature,
														eAllStructuralFeature)),
											new Object[]{eStructuralFeature,
												eAllStructuralFeature}));
								}
							}
						}
					}
				}
			}

			for (Iterator eStructuralFeatures = featuresToDuplicate.iterator(); eStructuralFeatures
				.hasNext();) {

				EStructuralFeature eStructuralFeature = (EStructuralFeature) eStructuralFeatures
					.next();

				getEAnnotation(eStructuralFeature.getEContainingClass(),
					ANNOTATION_SOURCE__DUPLICATES, true).getContents().add(
					eStructuralFeature);

				if (eStructuralFeature instanceof EReference) {
					EReference eOpposite = ((EReference) eStructuralFeature)
						.getEOpposite();

					if (null != eOpposite
						&& !featuresToDuplicate.contains(eOpposite)) {

						eOpposite.setEOpposite(null);

						if (((EReference) eStructuralFeature).isContainment()) {
							eOpposite.setChangeable(false);
							eOpposite.setTransient(true);
						}

						eOpposite.setVolatile(true);
					}
				}
			}

			for (Iterator eStructuralFeatures = featuresToRemove.iterator(); eStructuralFeatures
				.hasNext();) {

				EStructuralFeature eStructuralFeature = (EStructuralFeature) eStructuralFeatures
					.next();
				EClass eContainingClass = eStructuralFeature
					.getEContainingClass();

				if (null != eContainingClass) {
					eContainingClass.getEStructuralFeatures().remove(
						eStructuralFeature);
				}
			}
		}

		protected void processDuplicateFeatureInheritance(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator eModelElements = elementToEModelElementMap.values()
				.iterator(); eModelElements.hasNext();) {

				EModelElement eModelElement = (EModelElement) eModelElements
					.next();

				if (eModelElement instanceof EClass) {
					EClass eClass = (EClass) eModelElement;

					if (eClass.getESuperTypes().size() > 1) {
						Iterator eSuperTypes = eClass.getESuperTypes()
							.iterator();
						eSuperTypes.next();

						while (eSuperTypes.hasNext()) {
							EClass mixinEClass = (EClass) eSuperTypes.next();

							mixinEStructuralFeaturesLoop : for (Iterator mixinEStructuralFeatures = mixinEClass
								.getEAllStructuralFeatures().iterator(); mixinEStructuralFeatures
								.hasNext();) {

								EStructuralFeature mixinEStructuralFeature = (EStructuralFeature) mixinEStructuralFeatures
									.next();

								for (Iterator eStructuralFeatures = eClass
									.getEAllStructuralFeatures().iterator(); eStructuralFeatures
									.hasNext();) {

									EStructuralFeature eStructuralFeature = (EStructuralFeature) eStructuralFeatures
										.next();

									if (mixinEStructuralFeature == eStructuralFeature) {
										break;
									} else if (new NameMatcher(
										mixinEStructuralFeature)
										.matches(eStructuralFeature)) {

										if (OPTION__PROCESS
											.equals(options
												.get(OPTION__DUPLICATE_FEATURE_INHERITANCE))) {

											if (null != diagnostics) {
												diagnostics
													.add(new BasicDiagnostic(
														Diagnostic.INFO,
														UML2Validator.DIAGNOSTIC_SOURCE,
														DUPLICATE_FEATURE_INHERITANCE,
														UML2Plugin.INSTANCE
															.getString(
																"_UI_UML22EcoreConverter_ProcessDuplicateFeatureInheritance_diagnostic", //$NON-NLS-1$
																getMessageSubstitutions(
																	context,
																	eClass,
																	eStructuralFeature,
																	mixinEStructuralFeature)),
														new Object[]{eClass,
															eStructuralFeature,
															mixinEStructuralFeature}));
											}

											qualifyName(mixinEStructuralFeature);

											List redefinedFeatures = getEAnnotation(
												mixinEStructuralFeature,
												ANNOTATION_SOURCE__REDEFINES,
												true).getReferences();

											if (!redefinedFeatures
												.contains(eStructuralFeature)) {

												redefinedFeatures
													.add(eStructuralFeature);
											}
										} else if (OPTION__DISCARD
											.equals(options
												.get(OPTION__DUPLICATE_FEATURE_INHERITANCE))) {

											if (null != diagnostics) {
												diagnostics
													.add(new BasicDiagnostic(
														Diagnostic.WARNING,
														UML2Validator.DIAGNOSTIC_SOURCE,
														DUPLICATE_FEATURE_INHERITANCE,
														UML2Plugin.INSTANCE
															.getString(
																"_UI_UML22EcoreConverter_DiscardDuplicateFeatureInheritance_diagnostic", //$NON-NLS-1$
																getMessageSubstitutions(
																	context,
																	eClass,
																	eStructuralFeature,
																	mixinEStructuralFeature)),
														new Object[]{eClass,
															eStructuralFeature,
															mixinEStructuralFeature}));
											}

											eSuperTypes.remove();
											break mixinEStructuralFeaturesLoop;
										} else if (OPTION__REPORT
											.equals(options
												.get(OPTION__DUPLICATE_FEATURE_INHERITANCE))
											&& null != diagnostics) {

											diagnostics
												.add(new BasicDiagnostic(
													Diagnostic.ERROR,
													UML2Validator.DIAGNOSTIC_SOURCE,
													DUPLICATE_FEATURE_INHERITANCE,
													UML2Plugin.INSTANCE
														.getString(
															"_UI_UML22EcoreConverter_ReportDuplicateFeatureInheritance_diagnostic", //$NON-NLS-1$
															getMessageSubstitutions(
																context,
																eClass,
																eStructuralFeature,
																mixinEStructuralFeature)),
													new Object[]{eClass,
														eStructuralFeature,
														mixinEStructuralFeature}));
										}
									}
								}
							}
						}
					}
				}
			}
		}

		protected void processSuperClassOrder(Map options,
				DiagnosticChain diagnostics, Map context) {

			Comparator eClassComparator = new Comparator() {

				public int compare(Object object, Object otherObject) {
					EClass eClass = (EClass) object;
					EClass otherEClass = (EClass) otherObject;

					int eAllStructuralFeaturesSize = eClass
						.getEAllStructuralFeatures().size();
					int otherEAllStructuralFeaturesSize = otherEClass
						.getEAllStructuralFeatures().size();

					return eAllStructuralFeaturesSize < otherEAllStructuralFeaturesSize
						? 1
						: (otherEAllStructuralFeaturesSize < eAllStructuralFeaturesSize
							? -1
							: eClass.getName().compareTo(otherEClass.getName()));
				}
			};

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {
				Map.Entry entry = (Map.Entry) entries.next();
				Object key = entry.getKey();
				Object value = entry.getValue();

				if (key instanceof Classifier && value instanceof EClass) {
					EClass eClass = (EClass) value;
					EList eSuperTypes = eClass.getESuperTypes();

					List extendSuperClasses = new ArrayList();
					List unspecifiedSuperClasses = new ArrayList();
					List mixinSuperClasses = new ArrayList();

					for (Iterator generalizations = ((Classifier) key)
						.getGeneralizations().iterator(); generalizations
						.hasNext();) {
						Generalization generalization = (Generalization) generalizations
							.next();
						Classifier general = generalization.getGeneral();

						if (null != general) {
							EModelElement eModelElement = (EModelElement) elementToEModelElementMap
								.get(general);

							if (eSuperTypes.contains(eModelElement)) {

								if (generalization.hasKeyword("extend")) { //$NON-NLS-1$
									extendSuperClasses.add(eModelElement);
								} else if (generalization.hasKeyword("mixin")) { //$NON-NLS-1$
									mixinSuperClasses.add(eModelElement);
								} else {
									unspecifiedSuperClasses.add(eModelElement);
								}
							}
						}

					}

					Collections.sort(extendSuperClasses, eClassComparator);
					Collections.sort(unspecifiedSuperClasses, eClassComparator);
					Collections.sort(mixinSuperClasses, eClassComparator);

					List superClasses = new UniqueEList.FastCompare(
						extendSuperClasses);
					superClasses.addAll(unspecifiedSuperClasses);
					superClasses.addAll(mixinSuperClasses);

					if (!superClasses.equals(eSuperTypes)) {

						if (OPTION__PROCESS.equals(options
							.get(OPTION__SUPER_CLASS_ORDER))) {

							if (null != diagnostics) {
								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.INFO,
										UML2Validator.DIAGNOSTIC_SOURCE,
										SUPER_CLASS_ORDER,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ProcessSuperClassOrder_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eClass)),
										new Object[]{eClass}));
							}

							for (ListIterator li = superClasses.listIterator(); li
								.hasNext();) {

								Object superClass = li.next();
								eSuperTypes
									.move(li.previousIndex(), superClass);
							}
						} else if (OPTION__REPORT.equals(options
							.get(OPTION__SUPER_CLASS_ORDER))
							&& null != diagnostics) {

							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.WARNING,
									UML2Validator.DIAGNOSTIC_SOURCE,
									SUPER_CLASS_ORDER,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_UML22EcoreConverter_ReportSuperClassOrder_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												eClass)), new Object[]{eClass}));
						}
					}
				}
			}
		}

		protected void processAnnotationDetails(final Map options,
				final DiagnosticChain diagnostics, final Map context) {

			for (Iterator entries = elementToEModelElementMap.entrySet()
				.iterator(); entries.hasNext();) {

				final Map.Entry entry = (Map.Entry) entries.next();
				EModelElement eModelElement = (EModelElement) entry.getValue();

				if (null != eModelElement) {
					Element element = (Element) entry.getKey();

					for (Iterator eAnnotations = element.getEAnnotations()
						.iterator(); eAnnotations.hasNext();) {

						EAnnotation eAnnotation = (EAnnotation) eAnnotations
							.next();
						EMap details = eAnnotation.getDetails();

						if (!details.isEmpty()) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__ANNOTATION_DETAILS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											ANNOTATION_DETAILS,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_UML22EcoreConverter_ProcessAnnotationDetails_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, eModelElement,
														eAnnotation.getSource())),
											new Object[]{eModelElement}));
								}

								getEAnnotation(eModelElement,
									eAnnotation.getSource(), true).getDetails()
									.putAll(details.map());
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__ANNOTATION_DETAILS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										ANNOTATION_DETAILS,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_UML22EcoreConverter_ReportAnnotationDetails_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, eModelElement,
													eAnnotation.getSource())),
										new Object[]{eModelElement}));
							}
						}
					}
				}
			}
		}

		protected void processOptions(Map options, DiagnosticChain diagnostics,
				Map context) {

			if (!OPTION__IGNORE
				.equals(options.get(OPTION__ECORE_TAGGED_VALUES))) {

				processEcoreTaggedValues(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__REDEFINING_OPERATIONS))) {

				processRedefiningOperations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__REDEFINING_PROPERTIES))) {

				processRedefiningProperties(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__SUBSETTING_PROPERTIES))) {

				processSubsettingProperties(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__DERIVED_FEATURES))) {
				processDerivedFeatures(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__UNION_PROPERTIES))) {
				processUnionProperties(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__DUPLICATE_OPERATIONS))) {

				processDuplicateOperations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__DUPLICATE_OPERATION_INHERITANCE))) {

				processDuplicateOperationInheritance(options, diagnostics,
					context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__DUPLICATE_FEATURES))) {
				processDuplicateFeatures(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__DUPLICATE_FEATURE_INHERITANCE))) {

				processDuplicateFeatureInheritance(options, diagnostics,
					context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__SUPER_CLASS_ORDER))) {
				processSuperClassOrder(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__ANNOTATION_DETAILS))) {
				processAnnotationDetails(options, diagnostics, context);
			}
		}

		public Collection convert(Collection eObjects, Map options,
				DiagnosticChain diagnostics, Map context) {
			packages = EcoreUtil.getObjectsByType(eObjects,
				UML2Package.Literals.PACKAGE);

			for (Iterator p = packages.iterator(); p.hasNext();) {
				doSwitch((org.eclipse.uml2.Package) p.next());
			}

			if (null != options) {
				processOptions(options, diagnostics, context);
			}

			return getRootContainers(EcoreUtil.getObjectsByType(
				elementToEModelElementMap.values(), EcorePackage.eINSTANCE
					.getEPackage()));
		}

	}

	public static class PackageMerger
			extends EcoreUtil.Copier {

		protected class BodyMatcher
				extends EClassMatcher {

			protected BodyMatcher(Comment comment) {
				super(comment);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((Comment) eObject)
						.getBody().equals(((Comment) otherEObject).getBody()));
			}
		}

		protected class NameMatcher
				extends EClassMatcher {

			protected NameMatcher(NamedElement namedElement) {
				super(namedElement);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((NamedElement) eObject)
						.getName().equals(
							((NamedElement) otherEObject).getName()));
			}
		}

		protected class KeyMatcher
				extends EClassMatcher {

			protected KeyMatcher(BasicEMap.Entry entry) {
				super((EObject) entry);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((BasicEMap.Entry) eObject)
						.getKey().equals(
							((BasicEMap.Entry) otherEObject).getKey()));
			}
		}

		protected class ResultingQNameMatcher
				extends EClassMatcher {

			protected ResultingQNameMatcher(EObject eObject) {
				super(eObject);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || getResultingQName(
						eObject).equals(getResultingQName(otherEObject)));
			}
		}

		protected class StringValueMatcher
				extends EClassMatcher {

			protected StringValueMatcher(ValueSpecification valueSpecification) {
				super(valueSpecification);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((ValueSpecification) eObject)
						.stringValue().equals(
							((ValueSpecification) otherEObject).stringValue()));
			}
		}

		protected class SourceMatcher
				extends EClassMatcher {

			protected SourceMatcher(EAnnotation eAnnotation) {
				super(eAnnotation);
			}

			public boolean matches(EObject otherEObject) {

				return super.matches(otherEObject)
					&& ((null == eObject && null == otherEObject) || ((EAnnotation) eObject)
						.getSource().equals(
							((EAnnotation) otherEObject).getSource()));
			}
		}

		protected class TypeMatcher
				extends NameMatcher {

			protected TypeMatcher(TypedElement typedElement) {
				super(typedElement);
			}

			public boolean matches(EObject otherEObject) {

				if (super.matches(otherEObject)) {

					if (null == eObject && null == otherEObject) {
						return true;
					} else {
						Type type = ((TypedElement) eObject).getType();
						Type otherType = ((TypedElement) otherEObject)
							.getType();

						return new ResultingQNameMatcher(type)
							.matches(otherType)
							|| (type instanceof Classifier
								&& otherType instanceof Classifier && (null != findEObject(
								((Classifier) type).allParents(),
								new ResultingQNameMatcher(otherType)) || null != findEObject(
								((Classifier) otherType).allParents(),
								new ResultingQNameMatcher(type))));
					}
				}

				return false;
			}
		}

		public static final String OPTION__DIFFERENT_PROPERTY_STATICITY = "DIFFERENT_PROPERTY_STATICITY"; //$NON-NLS-1$

		public static final String OPTION__DIFFERENT_PROPERTY_UNIQUENESS = "DIFFERENT_PROPERTY_UNIQUENESS"; //$NON-NLS-1$

		public static final String OPTION__REDUNDANT_GENERALIZATIONS = "REDUNDANT_GENERALIZATIONS"; //$NON-NLS-1$

		public static final String OPTION__IMPLICIT_REDEFINITIONS = "IMPLICIT_REDEFINITIONS"; //$NON-NLS-1$

		public static final String OPTION__INVALID_REDEFINITIONS = "INVALID_REDEFINITIONS"; //$NON-NLS-1$

		public static final String OPTION__INVALID_SUBSETS = "INVALID_SUBSETS"; //$NON-NLS-1$

		public static final String OPTION__EMPTY_UNIONS = "EMPTY_UNIONS"; //$NON-NLS-1$

		public static final String OPTION__ASSOCIATION_SPECIALIZATIONS = "ASSOCIATION_SPECIALIZATIONS"; //$NON-NLS-1$

		public static final String OPTION__CAPABILITIES = "CAPABILITIES"; //$NON-NLS-1$

		private static final int DIAGNOSTIC_CODE_OFFSET = 1000;

		public static final int DIFFERENT_PROPERTY_STATICITY = DIAGNOSTIC_CODE_OFFSET + 1;

		public static final int DIFFERENT_PROPERTY_UNIQUENESS = DIAGNOSTIC_CODE_OFFSET + 2;

		public static final int REDUNDANT_GENERALIZATION = DIAGNOSTIC_CODE_OFFSET + 3;

		public static final int IMPLICIT_REDEFINITION = DIAGNOSTIC_CODE_OFFSET + 4;

		public static final int INVALID_REDEFINITION = DIAGNOSTIC_CODE_OFFSET + 5;

		public static final int INVALID_SUBSET = DIAGNOSTIC_CODE_OFFSET + 6;

		public static final int EMPTY_UNION = DIAGNOSTIC_CODE_OFFSET + 7;

		public static final int ASSOCIATION_SPECIALIZATION = DIAGNOSTIC_CODE_OFFSET + 8;

		public static final int CAPABILITY = DIAGNOSTIC_CODE_OFFSET + 9;

		protected static final String ANNOTATION_SOURCE__STEREOTYPE = "stereotype"; //$NON-NLS-1$

		protected static final String ANNOTATION_SOURCE__CAPABILITIES = "capabilities"; //$NON-NLS-1$

		protected org.eclipse.uml2.Package receivingPackage = null;

		protected Collection mergedPackages = null;

		protected final Map resultingToMergedEObjectMap = new LinkedHashMap();

		private final Map copierMap = new LinkedHashMap();

		public void clear() {
			copierMap.clear();
		}

		public boolean containsKey(Object key) {
			return copierMap.containsKey(key);
		}

		public boolean containsValue(Object value) {
			return copierMap.containsValue(value);
		}

		public Set entrySet() {
			return copierMap.entrySet();
		}

		public Object get(Object key) {
			return copierMap.get(key);
		}

		public boolean isEmpty() {
			return copierMap.isEmpty();
		}

		public Set keySet() {
			return copierMap.keySet();
		}

		public Object put(Object key, Object value) {
			return copierMap.put(key, value);
		}

		public void putAll(Map t) {
			copierMap.putAll(t);
		}

		public Object remove(Object key) {
			return copierMap.remove(key);
		}

		public int size() {
			return copierMap.size();
		}

		public Collection values() {
			return copierMap.values();
		}

		protected List getMatchCandidates(EObject eObject) {
			EStructuralFeature eContainingFeature = eObject
				.eContainingFeature();

			return eContainingFeature.isMany()
				? (List) ((EObject) get(eObject.eContainer()))
					.eGet(eContainingFeature)
				: Collections
					.singletonList(((EObject) get(eObject.eContainer()))
						.eGet(eContainingFeature));
		}

		protected List getMergedEObjects(EObject resultingEObject) {
			Object mergedEObjects = resultingToMergedEObjectMap
				.get(resultingEObject);

			return null == mergedEObjects
				? Collections.singletonList(resultingEObject)
				: (List) mergedEObjects;
		}

		protected EObject getPreviouslyMergedEObject(EObject resultingEObject) {
			List mergedEObjects = getMergedEObjects(resultingEObject);

			return (EObject) mergedEObjects.get(mergedEObjects.size() - 1);
		}

		protected String getResultingQName(EObject eObject) {
			StringBuffer resultingQName = appendResultingQName(
				new StringBuffer(), eObject, QualifiedTextProvider.DEFAULT);

			return resultingQName.toString();
		}

		private StringBuffer appendResultingQName(StringBuffer resultingQName,
				EObject eObject, QualifiedTextProvider qualifiedTextProvider) {

			eObject = mergedPackages.contains(eObject)
				? receivingPackage
				: eObject;

			EObject eContainer = eObject.eContainer();

			if (null != eContainer) {
				appendResultingQName(resultingQName, eContainer,
					qualifiedTextProvider);

				if (0 < resultingQName.length()) {
					resultingQName.append(qualifiedTextProvider.getSeparator());
				}
			}

			return getQualifiedTextSegment(eObject, qualifiedTextProvider,
				resultingQName);
		}

		protected void mergeAssociation_IsDerived(
				Association receivingAssociation, Association mergedAssociation) {

			receivingAssociation.setIsDerived(receivingAssociation.isDerived()
				|| mergedAssociation.isDerived());
		}

		protected void mergeClassifier_IsAbstract(
				Classifier receivingClassifier, Classifier mergedClassifier) {

			receivingClassifier.setIsAbstract(receivingClassifier.isAbstract()
				&& mergedClassifier.isAbstract());
		}

		protected void mergeLiteralInteger_Value(
				LiteralInteger receivingLiteralInteger,
				LiteralInteger mergedLiteralInteger) {

			receivingLiteralInteger.setValue(getLesserLowerBound(
				receivingLiteralInteger.getValue(), mergedLiteralInteger
					.getValue()));
		}

		protected void mergeLiteralUnlimitedNatural_Value(
				LiteralUnlimitedNatural receivingLiteralUnlimitedNatural,
				LiteralUnlimitedNatural mergedLiteralUnlimitedNatural) {

			receivingLiteralUnlimitedNatural.setValue(getGreaterUpperBound(
				receivingLiteralUnlimitedNatural.getValue(),
				mergedLiteralUnlimitedNatural.getValue()));
		}

		protected void mergeMultiplicityElement_IsOrdered(
				MultiplicityElement receivingMultiplicityElement,
				MultiplicityElement mergedMultiplicityElement) {

			receivingMultiplicityElement
				.setIsOrdered(receivingMultiplicityElement.isOrdered()
					|| mergedMultiplicityElement.isOrdered());
		}

		protected void mergeMultiplicityElement_IsUnique(
				MultiplicityElement receivingMultiplicityElement,
				MultiplicityElement mergedMultiplicityElement) {

			receivingMultiplicityElement
				.setIsUnique(receivingMultiplicityElement.isUnique()
					&& mergedMultiplicityElement.isUnique());
		}

		protected void mergeNamedElement_Visibility(
				NamedElement receivingNamedElement,
				NamedElement mergedNamedElement) {

			receivingNamedElement
				.setVisibility(VisibilityKind.PRIVATE_LITERAL == receivingNamedElement
					.getVisibility()
					&& VisibilityKind.PRIVATE_LITERAL == mergedNamedElement
						.getVisibility()
					? VisibilityKind.PRIVATE_LITERAL
					: VisibilityKind.PUBLIC_LITERAL);
		}

		protected void mergePackageableElement_PackageableElement_visibility(
				PackageableElement receivingPackageableElement,
				PackageableElement mergedPackageableElement) {

			receivingPackageableElement
				.setPackageableElement_visibility(VisibilityKind.PRIVATE_LITERAL == receivingPackageableElement
					.getPackageableElement_visibility()
					&& VisibilityKind.PRIVATE_LITERAL == mergedPackageableElement
						.getPackageableElement_visibility()
					? VisibilityKind.PRIVATE_LITERAL
					: VisibilityKind.PUBLIC_LITERAL);
		}

		protected void mergeProperty_IsDerived(Property receivingProperty,
				Property mergedProperty) {

			receivingProperty.setIsDerived(receivingProperty.isDerived()
				|| mergedProperty.isDerived());
		}

		protected void mergeProperty_IsDerivedUnion(Property receivingProperty,
				Property mergedProperty) {

			receivingProperty.setIsDerivedUnion(receivingProperty
				.isDerivedUnion()
				|| mergedProperty.isDerivedUnion());
		}

		protected void mergeStructuralFeature_IsReadOnly(
				StructuralFeature receivingStructuralFeature,
				StructuralFeature mergedStructuralFeature) {

			receivingStructuralFeature.setIsReadOnly(receivingStructuralFeature
				.isReadOnly()
				&& mergedStructuralFeature.isReadOnly());
		}

		protected void copyAttribute(EAttribute eAttribute, EObject eObject,
				EObject copyEObject) {

			if (eObject != copyEObject) {

				if (receivingPackage == copyEObject) {
					return;
				} else if (resultingToMergedEObjectMap.containsKey(copyEObject)) {

					if (UML2Package.Literals.ASSOCIATION__IS_DERIVED == eAttribute) {
						mergeAssociation_IsDerived((Association) copyEObject,
							(Association) eObject);
					} else if (UML2Package.Literals.CLASSIFIER__IS_ABSTRACT == eAttribute) {
						mergeClassifier_IsAbstract((Classifier) copyEObject,
							(Classifier) eObject);
					} else if (UML2Package.Literals.LITERAL_INTEGER__VALUE == eAttribute
						&& UML2Package.Literals.MULTIPLICITY_ELEMENT__LOWER_VALUE == copyEObject
							.eContainingFeature()) {

						mergeLiteralInteger_Value((LiteralInteger) copyEObject,
							(LiteralInteger) eObject);
					} else if (UML2Package.Literals.LITERAL_UNLIMITED_NATURAL__VALUE == eAttribute
						&& UML2Package.Literals.MULTIPLICITY_ELEMENT__UPPER_VALUE == copyEObject
							.eContainingFeature()) {

						mergeLiteralUnlimitedNatural_Value(
							(LiteralUnlimitedNatural) copyEObject,
							(LiteralUnlimitedNatural) eObject);
					} else if (UML2Package.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED == eAttribute) {

						mergeMultiplicityElement_IsOrdered(
							(MultiplicityElement) copyEObject,
							(MultiplicityElement) eObject);
					} else if (UML2Package.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE == eAttribute) {

						mergeMultiplicityElement_IsUnique(
							(MultiplicityElement) copyEObject,
							(MultiplicityElement) eObject);
					} else if (UML2Package.Literals.NAMED_ELEMENT__VISIBILITY == eAttribute) {
						mergeNamedElement_Visibility(
							(NamedElement) copyEObject, (NamedElement) eObject);
					} else if (UML2Package.Literals.PACKAGEABLE_ELEMENT__PACKAGEABLE_ELEMENT_VISIBILITY == eAttribute) {

						mergePackageableElement_PackageableElement_visibility(
							(PackageableElement) copyEObject,
							(PackageableElement) eObject);
					} else if (UML2Package.Literals.PROPERTY__IS_DERIVED == eAttribute) {
						mergeProperty_IsDerived((Property) copyEObject,
							(Property) eObject);
					} else if (UML2Package.Literals.PROPERTY__IS_DERIVED_UNION == eAttribute) {
						mergeProperty_IsDerivedUnion((Property) copyEObject,
							(Property) eObject);
					} else if (UML2Package.Literals.STRUCTURAL_FEATURE__IS_READ_ONLY == eAttribute) {

						mergeStructuralFeature_IsReadOnly(
							(StructuralFeature) copyEObject,
							(StructuralFeature) eObject);
					} else {
						super.copyAttribute(eAttribute, eObject, copyEObject);
					}
				} else {
					super.copyAttribute(eAttribute, eObject, copyEObject);
				}
			}
		}

		protected void copyContainment(EReference eReference, EObject eObject,
				EObject copyEObject) {

			if (eObject != copyEObject) {

				if (eReference.isMany()) {
					InternalEList targetList = (InternalEList) copyEObject
						.eGet(getTarget(eReference));

					for (Iterator i = ((List) eObject.eGet(eReference))
						.iterator(); i.hasNext();) {

						EObject childEObject = (EObject) i.next();
						EObject copyChildEObject = copy(childEObject);

						if (childEObject != copyChildEObject) {
							targetList.addUnique(copyChildEObject);
						}
					}
				} else {
					EObject childEObject = (EObject) eObject.eGet(eReference);
					EObject copyChildEObject = null == childEObject
						? null
						: copy(childEObject);

					if (childEObject != copyChildEObject) {
						copyEObject.eSet(getTarget(eReference),
							copyChildEObject);
					}
				}
			}
		}

		protected void mergeTypedElement_Type(
				TypedElement receivingTypedElement,
				TypedElement mergedTypedElement) {

			Type receivingType = receivingTypedElement.getType();
			Type mergedType = mergedTypedElement.getType();

			if (null != receivingType && mergedType instanceof Classifier) {
				Set allParents = ((Classifier) mergedType).allParents();

				for (Iterator mergedEObjects = getMergedEObjects(receivingType)
					.iterator(); mergedEObjects.hasNext();) {

					EObject mergedEObject = (EObject) mergedEObjects.next();

					if (null != findEObject(allParents,
						new ResultingQNameMatcher(mergedEObject))) {

						mergedType = (Type) mergedEObject;
					}
				}
			}

			Type resultingType = null == mergedType
				? null
				: (Type) get(mergedType);

			receivingTypedElement.setType(null == resultingType
				? mergedType
				: resultingType);
		}

		protected void copyReference(EReference eReference, EObject eObject,
				EObject copyEObject) {

			if (eObject != copyEObject && eObject.eIsSet(eReference)) {

				if (UML2Package.Literals.TYPED_ELEMENT__TYPE == eReference) {
					mergeTypedElement_Type((TypedElement) copyEObject,
						(TypedElement) eObject);
				} else if (eReference.isMany()) {
					InternalEList targetList = (InternalEList) copyEObject
						.eGet(getTarget(eReference));

					boolean isBidirectional = eReference.getEOpposite() != null;
					int index = 0;

					for (Iterator i = ((List) eObject.eGet(eReference))
						.iterator(); i.hasNext();) {

						Object referencedEObject = i.next();
						Object copyReferencedEObject = get(referencedEObject);

						if (copyReferencedEObject == null) {

							if (!isBidirectional) {

								if (!targetList.contains(referencedEObject)) {
									targetList.addUnique(index,
										referencedEObject);
								}

								index++;
							}
						} else {

							if (isBidirectional) {
								int position = targetList
									.indexOf(copyReferencedEObject);

								if (position == -1) {
									targetList.addUnique(index,
										copyReferencedEObject);
								} else if (index != position) {
									targetList.move(index,
										copyReferencedEObject);
								}
							} else if (!targetList
								.contains(copyReferencedEObject)) {

								targetList.addUnique(index,
									copyReferencedEObject);
							}

							index++;
						}
					}
				} else {
					super.copyReference(eReference, eObject, copyEObject);
				}
			}
		}

		protected EObject createCopy(EObject eObject) {
			return (EObject) new UML2Switch() {

				public Object caseAssociation(Association association) {
					Association matchingAssociation = (Association) findEObject(
						getMatchCandidates(association), new NameMatcher(
							association) {

							public boolean matches(EObject otherEObject) {

								if (super.matches(otherEObject)) {
									otherEObject = getPreviouslyMergedEObject(otherEObject);

									List memberEnds = ((Association) eObject)
										.getMemberEnds();
									List otherMemberEnds = ((Association) otherEObject)
										.getMemberEnds();

									if (memberEnds.size() == otherMemberEnds
										.size()) {

										for (Iterator i = memberEnds.iterator(); i
											.hasNext();) {

											if (null == findEObject(
												otherMemberEnds,
												new TypeMatcher(
													(TypedElement) i.next()))) {

												return false;
											}
										}

										return true;
									}

								}

								return false;
							}
						});

					return null == matchingAssociation
						? super.caseAssociation(association)
						: matchingAssociation;
				}

				public Object caseClass(org.eclipse.uml2.Class class_) {
					org.eclipse.uml2.Class matchingClass = (org.eclipse.uml2.Class) findEObject(
						getMatchCandidates(class_), new NameMatcher(class_));

					return null == matchingClass
						? super.caseClass(class_)
						: matchingClass;
				}

				public Object caseComment(Comment comment) {
					Comment matchingComment = (Comment) findEObject(
						getMatchCandidates(comment), new BodyMatcher(comment));

					return null == matchingComment
						? super.caseComment(comment)
						: matchingComment;
				}

				public Object caseConstraint(Constraint constraint) {
					Constraint matchingConstraint = (Constraint) findEObject(
						getMatchCandidates(constraint), new NameMatcher(
							constraint));

					return null == matchingConstraint
						? super.caseConstraint(constraint)
						: matchingConstraint;
				}

				public Object caseDataType(DataType dataType) {
					DataType matchingDataType = (DataType) findEObject(
						getMatchCandidates(dataType), new NameMatcher(dataType));

					return null == matchingDataType
						? super.caseDataType(dataType)
						: matchingDataType;
				}

				public Object caseDirectedRelationship(
						DirectedRelationship directedRelationship) {

					if (mergedPackages.containsAll(directedRelationship
						.getTargets())) {

						return directedRelationship;
					}

					DirectedRelationship matchingDirectedRelationship = (DirectedRelationship) findEObject(
						getMatchCandidates(directedRelationship),
						new EClassMatcher(directedRelationship) {

							public boolean matches(EObject otherEObject) {

								if (super.matches(otherEObject)) {
									otherEObject = getPreviouslyMergedEObject(otherEObject);

									List targets = ((DirectedRelationship) eObject)
										.getTargets();
									List otherTargets = ((DirectedRelationship) otherEObject)
										.getTargets();

									if (targets.size() == otherTargets.size()) {

										for (Iterator i = targets.iterator(); i
											.hasNext();) {

											if (null == findEObject(
												otherTargets,
												new ResultingQNameMatcher(
													(EObject) i.next()))) {

												return false;
											}
										}

										return true;
									}
								}

								return false;
							}
						});

					return null == matchingDirectedRelationship
						? super.caseDirectedRelationship(directedRelationship)
						: matchingDirectedRelationship;
				}

				public Object caseEnumerationLiteral(
						EnumerationLiteral enumerationLiteral) {
					EnumerationLiteral matchingEnumerationLiteral = (EnumerationLiteral) findEObject(
						getMatchCandidates(enumerationLiteral),
						new NameMatcher(enumerationLiteral));

					return null == matchingEnumerationLiteral
						? super.caseEnumerationLiteral(enumerationLiteral)
						: matchingEnumerationLiteral;
				}

				public Object caseOperation(Operation operation) {
					Operation matchingOperation = (Operation) findEObject(
						getMatchCandidates(operation), new NameMatcher(
							operation) {

							public boolean matches(EObject otherEObject) {

								if (super.matches(otherEObject)) {
									otherEObject = getPreviouslyMergedEObject(otherEObject);

									List ownedParameters = ((Operation) eObject)
										.getOwnedParameters();
									List otherOwnedParameters = ((Operation) otherEObject)
										.getOwnedParameters();

									if (ownedParameters.size() == otherOwnedParameters
										.size()) {

										for (int i = 0; i < ownedParameters
											.size(); i++) {

											if (!new TypeMatcher(
												(TypedElement) ownedParameters
													.get(i))
												.matches((EObject) otherOwnedParameters
													.get(i))) {

												return false;
											}
										}

										return true;
									}
								}

								return false;
							}
						});

					return null == matchingOperation
						? super.caseOperation(operation)
						: matchingOperation;
				}

				public Object casePackage(org.eclipse.uml2.Package package_) {
					org.eclipse.uml2.Package matchingPackage = null;

					if (mergedPackages.contains(package_)) {
						matchingPackage = receivingPackage;
					} else {
						matchingPackage = (org.eclipse.uml2.Package) findEObject(
							getMatchCandidates(package_), new NameMatcher(
								package_));
					}

					return null == matchingPackage
						? super.casePackage(package_)
						: matchingPackage;
				}

				public Object caseParameter(Parameter parameter) {
					Parameter matchingParameter = (Parameter) findEObject(
						getMatchCandidates(parameter), new NameMatcher(
							parameter));

					return null == matchingParameter
						? super.caseParameter(parameter)
						: matchingParameter;
				}

				public Object caseProperty(Property property) {
					Property matchingProperty = (Property) findEObject(
						getMatchCandidates(property), new NameMatcher(property));

					return null == matchingProperty
						? super.caseProperty(property)
						: matchingProperty;
				}

				public Object defaultCase(EObject eObject) {
					return PackageMerger.super.createCopy(eObject);
				}

				protected Object doSwitch(EClass theEClass, EObject theEObject) {

					if (modelPackage != theEClass.eContainer()) {

						if (EcorePackage.eINSTANCE.getEAnnotation() == theEClass) {
							EAnnotation matchingEAnnotation = (EAnnotation) findEObject(
								getMatchCandidates(theEObject),
								new SourceMatcher((EAnnotation) theEObject));

							if (null != matchingEAnnotation) {
								return matchingEAnnotation;
							}
						} else if (EcorePackage.eINSTANCE
							.getEStringToStringMapEntry() == theEClass) {

							BasicEMap.Entry matchingEntry = (BasicEMap.Entry) findEObject(
								getMatchCandidates(theEObject), new KeyMatcher(
									(BasicEMap.Entry) theEObject));

							if (null != matchingEntry) {
								return matchingEntry;
							}
						} else if (null != getEAnnotation(theEClass,
							ANNOTATION_SOURCE__STEREOTYPE, false)) {

							EObject matchingEObject = findEObject(
								getMatchCandidates(theEObject),
								new org.eclipse.uml2.common.util.UML2Util.EClassMatcher(
									theEObject));

							if (null != matchingEObject) {
								return matchingEObject;
							}
						}
					}

					return super.doSwitch(theEClass, theEObject);
				}
			}.doSwitch(eObject);
		}

		public EObject copy(EObject eObject) {
			EObject copyEObject = super.copy(eObject);

			if (eObject != copyEObject) {
				List mergedEObjects = (List) resultingToMergedEObjectMap
					.get(copyEObject);

				if (null == mergedEObjects) {
					resultingToMergedEObjectMap.put(copyEObject,
						mergedEObjects = new UniqueEList.FastCompare(1));
				}

				mergedEObjects.add(eObject);
			}

			if (DEBUG) {
				System.out.println(getQualifiedText(eObject) + "->" //$NON-NLS-1$
					+ getQualifiedText(copyEObject));
			}

			return copyEObject;
		}

		protected Collection getAllMergedPackages(
				org.eclipse.uml2.Package package_) {

			return getAllMergedPackages(package_, new UniqueEList.FastCompare());
		}

		/**
		 * @deprecated
		 */
		protected void getAllMergedPackagesHelper(
				org.eclipse.uml2.Package package_, Collection allMergedPackages) {

			getAllMergedPackages(package_, allMergedPackages);
		}

		private Collection getAllMergedPackages(
				org.eclipse.uml2.Package package_, Collection allMergedPackages) {

			for (Iterator packageMerges = package_.getPackageMerges()
				.iterator(); packageMerges.hasNext();) {

				org.eclipse.uml2.Package mergedPackage = ((PackageMerge) packageMerges
					.next()).getMergedPackage();

				if (null != mergedPackage) {
					getAllMergedPackages(mergedPackage, allMergedPackages);

					allMergedPackages.add(mergedPackage);
				}
			}

			return allMergedPackages;
		}

		protected void processDifferentPropertyStaticity(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = resultingToMergedEObjectMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Object key = entry.getKey();

				if (key instanceof Property) {
					Property property = (Property) key;

					for (Iterator mergedProperties = ((List) entry.getValue())
						.iterator(); mergedProperties.hasNext();) {

						Property mergedProperty = (Property) mergedProperties
							.next();

						if (OPTION__REPORT.equals(options
							.get(OPTION__DIFFERENT_PROPERTY_STATICITY))
							&& null != diagnostics) {

							if (property.isStatic() != mergedProperty
								.isStatic()) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.ERROR,
										UML2Validator.DIAGNOSTIC_SOURCE,
										DIFFERENT_PROPERTY_STATICITY,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportDifferentPropertyStaticity_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, property,
													mergedProperty)),
										new Object[]{property, mergedProperty}));
							}
						}
					}
				}
			}
		}

		protected void processDifferentPropertyUniqueness(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = resultingToMergedEObjectMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				Object key = entry.getKey();

				if (key instanceof Property) {
					Property property = (Property) key;

					for (Iterator mergedProperties = ((List) entry.getValue())
						.iterator(); mergedProperties.hasNext();) {

						Property mergedProperty = (Property) mergedProperties
							.next();

						if (OPTION__REPORT.equals(options
							.get(OPTION__DIFFERENT_PROPERTY_UNIQUENESS))
							&& null != diagnostics) {

							if (property.isUnique() != mergedProperty
								.isUnique()) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.ERROR,
										UML2Validator.DIAGNOSTIC_SOURCE,
										DIFFERENT_PROPERTY_UNIQUENESS,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportDifferentPropertyUniqueness_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, property,
													mergedProperty)),
										new Object[]{property, mergedProperty}));
							}
						}
					}
				}
			}
		}

		/**
		 * @deprecated
		 */
		protected Set getImplicitlyRedefinedProperties(Set redefinedProperties,
				Property redefiningProperty, Classifier redefinitionContext) {

			findValidRedefinitions(redefinedProperties, redefiningProperty,
				redefiningProperty.getName(), redefinitionContext);

			List redefiningRedefinedProperties = redefiningProperty
				.getRedefinedProperties();

			for (Iterator i = redefinedProperties.iterator(); i.hasNext();) {

				if (redefiningRedefinedProperties.contains(i.next())) {
					i.remove();
				}
			}

			return redefinedProperties;
		}

		protected void processImplicitRedefinitions(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator resultingEObjects = resultingToMergedEObjectMap
				.keySet().iterator(); resultingEObjects.hasNext();) {

				EObject resultingEObject = (EObject) resultingEObjects.next();

				if (resultingEObject instanceof Feature) {
					Feature redefiningFeature = (Feature) resultingEObject;
					List redefinedFeatures = getRedefinedFeatures(redefiningFeature);

					for (Iterator validRedefinitions = findValidRedefinitions(
						redefiningFeature, redefiningFeature.getName())
						.iterator(); validRedefinitions.hasNext();) {

						Feature redefinedFeature = (Feature) validRedefinitions
							.next();

						if (!redefinedFeatures.contains(redefinedFeature)) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__IMPLICIT_REDEFINITIONS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											IMPLICIT_REDEFINITION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_PackageMerger_ProcessImplicitFeatureRedefinition_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context,
														redefiningFeature,
														redefinedFeature)),
											new Object[]{redefiningFeature,
												redefinedFeature}));
								}

								redefinedFeatures.add(redefinedFeature);
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__IMPLICIT_REDEFINITIONS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										IMPLICIT_REDEFINITION,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportImplicitFeatureRedefinition_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, redefiningFeature,
													redefinedFeature)),
										new Object[]{redefiningFeature,
											redefinedFeature}));
							}
						}
					}
				}
			}
		}

		/**
		 * @deprecated
		 */
		protected boolean isRedefinitionValid(Property redefiningProperty,
				Property redefinedProperty) {

			return UML2Util.isRedefinitionValid(redefiningProperty,
				redefinedProperty);
		}

		protected void processInvalidRedefinitions(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator resultingEObjects = resultingToMergedEObjectMap
				.keySet().iterator(); resultingEObjects.hasNext();) {

				EObject resultingEObject = (EObject) resultingEObjects.next();

				if (resultingEObject instanceof Feature) {
					Feature redefiningFeature = (Feature) resultingEObject;
					List redefinedFeatures = getRedefinedFeatures(redefiningFeature);

					for (Iterator i = new ArrayList(redefinedFeatures)
						.iterator(); i.hasNext();) {

						Feature redefinedFeature = (Feature) i.next();

						if (!UML2Util.isRedefinitionValid(redefiningFeature,
							redefinedFeature)) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__INVALID_REDEFINITIONS))
								|| OPTION__DISCARD.equals(options
									.get(OPTION__INVALID_REDEFINITIONS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											INVALID_REDEFINITION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_PackageMerger_DiscardInvalidFeatureRedefinition_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context,
														redefiningFeature,
														redefinedFeature)),
											new Object[]{redefiningFeature,
												redefinedFeature}));
								}

								redefinedFeatures.remove(redefinedFeature);
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__INVALID_REDEFINITIONS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										INVALID_REDEFINITION,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportInvalidFeatureRedefinition_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, redefiningFeature,
													redefinedFeature)),
										new Object[]{redefiningFeature,
											redefinedFeature}));
							}
						}

						if (OPTION__PROCESS.equals(options
							.get(OPTION__INVALID_REDEFINITIONS))) {

							Collection validRedefinitions = findValidRedefinitions(
								redefiningFeature, redefinedFeature.getName());

							if (!validRedefinitions.isEmpty()) {

								for (Iterator j = validRedefinitions.iterator(); j
									.hasNext();) {

									Feature validRedefinition = (Feature) j
										.next();

									if (!redefinedFeatures
										.contains(validRedefinition)) {

										if (null != diagnostics) {
											diagnostics
												.add(new BasicDiagnostic(
													Diagnostic.INFO,
													UML2Validator.DIAGNOSTIC_SOURCE,
													INVALID_REDEFINITION,
													UML2Plugin.INSTANCE
														.getString(
															"_UI_PackageMerger_ProcessInvalidRedefinition_diagnostic", //$NON-NLS-1$
															getMessageSubstitutions(
																context,
																redefiningFeature,
																redefinedFeature,
																validRedefinition)),
													new Object[]{
														redefiningFeature,
														validRedefinition}));
										}

										redefinedFeatures
											.add(validRedefinition);
									}
								}

								if (!validRedefinitions
									.contains(redefinedFeature)) {

									redefinedFeatures.remove(redefinedFeature);
								}
							}
						}
					}
				}
			}
		}

		/**
		 * @deprecated
		 */
		protected boolean isSubsetValid(Property subsettingProperty,
				Property subsettedProperty) {

			return UML2Util
				.isSubsetValid(subsettingProperty, subsettedProperty);
		}

		protected void processInvalidSubsets(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator resultingEObjects = resultingToMergedEObjectMap
				.keySet().iterator(); resultingEObjects.hasNext();) {

				EObject resultingEObject = (EObject) resultingEObjects.next();

				if (resultingEObject instanceof Property) {
					Property subsettingProperty = (Property) resultingEObject;
					List subsettedProperties = subsettingProperty
						.getSubsettedProperties();

					for (Iterator i = new ArrayList(subsettedProperties)
						.iterator(); i.hasNext();) {

						Property subsettedProperty = (Property) i.next();

						if (!UML2Util.isSubsetValid(subsettingProperty,
							subsettedProperty)) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__INVALID_SUBSETS))
								|| OPTION__DISCARD.equals(options
									.get(OPTION__INVALID_SUBSETS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											INVALID_SUBSET,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_PackageMerger_DiscardInvalidSubset_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context,
														subsettingProperty,
														subsettedProperty)),
											new Object[]{subsettingProperty,
												subsettedProperty}));
								}

								subsettedProperties.remove(subsettedProperty);
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__INVALID_SUBSETS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										INVALID_SUBSET,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportInvalidSubset_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context,
													subsettingProperty,
													subsettedProperty)),
										new Object[]{subsettingProperty,
											subsettedProperty}));
							}
						}

						if (OPTION__PROCESS.equals(options
							.get(OPTION__INVALID_SUBSETS))) {

							Collection validSubsets = findValidSubsets(
								subsettingProperty, subsettedProperty.getName());

							if (!validSubsets.isEmpty()) {

								for (Iterator j = validSubsets.iterator(); j
									.hasNext();) {

									Property validSubset = (Property) j.next();

									if (!subsettedProperties
										.contains(validSubset)) {

										if (null != diagnostics) {
											diagnostics
												.add(new BasicDiagnostic(
													Diagnostic.INFO,
													UML2Validator.DIAGNOSTIC_SOURCE,
													INVALID_SUBSET,
													UML2Plugin.INSTANCE
														.getString(
															"_UI_PackageMerger_ProcessInvalidSubset_diagnostic", //$NON-NLS-1$
															getMessageSubstitutions(
																context,
																subsettingProperty,
																subsettedProperty,
																validSubset)),
													new Object[]{
														subsettingProperty,
														validSubset}));
										}

										subsettedProperties.add(validSubset);
									}
								}

								if (!validSubsets.contains(subsettedProperty)) {
									subsettedProperties
										.remove(subsettedProperty);
								}
							}
						}
					}
				}
			}
		}

		protected void processEmptyUnions(Map options,
				DiagnosticChain diagnostics, Map context) {

			Map unionToSubsettingPropertyMap = new LinkedHashMap();

			for (Iterator resultingEObjects = resultingToMergedEObjectMap
				.keySet().iterator(); resultingEObjects.hasNext();) {

				EObject resultingEObject = (EObject) resultingEObjects.next();

				if (resultingEObject instanceof Property) {
					Property property = (Property) resultingEObject;

					if (property.isDerivedUnion()
						&& !unionToSubsettingPropertyMap.containsKey(property)) {

						unionToSubsettingPropertyMap.put(property,
							new UniqueEList.FastCompare());
					}

					for (Iterator subsettedProperties = property
						.getSubsettedProperties().iterator(); subsettedProperties
						.hasNext();) {

						Property subsettedProperty = (Property) subsettedProperties
							.next();

						if (subsettedProperty.isDerivedUnion()) {
							List subsettingProperties = (List) unionToSubsettingPropertyMap
								.get(subsettedProperty);

							if (null == subsettingProperties) {
								unionToSubsettingPropertyMap
									.put(
										subsettedProperty,
										subsettingProperties = new UniqueEList.FastCompare());
							}

							subsettingProperties.add(property);
						}
					}
				}
			}

			for (Iterator entries = unionToSubsettingPropertyMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();

				if (((List) entry.getValue()).isEmpty()) {
					Property unionProperty = (Property) entry.getKey();

					if (OPTION__PROCESS.equals(options
						.get(OPTION__EMPTY_UNIONS))) {

						if (null != diagnostics) {
							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.INFO,
									UML2Validator.DIAGNOSTIC_SOURCE,
									EMPTY_UNION,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_PackageMerger_ProcessEmptyUnion_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												unionProperty)),
									new Object[]{unionProperty}));
						}

						unionProperty.setIsDerivedUnion(false);
					} else if (OPTION__REPORT.equals(options
						.get(OPTION__EMPTY_UNIONS))
						&& null != diagnostics) {

						diagnostics
							.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								UML2Validator.DIAGNOSTIC_SOURCE,
								EMPTY_UNION,
								UML2Plugin.INSTANCE
									.getString(
										"_UI_PackageMerger_ReportEmptyUnion_diagnostic", //$NON-NLS-1$
										getMessageSubstitutions(context,
											unionProperty)),
								new Object[]{unionProperty}));
					}
				}
			}
		}

		protected void processRedundantGeneralizations(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator resultingEObjects = resultingToMergedEObjectMap
				.keySet().iterator(); resultingEObjects.hasNext();) {

				EObject resultingEObject = (EObject) resultingEObjects.next();

				if (resultingEObject instanceof Classifier) {
					Classifier classifier = (Classifier) resultingEObject;
					EList generalizations = classifier.getGeneralizations();

					for (Iterator i = new ArrayList(generalizations).iterator(); i
						.hasNext();) {

						Classifier general = ((Generalization) i.next())
							.getGeneral();

						if (null != general) {
							Set generalAllParents = general.allParents();

							for (Iterator j = generalizations.iterator(); j
								.hasNext();) {

								Generalization otherGeneralization = (Generalization) j
									.next();
								Classifier otherGeneral = otherGeneralization
									.getGeneral();

								if (general != otherGeneral
									&& generalAllParents.contains(otherGeneral)
									&& !otherGeneralization
										.hasKeyword("extend")) { //$NON-NLS-1$

									if (OPTION__DISCARD
										.equals(options
											.get(OPTION__REDUNDANT_GENERALIZATIONS))) {

										if (null != diagnostics) {
											diagnostics
												.add(new BasicDiagnostic(
													Diagnostic.INFO,
													UML2Validator.DIAGNOSTIC_SOURCE,
													REDUNDANT_GENERALIZATION,
													UML2Plugin.INSTANCE
														.getString(
															"_UI_PackageMerger_DiscardRedundantGeneralization_diagnostic", //$NON-NLS-1$
															getMessageSubstitutions(
																context,
																classifier,
																otherGeneral,
																general)),
													new Object[]{classifier,
														otherGeneral}));
										}

										j.remove();
									} else if (OPTION__REPORT
										.equals(options
											.get(OPTION__REDUNDANT_GENERALIZATIONS))
										&& null != diagnostics) {

										diagnostics
											.add(new BasicDiagnostic(
												Diagnostic.WARNING,
												UML2Validator.DIAGNOSTIC_SOURCE,
												REDUNDANT_GENERALIZATION,
												UML2Plugin.INSTANCE
													.getString(
														"_UI_PackageMerger_ReportRedundantGeneralization_diagnostic", //$NON-NLS-1$
														getMessageSubstitutions(
															context,
															classifier,
															otherGeneral,
															general)),
												new Object[]{classifier,
													otherGeneral}));
									}

									break;
								}
							}
						}
					}
				}
			}
		}

		protected void processAssociationSpecializations(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = resultingToMergedEObjectMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EObject resultingEObject = (EObject) entry.getKey();

				if (resultingEObject instanceof Association) {
					Association association = (Association) resultingEObject;

					List generalAssociations = new UniqueEList.FastCompare();

					for (Iterator memberEnds = association.getMemberEnds()
						.iterator(); memberEnds.hasNext();) {

						Property memberEnd = (Property) memberEnds.next();

						for (Iterator redefinedProperties = memberEnd
							.getRedefinedProperties().iterator(); redefinedProperties
							.hasNext();) {

							Association redefinedAssociation = ((Property) redefinedProperties
								.next()).getAssociation();

							if (null != redefinedAssociation) {
								generalAssociations.add(redefinedAssociation);
							}
						}

						for (Iterator subsettedProperties = memberEnd
							.getSubsettedProperties().iterator(); subsettedProperties
							.hasNext();) {

							Association subsettedAssociation = ((Property) subsettedProperties
								.next()).getAssociation();

							if (null != subsettedAssociation) {
								generalAssociations.add(subsettedAssociation);
							}
						}
					}

					for (Iterator i = generalAssociations.iterator(); i
						.hasNext();) {

						Association generalAssocation = (Association) i.next();

						if (!association.allParents().contains(
							generalAssocation)) {

							if (OPTION__PROCESS.equals(options
								.get(OPTION__ASSOCIATION_SPECIALIZATIONS))) {

								if (null != diagnostics) {
									diagnostics
										.add(new BasicDiagnostic(
											Diagnostic.INFO,
											UML2Validator.DIAGNOSTIC_SOURCE,
											ASSOCIATION_SPECIALIZATION,
											UML2Plugin.INSTANCE
												.getString(
													"_UI_PackageMerger_ProcessAssociationSpecialization_diagnostic", //$NON-NLS-1$
													getMessageSubstitutions(
														context, association,
														generalAssocation)),
											new Object[]{association,
												generalAssocation}));
								}

								association
									.createGeneralization(generalAssocation);
							} else if (OPTION__REPORT.equals(options
								.get(OPTION__ASSOCIATION_SPECIALIZATIONS))
								&& null != diagnostics) {

								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.WARNING,
										UML2Validator.DIAGNOSTIC_SOURCE,
										ASSOCIATION_SPECIALIZATION,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ReportAssociationSpecialization_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, association,
													generalAssocation)),
										new Object[]{association,
											generalAssocation}));
							}
						}
					}
				}
			}
		}

		protected void processCapabilities(Map options,
				DiagnosticChain diagnostics, Map context) {

			for (Iterator entries = resultingToMergedEObjectMap.entrySet()
				.iterator(); entries.hasNext();) {

				Map.Entry entry = (Map.Entry) entries.next();
				EObject resultingEObject = (EObject) entry.getKey();

				if (resultingEObject instanceof RedefinableElement) {
					org.eclipse.uml2.Package resultingPackage = ((RedefinableElement) resultingEObject)
						.getNearestPackage();

					for (Iterator mergedEObjects = ((List) entry.getValue())
						.iterator(); mergedEObjects.hasNext();) {

						org.eclipse.uml2.Package mergedPackage = ((Element) mergedEObjects
							.next()).getNearestPackage();

						if (OPTION__PROCESS.equals(options
							.get(OPTION__CAPABILITIES))) {

							if (null != diagnostics) {
								diagnostics
									.add(new BasicDiagnostic(
										Diagnostic.INFO,
										UML2Validator.DIAGNOSTIC_SOURCE,
										CAPABILITY,
										UML2Plugin.INSTANCE
											.getString(
												"_UI_PackageMerger_ProcessCapability_diagnostic", //$NON-NLS-1$
												getMessageSubstitutions(
													context, resultingEObject,
													mergedPackage)),
										new Object[]{resultingEObject,
											mergedPackage}));
							}

							getEAnnotation(
								getEAnnotation(resultingPackage,
									ANNOTATION_SOURCE__CAPABILITIES, true),
								mergedPackage.getQualifiedName(), true)
								.getReferences().add(resultingEObject);
						} else if (OPTION__REPORT.equals(options
							.get(OPTION__CAPABILITIES))
							&& null != diagnostics) {

							diagnostics
								.add(new BasicDiagnostic(
									Diagnostic.WARNING,
									UML2Validator.DIAGNOSTIC_SOURCE,
									CAPABILITY,
									UML2Plugin.INSTANCE
										.getString(
											"_UI_PackageMerger_ReportCapability_diagnostic", //$NON-NLS-1$
											getMessageSubstitutions(context,
												resultingEObject, mergedPackage)),
									new Object[]{resultingEObject,
										mergedPackage}));
						}
					}
				}
			}
		}

		protected void processOptions(Map options, DiagnosticChain diagnostics,
				Map context) {

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__DIFFERENT_PROPERTY_STATICITY))) {

				processDifferentPropertyStaticity(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__DIFFERENT_PROPERTY_UNIQUENESS))) {

				processDifferentPropertyUniqueness(options, diagnostics,
					context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__IMPLICIT_REDEFINITIONS))) {

				processImplicitRedefinitions(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__INVALID_REDEFINITIONS))) {

				processInvalidRedefinitions(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__INVALID_SUBSETS))) {
				processInvalidSubsets(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__EMPTY_UNIONS))) {
				processEmptyUnions(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__ASSOCIATION_SPECIALIZATIONS))) {

				processAssociationSpecializations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options
				.get(OPTION__REDUNDANT_GENERALIZATIONS))) {

				processRedundantGeneralizations(options, diagnostics, context);
			}

			if (!OPTION__IGNORE.equals(options.get(OPTION__CAPABILITIES))) {
				processCapabilities(options, diagnostics, context);
			}
		}

		public void merge(org.eclipse.uml2.Package package_, Map options,
				DiagnosticChain diagnostics, Map context) {
			receivingPackage = package_;

			mergedPackages = getAllMergedPackages(package_);

			copyAll(mergedPackages);
			copyReferences();

			receivingPackage.getPackageMerges().clear();

			if (null != options) {
				processOptions(options, diagnostics, context);
			}
		}
	}

	protected static boolean DEBUG = false;

	public static final String OPTION__DISCARD = "DISCARD"; //$NON-NLS-1$

	public static final String OPTION__IGNORE = "IGNORE"; //$NON-NLS-1$

	public static final String OPTION__PROCESS = "PROCESS"; //$NON-NLS-1$

	public static final String OPTION__REPORT = "REPORT"; //$NON-NLS-1$

	protected static final String ANNOTATION_SOURCE__DUPLICATES = "duplicates"; //$NON-NLS-1$

	protected static final String ANNOTATION_SOURCE__REDEFINES = "redefines"; //$NON-NLS-1$

	protected static final String ANNOTATION_SOURCE__SUBSETS = "subsets"; //$NON-NLS-1$

	protected static final String ANNOTATION_SOURCE__UNION = "union"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__ATTRIBUTE = "Attribute"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__ATTRIBUTE_WILDCARD = "AttributeWilcard"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__ELEMENT = "Element"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__ELEMENT_ONLY = "ElementOnly"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__ELEMENT_WILDCARD = "ElementWildcard"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__EMPTY = "Empty"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__GROUP = "Group"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__MIXED = "Mixed"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__NONE = "None"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__SIMPLE = "Simple"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__READ_ONLY = "ReadOnly"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__READ_ONLY_UNSETTABLE = "ReadOnlyUnsettable"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__READ_WRITE = "ReadWrite"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__READ_WRITE_UNSETTABLE = "ReadWriteUnsettable"; //$NON-NLS-1$

	protected static final String ENUMERATION_LITERAL_NAME__UNSPECIFIED = "Unspecified"; //$NON-NLS-1$

	protected static final String ENUMERATION_NAME__CONTENT_KIND = "ContentKind"; //$NON-NLS-1$

	protected static final String ENUMERATION_NAME__FEATURE_KIND = "FeatureKind"; //$NON-NLS-1$

	protected static final String ENUMERATION_NAME__VISIBILITY_KIND = "VisibilityKind"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__ATTRIBUTE_NAME = "attributeName"; //$NON-NLS-1$

	public static final String PROPERTY_NAME__BASE_PACKAGE = "basePackage"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__CLASS_NAME = "className"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__DATA_TYPE_NAME = "dataTypeName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__ENUM_NAME = "enumName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__ENUM_LITERAL_NAME = "enumLiteralName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__INSTANCE_CLASS_NAME = "instanceClassName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__IS_ID = "isID"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__IS_RESOLVE_PROXIES = "isResolveProxies"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__IS_TRANSIENT = "isTransient"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__IS_UNSETTABLE = "isUnsettable"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__IS_VOLATILE = "isVolatile"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__NS_PREFIX = "nsPrefix"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__NS_URI = "nsURI"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__OPERATION_NAME = "operationName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__PACKAGE_NAME = "packageName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__PARAMETER_NAME = "parameterName"; //$NON-NLS-1$

	public static final String PROPERTY_NAME__PREFIX = "prefix"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__REFERENCE_NAME = "referenceName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__VISIBILITY = "visibility"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__XML_CONTENT_KIND = "xmlContentKind"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__XML_FEATURE_KIND = "xmlFeatureKind"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__XML_NAME = "xmlName"; //$NON-NLS-1$

	protected static final String PROPERTY_NAME__XML_NAMESPACE = "xmlNamespace"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_ATTRIBUTE = "EAttribute"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_CLASS = "EClass"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_DATA_TYPE = "EDataType"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_ENUM = "EEnum"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_ENUM_LITERAL = "EEnumLiteral"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_OPERATION = "EOperation"; //$NON-NLS-1$

	public static final String STEREOTYPE_NAME__E_PACKAGE = "EPackage"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_PARAMETER = "EParameter"; //$NON-NLS-1$

	protected static final String STEREOTYPE_NAME__E_REFERENCE = "EReference"; //$NON-NLS-1$

	protected static Property getTagDefinition(Stereotype stereotype,
			final String propertyName) {

		return (Property) findEObject(stereotype.allFeatures(),
			new EObjectMatcher() {

				public boolean matches(EObject eObject) {
					return eObject instanceof Property
						&& safeEquals(((Property) eObject).getName(),
							propertyName);
				}
			});
	}

	protected static Object getTaggedValue(Element element,
			String qualifiedStereotypeName, String propertyName) {
		Stereotype stereotype = element
			.getAppliedStereotype(qualifiedStereotypeName);

		return null == stereotype
			? null
			: element.getValue(stereotype, propertyName);
	}

	protected static void safeApplyStereotype(Element element,
			Stereotype stereotype) {

		if (!element.isApplied(stereotype)) {
			Profile profile = stereotype.getProfile();

			if (!element.getNearestPackage().getAllAppliedProfiles().contains(
				profile)) {

				element.getModel().apply(profile);
			}

			element.apply(stereotype);
		}
	}

	protected static void setTaggedValue(Element element,
			Stereotype stereotype, String propertyName, Object value) {
		safeApplyStereotype(element, stereotype);

		element.setValue(stereotype, propertyName, value);
	}

	public static String getQualifiedText(EObject eObject) {
		return getQualifiedText(eObject, QualifiedTextProvider.DEFAULT);
	}

	public static int getInstanceCount(ResourceSet resourceSet,
			EClassifier eClassifier) {
		return getInstanceCount(resourceSet.getAllContents(), eClassifier);
	}

	public static int getInstanceCount(Resource resource,
			EClassifier eClassifier) {
		return getInstanceCount(resource.getAllContents(), eClassifier);
	}

	public static int getInstanceCount(EObject eObject, EClassifier eClassifier) {
		return getInstanceCount(eObject.eAllContents(), eClassifier);
	}

	public static Collection findNamedElements(ResourceSet resourceSet,
			String qualifiedName) {
		return findNamedElements(resourceSet, qualifiedName, false);
	}

	public static Collection findNamedElements(ResourceSet resourceSet,
			String qualifiedName, boolean ignoreCase) {
		return findNamedElements(resourceSet, qualifiedName, ignoreCase,
			UML2Package.Literals.NAMED_ELEMENT);
	}

	public static Collection findNamedElements(ResourceSet resourceSet,
			String qualifiedName, boolean ignoreCase, EClass eClass) {

		if (!isEmpty(qualifiedName)
			&& UML2Package.Literals.NAMED_ELEMENT.isSuperTypeOf(eClass)) {

			EList resources = resourceSet.getResources();
			int size = resources.size();

			if (size > 0) {
				EList namedElements = new UniqueEList.FastCompare();

				for (int i = 0; i < size; i++) {
					findNamedElements(((Resource) resources.get(i))
						.getContents(), qualifiedName, ignoreCase, eClass,
						namedElements);
				}

				return ECollections.unmodifiableEList(namedElements);
			}
		}

		return ECollections.EMPTY_ELIST;
	}

	public static Collection findNamedElements(Resource resource,
			String qualifiedName) {
		return findNamedElements(resource, qualifiedName, false);
	}

	public static Collection findNamedElements(Resource resource,
			String qualifiedName, boolean ignoreCase) {
		return findNamedElements(resource, qualifiedName, ignoreCase,
			UML2Package.Literals.NAMED_ELEMENT);
	}

	public static Collection findNamedElements(Resource resource,
			String qualifiedName, boolean ignoreCase, EClass eClass) {

		if (!isEmpty(qualifiedName)
			&& UML2Package.Literals.NAMED_ELEMENT.isSuperTypeOf(eClass)) {

			EList contents = resource.getContents();

			if (!contents.isEmpty()) {
				EList namedElements = new UniqueEList.FastCompare();

				findNamedElements(contents, qualifiedName, ignoreCase, eClass,
					namedElements);

				return ECollections.unmodifiableEList(namedElements);
			}
		}

		return ECollections.EMPTY_ELIST;
	}

	protected static Collection findNamedElements(Collection eObjects,
			String qualifiedName, boolean ignoreCase, EClass eClass,
			Collection namedElements) {
		int index = qualifiedName.indexOf(NamedElement.SEPARATOR);

		if (-1 == index) {

			for (Iterator members = EcoreUtil
				.getObjectsByType(eObjects, eClass).iterator(); members
				.hasNext();) {

				NamedElement member = (NamedElement) members.next();

				if (ignoreCase
					? qualifiedName.equalsIgnoreCase(member.getName())
					: qualifiedName.equals(member.getName())) {

					namedElements.add(member);
				}
			}
		} else {
			String name = qualifiedName.substring(0, index);
			qualifiedName = qualifiedName.substring(index
				+ NamedElement.SEPARATOR.length());

			for (Iterator namespaces = EcoreUtil.getObjectsByType(eObjects,
				UML2Package.Literals.NAMESPACE).iterator(); namespaces
				.hasNext();) {

				Namespace namespace = (Namespace) namespaces.next();

				if (ignoreCase
					? name.equalsIgnoreCase(namespace.getName())
					: name.equals(namespace.getName())) {

					findNamedElements(namespace.getMembers(), qualifiedName,
						ignoreCase, eClass, namedElements);
				}
			}
		}

		return namedElements;
	}

	public static org.eclipse.uml2.Package load(ResourceSet resourceSet, URI uri) {

		try {
			return (org.eclipse.uml2.Package) load(resourceSet, uri,
				UML2Package.Literals.PACKAGE);
		} catch (Exception e) {
			return null;
		}
	}

	protected static List getOwnedAttributes(Type type) {

		return (List) new UML2Switch() {

			public Object caseArtifact(Artifact artifact) {
				return artifact.getOwnedAttributes();
			}

			public Object caseDataType(DataType dataType) {
				return dataType.getOwnedAttributes();
			}

			public Object caseInterface(Interface interface_) {
				return interface_.getOwnedAttributes();
			}

			public Object caseSignal(Signal signal) {
				return signal.getOwnedAttributes();
			}

			public Object caseStructuredClassifier(
					StructuredClassifier structuredClassifier) {
				return structuredClassifier.getOwnedAttributes();
			}

			public Object doSwitch(EObject eObject) {
				return null == eObject
					? null
					: super.doSwitch(eObject);
			}
		}.doSwitch(type);
	}

	protected static List getOwnedOperations(Type type) {

		return (List) new UML2Switch() {

			public Object caseArtifact(Artifact artifact) {
				return artifact.getOwnedOperations();
			}

			public Object caseClass(org.eclipse.uml2.Class class_) {
				return class_.getOwnedOperations();
			}

			public Object caseDataType(DataType dataType) {
				return dataType.getOwnedOperations();
			}

			public Object caseInterface(Interface interface_) {
				return interface_.getOwnedOperations();
			}

			public Object doSwitch(EObject eObject) {
				return null == eObject
					? null
					: super.doSwitch(eObject);
			}
		}.doSwitch(type);
	}

	protected static List getRedefinedFeatures(Feature feature) {
		return (List) new UML2Switch() {

			public Object caseOperation(Operation operation) {
				return operation.getRedefinedOperations();
			}

			public Object caseProperty(Property property) {
				return property.getRedefinedProperties();
			}

			public Object defaultCase(EObject eObject) {
				return Collections.EMPTY_LIST;
			}
		}.doSwitch(feature);
	}

	protected static boolean isRedefinitionValid(Feature redefiningFeature,
			Feature redefinedFeature) {

		return redefinedFeature.isConsistentWith(redefiningFeature);
	}

	protected static Collection findValidRedefinitions(
			Feature redefiningFeature, String name) {
		Collection redefinedFeatures = new UniqueEList.FastCompare();

		for (Iterator redefinitionContexts = redefiningFeature
			.getRedefinitionContexts().iterator(); redefinitionContexts
			.hasNext();) {

			findValidRedefinitions(redefinedFeatures, redefiningFeature, name,
				(Classifier) redefinitionContexts.next());
		}

		return redefinedFeatures;
	}

	private static Collection findValidRedefinitions(
			Collection redefinedFeatures, Feature redefiningFeature,
			final String name, Classifier redefinitionContext) {

		Feature redefinedFeature = (Feature) findEObject(redefinitionContext
			.getFeatures(), new EClassMatcher(redefiningFeature) {

			public boolean matches(EObject otherEObject) {

				if (super.matches(otherEObject)) {
					Feature feature = (Feature) eObject;
					Feature otherFeature = (Feature) otherEObject;

					return (null == feature && null == otherFeature)
						|| (feature != otherFeature
							&& otherFeature.getName().equals(name) && isRedefinitionValid(
							feature, otherFeature));
				}

				return false;
			}
		});

		if (null == redefinedFeature) {

			for (Iterator generals = redefinitionContext.getGenerals()
				.iterator(); generals.hasNext();) {

				findValidRedefinitions(redefinedFeatures, redefiningFeature,
					name, (Classifier) generals.next());
			}
		} else {
			redefinedFeatures.add(redefinedFeature);
		}

		return redefinedFeatures;
	}

	protected static boolean isSubsetValid(Property subsettingProperty,
			Property subsettedProperty) {

		for (Iterator subsettingContexts = subsettingProperty
			.subsettingContext().iterator(); subsettingContexts.hasNext();) {

			Classifier subsettingContext = (Classifier) subsettingContexts
				.next();

			for (Iterator subsettedContexts = subsettedProperty
				.subsettingContext().iterator(); subsettedContexts.hasNext();) {

				if (!subsettingContext
					.conformsTo((Classifier) subsettedContexts.next())) {

					return false;
				}
			}
		}

		return true;
	}

	protected static Collection findValidSubsets(Property subsettingProperty,
			String name) {

		Collection subsettedProperties = new UniqueEList.FastCompare();

		for (Iterator subsettingContexts = subsettingProperty
			.subsettingContext().iterator(); subsettingContexts.hasNext();) {

			findValidSubsets(subsettedProperties, subsettingProperty, name,
				(Classifier) subsettingContexts.next());
		}

		return subsettedProperties;
	}

	private static Collection findValidSubsets(Collection subsettedProperties,
			Property subsettingProperty, final String name,
			Classifier subsettingContext) {

		Property subsettedProperty = (Property) findEObject(subsettingContext
			.getAttributes(), new EClassMatcher(subsettingProperty) {

			public boolean matches(EObject otherEObject) {

				if (super.matches(otherEObject)) {
					Property property = (Property) eObject;
					Property otherProperty = (Property) otherEObject;

					return (null == property && null == otherProperty)
						|| (property != otherProperty
							&& otherProperty.getName().equals(name) && isSubsetValid(
							property, otherProperty));
				}

				return false;
			}
		});

		if (null == subsettedProperty) {

			for (Iterator generals = subsettingContext.getGenerals().iterator(); generals
				.hasNext();) {

				findValidSubsets(subsettedProperties, subsettingProperty, name,
					(Classifier) generals.next());
			}
		} else {
			subsettedProperties.add(subsettedProperty);
		}

		return subsettedProperties;
	}

	public static Collection convertFromEcore(EPackage ePackage, Map options) {

		if (null == options) {
			options = new HashMap();
		}

		return convertFromEcore(ePackage, options, null, null);
	}

	public static Collection convertFromEcore(EPackage ePackage, Map options,
			DiagnosticChain diagnostics, Map context) {

		if (null == options) {
			options = new HashMap();
		}

		return new Ecore2UML2Converter().convert(Collections
			.singleton(ePackage), options, diagnostics, context);
	}

	public static Collection convertToEcore(org.eclipse.uml2.Package package_,
			Map options) {

		if (null == options) {
			options = new HashMap();
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__REDEFINING_OPERATIONS)) {

			options.put(UML22EcoreConverter.OPTION__REDEFINING_OPERATIONS,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__REDEFINING_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__REDEFINING_PROPERTIES,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__SUBSETTING_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__SUBSETTING_PROPERTIES,
				OPTION__IGNORE);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__UNION_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__UNION_PROPERTIES,
				OPTION__IGNORE);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__DERIVED_FEATURES)) {

			options.put(UML22EcoreConverter.OPTION__DERIVED_FEATURES,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_OPERATIONS)) {

			options.put(UML22EcoreConverter.OPTION__DUPLICATE_OPERATIONS,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE)) {

			options.put(
				UML22EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_FEATURES)) {

			options.put(UML22EcoreConverter.OPTION__DUPLICATE_FEATURES,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE)) {

			options.put(
				UML22EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE,
				OPTION__IGNORE);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__SUPER_CLASS_ORDER)) {
			options.put(UML22EcoreConverter.OPTION__SUPER_CLASS_ORDER,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__ANNOTATION_DETAILS)) {

			options.put(UML22EcoreConverter.OPTION__ANNOTATION_DETAILS,
				OPTION__IGNORE);
		}

		return convertToEcore(package_, options, null, null);
	}

	public static Collection convertToEcore(org.eclipse.uml2.Package package_,
			Map options, DiagnosticChain diagnostics, Map context) {

		if (null == options) {
			options = new HashMap();
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__REDEFINING_OPERATIONS)) {

			options.put(UML22EcoreConverter.OPTION__REDEFINING_OPERATIONS,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__REDEFINING_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__REDEFINING_PROPERTIES,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__SUBSETTING_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__SUBSETTING_PROPERTIES,
				OPTION__REPORT);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__UNION_PROPERTIES)) {

			options.put(UML22EcoreConverter.OPTION__UNION_PROPERTIES,
				OPTION__REPORT);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__DERIVED_FEATURES)) {

			options.put(UML22EcoreConverter.OPTION__DERIVED_FEATURES,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_OPERATIONS)) {

			options.put(UML22EcoreConverter.OPTION__DUPLICATE_OPERATIONS,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE)) {

			options.put(
				UML22EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_FEATURES)) {

			options.put(UML22EcoreConverter.OPTION__DUPLICATE_FEATURES,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE)) {

			options.put(
				UML22EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE,
				OPTION__REPORT);
		}

		if (!options.containsKey(UML22EcoreConverter.OPTION__SUPER_CLASS_ORDER)) {
			options.put(UML22EcoreConverter.OPTION__SUPER_CLASS_ORDER,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(UML22EcoreConverter.OPTION__ANNOTATION_DETAILS)) {

			options.put(UML22EcoreConverter.OPTION__ANNOTATION_DETAILS,
				OPTION__REPORT);
		}

		return new UML22EcoreConverter().convert(Collections
			.singleton(package_), options, diagnostics, context);
	}

	public static void merge(org.eclipse.uml2.Package package_, Map options) {

		if (null == options) {
			options = new HashMap();
		}

		if (!options
			.containsKey(PackageMerger.OPTION__DIFFERENT_PROPERTY_STATICITY)) {

			options.put(PackageMerger.OPTION__DIFFERENT_PROPERTY_STATICITY,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__DIFFERENT_PROPERTY_UNIQUENESS)) {

			options.put(PackageMerger.OPTION__DIFFERENT_PROPERTY_UNIQUENESS,
				OPTION__IGNORE);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__REDUNDANT_GENERALIZATIONS)) {

			options.put(PackageMerger.OPTION__REDUNDANT_GENERALIZATIONS,
				OPTION__IGNORE);
		}

		if (!options.containsKey(PackageMerger.OPTION__IMPLICIT_REDEFINITIONS)) {
			options.put(PackageMerger.OPTION__IMPLICIT_REDEFINITIONS,
				OPTION__IGNORE);
		}

		if (!options.containsKey(PackageMerger.OPTION__INVALID_REDEFINITIONS)) {
			options.put(PackageMerger.OPTION__INVALID_REDEFINITIONS,
				OPTION__IGNORE);
		}

		if (!options.containsKey(PackageMerger.OPTION__INVALID_SUBSETS)) {
			options.put(PackageMerger.OPTION__INVALID_SUBSETS, OPTION__IGNORE);
		}

		if (!options.containsKey(PackageMerger.OPTION__EMPTY_UNIONS)) {
			options.put(PackageMerger.OPTION__EMPTY_UNIONS, OPTION__IGNORE);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__ASSOCIATION_SPECIALIZATIONS)) {

			options.put(PackageMerger.OPTION__ASSOCIATION_SPECIALIZATIONS,
				OPTION__IGNORE);
		}

		if (!options.containsKey(PackageMerger.OPTION__CAPABILITIES)) {
			options.put(PackageMerger.OPTION__CAPABILITIES, OPTION__IGNORE);
		}

		merge(package_, options, null, null);
	}

	public static void merge(org.eclipse.uml2.Package package_, Map options,
			DiagnosticChain diagnostics, Map context) {

		if (null == options) {
			options = new HashMap();
		}

		if (!options
			.containsKey(PackageMerger.OPTION__DIFFERENT_PROPERTY_STATICITY)) {

			options.put(PackageMerger.OPTION__DIFFERENT_PROPERTY_STATICITY,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__DIFFERENT_PROPERTY_UNIQUENESS)) {

			options.put(PackageMerger.OPTION__DIFFERENT_PROPERTY_UNIQUENESS,
				OPTION__REPORT);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__REDUNDANT_GENERALIZATIONS)) {

			options.put(PackageMerger.OPTION__REDUNDANT_GENERALIZATIONS,
				OPTION__REPORT);
		}

		if (!options.containsKey(PackageMerger.OPTION__IMPLICIT_REDEFINITIONS)) {
			options.put(PackageMerger.OPTION__IMPLICIT_REDEFINITIONS,
				OPTION__REPORT);
		}

		if (!options.containsKey(PackageMerger.OPTION__INVALID_REDEFINITIONS)) {
			options.put(PackageMerger.OPTION__INVALID_REDEFINITIONS,
				OPTION__REPORT);
		}

		if (!options.containsKey(PackageMerger.OPTION__INVALID_SUBSETS)) {
			options.put(PackageMerger.OPTION__INVALID_SUBSETS, OPTION__REPORT);
		}

		if (!options.containsKey(PackageMerger.OPTION__EMPTY_UNIONS)) {
			options.put(PackageMerger.OPTION__EMPTY_UNIONS, OPTION__REPORT);
		}

		if (!options
			.containsKey(PackageMerger.OPTION__ASSOCIATION_SPECIALIZATIONS)) {

			options.put(PackageMerger.OPTION__ASSOCIATION_SPECIALIZATIONS,
				OPTION__REPORT);
		}

		if (!options.containsKey(PackageMerger.OPTION__CAPABILITIES)) {
			options.put(PackageMerger.OPTION__CAPABILITIES, OPTION__REPORT);
		}

		new PackageMerger().merge(package_, options, diagnostics, context);
	}
}