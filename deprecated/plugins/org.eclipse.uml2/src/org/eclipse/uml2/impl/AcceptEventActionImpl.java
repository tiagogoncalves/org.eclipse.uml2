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
 * $Id: AcceptEventActionImpl.java,v 1.18 2005/11/23 20:05:09 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.AcceptEventAction;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.OutputPin;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.StructuredActivityNode;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.Trigger;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accept Event Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.AcceptEventActionImpl#getOutputs <em>Output</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.AcceptEventActionImpl#getTriggers <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.AcceptEventActionImpl#getResults <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcceptEventActionImpl extends ActionImpl implements AcceptEventAction {

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
	protected AcceptEventActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.ACCEPT_EVENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOutputs() {
		EList output = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__OUTPUT);
		if (output == null) {
			eVirtualSet(UML2Package.ACCEPT_EVENT_ACTION__OUTPUT, output = new DerivedUnionEObjectEList(OutputPin.class, this, UML2Package.ACCEPT_EVENT_ACTION__OUTPUT, new int[] {UML2Package.ACCEPT_EVENT_ACTION__RESULT}));
		}
		return output;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOutputs() {
		return super.isSetOutputs()
			|| eIsSet(UML2Package.ACCEPT_EVENT_ACTION__RESULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTriggers() {
		EList trigger = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__TRIGGER);
		if (trigger == null) {
			eVirtualSet(UML2Package.ACCEPT_EVENT_ACTION__TRIGGER, trigger = new EObjectResolvingEList(Trigger.class, this, UML2Package.ACCEPT_EVENT_ACTION__TRIGGER));
		}
		return trigger;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public Trigger getTrigger(String name) {
		for (Iterator i = getTriggers().iterator(); i.hasNext(); ) {
			Trigger trigger = (Trigger) i.next();
			if (name.equals(trigger.getName())) {
				return trigger;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResults() {
		EList result = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__RESULT);
		if (result == null) {
			eVirtualSet(UML2Package.ACCEPT_EVENT_ACTION__RESULT, result = new EObjectResolvingEList(OutputPin.class, this, UML2Package.ACCEPT_EVENT_ACTION__RESULT));
		}
		return result;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public OutputPin getResult(String name) {
		for (Iterator i = getResults().iterator(); i.hasNext(); ) {
			OutputPin result = (OutputPin) i.next();
			if (name.equals(result.getName())) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.ACCEPT_EVENT_ACTION__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.ACCEPT_EVENT_ACTION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.ACCEPT_EVENT_ACTION__NAME:
				return getName();
			case UML2Package.ACCEPT_EVENT_ACTION__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.ACCEPT_EVENT_ACTION__VISIBILITY:
				return getVisibility();
			case UML2Package.ACCEPT_EVENT_ACTION__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.ACCEPT_EVENT_ACTION__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.ACCEPT_EVENT_ACTION__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.ACCEPT_EVENT_ACTION__OUTGOING:
				return getOutgoings();
			case UML2Package.ACCEPT_EVENT_ACTION__INCOMING:
				return getIncomings();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_GROUP:
				return getInGroups();
			case UML2Package.ACCEPT_EVENT_ACTION__ACTIVITY:
				return getActivity();
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINED_ELEMENT:
				return getRedefinedElements();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_STRUCTURED_NODE:
				return getInStructuredNode();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_PARTITION:
				return getInPartitions();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_INTERRUPTIBLE_REGION:
				return getInInterruptibleRegions();
			case UML2Package.ACCEPT_EVENT_ACTION__HANDLER:
				return getHandlers();
			case UML2Package.ACCEPT_EVENT_ACTION__EFFECT:
				return getEffect();
			case UML2Package.ACCEPT_EVENT_ACTION__OUTPUT:
				return getOutputs();
			case UML2Package.ACCEPT_EVENT_ACTION__INPUT:
				return getInputs();
			case UML2Package.ACCEPT_EVENT_ACTION__CONTEXT:
				return getContext();
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_PRECONDITION:
				return getLocalPreconditions();
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_POSTCONDITION:
				return getLocalPostconditions();
			case UML2Package.ACCEPT_EVENT_ACTION__TRIGGER:
				return getTriggers();
			case UML2Package.ACCEPT_EVENT_ACTION__RESULT:
				return getResults();
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
			case UML2Package.ACCEPT_EVENT_ACTION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__NAME:
				setName((String)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IS_LEAF:
				setIsLeaf(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OUTGOING:
				getOutgoings().clear();
				getOutgoings().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__INCOMING:
				getIncomings().clear();
				getIncomings().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				getRedefinedElements().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_PARTITION:
				getInPartitions().clear();
				getInPartitions().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				getInInterruptibleRegions().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__HANDLER:
				getHandlers().clear();
				getHandlers().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__EFFECT:
				setEffect((String)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_PRECONDITION:
				getLocalPreconditions().clear();
				getLocalPreconditions().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_POSTCONDITION:
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__TRIGGER:
				getTriggers().clear();
				getTriggers().addAll((Collection)newValue);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__RESULT:
				getResults().clear();
				getResults().addAll((Collection)newValue);
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
			case UML2Package.ACCEPT_EVENT_ACTION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__OUTGOING:
				getOutgoings().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__INCOMING:
				getIncomings().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__ACTIVITY:
				setActivity((Activity)null);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINED_ELEMENT:
				getRedefinedElements().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_STRUCTURED_NODE:
				setInStructuredNode((StructuredActivityNode)null);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_PARTITION:
				getInPartitions().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_INTERRUPTIBLE_REGION:
				getInInterruptibleRegions().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__HANDLER:
				getHandlers().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__EFFECT:
				setEffect(EFFECT_EDEFAULT);
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_PRECONDITION:
				getLocalPreconditions().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_POSTCONDITION:
				getLocalPostconditions().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__TRIGGER:
				getTriggers().clear();
				return;
			case UML2Package.ACCEPT_EVENT_ACTION__RESULT:
				getResults().clear();
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
			case UML2Package.ACCEPT_EVENT_ACTION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNER:
				return isSetOwner();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_COMMENT:
				EList ownedComment = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__TEMPLATE_BINDING:
				EList templateBinding = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__OWNED_TEMPLATE_SIGNATURE:
				return eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__OWNED_TEMPLATE_SIGNATURE) != null;
			case UML2Package.ACCEPT_EVENT_ACTION__NAME:
				String name = (String)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.ACCEPT_EVENT_ACTION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.ACCEPT_EVENT_ACTION__VISIBILITY:
				return eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__VISIBILITY, VISIBILITY_EDEFAULT) != VISIBILITY_EDEFAULT;
			case UML2Package.ACCEPT_EVENT_ACTION__CLIENT_DEPENDENCY:
				EList clientDependency = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__NAME_EXPRESSION:
				return eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__NAME_EXPRESSION) != null;
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.ACCEPT_EVENT_ACTION__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.ACCEPT_EVENT_ACTION__OUTGOING:
				EList outgoing = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__OUTGOING);
				return outgoing != null && !outgoing.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__INCOMING:
				EList incoming = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__INCOMING);
				return incoming != null && !incoming.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_GROUP:
				return isSetInGroups();
			case UML2Package.ACCEPT_EVENT_ACTION__ACTIVITY:
				return getActivity() != null;
			case UML2Package.ACCEPT_EVENT_ACTION__REDEFINED_ELEMENT:
				return isSetRedefinedElements();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_STRUCTURED_NODE:
				return getInStructuredNode() != null;
			case UML2Package.ACCEPT_EVENT_ACTION__IN_PARTITION:
				EList inPartition = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__IN_PARTITION);
				return inPartition != null && !inPartition.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__IN_INTERRUPTIBLE_REGION:
				EList inInterruptibleRegion = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__IN_INTERRUPTIBLE_REGION);
				return inInterruptibleRegion != null && !inInterruptibleRegion.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__HANDLER:
				EList handler = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__HANDLER);
				return handler != null && !handler.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__EFFECT:
				String effect = (String)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__EFFECT, EFFECT_EDEFAULT);
				return EFFECT_EDEFAULT == null ? effect != null : !EFFECT_EDEFAULT.equals(effect);
			case UML2Package.ACCEPT_EVENT_ACTION__OUTPUT:
				return isSetOutputs();
			case UML2Package.ACCEPT_EVENT_ACTION__INPUT:
				return isSetInputs();
			case UML2Package.ACCEPT_EVENT_ACTION__CONTEXT:
				return getContext() != null;
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_PRECONDITION:
				EList localPrecondition = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__LOCAL_PRECONDITION);
				return localPrecondition != null && !localPrecondition.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__LOCAL_POSTCONDITION:
				EList localPostcondition = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__LOCAL_POSTCONDITION);
				return localPostcondition != null && !localPostcondition.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__TRIGGER:
				EList trigger = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__TRIGGER);
				return trigger != null && !trigger.isEmpty();
			case UML2Package.ACCEPT_EVENT_ACTION__RESULT:
				EList result = (EList)eVirtualGet(UML2Package.ACCEPT_EVENT_ACTION__RESULT);
				return result != null && !result.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}


} //AcceptEventActionImpl
