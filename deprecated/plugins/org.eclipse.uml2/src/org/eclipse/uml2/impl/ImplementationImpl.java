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
 * $Id: ImplementationImpl.java,v 1.23 2005/11/23 20:05:08 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.BehavioredClassifier;
import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.Component;
//import org.eclipse.uml2.Element;
import org.eclipse.uml2.Implementation;
import org.eclipse.uml2.Interface;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.OpaqueExpression;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

//import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SupersetEObjectResolvingEList;
import org.eclipse.uml2.common.util.SupersetEObjectWithInverseResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getTargets <em>Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getSources <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getSuppliers <em>Supplier</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getClients <em>Client</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ImplementationImpl#getImplementingClassifier <em>Implementing Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationImpl extends RealizationImpl implements Implementation {
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
	protected ImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTargets() {
		return super.getTargets();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargets() {
		return super.isSetTargets()
			|| eIsSet(UML2Package.IMPLEMENTATION__CONTRACT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getSources() {
		return super.getSources();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSources() {
		return super.isSetSources()
			|| eIsSet(UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getContract() {
		Interface contract = (Interface)eVirtualGet(UML2Package.IMPLEMENTATION__CONTRACT);
		if (contract != null && contract.eIsProxy()) {
			InternalEObject oldContract = (InternalEObject)contract;
			contract = (Interface)eResolveProxy(oldContract);
			if (contract != oldContract) {
				eVirtualSet(UML2Package.IMPLEMENTATION__CONTRACT, contract);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.IMPLEMENTATION__CONTRACT, oldContract, contract));
			}
		}
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetContract() {
		return (Interface)eVirtualGet(UML2Package.IMPLEMENTATION__CONTRACT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContract(Interface newContract) {
		if (newContract != null && !getSuppliers().contains(newContract)) {
			getSuppliers().add(newContract);
		}
		Interface contract = newContract;
		Object oldContract = eVirtualSet(UML2Package.IMPLEMENTATION__CONTRACT, contract);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.IMPLEMENTATION__CONTRACT, oldContract == EVIRTUAL_NO_VALUE ? null : oldContract, contract));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier getImplementingClassifier() {
		if (eContainerFeatureID != UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER) return null;
		return (BehavioredClassifier)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementingClassifier(BehavioredClassifier newImplementingClassifier) {
		if (newImplementingClassifier != null && !getClients().contains(newImplementingClassifier)) {
			getClients().add(newImplementingClassifier);
		}
		if (newImplementingClassifier != eInternalContainer() || (eContainerFeatureID != UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER && newImplementingClassifier != null)) {
			if (EcoreUtil.isAncestor(this, newImplementingClassifier))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newImplementingClassifier != null)
				msgs = ((InternalEObject)newImplementingClassifier).eInverseAdd(this, UML2Package.BEHAVIORED_CLASSIFIER__IMPLEMENTATION, BehavioredClassifier.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newImplementingClassifier, UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER, newImplementingClassifier, newImplementingClassifier));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuppliers() {
		EList supplier = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__SUPPLIER);
		if (supplier == null) {
			eVirtualSet(UML2Package.IMPLEMENTATION__SUPPLIER, supplier = new SupersetEObjectResolvingEList(NamedElement.class, this, UML2Package.IMPLEMENTATION__SUPPLIER, new int[] {UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER, UML2Package.IMPLEMENTATION__CONTRACT}));
		}
		return supplier;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClients() {
		EList client = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__CLIENT);
		if (client == null) {
			eVirtualSet(UML2Package.IMPLEMENTATION__CLIENT, client = new SupersetEObjectWithInverseResolvingEList.ManyInverse(NamedElement.class, this, UML2Package.IMPLEMENTATION__CLIENT, new int[] {UML2Package.IMPLEMENTATION__ABSTRACTION, UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER}, UML2Package.NAMED_ELEMENT__CLIENT_DEPENDENCY));
		}
		return client;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UML2Package.IMPLEMENTATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
					TemplateSignature ownedTemplateSignature = (TemplateSignature)eVirtualGet(UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE);
					if (ownedTemplateSignature != null)
						msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE, null, msgs);
					return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
					TemplateParameter templateParameter = (TemplateParameter)eVirtualGet(UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER);
					if (templateParameter != null)
						msgs = ((InternalEObject)templateParameter).eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
					return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UML2Package.IMPLEMENTATION__OWNING_PARAMETER, msgs);
				case UML2Package.IMPLEMENTATION__CLIENT:
					return ((InternalEList)getClients()).basicAdd(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__ABSTRACTION:
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UML2Package.IMPLEMENTATION__ABSTRACTION, msgs);
				case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
					if (eInternalContainer() != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER, msgs);
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
				case UML2Package.IMPLEMENTATION__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__OWNED_COMMENT:
					return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
					return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
					return basicSetOwnedTemplateSignature(null, msgs);
				case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
					return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__NAME_EXPRESSION:
					return basicSetNameExpression(null, msgs);
				case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
					return basicSetTemplateParameter(null, msgs);
				case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
					return eBasicSetContainer(null, UML2Package.IMPLEMENTATION__OWNING_PARAMETER, msgs);
				case UML2Package.IMPLEMENTATION__CLIENT:
					return ((InternalEList)getClients()).basicRemove(otherEnd, msgs);
				case UML2Package.IMPLEMENTATION__MAPPING:
					return basicSetMapping(null, msgs);
				case UML2Package.IMPLEMENTATION__ABSTRACTION:
					return eBasicSetContainer(null, UML2Package.IMPLEMENTATION__ABSTRACTION, msgs);
				case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
					return eBasicSetContainer(null, UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
					return eInternalContainer().eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				case UML2Package.IMPLEMENTATION__ABSTRACTION:
					return eInternalContainer().eInverseRemove(this, UML2Package.COMPONENT__REALIZATION, Component.class, msgs);
				case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
					return eInternalContainer().eInverseRemove(this, UML2Package.BEHAVIORED_CLASSIFIER__IMPLEMENTATION, BehavioredClassifier.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eInternalContainer().eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.IMPLEMENTATION__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.IMPLEMENTATION__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.IMPLEMENTATION__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.IMPLEMENTATION__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.IMPLEMENTATION__NAME:
				return getName();
			case UML2Package.IMPLEMENTATION__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.IMPLEMENTATION__VISIBILITY:
				return getVisibility();
			case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.IMPLEMENTATION__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.IMPLEMENTATION__PACKAGEABLE_ELEMENT_VISIBILITY:
				return getPackageableElement_visibility();
			case UML2Package.IMPLEMENTATION__RELATED_ELEMENT:
				return getRelatedElements();
			case UML2Package.IMPLEMENTATION__SOURCE:
				return getSources();
			case UML2Package.IMPLEMENTATION__TARGET:
				return getTargets();
			case UML2Package.IMPLEMENTATION__CLIENT:
				return getClients();
			case UML2Package.IMPLEMENTATION__SUPPLIER:
				return getSuppliers();
			case UML2Package.IMPLEMENTATION__MAPPING:
				return getMapping();
			case UML2Package.IMPLEMENTATION__ABSTRACTION:
				return getAbstraction();
			case UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER:
				if (resolve) return getRealizingClassifier();
				return basicGetRealizingClassifier();
			case UML2Package.IMPLEMENTATION__CONTRACT:
				if (resolve) return getContract();
				return basicGetContract();
			case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
				return getImplementingClassifier();
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
			case UML2Package.IMPLEMENTATION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.IMPLEMENTATION__NAME:
				setName((String)newValue);
				return;
			case UML2Package.IMPLEMENTATION__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.IMPLEMENTATION__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility((VisibilityKind)newValue);
				return;
			case UML2Package.IMPLEMENTATION__CLIENT:
				getClients().clear();
				getClients().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__SUPPLIER:
				getSuppliers().clear();
				getSuppliers().addAll((Collection)newValue);
				return;
			case UML2Package.IMPLEMENTATION__MAPPING:
				setMapping((OpaqueExpression)newValue);
				return;
			case UML2Package.IMPLEMENTATION__ABSTRACTION:
				setAbstraction((Component)newValue);
				return;
			case UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER:
				setRealizingClassifier((Classifier)newValue);
				return;
			case UML2Package.IMPLEMENTATION__CONTRACT:
				setContract((Interface)newValue);
				return;
			case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
				setImplementingClassifier((BehavioredClassifier)newValue);
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
			case UML2Package.IMPLEMENTATION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.IMPLEMENTATION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.IMPLEMENTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.IMPLEMENTATION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.IMPLEMENTATION__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.IMPLEMENTATION__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility(PACKAGEABLE_ELEMENT_VISIBILITY_EDEFAULT);
				return;
			case UML2Package.IMPLEMENTATION__CLIENT:
				getClients().clear();
				return;
			case UML2Package.IMPLEMENTATION__SUPPLIER:
				getSuppliers().clear();
				return;
			case UML2Package.IMPLEMENTATION__MAPPING:
				setMapping((OpaqueExpression)null);
				return;
			case UML2Package.IMPLEMENTATION__ABSTRACTION:
				setAbstraction((Component)null);
				return;
			case UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER:
				setRealizingClassifier((Classifier)null);
				return;
			case UML2Package.IMPLEMENTATION__CONTRACT:
				setContract((Interface)null);
				return;
			case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
				setImplementingClassifier((BehavioredClassifier)null);
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
			case UML2Package.IMPLEMENTATION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.IMPLEMENTATION__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.IMPLEMENTATION__OWNER:
				return isSetOwner();
			case UML2Package.IMPLEMENTATION__OWNED_COMMENT:
				EList ownedComment = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UML2Package.IMPLEMENTATION__TEMPLATE_BINDING:
				EList templateBinding = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE:
				return eVirtualGet(UML2Package.IMPLEMENTATION__OWNED_TEMPLATE_SIGNATURE) != null;
			case UML2Package.IMPLEMENTATION__NAME:
				String name = (String)eVirtualGet(UML2Package.IMPLEMENTATION__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.IMPLEMENTATION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.IMPLEMENTATION__VISIBILITY:
				return isSetVisibility();
			case UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY:
				EList clientDependency = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UML2Package.IMPLEMENTATION__NAME_EXPRESSION:
				return eVirtualGet(UML2Package.IMPLEMENTATION__NAME_EXPRESSION) != null;
			case UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER:
				return eVirtualGet(UML2Package.IMPLEMENTATION__TEMPLATE_PARAMETER) != null;
			case UML2Package.IMPLEMENTATION__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.IMPLEMENTATION__PACKAGEABLE_ELEMENT_VISIBILITY:
				return isSetPackageableElement_visibility();
			case UML2Package.IMPLEMENTATION__RELATED_ELEMENT:
				return isSetRelatedElements();
			case UML2Package.IMPLEMENTATION__SOURCE:
				return isSetSources();
			case UML2Package.IMPLEMENTATION__TARGET:
				return isSetTargets();
			case UML2Package.IMPLEMENTATION__CLIENT:
				EList client = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__CLIENT);
				return client != null && !client.isEmpty();
			case UML2Package.IMPLEMENTATION__SUPPLIER:
				EList supplier = (EList)eVirtualGet(UML2Package.IMPLEMENTATION__SUPPLIER);
				return supplier != null && !supplier.isEmpty();
			case UML2Package.IMPLEMENTATION__MAPPING:
				return eVirtualGet(UML2Package.IMPLEMENTATION__MAPPING) != null;
			case UML2Package.IMPLEMENTATION__ABSTRACTION:
				return getAbstraction() != null;
			case UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER:
				return eVirtualGet(UML2Package.IMPLEMENTATION__REALIZING_CLASSIFIER) != null;
			case UML2Package.IMPLEMENTATION__CONTRACT:
				return eVirtualGet(UML2Package.IMPLEMENTATION__CONTRACT) != null;
			case UML2Package.IMPLEMENTATION__IMPLEMENTING_CLASSIFIER:
				return getImplementingClassifier() != null;
		}
		return eDynamicIsSet(featureID);
	}


} //ImplementationImpl
