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
 * $Id: TransitionKind.java,v 1.1 2005/11/14 22:25:56 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transition Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * TransitionKind is an enumeration of the following literal values:
 * ? external
 * ? internal
 * ? local
 * 
 * kind=#local implies owner.source.isComposite
 * kind=#external implies owner.source.isComposite
 * <!-- end-model-doc -->
 * @see org.eclipse.uml2.uml.UMLPackage#getTransitionKind()
 * @model
 * @generated
 */
public final class TransitionKind
		extends AbstractEnumerator {

	/**
	 * The '<em><b>Internal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kind=internal implies that the transition, if triggered, occurs without exiting or entering the source state. Thus, it does not cause a state change. This means that the entry or exit condition of the source state will not be invoked. An internal transition can be taken even if the state machine is in one or more regions nested within this state.
	 * <!-- end-model-doc -->
	 * @see #INTERNAL_LITERAL
	 * @model name="internal"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL = 0;

	/**
	 * The '<em><b>Local</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kind=local implies that the transition, if triggered, will not exit the composite (source) state, but it will apply to any state within the composite state, and these will be exited and entered.
	 * <!-- end-model-doc -->
	 * @see #LOCAL_LITERAL
	 * @model name="local"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL = 1;

	/**
	 * The '<em><b>External</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kind=external implies that the transition, if triggered, will exit the composite (source) state.
	 * <!-- end-model-doc -->
	 * @see #EXTERNAL_LITERAL
	 * @model name="external"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNAL = 2;

	/**
	 * The '<em><b>Internal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNAL
	 * @generated
	 * @ordered
	 */
	public static final TransitionKind INTERNAL_LITERAL = new TransitionKind(
		INTERNAL, "internal", "internal"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Local</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL
	 * @generated
	 * @ordered
	 */
	public static final TransitionKind LOCAL_LITERAL = new TransitionKind(
		LOCAL, "local", "local"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>External</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL
	 * @generated
	 * @ordered
	 */
	public static final TransitionKind EXTERNAL_LITERAL = new TransitionKind(
		EXTERNAL, "external", "external"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransitionKind[] VALUES_ARRAY = new TransitionKind[]{
		INTERNAL_LITERAL, LOCAL_LITERAL, EXTERNAL_LITERAL,};

	/**
	 * A public read-only list of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays
		.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind get(int value) {
		switch (value) {
			case INTERNAL :
				return INTERNAL_LITERAL;
			case LOCAL :
				return LOCAL_LITERAL;
			case EXTERNAL :
				return EXTERNAL_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransitionKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TransitionKind