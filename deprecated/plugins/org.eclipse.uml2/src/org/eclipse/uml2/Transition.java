/*
 * Copyright (c) 2003, 2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package org.eclipse.uml2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.Transition#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getRedefinedTransition <em>Redefined Transition</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getTriggers <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.uml2.Transition#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.UML2Package#getTransition()
 * @model 
 * @generated
 */
public interface Transition extends RedefinableElement{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2003, 2004 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.uml2.TransitionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.uml2.TransitionKind
	 * @see #setKind(TransitionKind)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Kind()
	 * @model 
	 * @generated
	 */
	TransitionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.uml2.TransitionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TransitionKind value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.Region#getTransitions <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Region)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Container()
	 * @see org.eclipse.uml2.Region#getTransitions
	 * @model opposite="transition" required="true"
	 * @generated
	 */
	Region getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Region value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.Vertex#getOutgoings <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Vertex)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Source()
	 * @see org.eclipse.uml2.Vertex#getOutgoings
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	Vertex getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Vertex value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.Vertex#getIncomings <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Vertex)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Target()
	 * @see org.eclipse.uml2.Vertex#getIncomings
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	Vertex getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Vertex value);

	/**
	 * Returns the value of the '<em><b>Redefined Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Transition</em>' reference.
	 * @see #setRedefinedTransition(Transition)
	 * @see org.eclipse.uml2.UML2Package#getTransition_RedefinedTransition()
	 * @model 
	 * @generated
	 */
	Transition getRedefinedTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getRedefinedTransition <em>Redefined Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefined Transition</em>' reference.
	 * @see #getRedefinedTransition()
	 * @generated
	 */
	void setRedefinedTransition(Transition value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.Trigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' reference list.
	 * @see org.eclipse.uml2.UML2Package#getTransition_Trigger()
	 * @model type="org.eclipse.uml2.Trigger"
	 * @generated
	 */
	EList getTriggers();

    /**
     * Retrieves the {@link org.eclipse.uml2.Trigger} with the specified name from the '<em><b>Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param unqualifiedName The unqualified name of the {@link org.eclipse.uml2.Trigger} to retrieve.
	 * @return The {@link org.eclipse.uml2.Trigger} with the specified name, or <code>null</code>.
	 * @see #getTriggers()
	 * @generated
     */
    Trigger getTrigger(String unqualifiedName);
      
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Constraint)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Guard()
	 * @model containment="true" volatile="true"
	 * @generated
	 */
	Constraint getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Constraint value);

    /**
     * Creates a {@link org.eclipse.uml2.Constraint} and sets the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.Constraint} to create.
	 * @return The new {@link org.eclipse.uml2.Constraint}.
	 * @see #getGuard()
	 * @generated
     */
    Constraint createGuard(EClass eClass);
     
	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(Activity)
	 * @see org.eclipse.uml2.UML2Package#getTransition_Effect()
	 * @model containment="true"
	 * @generated
	 */
	Activity getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.Transition#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Activity value);

    /**
     * Creates a {@link org.eclipse.uml2.Activity} and sets the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.Activity} to create.
	 * @return The new {@link org.eclipse.uml2.Activity}.
	 * @see #getEffect()
	 * @generated
     */
    Activity createEffect(EClass eClass);
     
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
	EList getRedefinitionContexts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
	Element getOwner();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
	EList getRedefinedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
	EList getOwnedElements();

} // Transition
