/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: GeneralizationSetImpl.java,v 1.9 2005/12/14 22:34:17 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.GeneralizationSetOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralizationSetImpl#isCovering <em>Is Covering</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralizationSetImpl#isDisjoint <em>Is Disjoint</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralizationSetImpl#getPowertype <em>Powertype</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.GeneralizationSetImpl#getGeneralizations <em>Generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationSetImpl
		extends PackageableElementImpl
		implements GeneralizationSet {

	/**
	 * The default value of the '{@link #isCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCovering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COVERING_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCovering()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COVERING_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DISJOINT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DISJOINT_EFLAG = 1 << 9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.GENERALIZATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCovering() {
		return (eFlags & IS_COVERING_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCovering(boolean newIsCovering) {
		boolean oldIsCovering = (eFlags & IS_COVERING_EFLAG) != 0;
		if (newIsCovering)
			eFlags |= IS_COVERING_EFLAG;
		else
			eFlags &= ~IS_COVERING_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.GENERALIZATION_SET__IS_COVERING, oldIsCovering,
				newIsCovering));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisjoint() {
		return (eFlags & IS_DISJOINT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDisjoint(boolean newIsDisjoint) {
		boolean oldIsDisjoint = (eFlags & IS_DISJOINT_EFLAG) != 0;
		if (newIsDisjoint)
			eFlags |= IS_DISJOINT_EFLAG;
		else
			eFlags &= ~IS_DISJOINT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.GENERALIZATION_SET__IS_DISJOINT, oldIsDisjoint,
				newIsDisjoint));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getPowertype() {
		Classifier powertype = (Classifier) eVirtualGet(UMLPackage.GENERALIZATION_SET__POWERTYPE);
		if (powertype != null && powertype.eIsProxy()) {
			InternalEObject oldPowertype = (InternalEObject) powertype;
			powertype = (Classifier) eResolveProxy(oldPowertype);
			if (powertype != oldPowertype) {
				eVirtualSet(UMLPackage.GENERALIZATION_SET__POWERTYPE, powertype);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.GENERALIZATION_SET__POWERTYPE, oldPowertype,
						powertype));
			}
		}
		return powertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetPowertype() {
		return (Classifier) eVirtualGet(UMLPackage.GENERALIZATION_SET__POWERTYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowertype(Classifier newPowertype,
			NotificationChain msgs) {
		Object oldPowertype = eVirtualSet(
			UMLPackage.GENERALIZATION_SET__POWERTYPE, newPowertype);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, UMLPackage.GENERALIZATION_SET__POWERTYPE,
				oldPowertype == EVIRTUAL_NO_VALUE
					? null
					: oldPowertype, newPowertype);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowertype(Classifier newPowertype) {
		Classifier powertype = (Classifier) eVirtualGet(UMLPackage.GENERALIZATION_SET__POWERTYPE);
		if (newPowertype != powertype) {
			NotificationChain msgs = null;
			if (powertype != null)
				msgs = ((InternalEObject) powertype).eInverseRemove(this,
					UMLPackage.CLASSIFIER__POWERTYPE_EXTENT, Classifier.class,
					msgs);
			if (newPowertype != null)
				msgs = ((InternalEObject) newPowertype).eInverseAdd(this,
					UMLPackage.CLASSIFIER__POWERTYPE_EXTENT, Classifier.class,
					msgs);
			msgs = basicSetPowertype(newPowertype, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.GENERALIZATION_SET__POWERTYPE, newPowertype,
				newPowertype));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGeneralizations() {
		EList generalization = (EList) eVirtualGet(UMLPackage.GENERALIZATION_SET__GENERALIZATION);
		if (generalization == null) {
			eVirtualSet(
				UMLPackage.GENERALIZATION_SET__GENERALIZATION,
				generalization = new EObjectWithInverseResolvingEList.ManyInverse(
					Generalization.class, this,
					UMLPackage.GENERALIZATION_SET__GENERALIZATION,
					UMLPackage.GENERALIZATION__GENERALIZATION_SET));
		}
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationSameClassifier(
			DiagnosticChain diagnostics, Map context) {
		return GeneralizationSetOperations
			.validateGeneralizationSameClassifier(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapsToGeneralizationSet(DiagnosticChain diagnostics,
			Map context) {
		return GeneralizationSetOperations.validateMapsToGeneralizationSet(
			this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicAdd(otherEnd,
					msgs);
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicAdd(
					otherEnd, msgs);
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd,
					UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER,
					msgs);
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				TemplateParameter templateParameter = (TemplateParameter) eVirtualGet(UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER);
				if (templateParameter != null)
					msgs = ((InternalEObject) templateParameter)
						.eInverseRemove(this,
							UMLPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT,
							TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter) otherEnd,
					msgs);
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				Classifier powertype = (Classifier) eVirtualGet(UMLPackage.GENERALIZATION_SET__POWERTYPE);
				if (powertype != null)
					msgs = ((InternalEObject) powertype).eInverseRemove(this,
						UMLPackage.CLASSIFIER__POWERTYPE_EXTENT,
						Classifier.class, msgs);
				return basicSetPowertype((Classifier) otherEnd, msgs);
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				return ((InternalEList) getGeneralizations()).basicAdd(
					otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERALIZATION_SET__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				return eBasicSetContainer(null,
					UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER,
					msgs);
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				return basicSetTemplateParameter(null, msgs);
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				return basicSetPowertype(null, msgs);
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				return ((InternalEList) getGeneralizations()).basicRemove(
					otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.GENERALIZATION_SET__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.GENERALIZATION_SET__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.GENERALIZATION_SET__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.GENERALIZATION_SET__NAME :
				return getName();
			case UMLPackage.GENERALIZATION_SET__VISIBILITY :
				return getVisibility();
			case UMLPackage.GENERALIZATION_SET__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.GENERALIZATION_SET__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				if (resolve)
					return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.GENERALIZATION_SET__IS_COVERING :
				return isCovering()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.GENERALIZATION_SET__IS_DISJOINT :
				return isDisjoint()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				if (resolve)
					return getPowertype();
				return basicGetPowertype();
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				return getGeneralizations();
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
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__IS_COVERING :
				setIsCovering(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.GENERALIZATION_SET__IS_DISJOINT :
				setIsDisjoint(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				setPowertype((Classifier) newValue);
				return;
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection) newValue);
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
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.GENERALIZATION_SET__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.GENERALIZATION_SET__NAME :
				unsetName();
				return;
			case UMLPackage.GENERALIZATION_SET__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.GENERALIZATION_SET__IS_COVERING :
				setIsCovering(IS_COVERING_EDEFAULT);
				return;
			case UMLPackage.GENERALIZATION_SET__IS_DISJOINT :
				setIsDisjoint(IS_DISJOINT_EDEFAULT);
				return;
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				setPowertype((Classifier) null);
				return;
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				getGeneralizations().clear();
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
			case UMLPackage.GENERALIZATION_SET__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.GENERALIZATION_SET__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.GENERALIZATION_SET__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.GENERALIZATION_SET__OWNER :
				return isSetOwner();
			case UMLPackage.GENERALIZATION_SET__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.GENERALIZATION_SET__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.GENERALIZATION_SET__NAME :
				return isSetName();
			case UMLPackage.GENERALIZATION_SET__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.GENERALIZATION_SET__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.GENERALIZATION_SET__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.GENERALIZATION_SET__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.GENERALIZATION_SET__NAME_EXPRESSION) != null;
			case UMLPackage.GENERALIZATION_SET__OWNING_TEMPLATE_PARAMETER :
				return basicGetOwningTemplateParameter() != null;
			case UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER :
				return eVirtualGet(UMLPackage.GENERALIZATION_SET__TEMPLATE_PARAMETER) != null;
			case UMLPackage.GENERALIZATION_SET__IS_COVERING :
				return ((eFlags & IS_COVERING_EFLAG) != 0) != IS_COVERING_EDEFAULT;
			case UMLPackage.GENERALIZATION_SET__IS_DISJOINT :
				return ((eFlags & IS_DISJOINT_EFLAG) != 0) != IS_DISJOINT_EDEFAULT;
			case UMLPackage.GENERALIZATION_SET__POWERTYPE :
				return eVirtualGet(UMLPackage.GENERALIZATION_SET__POWERTYPE) != null;
			case UMLPackage.GENERALIZATION_SET__GENERALIZATION :
				EList generalization = (EList) eVirtualGet(UMLPackage.GENERALIZATION_SET__GENERALIZATION);
				return generalization != null && !generalization.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCovering: "); //$NON-NLS-1$
		result.append((eFlags & IS_COVERING_EFLAG) != 0);
		result.append(", isDisjoint: "); //$NON-NLS-1$
		result.append((eFlags & IS_DISJOINT_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //GeneralizationSetImpl
