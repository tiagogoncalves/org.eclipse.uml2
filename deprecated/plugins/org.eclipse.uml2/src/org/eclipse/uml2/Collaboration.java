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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.Collaboration#getCollaborationRoles <em>Collaboration Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.UML2Package#getCollaboration()
 * @model 
 * @generated
 */
public interface Collaboration extends BehavioredClassifier, StructuredClassifier{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2003, 2004 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Collaboration Role</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.ConnectableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaboration Role</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaboration Role</em>' reference list.
	 * @see org.eclipse.uml2.UML2Package#getCollaboration_CollaborationRole()
	 * @model type="org.eclipse.uml2.ConnectableElement"
	 * @generated
	 */
	EList getCollaborationRoles();

    /**
     * Retrieves the {@link org.eclipse.uml2.ConnectableElement} with the specified name from the '<em><b>Collaboration Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param unqualifiedName The unqualified name of the {@link org.eclipse.uml2.ConnectableElement} to retrieve.
	 * @return The {@link org.eclipse.uml2.ConnectableElement} with the specified name, or <code>null</code>.
	 * @see #getCollaborationRoles()
	 * @generated
     */
    ConnectableElement getCollaborationRole(String unqualifiedName);
      
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
	EList getRoles();

} // Collaboration
