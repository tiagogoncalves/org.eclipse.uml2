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
 * $Id: TriggerImpl.java,v 1.8 2005/12/14 22:34:18 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TriggerImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.TriggerImpl#getPorts <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl
		extends NamedElementImpl
		implements Trigger {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getEvent() {
		Event event = (Event) eVirtualGet(UMLPackage.TRIGGER__EVENT);
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject) event;
			event = (Event) eResolveProxy(oldEvent);
			if (event != oldEvent) {
				eVirtualSet(UMLPackage.TRIGGER__EVENT, event);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.TRIGGER__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetEvent() {
		return (Event) eVirtualGet(UMLPackage.TRIGGER__EVENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Event newEvent) {
		Event event = newEvent;
		Object oldEvent = eVirtualSet(UMLPackage.TRIGGER__EVENT, event);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.TRIGGER__EVENT, oldEvent == EVIRTUAL_NO_VALUE
					? null
					: oldEvent, event));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPorts() {
		EList port = (EList) eVirtualGet(UMLPackage.TRIGGER__PORT);
		if (port == null) {
			eVirtualSet(UMLPackage.TRIGGER__PORT,
				port = new EObjectResolvingEList(Port.class, this,
					UMLPackage.TRIGGER__PORT));
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort(String name) {
		for (Iterator i = getPorts().iterator(); i.hasNext();) {
			Port port = (Port) i.next();
			if (name.equals(port.getName())) {
				return port;
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
			case UMLPackage.TRIGGER__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.TRIGGER__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.TRIGGER__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.TRIGGER__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.TRIGGER__NAME :
				return getName();
			case UMLPackage.TRIGGER__VISIBILITY :
				return getVisibility();
			case UMLPackage.TRIGGER__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.TRIGGER__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.TRIGGER__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.TRIGGER__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.TRIGGER__EVENT :
				if (resolve)
					return getEvent();
				return basicGetEvent();
			case UMLPackage.TRIGGER__PORT :
				return getPorts();
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
			case UMLPackage.TRIGGER__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.TRIGGER__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.TRIGGER__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.TRIGGER__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.TRIGGER__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.TRIGGER__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.TRIGGER__EVENT :
				setEvent((Event) newValue);
				return;
			case UMLPackage.TRIGGER__PORT :
				getPorts().clear();
				getPorts().addAll((Collection) newValue);
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
			case UMLPackage.TRIGGER__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.TRIGGER__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.TRIGGER__NAME :
				unsetName();
				return;
			case UMLPackage.TRIGGER__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.TRIGGER__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.TRIGGER__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.TRIGGER__EVENT :
				setEvent((Event) null);
				return;
			case UMLPackage.TRIGGER__PORT :
				getPorts().clear();
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
			case UMLPackage.TRIGGER__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.TRIGGER__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.TRIGGER__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.TRIGGER__OWNER :
				return isSetOwner();
			case UMLPackage.TRIGGER__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.TRIGGER__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.TRIGGER__NAME :
				return isSetName();
			case UMLPackage.TRIGGER__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.TRIGGER__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.TRIGGER__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.TRIGGER__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.TRIGGER__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.TRIGGER__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.TRIGGER__NAME_EXPRESSION) != null;
			case UMLPackage.TRIGGER__EVENT :
				return eVirtualGet(UMLPackage.TRIGGER__EVENT) != null;
			case UMLPackage.TRIGGER__PORT :
				EList port = (EList) eVirtualGet(UMLPackage.TRIGGER__PORT);
				return port != null && !port.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

} //TriggerImpl
