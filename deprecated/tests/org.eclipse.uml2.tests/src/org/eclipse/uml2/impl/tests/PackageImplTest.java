/*
 * Copyright (c) 2003, 2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * $Id: PackageImplTest.java,v 1.2 2004/05/11 15:20:50 khussey Exp $
 */
package org.eclipse.uml2.impl.tests;

import java.util.Arrays;
import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.Actor;
import org.eclipse.uml2.ElementImport;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.Package;
import org.eclipse.uml2.PackageImport;
import org.eclipse.uml2.PackageableElement;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;
import org.eclipse.uml2.impl.PackageImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getTemplateParameter() <em>Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getOwningParameter() <em>Owning Parameter</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getPackageableElement_visibility() <em>Packageable Element visibility</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getNestedPackages() <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getNestingPackage() <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getOwnedTypes() <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getOwnedMembers() <em>Owned Member</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getAppliedProfiles() <em>Applied Profile</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getOwner() <em>Get Owner</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getVisibility() <em>Get Visibility</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#setVisibility(VisibilityKind) <em>Set Visibility</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#validateElementsPublicOrPrivate(EDiagnosticChain, EMap) <em>Validate Elements Public Or Private</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#mustBeOwned() <em>Must Be Owned</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#visibleMembers() <em>Visible Members</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#makesVisible(NamedElement) <em>Makes Visible</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getNamespace() <em>Get Namespace</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getOwnedElements() <em>Get Owned Elements</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.PackageImpl#getPackageImports() <em>Get Package Imports</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PackageImplTest extends NamespaceImplTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2003, 2004 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PackageImplTest.class);
	}

	/**
	 * Constructs a new Package test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImplTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Package test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PackageImpl getFixture() {
		return (PackageImpl) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture((PackageImpl) UML2Factory.eINSTANCE.createPackage());
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
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getTemplateParameter() <em>Template Parameter</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getTemplateParameter()
	 * @generated
	 */
	public void testGetTemplateParameter() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#setTemplateParameter() <em>Template Parameter</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#setTemplateParameter()
	 * @generated
	 */
	public void testSetTemplateParameter() {
		// TODO: implement this feature setter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getOwningParameter() <em>Owning Parameter</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getOwningParameter()
	 * @generated
	 */
	public void testGetOwningParameter() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#setOwningParameter() <em>Owning Parameter</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#setOwningParameter()
	 * @generated
	 */
	public void testSetOwningParameter() {
		// TODO: implement this feature setter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getPackageableElement_visibility() <em>Packageable Element visibility</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getPackageableElement_visibility()
	 * @generated
	 */
	public void testGetPackageableElement_visibility() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#setPackageableElement_visibility() <em>Packageable Element visibility</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#setPackageableElement_visibility()
	 * @generated
	 */
	public void testSetPackageableElement_visibility() {
		// TODO: implement this feature setter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getNestedPackages() <em>Nested Package</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getNestedPackages()
	 * @generated
	 */
	public void testGetNestedPackages() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getNestingPackage() <em>Nesting Package</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getNestingPackage()
	 * @generated
	 */
	public void testGetNestingPackage() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getOwnedTypes() <em>Owned Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getOwnedTypes()
	 * @generated NOT
	 */
	public void testGetOwnedTypes() {
		Actor ownedActor = UML2Factory.eINSTANCE.createActor();
		getFixture().getOwnedMembers().add(ownedActor);

		Package ownedPackage = UML2Factory.eINSTANCE.createPackage();
		getFixture().getOwnedMembers().add(ownedPackage);

		assertTrue(getFixture().getOwnedTypes().contains(ownedActor));
		assertFalse(getFixture().getOwnedTypes().contains(ownedPackage));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getOwnedMembers() <em>Owned Member</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getOwnedMembers()
	 * @generated
	 */
	public void testGetOwnedMembers() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getAppliedProfiles() <em>Applied Profile</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getAppliedProfiles()
	 * @generated
	 */
	public void testGetAppliedProfiles() {
		// TODO: implement this feature getter test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getOwner() <em>Get Owner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getOwner()
	 * @generated NOT
	 */
	public void testGetOwner() {
		super.testGetOwner();

		assertSame(getFixture().getOwningParameter(), getFixture().getOwner());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getVisibility() <em>Get Visibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getVisibility()
	 * @generated NOT
	 */
	public void testGetVisibility() {
		getFixture().setPackageableElement_visibility(VisibilityKind.PACKAGE_LITERAL);

		assertSame(getFixture().getPackageableElement_visibility(), getFixture().getVisibility());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#setVisibility(VisibilityKind) <em>Set Visibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#setVisibility(VisibilityKind)
	 * @generated NOT
	 */
	public void testSetVisibility__VisibilityKind() {
		getFixture().setVisibility(VisibilityKind.PACKAGE_LITERAL);

		assertSame(getFixture().getVisibility(), getFixture().getPackageableElement_visibility());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#validateElementsPublicOrPrivate(EDiagnosticChain, EMap) <em>Validate Elements Public Or Private</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#validateElementsPublicOrPrivate(EDiagnosticChain, EMap)
	 * @generated
	 */
	public void testValidateElementsPublicOrPrivate__EDiagnosticChain_EMap() {
		// TODO: implement this operation test method
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#mustBeOwned() <em>Must Be Owned</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#mustBeOwned()
	 * @generated NOT
	 */
	public void testMustBeOwned() {
		assertFalse(getFixture().mustBeOwned());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#visibleMembers() <em>Visible Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#visibleMembers()
	 * @generated NOT
	 */
	public void testVisibleMembers() {
		Actor[] ownedActors = new Actor[VisibilityKind.VALUES.size() + 1];
		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			ownedActors[index] = UML2Factory.eINSTANCE.createActor();
			ownedActors[index].setPackageableElement_visibility((VisibilityKind) VisibilityKind.VALUES.get(index));
		}
		ownedActors[VisibilityKind.VALUES.size()] = UML2Factory.eINSTANCE.createActor();
		ownedActors[VisibilityKind.VALUES.size()].setPackageableElement_visibility(null);
		getFixture().getOwnedMembers().addAll(Arrays.asList(ownedActors));

		Package importedPackage = UML2Factory.eINSTANCE.createPackage();

		Actor[] actors = new Actor[VisibilityKind.VALUES.size() + 1];
		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			actors[index] = UML2Factory.eINSTANCE.createActor();
			actors[index].setPackageableElement_visibility((VisibilityKind) VisibilityKind.VALUES.get(index));
		}
		actors[VisibilityKind.VALUES.size()] = UML2Factory.eINSTANCE.createActor();
		actors[VisibilityKind.VALUES.size()].setPackageableElement_visibility(null);
		importedPackage.getOwnedMembers().addAll(Arrays.asList(actors));

		PackageImport packageImport = UML2Factory.eINSTANCE.createPackageImport();
		packageImport.setImportedPackage(importedPackage);
		getFixture().getPackageImports().add(packageImport);

		Actor[] importedActors = new Actor[2];
		importedActors[0] = UML2Factory.eINSTANCE.createActor();
		importedActors[0].setPackageableElement_visibility(VisibilityKind.PUBLIC_LITERAL);
		importedActors[1] = UML2Factory.eINSTANCE.createActor();
		importedActors[1].setPackageableElement_visibility(null);

		for (int index = 0; index < 2; index++) {
			ElementImport elementImport = UML2Factory.eINSTANCE.createElementImport();
			elementImport.setImportedElement(importedActors[index]);

			getFixture().getElementImports().add(elementImport);
		}

		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			assertEquals(VisibilityKind.PUBLIC == index, getFixture().visibleMembers().contains(ownedActors[index]));
			assertEquals(VisibilityKind.PUBLIC == index, getFixture().visibleMembers().contains(actors[index]));
		}

		assertTrue(getFixture().visibleMembers().contains(ownedActors[VisibilityKind.VALUES.size()]));
		assertTrue(getFixture().visibleMembers().contains(actors[VisibilityKind.VALUES.size()]));

		assertTrue(getFixture().visibleMembers().contains(importedActors[0]));
		assertTrue(getFixture().visibleMembers().contains(importedActors[1]));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#makesVisible(NamedElement) <em>Makes Visible</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#makesVisible(NamedElement)
	 * @generated NOT
	 */
	public void testMakesVisible__NamedElement() {
		Actor[] ownedActors = new Actor[VisibilityKind.VALUES.size() + 1];

		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			ownedActors[index] = UML2Factory.eINSTANCE.createActor();
			ownedActors[index].setPackageableElement_visibility((VisibilityKind) VisibilityKind.VALUES.get(index));
		}

		ownedActors[VisibilityKind.VALUES.size()] = UML2Factory.eINSTANCE.createActor();
		ownedActors[VisibilityKind.VALUES.size()].setPackageableElement_visibility(null);
		getFixture().getOwnedMembers().addAll(Arrays.asList(ownedActors));

		Package importedPackage = UML2Factory.eINSTANCE.createPackage();

		Actor[] actors = new Actor[VisibilityKind.VALUES.size() + 1];

		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			actors[index] = UML2Factory.eINSTANCE.createActor();
			actors[index].setPackageableElement_visibility((VisibilityKind) VisibilityKind.VALUES.get(index));
		}

		actors[VisibilityKind.VALUES.size()] = UML2Factory.eINSTANCE.createActor();
		actors[VisibilityKind.VALUES.size()].setPackageableElement_visibility(null);
		importedPackage.getOwnedMembers().addAll(Arrays.asList(actors));

		PackageImport packageImport = UML2Factory.eINSTANCE.createPackageImport();
		packageImport.setImportedPackage(importedPackage);
		getFixture().getPackageImports().add(packageImport);

		Actor[] importedActors = new Actor[2];
		importedActors[0] = UML2Factory.eINSTANCE.createActor();
		importedActors[0].setPackageableElement_visibility(VisibilityKind.PUBLIC_LITERAL);
		importedActors[1] = UML2Factory.eINSTANCE.createActor();
		importedActors[1].setPackageableElement_visibility(null);

		for (int index = 0; index < 2; index++) {
			ElementImport elementImport = UML2Factory.eINSTANCE.createElementImport();
			elementImport.setImportedElement(importedActors[index]);

			getFixture().getElementImports().add(elementImport);
		}

		assertFalse(getFixture().makesVisible(UML2Factory.eINSTANCE.createActor()));

		for (int index = 0; index < VisibilityKind.VALUES.size(); index++) {
			assertEquals(VisibilityKind.PUBLIC == index, getFixture().makesVisible(ownedActors[index]));

			try {
				assertEquals(VisibilityKind.PUBLIC == index, getFixture().makesVisible(actors[index]));
			} catch (IllegalArgumentException iae) {
				assertTrue(VisibilityKind.PUBLIC != index);
			}
		}

		assertTrue(getFixture().makesVisible(ownedActors[VisibilityKind.VALUES.size()]));
		assertTrue(getFixture().makesVisible(actors[VisibilityKind.VALUES.size()]));

		assertTrue(getFixture().makesVisible(importedActors[0]));
		assertTrue(getFixture().makesVisible(importedActors[1]));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getNamespace() <em>Get Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getNamespace()
	 * @generated NOT
	 */
	public void testGetNamespace() {
		super.testGetNamespace();

		assertSame(getFixture().getNestingPackage(), getFixture().getNamespace());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getOwnedElements() <em>Get Owned Elements</em>}' getter operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getOwnedElements()
	 * @generated NOT
	 */
	public void testGetOwnedElements() {
		super.testGetOwnedElements();

		assertTrue(getFixture().getOwnedElements().containsAll(getFixture().getPackageExtensions()));
		assertTrue(getFixture().getOwnedElements().containsAll(getFixture().getPackageMerges()));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.impl.PackageImpl#getPackageImports() <em>Get Package Imports</em>}' getter operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.impl.PackageImpl#getPackageImports()
	 * @generated
	 */
	public void testGetPackageImports() {
		// TODO: implement this getter operation test method
	}

	/**
	 * @see org.eclipse.uml2.impl.tests.NamedElementImplTest#setUpNamespace()
	 */
	protected void setUpNamespace() {
		UML2Factory.eINSTANCE.createPackage().getOwnedMembers().add(getFixture());
	}

	/**
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwnedElements()
	 */
	protected void setUpOwnedElements() {
		super.setUpOwnedElements();

		getFixture().getPackageExtensions().add(UML2Factory.eINSTANCE.createPackageMerge());
		getFixture().getPackageExtensions().add(UML2Factory.eINSTANCE.createPackageMerge());

		getFixture().getPackageMerges().add(UML2Factory.eINSTANCE.createPackageMerge());
		getFixture().getPackageMerges().add(UML2Factory.eINSTANCE.createPackageMerge());
	}

	/**
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwner()
	 */
	protected void setUpOwner() {
		UML2Factory.eINSTANCE.createTemplateParameter().setOwnedParameteredElement(getFixture());
	}

	/**
	 * @see org.eclipse.uml2.impl.tests.NamespaceImplTest#testGetOwnedMembers()
	 */
	public void testGetOwnedMember() {

		for (Iterator eAllSubClasses = getEAllSubClasses(UML2Package.eINSTANCE.getNamedElement()).iterator(); eAllSubClasses.hasNext();) {
			NamedElement namedElement = (NamedElement) UML2Factory.eINSTANCE.create((EClass) eAllSubClasses.next());

			try {
				getFixture().getOwnedMembers().add(namedElement);

				assertTrue(getFixture().getOwnedMembers().contains(namedElement));
			} catch (Exception e) {
				assertFalse(PackageableElement.class.isInstance(namedElement));
			}
		}
	}

} //PackageImplTest
