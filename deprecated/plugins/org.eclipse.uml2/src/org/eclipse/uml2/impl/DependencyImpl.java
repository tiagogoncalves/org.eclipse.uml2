/*
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: DependencyImpl.java,v 1.22 2005/11/23 20:05:08 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.Dependency;
import org.eclipse.uml2.DirectedRelationship;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.Relationship;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.DependencyImpl#getRelatedElements <em>Related Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.DependencyImpl#getSources <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.DependencyImpl#getTargets <em>Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.DependencyImpl#getClients <em>Client</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.DependencyImpl#getSuppliers <em>Supplier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyImpl extends PackageableElementImpl implements Dependency {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRelatedElements() {
		EList relatedElement = (EList)eVirtualGet(UML2Package.DEPENDENCY__RELATED_ELEMENT);
		if (relatedElement == null) {
			eVirtualSet(UML2Package.DEPENDENCY__RELATED_ELEMENT, relatedElement = new DerivedUnionEObjectEList(Element.class, this, UML2Package.DEPENDENCY__RELATED_ELEMENT, new int[] {UML2Package.DEPENDENCY__SOURCE, UML2Package.DEPENDENCY__TARGET}));
		}
		return relatedElement;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelatedElements() {
		return isSetSources()
			|| isSetTargets();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getSources() {
		EList source = (EList)eVirtualGet(UML2Package.DEPENDENCY__SOURCE);
		if (source == null) {
			eVirtualSet(UML2Package.DEPENDENCY__SOURCE, source = new DerivedUnionEObjectEList(Element.class, this, UML2Package.DEPENDENCY__SOURCE, new int[] {UML2Package.DEPENDENCY__CLIENT}));
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetSources() {
		return eIsSet(UML2Package.Literals.DEPENDENCY__CLIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTargets() {
		EList target = (EList)eVirtualGet(UML2Package.DEPENDENCY__TARGET);
		if (target == null) {
			eVirtualSet(UML2Package.DEPENDENCY__TARGET, target = new DerivedUnionEObjectEList(Element.class, this, UML2Package.DEPENDENCY__TARGET, new int[] {UML2Package.DEPENDENCY__SUPPLIER}));
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetTargets() {
		return eIsSet(UML2Package.Literals.DEPENDENCY__SUPPLIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClients() {
		EList client = (EList)eVirtualGet(UML2Package.DEPENDENCY__CLIENT);
		if (client == null) {
			eVirtualSet(UML2Package.DEPENDENCY__CLIENT, client = new EObjectWithInverseResolvingEList.ManyInverse(NamedElement.class, this, UML2Package.DEPENDENCY__CLIENT, UML2Package.NAMED_ELEMENT__CLIENT_DEPENDENCY));
		}
		return client;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedElement getClient(String name) {
		for (Iterator i = getClients().iterator(); i.hasNext(); ) {
			NamedElement client = (NamedElement) i.next();
			if (name.equals(client.getName())) {
				return client;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuppliers() {
		EList supplier = (EList)eVirtualGet(UML2Package.DEPENDENCY__SUPPLIER);
		if (supplier == null) {
			eVirtualSet(UML2Package.DEPENDENCY__SUPPLIER, supplier = new EObjectResolvingEList(NamedElement.class, this, UML2Package.DEPENDENCY__SUPPLIER));
		}
		return supplier;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedElement getSupplier(String name) {
		for (Iterator i = getSuppliers().iterator(); i.hasNext(); ) {
			NamedElement supplier = (NamedElement) i.next();
			if (name.equals(supplier.getName())) {
				return supplier;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.DEPENDENCY__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
				case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
					TemplateSignature ownedTemplateSignature = (TemplateSignature)eVirtualGet(UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE);
					if (ownedTemplateSignature != null)
						msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE, null, msgs);
					return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
				case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
				case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
					TemplateParameter templateParameter = (TemplateParameter)eVirtualGet(UML2Package.DEPENDENCY__TEMPLATE_PARAMETER);
					if (templateParameter != null)
						msgs = ((InternalEObject)templateParameter).eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
					return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
				case UML2Package.DEPENDENCY__OWNING_PARAMETER:
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UML2Package.DEPENDENCY__OWNING_PARAMETER, msgs);
				case UML2Package.DEPENDENCY__CLIENT:
					return ((InternalEList)getClients()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eInternalContainer() != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.DEPENDENCY__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UML2Package.DEPENDENCY__OWNED_COMMENT:
					return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
				case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
				case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
					return basicSetOwnedTemplateSignature(null, msgs);
				case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
				case UML2Package.DEPENDENCY__NAME_EXPRESSION:
					return basicSetNameExpression(null, msgs);
				case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
					return basicSetTemplateParameter(null, msgs);
				case UML2Package.DEPENDENCY__OWNING_PARAMETER:
					return eBasicSetContainer(null, UML2Package.DEPENDENCY__OWNING_PARAMETER, msgs);
				case UML2Package.DEPENDENCY__CLIENT:
					return ((InternalEList)getClients()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.DEPENDENCY__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.DEPENDENCY__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.DEPENDENCY__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.DEPENDENCY__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.DEPENDENCY__NAME:
				return getName();
			case UML2Package.DEPENDENCY__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.DEPENDENCY__VISIBILITY:
				return getVisibility();
			case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.DEPENDENCY__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.DEPENDENCY__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.DEPENDENCY__PACKAGEABLE_ELEMENT_VISIBILITY:
				return getPackageableElement_visibility();
			case UML2Package.DEPENDENCY__RELATED_ELEMENT:
				return getRelatedElements();
			case UML2Package.DEPENDENCY__SOURCE:
				return getSources();
			case UML2Package.DEPENDENCY__TARGET:
				return getTargets();
			case UML2Package.DEPENDENCY__CLIENT:
				return getClients();
			case UML2Package.DEPENDENCY__SUPPLIER:
				return getSuppliers();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UML2Package.DEPENDENCY__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.DEPENDENCY__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.DEPENDENCY__NAME:
				setName((String)newValue);
				return;
			case UML2Package.DEPENDENCY__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.DEPENDENCY__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.DEPENDENCY__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.DEPENDENCY__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility((VisibilityKind)newValue);
				return;
			case UML2Package.DEPENDENCY__CLIENT:
				getClients().clear();
				getClients().addAll((Collection)newValue);
				return;
			case UML2Package.DEPENDENCY__SUPPLIER:
				getSuppliers().clear();
				getSuppliers().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UML2Package.DEPENDENCY__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.DEPENDENCY__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.DEPENDENCY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.DEPENDENCY__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.DEPENDENCY__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.DEPENDENCY__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.DEPENDENCY__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility(PACKAGEABLE_ELEMENT_VISIBILITY_EDEFAULT);
				return;
			case UML2Package.DEPENDENCY__CLIENT:
				getClients().clear();
				return;
			case UML2Package.DEPENDENCY__SUPPLIER:
				getSuppliers().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UML2Package.DEPENDENCY__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.DEPENDENCY__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.DEPENDENCY__OWNER:
				return isSetOwner();
			case UML2Package.DEPENDENCY__OWNED_COMMENT:
				EList ownedComment = (EList)eVirtualGet(UML2Package.DEPENDENCY__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UML2Package.DEPENDENCY__TEMPLATE_BINDING:
				EList templateBinding = (EList)eVirtualGet(UML2Package.DEPENDENCY__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE:
				return eVirtualGet(UML2Package.DEPENDENCY__OWNED_TEMPLATE_SIGNATURE) != null;
			case UML2Package.DEPENDENCY__NAME:
				String name = (String)eVirtualGet(UML2Package.DEPENDENCY__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.DEPENDENCY__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.DEPENDENCY__VISIBILITY:
				return isSetVisibility();
			case UML2Package.DEPENDENCY__CLIENT_DEPENDENCY:
				EList clientDependency = (EList)eVirtualGet(UML2Package.DEPENDENCY__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UML2Package.DEPENDENCY__NAME_EXPRESSION:
				return eVirtualGet(UML2Package.DEPENDENCY__NAME_EXPRESSION) != null;
			case UML2Package.DEPENDENCY__TEMPLATE_PARAMETER:
				return eVirtualGet(UML2Package.DEPENDENCY__TEMPLATE_PARAMETER) != null;
			case UML2Package.DEPENDENCY__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.DEPENDENCY__PACKAGEABLE_ELEMENT_VISIBILITY:
				return isSetPackageableElement_visibility();
			case UML2Package.DEPENDENCY__RELATED_ELEMENT:
				return isSetRelatedElements();
			case UML2Package.DEPENDENCY__SOURCE:
				return isSetSources();
			case UML2Package.DEPENDENCY__TARGET:
				return isSetTargets();
			case UML2Package.DEPENDENCY__CLIENT:
				EList client = (EList)eVirtualGet(UML2Package.DEPENDENCY__CLIENT);
				return client != null && !client.isEmpty();
			case UML2Package.DEPENDENCY__SUPPLIER:
				EList supplier = (EList)eVirtualGet(UML2Package.DEPENDENCY__SUPPLIER);
				return supplier != null && !supplier.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == Relationship.class) {
			switch (derivedFeatureID) {
				case UML2Package.DEPENDENCY__RELATED_ELEMENT: return UML2Package.RELATIONSHIP__RELATED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == DirectedRelationship.class) {
			switch (derivedFeatureID) {
				case UML2Package.DEPENDENCY__SOURCE: return UML2Package.DIRECTED_RELATIONSHIP__SOURCE;
				case UML2Package.DEPENDENCY__TARGET: return UML2Package.DIRECTED_RELATIONSHIP__TARGET;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == Relationship.class) {
			switch (baseFeatureID) {
				case UML2Package.RELATIONSHIP__RELATED_ELEMENT: return UML2Package.DEPENDENCY__RELATED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == DirectedRelationship.class) {
			switch (baseFeatureID) {
				case UML2Package.DIRECTED_RELATIONSHIP__SOURCE: return UML2Package.DEPENDENCY__SOURCE;
				case UML2Package.DIRECTED_RELATIONSHIP__TARGET: return UML2Package.DEPENDENCY__TARGET;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}


} //DependencyImpl
