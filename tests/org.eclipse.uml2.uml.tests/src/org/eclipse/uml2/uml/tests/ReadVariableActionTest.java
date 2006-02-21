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
 * $Id: ReadVariableActionTest.java,v 1.1 2006/02/21 16:32:27 khussey Exp $
 */
package org.eclipse.uml2.uml.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.uml.ReadVariableAction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Read Variable Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Action#getOutputs() <em>Output</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.ReadVariableAction#validateTypeAndOrdering(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type And Ordering</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.ReadVariableAction#validateCompatibleMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Multiplicity</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ReadVariableActionTest
		extends VariableActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReadVariableActionTest.class);
	}

	/**
	 * Constructs a new Read Variable Action test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadVariableActionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Read Variable Action test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ReadVariableAction getFixture() {
		return (ReadVariableAction) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp()
			throws Exception {
		setFixture(UMLFactory.eINSTANCE.createReadVariableAction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown()
			throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Action#getOutputs() <em>Output</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Action#getOutputs()
	 * @generated
	 */
	public void testGetOutputs() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.ReadVariableAction#validateTypeAndOrdering(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type And Ordering</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.ReadVariableAction#validateTypeAndOrdering(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateTypeAndOrdering__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.ReadVariableAction#validateCompatibleMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Multiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.ReadVariableAction#validateCompatibleMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateCompatibleMultiplicity__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

} //ReadVariableActionTest