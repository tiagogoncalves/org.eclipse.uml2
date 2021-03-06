/*
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: ExtensionPointImpl.java,v 1.18 2006/04/10 20:40:19 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.ExtensionPoint;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.UseCase;
import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ExtensionPointImpl#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionPointImpl extends RedefinableElementImpl implements ExtensionPoint {
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
	protected ExtensionPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.EXTENSION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getUseCase() {
		if (eContainerFeatureID != UML2Package.EXTENSION_POINT__USE_CASE) return null;
		return (UseCase)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUseCase(UseCase newUseCase, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUseCase, UML2Package.EXTENSION_POINT__USE_CASE, msgs);

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCase(UseCase newUseCase) {
		if (newUseCase != eInternalContainer() || (eContainerFeatureID != UML2Package.EXTENSION_POINT__USE_CASE && newUseCase != null)) {
			if (EcoreUtil.isAncestor(this, newUseCase))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUseCase != null)
				msgs = ((InternalEObject)newUseCase).eInverseAdd(this, UML2Package.USE_CASE__EXTENSION_POINT, UseCase.class, msgs);
			msgs = basicSetUseCase(newUseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.EXTENSION_POINT__USE_CASE, newUseCase, newUseCase));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__USE_CASE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUseCase((UseCase)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
			case UML2Package.EXTENSION_POINT__NAME_EXPRESSION:
				return basicSetNameExpression(null, msgs);
			case UML2Package.EXTENSION_POINT__USE_CASE:
				return basicSetUseCase(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case UML2Package.EXTENSION_POINT__USE_CASE:
				return eInternalContainer().eInverseRemove(this, UML2Package.USE_CASE__EXTENSION_POINT, UseCase.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.EXTENSION_POINT__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.EXTENSION_POINT__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.EXTENSION_POINT__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.EXTENSION_POINT__NAME:
				return getName();
			case UML2Package.EXTENSION_POINT__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.EXTENSION_POINT__VISIBILITY:
				return getVisibility();
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.EXTENSION_POINT__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.EXTENSION_POINT__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.EXTENSION_POINT__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_POINT__USE_CASE:
				return getUseCase();
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
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.EXTENSION_POINT__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.EXTENSION_POINT__NAME:
				setName((String)newValue);
				return;
			case UML2Package.EXTENSION_POINT__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.EXTENSION_POINT__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.EXTENSION_POINT__IS_LEAF:
				setIsLeaf(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.EXTENSION_POINT__USE_CASE:
				setUseCase((UseCase)newValue);
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
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.EXTENSION_POINT__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.EXTENSION_POINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.EXTENSION_POINT__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.EXTENSION_POINT__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.EXTENSION_POINT__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UML2Package.EXTENSION_POINT__USE_CASE:
				setUseCase((UseCase)null);
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
			case UML2Package.EXTENSION_POINT__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.EXTENSION_POINT__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.EXTENSION_POINT__OWNER:
				return isSetOwner();
			case UML2Package.EXTENSION_POINT__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.EXTENSION_POINT__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.EXTENSION_POINT__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.EXTENSION_POINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.EXTENSION_POINT__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.EXTENSION_POINT__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.EXTENSION_POINT__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.EXTENSION_POINT__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.EXTENSION_POINT__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.EXTENSION_POINT__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.EXTENSION_POINT__USE_CASE:
				return getUseCase() != null;
		}
		return eDynamicIsSet(featureID);
	}


} //ExtensionPointImpl
