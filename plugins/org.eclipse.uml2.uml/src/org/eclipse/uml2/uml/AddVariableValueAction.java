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
 * $Id: AddVariableValueAction.java,v 1.1 2005/11/14 22:25:57 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Variable Value Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Variables are potentially multi-valued and ordered, so the action supports specification of insertion points for new values. It also supports the removal of existing values of the variable before the new value is added.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.AddVariableValueAction#isReplaceAll <em>Is Replace All</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.AddVariableValueAction#getInsertAt <em>Insert At</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getAddVariableValueAction()
 * @model
 * @generated
 */
public interface AddVariableValueAction
		extends WriteVariableAction {

	/**
	 * Returns the value of the '<em><b>Is Replace All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies whether existing values of the variable should be removed before adding the new value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Replace All</em>' attribute.
	 * @see #setIsReplaceAll(boolean)
	 * @see org.eclipse.uml2.uml.UMLPackage#getAddVariableValueAction_IsReplaceAll()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isReplaceAll();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.AddVariableValueAction#isReplaceAll <em>Is Replace All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Replace All</em>' attribute.
	 * @see #isReplaceAll()
	 * @generated
	 */
	void setIsReplaceAll(boolean value);

	/**
	 * Returns the value of the '<em><b>Insert At</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gives the position at which to insert a new value or move an existing value in ordered variables. The types is UnlimitedINatural, but the value cannot be zero. This pin is omitted for unordered variables.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Insert At</em>' containment reference.
	 * @see #setInsertAt(InputPin)
	 * @see org.eclipse.uml2.uml.UMLPackage#getAddVariableValueAction_InsertAt()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	InputPin getInsertAt();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.AddVariableValueAction#getInsertAt <em>Insert At</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insert At</em>' containment reference.
	 * @see #getInsertAt()
	 * @generated
	 */
	void setInsertAt(InputPin value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.InputPin} and sets the '<em><b>Insert At</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.InputPin} to create.
	 * @return The new {@link org.eclipse.uml2.uml.InputPin}.
	 * @see #getInsertAt()
	 * @generated
	 */
	InputPin createInsertAt(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.InputPin} and sets the '<em><b>Insert At</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.InputPin}.
	 * @see #getInsertAt()
	 * @generated
	 */
	InputPin createInsertAt();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Actions adding values to ordered variables must have a single input pin for the insertion point with type UnlimtedNatural and multiplicity of 1..1, otherwise the action has no input pin for the insertion point.
	 * let insertAtPins : Collection = self.insertAt in
	 * if self.variable.ordering = #unordered
	 * then insertAtPins->size() = 0
	 * else let insertAtPin : InputPin = insertAt->asSequence()->first() in
	 * insertAtPins->size() = 1
	 * and insertAtPin.type = UnlimitedNatural
	 * and insertAtPin.multiplicity.is(1,1))
	 * endif
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSingleInputPin(DiagnosticChain diagnostics, Map context);

} // AddVariableValueAction