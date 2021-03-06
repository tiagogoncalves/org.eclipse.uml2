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
 * $Id: JoinNodeImpl.java,v 1.24 2006/05/26 18:16:42 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.Activity;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.JoinNode;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.StructuredActivityNode;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.ValueSpecification;
import org.eclipse.uml2.VisibilityKind;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.JoinNodeImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.JoinNodeImpl#isCombineDuplicate <em>Is Combine Duplicate</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.JoinNodeImpl#getJoinSpec <em>Join Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoinNodeImpl extends ControlNodeImpl implements JoinNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isCombineDuplicate() <em>Is Combine Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCombineDuplicate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMBINE_DUPLICATE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isCombineDuplicate() <em>Is Combine Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCombineDuplicate()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COMBINE_DUPLICATE_EFLAG = 1 << 9;

	/**
	 * The cached value of the '{@link #getJoinSpec() <em>Join Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinSpec()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification joinSpec = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinNodeImpl() {
		super();
		eFlags |= IS_COMBINE_DUPLICATE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.JOIN_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			EList ownedElements = (EList) cache.get(eResource, this, UML2Package.Literals.ELEMENT__OWNED_ELEMENT);
			if (ownedElements == null) {
				cache.put(eResource, this, UML2Package.Literals.ELEMENT__OWNED_ELEMENT, ownedElements = new DerivedUnionEObjectEList(Element.class, this, UML2Package.JOIN_NODE__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS));
			}
			return ownedElements;
		}
		return new DerivedUnionEObjectEList(Element.class, this, UML2Package.JOIN_NODE__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements()
			|| eIsSet(UML2Package.JOIN_NODE__JOIN_SPEC);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] {UML2Package.JOIN_NODE__OWNED_COMMENT, UML2Package.JOIN_NODE__TEMPLATE_BINDING, UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE, UML2Package.JOIN_NODE__NAME_EXPRESSION, UML2Package.JOIN_NODE__JOIN_SPEC};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCombineDuplicate() {
		return (eFlags & IS_COMBINE_DUPLICATE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCombineDuplicate(boolean newIsCombineDuplicate) {
		boolean oldIsCombineDuplicate = (eFlags & IS_COMBINE_DUPLICATE_EFLAG) != 0;
		if (newIsCombineDuplicate) eFlags |= IS_COMBINE_DUPLICATE_EFLAG; else eFlags &= ~IS_COMBINE_DUPLICATE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.JOIN_NODE__IS_COMBINE_DUPLICATE, oldIsCombineDuplicate, newIsCombineDuplicate));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getJoinSpec() {
		return joinSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJoinSpec(ValueSpecification newJoinSpec, NotificationChain msgs) {
		ValueSpecification oldJoinSpec = joinSpec;
		joinSpec = newJoinSpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.JOIN_NODE__JOIN_SPEC, oldJoinSpec, newJoinSpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinSpec(ValueSpecification newJoinSpec) {
		if (newJoinSpec != joinSpec) {
			NotificationChain msgs = null;
			if (joinSpec != null)
				msgs = ((InternalEObject)joinSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.JOIN_NODE__JOIN_SPEC, null, msgs);
			if (newJoinSpec != null)
				msgs = ((InternalEObject)newJoinSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UML2Package.JOIN_NODE__JOIN_SPEC, null, msgs);
			msgs = basicSetJoinSpec(newJoinSpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.JOIN_NODE__JOIN_SPEC, newJoinSpec, newJoinSpec));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ValueSpecification createJoinSpec(EClass eClass) {
		ValueSpecification newJoinSpec = (ValueSpecification) eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.JOIN_NODE__JOIN_SPEC, null, newJoinSpec));
		}
		setJoinSpec(newJoinSpec);
		return newJoinSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.JOIN_NODE__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case UML2Package.JOIN_NODE__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__NAME_EXPRESSION:
				return basicSetNameExpression(null, msgs);
			case UML2Package.JOIN_NODE__OUTGOING:
				return ((InternalEList)getOutgoings()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__INCOMING:
				return ((InternalEList)getIncomings()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__ACTIVITY:
				return basicSetActivity(null, msgs);
			case UML2Package.JOIN_NODE__IN_STRUCTURED_NODE:
				return basicSetInStructuredNode(null, msgs);
			case UML2Package.JOIN_NODE__IN_PARTITION:
				return ((InternalEList)getInPartitions()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__IN_INTERRUPTIBLE_REGION:
				return ((InternalEList)getInInterruptibleRegions()).basicRemove(otherEnd, msgs);
			case UML2Package.JOIN_NODE__JOIN_SPEC:
				return basicSetJoinSpec(null, msgs);
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
			case UML2Package.JOIN_NODE__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.JOIN_NODE__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.JOIN_NODE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.JOIN_NODE__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.JOIN_NODE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.JOIN_NODE__NAME:
				return getName();
			case UML2Package.JOIN_NODE__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.JOIN_NODE__VISIBILITY:
				return getVisibility();
			case UML2Package.JOIN_NODE__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.JOIN_NODE__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.JOIN_NODE__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.JOIN_NODE__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.JOIN_NODE__OUTGOING:
				return getOutgoings();
			case UML2Package.JOIN_NODE__INCOMING:
				return getIncomings();
			case UML2Package.JOIN_NODE__IN_GROUP:
				return getInGroups();
			case UML2Package.JOIN_NODE__ACTIVITY:
				return getActivity();
			case UML2Package.JOIN_NODE__REDEFINED_ELEMENT:
				return getRedefinedElements();
			case UML2Package.JOIN_NODE__IN_STRUCTURED_NODE:
				return getInStructuredNode();
			case UML2Package.JOIN_NODE__IN_PARTITION:
				return getInPartitions();
			case UML2Package.JOIN_NODE__IN_INTERRUPTIBLE_REGION:
				return getInInterruptibleRegions();
			case UML2Package.JOIN_NODE__IS_COMBINE_DUPLICATE:
				return isCombineDuplicate() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.JOIN_NODE__JOIN_SPEC:
				return getJoinSpec();
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
			case UML2Package.JOIN_NODE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.JOIN_NODE__NAME:
				setName((String)newValue);
				return;
			case UML2Package.JOIN_NODE__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.JOIN_NODE__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.JOIN_NODE__IS_LEAF:
				setIsLeaf(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.JOIN_NODE__OUTGOING:
				getOutgoings().clear();
				getOutgoings().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__INCOMING:
				getIncomings().clear();
				getIncomings().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case UML2Package.JOIN_NODE__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				getRedefinedElements().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)newValue);
				return;
			case UML2Package.JOIN_NODE__IN_PARTITION:
				getInPartitions().clear();
				getInPartitions().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection)newValue);
				return;
			case UML2Package.JOIN_NODE__IS_COMBINE_DUPLICATE:
				setIsCombineDuplicate(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.JOIN_NODE__JOIN_SPEC:
				setJoinSpec((ValueSpecification)newValue);
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
			case UML2Package.JOIN_NODE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.JOIN_NODE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.JOIN_NODE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.JOIN_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.JOIN_NODE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.JOIN_NODE__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.JOIN_NODE__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.JOIN_NODE__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UML2Package.JOIN_NODE__OUTGOING:
				getOutgoings().clear();
				return;
			case UML2Package.JOIN_NODE__INCOMING:
				getIncomings().clear();
				return;
			case UML2Package.JOIN_NODE__ACTIVITY:
				setActivity((Activity)null);
				return;
			case UML2Package.JOIN_NODE__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				return;
			case UML2Package.JOIN_NODE__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)null);
				return;
			case UML2Package.JOIN_NODE__IN_PARTITION:
				getInPartitions().clear();
				return;
			case UML2Package.JOIN_NODE__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				return;
			case UML2Package.JOIN_NODE__IS_COMBINE_DUPLICATE:
				setIsCombineDuplicate(IS_COMBINE_DUPLICATE_EDEFAULT);
				return;
			case UML2Package.JOIN_NODE__JOIN_SPEC:
				setJoinSpec((ValueSpecification)null);
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
			case UML2Package.JOIN_NODE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.JOIN_NODE__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.JOIN_NODE__OWNER:
				return isSetOwner();
			case UML2Package.JOIN_NODE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.JOIN_NODE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.JOIN_NODE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.JOIN_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.JOIN_NODE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.JOIN_NODE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.JOIN_NODE__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.JOIN_NODE__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.JOIN_NODE__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.JOIN_NODE__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.JOIN_NODE__OUTGOING:
				return outgoings != null && !outgoings.isEmpty();
			case UML2Package.JOIN_NODE__INCOMING:
				return incomings != null && !incomings.isEmpty();
			case UML2Package.JOIN_NODE__IN_GROUP:
				return isSetInGroups();
			case UML2Package.JOIN_NODE__ACTIVITY:
				return getActivity() != null;
			case UML2Package.JOIN_NODE__REDEFINED_ELEMENT:
				return isSetRedefinedElements();
			case UML2Package.JOIN_NODE__IN_STRUCTURED_NODE:
				return getInStructuredNode() != null;
			case UML2Package.JOIN_NODE__IN_PARTITION:
				return inPartitions != null && !inPartitions.isEmpty();
			case UML2Package.JOIN_NODE__IN_INTERRUPTIBLE_REGION:
				return inInterruptibleRegions != null && !inInterruptibleRegions.isEmpty();
			case UML2Package.JOIN_NODE__IS_COMBINE_DUPLICATE:
				return ((eFlags & IS_COMBINE_DUPLICATE_EFLAG) != 0) != IS_COMBINE_DUPLICATE_EDEFAULT;
			case UML2Package.JOIN_NODE__JOIN_SPEC:
				return joinSpec != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCombineDuplicate: "); //$NON-NLS-1$
		result.append((eFlags & IS_COMBINE_DUPLICATE_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}


} //JoinNodeImpl
