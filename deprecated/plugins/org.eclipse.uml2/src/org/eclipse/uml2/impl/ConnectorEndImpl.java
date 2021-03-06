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
 * $Id: ConnectorEndImpl.java,v 1.19 2006/04/10 20:40:20 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.Association;
import org.eclipse.uml2.ConnectableElement;
import org.eclipse.uml2.Connector;
import org.eclipse.uml2.ConnectorEnd;
import org.eclipse.uml2.Property;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ConnectorEndImpl#getDefiningEnd <em>Defining End</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ConnectorEndImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ConnectorEndImpl#getPartWithPort <em>Part With Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorEndImpl extends MultiplicityElementImpl implements ConnectorEnd {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected ConnectableElement role = null;

	/**
	 * The cached value of the '{@link #getPartWithPort() <em>Part With Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartWithPort()
	 * @generated
	 * @ordered
	 */
	protected Property partWithPort = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.CONNECTOR_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getDefiningEnd() {
		Property definingEnd = basicGetDefiningEnd();
		return definingEnd != null && definingEnd.eIsProxy() ? (Property)eResolveProxy((InternalEObject)definingEnd) : definingEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Property basicGetDefiningEnd() {

		if (Connector.class.isInstance(eContainer)) {
			Connector connector = (Connector) eContainer;
			Association type = connector.getType();

			if (null != type) {
				List ends = connector.getEnds();
				List memberEnds = type.getMemberEnds();

				if (ends.size() == memberEnds.size()) {
					return (Property) memberEnds.get(ends.indexOf(this));
				}
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectableElement getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (ConnectableElement)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.CONNECTOR_END__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectableElement basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRole(ConnectableElement newRole, NotificationChain msgs) {
		ConnectableElement oldRole = role;
		role = newRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UML2Package.CONNECTOR_END__ROLE, oldRole, newRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(ConnectableElement newRole) {
		if (newRole != role) {
			NotificationChain msgs = null;
			if (role != null)
				msgs = ((InternalEObject)role).eInverseRemove(this, UML2Package.CONNECTABLE_ELEMENT__END, ConnectableElement.class, msgs);
			if (newRole != null)
				msgs = ((InternalEObject)newRole).eInverseAdd(this, UML2Package.CONNECTABLE_ELEMENT__END, ConnectableElement.class, msgs);
			msgs = basicSetRole(newRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.CONNECTOR_END__ROLE, newRole, newRole));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPartWithPort() {
		if (partWithPort != null && partWithPort.eIsProxy()) {
			InternalEObject oldPartWithPort = (InternalEObject)partWithPort;
			partWithPort = (Property)eResolveProxy(oldPartWithPort);
			if (partWithPort != oldPartWithPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.CONNECTOR_END__PART_WITH_PORT, oldPartWithPort, partWithPort));
			}
		}
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetPartWithPort() {
		return partWithPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartWithPort(Property newPartWithPort) {
		Property oldPartWithPort = partWithPort;
		partWithPort = newPartWithPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.CONNECTOR_END__PART_WITH_PORT, oldPartWithPort, partWithPort));


	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
			case UML2Package.CONNECTOR_END__ROLE:
				if (role != null)
					msgs = ((InternalEObject)role).eInverseRemove(this, UML2Package.CONNECTABLE_ELEMENT__END, ConnectableElement.class, msgs);
				return basicSetRole((ConnectableElement)otherEnd, msgs);
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
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.CONNECTOR_END__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.CONNECTOR_END__UPPER_VALUE:
				return basicSetUpperValue(null, msgs);
			case UML2Package.CONNECTOR_END__LOWER_VALUE:
				return basicSetLowerValue(null, msgs);
			case UML2Package.CONNECTOR_END__ROLE:
				return basicSetRole(null, msgs);
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
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.CONNECTOR_END__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.CONNECTOR_END__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.CONNECTOR_END__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.CONNECTOR_END__IS_ORDERED:
				return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.CONNECTOR_END__IS_UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.CONNECTOR_END__LOWER:
				return new Integer(getLower());
			case UML2Package.CONNECTOR_END__UPPER:
				return new Integer(getUpper());
			case UML2Package.CONNECTOR_END__UPPER_VALUE:
				return getUpperValue();
			case UML2Package.CONNECTOR_END__LOWER_VALUE:
				return getLowerValue();
			case UML2Package.CONNECTOR_END__DEFINING_END:
				if (resolve) return getDefiningEnd();
				return basicGetDefiningEnd();
			case UML2Package.CONNECTOR_END__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case UML2Package.CONNECTOR_END__PART_WITH_PORT:
				if (resolve) return getPartWithPort();
				return basicGetPartWithPort();
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
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.CONNECTOR_END__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.CONNECTOR_END__IS_ORDERED:
				setIsOrdered(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.CONNECTOR_END__IS_UNIQUE:
				setIsUnique(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.CONNECTOR_END__UPPER_VALUE:
				setUpperValue((ValueSpecification)newValue);
				return;
			case UML2Package.CONNECTOR_END__LOWER_VALUE:
				setLowerValue((ValueSpecification)newValue);
				return;
			case UML2Package.CONNECTOR_END__ROLE:
				setRole((ConnectableElement)newValue);
				return;
			case UML2Package.CONNECTOR_END__PART_WITH_PORT:
				setPartWithPort((Property)newValue);
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
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.CONNECTOR_END__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.CONNECTOR_END__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case UML2Package.CONNECTOR_END__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case UML2Package.CONNECTOR_END__UPPER_VALUE:
				setUpperValue((ValueSpecification)null);
				return;
			case UML2Package.CONNECTOR_END__LOWER_VALUE:
				setLowerValue((ValueSpecification)null);
				return;
			case UML2Package.CONNECTOR_END__ROLE:
				setRole((ConnectableElement)null);
				return;
			case UML2Package.CONNECTOR_END__PART_WITH_PORT:
				setPartWithPort((Property)null);
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
			case UML2Package.CONNECTOR_END__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.CONNECTOR_END__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.CONNECTOR_END__OWNER:
				return isSetOwner();
			case UML2Package.CONNECTOR_END__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.CONNECTOR_END__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case UML2Package.CONNECTOR_END__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case UML2Package.CONNECTOR_END__LOWER:
				return getLower() != LOWER_EDEFAULT;
			case UML2Package.CONNECTOR_END__UPPER:
				return getUpper() != UPPER_EDEFAULT;
			case UML2Package.CONNECTOR_END__UPPER_VALUE:
				return upperValue != null;
			case UML2Package.CONNECTOR_END__LOWER_VALUE:
				return lowerValue != null;
			case UML2Package.CONNECTOR_END__DEFINING_END:
				return basicGetDefiningEnd() != null;
			case UML2Package.CONNECTOR_END__ROLE:
				return role != null;
			case UML2Package.CONNECTOR_END__PART_WITH_PORT:
				return partWithPort != null;
		}
		return eDynamicIsSet(featureID);
	}


} //ConnectorEndImpl
