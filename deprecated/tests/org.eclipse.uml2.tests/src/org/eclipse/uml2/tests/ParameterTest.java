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
 * $Id: ParameterTest.java,v 1.4 2006/05/29 17:27:33 khussey Exp $
 */
package org.eclipse.uml2.tests;

import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.LiteralInteger;
import org.eclipse.uml2.LiteralUnlimitedNatural;
import org.eclipse.uml2.MultiplicityElement;
import org.eclipse.uml2.Parameter;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#getLower() <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#getUpper() <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.uml2.Parameter#getDefault() <em>Default</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#lowerBound() <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#upperBound() <em>Upper Bound</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#isMultivalued() <em>Is Multivalued</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#includesCardinality(int) <em>Includes Cardinality</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#includesMultiplicity(org.eclipse.uml2.MultiplicityElement) <em>Includes Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#validateUpperGt0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Gt0</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Ge0</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Ge Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#validateLowerEqLowerbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Eq Lowerbound</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#validateUpperEqUpperbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Eq Upperbound</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#lower() <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.MultiplicityElement#upper() <em>Upper</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ParameterTest extends ConnectableElementTest {

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
		TestRunner.run(ParameterTest.class);
	}

	/**
	 * Constructs a new Parameter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parameter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Parameter getFixture() {
		return (Parameter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(UML2Factory.eINSTANCE.createParameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#getLower() <em>Lower</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#getLower()
	 * @generated
	 */
	public void testGetLowerGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testGetLower() {
		testGetLowerGen();
		
		getFixture().setLowerValue(null);

		assertEquals(getFixture().lower(), getFixture().getLower());

		LiteralInteger lowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		getFixture().setLowerValue(lowerValue);

		lowerValue.setValue(0);

		assertEquals(getFixture().lower(), getFixture().getLower());

		lowerValue.setValue(Integer.MAX_VALUE);

		assertEquals(getFixture().lower(), getFixture().getLower());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#getUpper() <em>Upper</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#getUpper()
	 * @generated
	 */
	public void testGetUpperGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testGetUpper() {
		testGetUpperGen();
		
		getFixture().setUpperValue(null);

		assertEquals(getFixture().upper(), getFixture().getUpper());

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(0);

		assertEquals(getFixture().upper(), getFixture().getUpper());

		upperValue.setValue(Integer.MAX_VALUE);

		assertEquals(getFixture().upper(), getFixture().getUpper());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.Parameter#getDefault() <em>Default</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.Parameter#getDefault()
	 * @generated
	 */
	public void testGetDefaultGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testGetDefault() {
		testGetDefaultGen();
		
		getFixture().setDefaultValue(null);

		assertEquals("", getFixture().getDefault()); //$NON-NLS-1$

		for (Iterator eAllSubClasses = getEAllSubClasses(UML2Package.eINSTANCE.getValueSpecification()).iterator(); eAllSubClasses.hasNext();) {
			ValueSpecification defaultValue = (ValueSpecification) UML2Factory.eINSTANCE.create((EClass) eAllSubClasses.next());

			getFixture().setDefaultValue(defaultValue);

			assertEquals(defaultValue.stringValue(), getFixture().getDefault());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#lowerBound() <em>Lower Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#lowerBound()
	 * @generated
	 */
	public void testLowerBoundGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testLowerBound() {
		testLowerBoundGen();
		
		getFixture().setLowerValue(null);

		assertEquals(1, getFixture().lowerBound());

		LiteralInteger lowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		getFixture().setLowerValue(lowerValue);

		lowerValue.setValue(0);

		assertEquals(0, getFixture().lowerBound());

		lowerValue.setValue(Integer.MAX_VALUE);

		assertEquals(Integer.MAX_VALUE, getFixture().lowerBound());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#upperBound() <em>Upper Bound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#upperBound()
	 * @generated
	 */
	public void testUpperBoundGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testUpperBound() {
		testUpperBoundGen();
		
		getFixture().setUpperValue(null);

		assertEquals(1, getFixture().upperBound());

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(0);

		assertEquals(0, getFixture().upperBound());

		upperValue.setValue(Integer.MAX_VALUE);

		assertEquals(Integer.MAX_VALUE, getFixture().upperBound());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#isMultivalued() <em>Is Multivalued</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#isMultivalued()
	 * @generated
	 */
	public void testIsMultivaluedGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testIsMultivalued() {
		testIsMultivaluedGen();
		
		getFixture().setUpperValue(null);

		assertFalse(getFixture().isMultivalued());

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(1);

		assertFalse(getFixture().isMultivalued());

		upperValue.setValue(Integer.MAX_VALUE);

		assertTrue(getFixture().isMultivalued());

		upperValue.setValue(MultiplicityElement.UNLIMITED_UPPER_BOUND);

		assertTrue(getFixture().isMultivalued());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#includesCardinality(int) <em>Includes Cardinality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#includesCardinality(int)
	 * @generated
	 */
	public void testIncludesCardinality__intGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testIncludesCardinality__int() {
		testIncludesCardinality__intGen();
		
		getFixture().setLowerValue(null);
		getFixture().setUpperValue(null);

		assertTrue(getFixture().includesCardinality(1));
		assertFalse(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		LiteralInteger lowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		getFixture().setLowerValue(lowerValue);

		lowerValue.setValue(0);

		assertTrue(getFixture().includesCardinality(1));
		assertFalse(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(0);

		assertFalse(getFixture().includesCardinality(1));
		assertFalse(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		upperValue.setValue(Integer.MAX_VALUE);

		assertTrue(getFixture().includesCardinality(1));
		assertFalse(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		upperValue.setValue(MultiplicityElement.UNLIMITED_UPPER_BOUND);

		assertTrue(getFixture().includesCardinality(1));
		assertTrue(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		lowerValue.setValue(1);

		assertTrue(getFixture().includesCardinality(1));
		assertTrue(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));

		lowerValue.setValue(Integer.MAX_VALUE);

		assertFalse(getFixture().includesCardinality(1));
		assertTrue(getFixture().includesCardinality(MultiplicityElement.UNLIMITED_UPPER_BOUND));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#includesMultiplicity(org.eclipse.uml2.MultiplicityElement) <em>Includes Multiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#includesMultiplicity(org.eclipse.uml2.MultiplicityElement)
	 * @generated
	 */
	public void testIncludesMultiplicity__MultiplicityElementGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testIncludesMultiplicity__MultiplicityElement() {
		testIncludesMultiplicity__MultiplicityElementGen();
		
		MultiplicityElement defaultMultiplicity = (MultiplicityElement) UML2Factory.eINSTANCE.create(getFixture().eClass());

		MultiplicityElement unboundedMultiplicity = (MultiplicityElement) UML2Factory.eINSTANCE.create(getFixture().eClass());

		LiteralInteger optionalLowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		unboundedMultiplicity.setLowerValue(optionalLowerValue);
		optionalLowerValue.setValue(0);

		LiteralUnlimitedNatural unlimitedUpperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		unboundedMultiplicity.setUpperValue(unlimitedUpperValue);
		unlimitedUpperValue.setValue(MultiplicityElement.UNLIMITED_UPPER_BOUND);

		getFixture().setLowerValue(null);
		getFixture().setUpperValue(null);

		assertTrue(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));

		LiteralInteger lowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		getFixture().setLowerValue(lowerValue);

		lowerValue.setValue(0);

		assertTrue(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(0);

		assertFalse(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));

		upperValue.setValue(Integer.MAX_VALUE);

		assertTrue(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));

		upperValue.setValue(MultiplicityElement.UNLIMITED_UPPER_BOUND);

		assertTrue(getFixture().includesMultiplicity(defaultMultiplicity));
		assertTrue(getFixture().includesMultiplicity(unboundedMultiplicity));

		lowerValue.setValue(1);

		assertTrue(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));

		lowerValue.setValue(Integer.MAX_VALUE);

		assertFalse(getFixture().includesMultiplicity(defaultMultiplicity));
		assertFalse(getFixture().includesMultiplicity(unboundedMultiplicity));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#validateUpperGt0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Gt0</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#validateUpperGt0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateUpperGt0__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Ge0</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateLowerGe0__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Ge Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateUpperGeLower__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#validateLowerEqLowerbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Eq Lowerbound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#validateLowerEqLowerbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateLowerEqLowerbound__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#validateUpperEqUpperbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Eq Upperbound</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#validateUpperEqUpperbound(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateUpperEqUpperbound__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#lower()
	 * @generated
	 */
	public void testLowerGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testLower() {
		testLowerGen();
		
		getFixture().setLowerValue(null);

		assertEquals(getFixture().lowerBound(), getFixture().lower());

		LiteralInteger lowerValue = UML2Factory.eINSTANCE.createLiteralInteger();
		getFixture().setLowerValue(lowerValue);

		lowerValue.setValue(0);

		assertEquals(getFixture().lowerBound(), getFixture().lower());

		lowerValue.setValue(Integer.MAX_VALUE);

		assertEquals(getFixture().lowerBound(), getFixture().lower());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.MultiplicityElement#upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.MultiplicityElement#upper()
	 * @generated
	 */
	public void testUpperGen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}


	public void testUpper() {
		testUpperGen();
		
		getFixture().setUpperValue(null);

		assertEquals(getFixture().upperBound(), getFixture().upper());

		LiteralUnlimitedNatural upperValue = UML2Factory.eINSTANCE.createLiteralUnlimitedNatural();
		getFixture().setUpperValue(upperValue);

		upperValue.setValue(0);

		assertEquals(getFixture().upperBound(), getFixture().upper());

		upperValue.setValue(Integer.MAX_VALUE);

		assertEquals(getFixture().upperBound(), getFixture().upper());
	}

	public void testGetNamespace() {
		super.testGetNamespace();

		assertSame(getFixture().getOperation(), getFixture().getNamespace());
	}

	public void testGetOwnedElements() {
		super.testGetOwnedElements();

		assertTrue(getFixture().getOwnedElements().contains(getFixture().getDefaultValue()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.NamedElementImplTest#setUpNamespace()
	 */
	protected void setUpNamespace() {
		UML2Factory.eINSTANCE.createOperation().getOwnedParameters().add(getFixture());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwner()
	 */
	protected void setUpOwner() {
		UML2Factory.eINSTANCE.createTemplateParameter().setOwnedParameteredElement(getFixture());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwnedElements()
	 */
	protected void setUpOwnedElements() {
		super.setUpOwnedElements();

		getFixture().setDefaultValue(UML2Factory.eINSTANCE.createLiteralNull());
	}

} //ParameterImplTest
