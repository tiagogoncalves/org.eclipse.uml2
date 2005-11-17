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
 * $Id: FinalStateOperations.java,v 1.1 2005/11/14 22:25:55 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.FinalState;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Final State</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateNoOutgoingTransitions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Outgoing Transitions</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateNoRegions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Regions</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateCannotReferenceSubmachine(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Cannot Reference Submachine</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateNoEntryBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Entry Behavior</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateNoExitbehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Exitbehavior</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.FinalState#validateNoStateBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No State Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public final class FinalStateOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FinalStateOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state cannot have any outgoing transitions.
	 * self.outgoing->size() = 0
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNoOutgoingTransitions(FinalState finalState,
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
						UMLValidator.FINAL_STATE__NO_OUTGOING_TRANSITIONS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNoOutgoingTransitions", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state cannot have regions.
	 * self.region->size() = 0
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNoRegions(FinalState finalState,
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
						UMLValidator.FINAL_STATE__NO_REGIONS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNoRegions", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state cannot reference a submachine.
	 * self.submachine->isEmpty()
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateCannotReferenceSubmachine(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
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
						UMLValidator.FINAL_STATE__CANNOT_REFERENCE_SUBMACHINE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateCannotReferenceSubmachine", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state has no entry behavior.
	 * self.entry->isEmpty()
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNoEntryBehavior(FinalState finalState,
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
						UMLValidator.FINAL_STATE__NO_ENTRY_BEHAVIOR,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNoEntryBehavior", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state has no exit behavior.
	 * self.exit->isEmpty()
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNoExitbehavior(FinalState finalState,
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
						UMLValidator.FINAL_STATE__NO_EXITBEHAVIOR,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNoExitbehavior", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A final state has no state (doActivity) behavior.
	 * self.doActivity->isEmpty()
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateNoStateBehavior(FinalState finalState,
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
						UMLValidator.FINAL_STATE__NO_STATE_BEHAVIOR,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateNoStateBehavior", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(finalState, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{finalState}));
			}
			return false;
		}
		return true;
	}

} // FinalStateOperations