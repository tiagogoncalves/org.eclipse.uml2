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
 * $Id: State.java,v 1.2 2005/11/17 21:23:33 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A state models a situation during which some (usually implicit) invariant condition holds. The invariant may represent a static situation such as an object waiting for some external event to occur. However, it can also model dynamic conditions such as the process of performing some behavior (i.e., the model element under consideration enters the state when the behavior commences and leaves it as soon as the behavior is completed). The following kinds of states are distinguished:
 * 
 * o Simple state,
 * 
 * o composite state, and
 * 
 * o submachine state.
 * 
 * A composite state is either a simple composite state (with just one region) or an orthogonal state (with more than one region).
 * 
 * 
 * 
 * Simple state
 * 
 * A simple state is a state that does not have substates, i.e. it has no regions and it has no submachine state machine.
 * 
 * 
 * 
 * Composite state
 * 
 * A composite state either contains one region or is decomposed into two or more orthogonal regions. Each region has a set of mutually exclusive disjoint subvertices and a set of transitions. A given state may only be decomposed in one of these two ways. 
 * 
 * Any state enclosed within a region of a composite state is called a substate of that composite state. It is called a direct substate when it is not contained by any other state; otherwise it is referred to as a indirect substate. 
 * 
 * Each region of a composite state may have an initial pseudostate and a final state. A transition to the enclosing state represents a transition to the initial pseudostate in each region. A newly-created object takes it's topmost default transitions, originating from the topmost initial pseudostates of each region.
 * 
 * 
 * 
 * A transition to a final state represents the completion of behavior in the enclosing region. Completion of behavior in all orthogonal regions represents completion of behavior by the enclosing state and triggers a completion event on the enclosing state. Completion of the topmost regions of an object corresponds to its termination.
 * 
 * 
 * 
 * An entry pseudostate is used to join an external transition terminating on that entry point to an internal transition emanating from that entry point. An exit pseudostate is used to join an internal transition terminating on that exit point to an external transition emanating from that exit point. The main purpose of such entry and exit points is to execute the state entry and exit actions respectively in between the actions that are associated with the joined transitions.
 * 
 * 
 * 
 * Semantic variation point (default entry rule)
 * 
 * If a transition terminates on an enclosing state and the enclosed regions do not have an initial pseudostate, the interpretation of this situation is a semantic variation point. In some interpretations, this is considered an ill-formed model. That is, in those cases the initial pseudostate is mandatory. 
 * 
 * An alternative interpretation allows this situation and it means that, when such a transition is taken, the state machine stays in the composite state, without entering any of the regions or their substates.
 * 
 * 
 * 
 * Submachine state
 * 
 * A submachine state specifies the insertion of the specification of a submachine state machine. The state machine that contains the submachine state is called the containing state machine. The same state machine may be a submachine more than once in the context of a single containing state machine.
 * 
 * 
 * 
 * A submachine state is semantically equivalent to a composite state. The regions of the submachine state machine are the regions of the composite state. The entry, exit and behavior actions, and internal transitions, are defined as part of the state. Submachine state is a decomposition mechanism that allows factoring of common behaviors and their reuse.
 * 
 * Transitions in the containing state machine can have entry/exit points of the inserted state machine as targets/sources.
 * 
 * 
 * The states of protocol state machines are exposed to the users of their context classifiers. A protocol state represents an exposed stable situation of its context classifier: when an instance of the classifier is not processing any operation, users of this instance can always know its state configuration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.State#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#isOrthogonal <em>Is Orthogonal</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#isSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#isSubmachineState <em>Is Submachine State</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getSubmachine <em>Submachine</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getConnections <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getConnectionPoints <em>Connection Point</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getRedefinedState <em>Redefined State</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getStateInvariant <em>State Invariant</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getExit <em>Exit</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getDoActivity <em>Do Activity</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getDeferrableTriggers <em>Deferrable Trigger</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.State#getRegions <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getState()
 * @model
 * @generated
 */
public interface State
		extends Namespace, RedefinableElement, Vertex {

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isComposite=true is said to be a composite state. A composite state is a state that contains at least one region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_IsComposite()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Returns the value of the '<em><b>Is Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isOrthogonal=true is said to be an orthogonal composite state. An orthogonal composite state contains two or more regions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Orthogonal</em>' attribute.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_IsOrthogonal()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isOrthogonal();

	/**
	 * Returns the value of the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isSimple=true is said to be a simple state. A simple state does not have any regions and it does not refer to any submachine state machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Simple</em>' attribute.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_IsSimple()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isSimple();

	/**
	 * Returns the value of the '<em><b>Is Submachine State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isSubmachineState=true is said to be a submachine state. Such a state refers to a state machine (submachine).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Submachine State</em>' attribute.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_IsSubmachineState()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isSubmachineState();

	/**
	 * Returns the value of the '<em><b>Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state machine that is to be inserted in place of the (submachine) state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachine</em>' reference.
	 * @see #setSubmachine(StateMachine)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_Submachine()
	 * @model ordered="false"
	 * @generated
	 */
	StateMachine getSubmachine();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getSubmachine <em>Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submachine</em>' reference.
	 * @see #getSubmachine()
	 * @generated
	 */
	void setSubmachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.ConnectionPointReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.ConnectionPointReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit connection points used in conjunction with this (submachine) state, i.e. as targets and sources, respectively, in the region with the submachine state. A connection point reference references the corresponding definition of a connection point pseudostate in the statemachine referenced by the submachinestate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_Connection()
	 * @see org.eclipse.uml2.uml.ConnectionPointReference#getState
	 * @model type="org.eclipse.uml2.uml.ConnectionPointReference" opposite="state" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getConnections();

	/**
	 * Creates a {@link org.eclipse.uml2.uml.ConnectionPointReference} and appends it to the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.ConnectionPointReference}.
	 * @see #getConnections()
	 * @generated
	 */
	ConnectionPointReference createConnection();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.ConnectionPointReference} with the specified '<em><b>Name</b></em>' from the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.ConnectionPointReference} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.ConnectionPointReference} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getConnections()
	 * @generated
	 */
	ConnectionPointReference getConnection(String name);

	/**
	 * Returns the value of the '<em><b>Connection Point</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Pseudostate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Pseudostate#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit pseudostates of a composite state. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite states.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Point</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_ConnectionPoint()
	 * @see org.eclipse.uml2.uml.Pseudostate#getState
	 * @model type="org.eclipse.uml2.uml.Pseudostate" opposite="state" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getConnectionPoints();

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Pseudostate} and appends it to the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Pseudostate}.
	 * @see #getConnectionPoints()
	 * @generated
	 */
	Pseudostate createConnectionPoint();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Pseudostate} with the specified '<em><b>Name</b></em>' from the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Pseudostate} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Pseudostate} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getConnectionPoints()
	 * @generated
	 */
	Pseudostate getConnectionPoint(String name);

	/**
	 * Returns the value of the '<em><b>Redefined State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state of which this state is a redefinition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined State</em>' reference.
	 * @see #setRedefinedState(State)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_RedefinedState()
	 * @model ordered="false"
	 * @generated
	 */
	State getRedefinedState();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getRedefinedState <em>Redefined State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefined State</em>' reference.
	 * @see #getRedefinedState()
	 * @generated
	 */
	void setRedefinedState(State value);

	/**
	 * Returns the value of the '<em><b>State Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies conditions that are always true when this state is the current state. In protocol state machines, state invariants are additional conditions to the preconditions of the outgoing transitions, and to the postcondition of the incoming transitions.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State Invariant</em>' containment reference.
	 * @see #setStateInvariant(Constraint)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_StateInvariant()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	Constraint getStateInvariant();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getStateInvariant <em>State Invariant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Invariant</em>' containment reference.
	 * @see #getStateInvariant()
	 * @generated
	 */
	void setStateInvariant(Constraint value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Constraint} and sets the '<em><b>State Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Constraint} to create.
	 * @return The new {@link org.eclipse.uml2.uml.Constraint}.
	 * @see #getStateInvariant()
	 * @generated
	 */
	Constraint createStateInvariant(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Constraint} and sets the '<em><b>State Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Constraint}.
	 * @see #getStateInvariant()
	 * @generated
	 */
	Constraint createStateInvariant();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed whenever this state is entered regardless of the transition taken to reach the state. If defined, entry actions are always executed to completion prior to any internal behavior or transitions performed within the state.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entry</em>' containment reference.
	 * @see #setEntry(Behavior)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_Entry()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	Behavior getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getEntry <em>Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' containment reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(Behavior value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Behavior} to create.
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getEntry()
	 * @generated
	 */
	Behavior createEntry(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getEntry()
	 * @generated
	 */
	Behavior createEntry();

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed whenever this state is exited regardless of which transition was taken out of the state. If defined, exit actions are always executed to completion only after all internal activities and transition actions have completed execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exit</em>' containment reference.
	 * @see #setExit(Behavior)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_Exit()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	Behavior getExit();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getExit <em>Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' containment reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(Behavior value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Behavior} to create.
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getExit()
	 * @generated
	 */
	Behavior createExit(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getExit()
	 * @generated
	 */
	Behavior createExit();

	/**
	 * Returns the value of the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed while being in the state. The execution starts when this state is entered, and stops either by itself, or when the state is exited, whichever comes first.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Do Activity</em>' containment reference.
	 * @see #setDoActivity(Behavior)
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_DoActivity()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	Behavior getDoActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.State#getDoActivity <em>Do Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do Activity</em>' containment reference.
	 * @see #getDoActivity()
	 * @generated
	 */
	void setDoActivity(Behavior value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Behavior} to create.
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getDoActivity()
	 * @generated
	 */
	Behavior createDoActivity(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Behavior} and sets the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Behavior}.
	 * @see #getDoActivity()
	 * @generated
	 */
	Behavior createDoActivity();

	/**
	 * Returns the value of the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Trigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of triggers that are candidates to be retained by the state machine if they trigger no transitions out of the state (not consumed). A deferred trigger is retained until the state machine reaches a state configuration where it is no longer deferred.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deferrable Trigger</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_DeferrableTrigger()
	 * @model type="org.eclipse.uml2.uml.Trigger" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getDeferrableTriggers();

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Trigger} and appends it to the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Trigger}.
	 * @see #getDeferrableTriggers()
	 * @generated
	 */
	Trigger createDeferrableTrigger();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Trigger} with the specified '<em><b>Name</b></em>' from the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Trigger} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Trigger} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDeferrableTriggers()
	 * @generated
	 */
	Trigger getDeferrableTrigger(String name);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Region#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regions owned directly by the state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getState_Region()
	 * @see org.eclipse.uml2.uml.Region#getState
	 * @model type="org.eclipse.uml2.uml.Region" opposite="state" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getRegions();

	/**
	 * Creates a {@link org.eclipse.uml2.uml.Region} and appends it to the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Region}.
	 * @see #getRegions()
	 * @generated
	 */
	Region createRegion();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Region} with the specified '<em><b>Name</b></em>' from the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Region} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Region} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRegions()
	 * @generated
	 */
	Region getRegion(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There have to be at least two regions in an orthogonal composite state.
	 * (self.isOrthogonal) implies
	 * (self.region->size >= 2)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateRegions(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only submachine states can have connection point references.
	 * isSubmachineState implies connection->notEmpty ( )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSubmachineStates(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connection point references used as destinations/sources of transitions associated with a submachine state must be defined as entry/exit points in the submachine state machine.
	 * true
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateDestinationsOrSourcesOfTransitions(
			DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state is not allowed to have both a submachine and regions.
	 * isComposite implies not isSubmachineState
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSubmachineOrRegions(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only composite states can have entry or exit pseudostates defined.
	 * connectionPoint->notEmpty() implies isComoposite
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateCompositeStates(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only entry or exit pseudostates can serve as connection points.
	 * connectionPoint->forAll(cp|cp.kind = #entry or cp.kind = #exit)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateEntryOrExit(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The redefinition context of a state is the nearest containing statemachine.
	 * result = let sm = containingStateMachine() in
	 * if sm.context->isEmpty() or sm.general->notEmpty() then
	 * sm
	 * else
	 * sm.context
	 * endif
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='spec'"
	 * @generated
	 */
	Classifier redefinitionContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isRedefinitionContextValid() specifies whether the redefinition contexts of a state are properly related to the redefinition contexts of the specified state to allow this element to redefine the other. The containing region of a redefining state must redefine the containing region of the redefined state.
	 * result = true
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false" redefinedRequired="true" redefinedOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='spec'"
	 * @generated
	 */
	boolean isRedefinitionContextValid(State redefined);

} // State