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
 * $Id: ActivityParameterNodeItemProviderTest.java,v 1.4 2005/05/18 17:04:08 khussey Exp $
 */
package org.eclipse.uml2.provider.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.ActivityParameterNode;
import org.eclipse.uml2.UML2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the '<em><b>Activity Parameter Node</b></em>' item provider adapter.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityParameterNodeItemProviderTest extends ObjectNodeItemProviderTest {

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
	public static void main(String[] args) {
		TestRunner.run(ActivityParameterNodeItemProviderTest.class);
	}

	/**
	 * Constructs a new Activity Parameter Node item provider adapter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityParameterNodeItemProviderTest(String name) {
		super(name);
	}

	/**
	 * Returns the model object for this Activity Parameter Node item provider adapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ActivityParameterNode getModelObject() {
		return (ActivityParameterNode) modelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		super.setUp();

		setModelObject(UML2Factory.eINSTANCE.createActivityParameterNode());
	}

} //ActivityParameterNodeItemProviderTest
