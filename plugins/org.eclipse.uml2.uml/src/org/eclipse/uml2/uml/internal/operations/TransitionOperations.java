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
 * $Id: TransitionOperations.java,v 1.1 2005/11/14 22:25:55 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Transition</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateForkSegmentGuards(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Fork Segment Guards</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateJoinSegmentGuards(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Join Segment Guards</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateForkSegmentState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Fork Segment State</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateJoinSegmentState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Join Segment State</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateOutgoingPseudostates(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Outgoing Pseudostates</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateInitialTransition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Initial Transition</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#validateSignaturesCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Signatures Compatible</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#redefinitionContext() <em>Redefinition Context</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#containingStateMachine() <em>Containing State Machine</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Transition#isConsistentWith(org.eclipse.uml2.uml.RedefinableElement) <em>Is Consistent With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public final class TransitionOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransitionOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A fork segment must not have guards or triggers.
	 * (source.oclIsKindOf(Pseudostate) and source.kind = #fork) implies (guard->isEmpty() and trigger->isEmpty())
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateForkSegmentGuards(Transition transition,
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
						UMLValidator.TRANSITION__FORK_SEGMENT_GUARDS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateForkSegmentGuards", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A join segment must not have guards or triggers.
	 * (target.oclIsKindOf(Pseudostate) and target.kind = #join) implies (guard->isEmpty() and trigger->isEmpty())
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateJoinSegmentGuards(Transition transition,
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
						UMLValidator.TRANSITION__JOIN_SEGMENT_GUARDS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateJoinSegmentGuards", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A fork segment must always target a state.
	 * (source.oclIsKindOf(Pseudostate) and source.kind = #fork) implies (target.oclIsKindOf(State))
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateForkSegmentState(Transition transition,
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
						UMLValidator.TRANSITION__FORK_SEGMENT_STATE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateForkSegmentState", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A join segment must always originate from a state.
	 * (target.oclIsKindOf(Pseudostate) and target.kind = #join) implies (source.oclIsKindOf(State))
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateJoinSegmentState(Transition transition,
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
						UMLValidator.TRANSITION__JOIN_SEGMENT_STATE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateJoinSegmentState", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transitions outgoing pseudostates may not have a trigger.
	 * source.oclIsKindOf(Pseudostate) and
	 * ((source.kind <> #junction) and (source.kind <> #join) and (source.kind <> #initial)) implies trigger->isEmpty()
	 * 
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateOutgoingPseudostates(Transition transition,
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
						UMLValidator.TRANSITION__OUTGOING_PSEUDOSTATES,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateOutgoingPseudostates", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An initial transition at the topmost level (region of a statemachine) either has no trigger or it has a trigger with the stereotype ?create?.
	 * self.source.oclIsKindOf(Pseudostate) implies
	 * (self.source.oclAsType(Pseudostate).kind = #initial) implies
	 * (self.source.container = self.stateMachine.top) implies
	 * ((self.trigger->isEmpty) or
	 * (self.trigger.stereotype.name = 'create'))
	 * 
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateInitialTransition(Transition transition,
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
						UMLValidator.TRANSITION__INITIAL_TRANSITION,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateInitialTransition", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of more than one trigger, the signatures of these must be compatible in case the parameters of the signal are assigned to local variables/attributes.
	 * 
	 * 
	 * true
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateSignaturesCompatible(Transition transition,
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
						UMLValidator.TRANSITION__SIGNATURES_COMPATIBLE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateSignaturesCompatible", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(transition, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transition}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The redefinition context of a transition is the nearest containing statemachine.
	 * result = let sm = containingStateMachine() in
	 * if sm.context->isEmpty() or sm.general->notEmpty() then
	 * sm
	 * else
	 * sm.context
	 * endif
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static Classifier redefinitionContext(Transition transition) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query containingStateMachine() returns the state machine that contains the transition either directly or transitively.
	 * result = container.containingStateMachine()
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static StateMachine containingStateMachine(Transition transition) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies that a redefining transition is consistent with a redefined transition provided that the redefining transition has the following relation to the redefined transition: A redefining transition redefines all properties of the corresponding redefined transition, except the source state and the trigger.
	 * result = (redefinee.oclIsKindOf(Transition) and
	 * 
	 *   let trans: Transition = redefinee.oclAsType(Transition) in
	 * 
	 *     (source() = trans.source() and trigger() = tran.trigger())
	 * redefinee.isRedefinitionContextValid(self)
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean isConsistentWith(Transition transition,
			RedefinableElement redefinee) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} // TransitionOperations