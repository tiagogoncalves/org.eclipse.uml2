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
 * $Id: StereotypeOperations.java,v 1.4 2005/12/14 22:34:27 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Stereotype</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Stereotype#validateNameNotClash(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Not Clash</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Stereotype#validateGeneralize(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Generalize</em>}</li>
 * </ul>
 * </p>
 *
 * @generated not
 */
public final class StereotypeOperations
		extends UMLOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private StereotypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stereotype names should not clash with keyword names for the extended model element.
	 * true
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNameNotClash(Stereotype stereotype,
			DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.STEREOTYPE__NAME_NOT_CLASH,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNameNotClash", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(stereotype, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{stereotype}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Stereotype may only generalize or specialize another Stereotype.
	 * generalization.general->forAll(e |e.oclIsKindOf(Stereotype)) and generalization.specific->forAll(e | e.oclIsKindOf(Stereotype)) 
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateGeneralize(Stereotype stereotype,
			DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.STEREOTYPE__GENERALIZE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateGeneralize", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(stereotype, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{stereotype}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Extension createExtension(Stereotype stereotype,
			org.eclipse.uml2.uml.Class metaclass, boolean isRequired) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Profile getProfile(Stereotype stereotype) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static String getKeyword(Stereotype stereotype) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static String getKeyword(Stereotype stereotype, boolean isLocalized) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EList getExtendedMetaclasses(Stereotype stereotype) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EList getAllExtendedMetaclasses(Stereotype stereotype) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} // StereotypeOperations