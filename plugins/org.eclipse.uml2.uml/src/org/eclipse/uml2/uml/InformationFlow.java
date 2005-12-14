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
 * $Id: InformationFlow.java,v 1.2 2005/12/14 22:34:16 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An information flow specifies that one or more information items circulates from its sources to its targets. Information flows require some kind of information channel for transmitting information items from the source to the destination. An information channel is represented in various ways depending on the nature of its sources and targets. It may be represented by connectors, links, associations, or even dependencies. For example, if the source and destination are parts in some composite structure such as a collaboration, then the information channel is likely to be represented by a connector between them. Or, if the source and target are objects (which are a kind of InstanceSpecification), they may be represented by a link that joins the two, and so on.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getRealizations <em>Realization</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getConveyeds <em>Conveyed</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getInformationSources <em>Information Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getInformationTargets <em>Information Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getRealizingActivityEdges <em>Realizing Activity Edge</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getRealizingConnectors <em>Realizing Connector</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#getRealizingMessages <em>Realizing Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow()
 * @model
 * @generated
 */
public interface InformationFlow
		extends PackageableElement, DirectedRelationship {

	/**
	 * Returns the value of the '<em><b>Realization</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Relationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines which Relationship will realize the specified flow
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realization</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_Realization()
	 * @model type="org.eclipse.uml2.uml.Relationship" ordered="false"
	 * @generated
	 */
	EList getRealizations();

	/**
	 * Returns the value of the '<em><b>Conveyed</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Classifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the information items that may circulate on this information flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conveyed</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_Conveyed()
	 * @model type="org.eclipse.uml2.uml.Classifier" required="true" ordered="false"
	 * @generated
	 */
	EList getConveyeds();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Classifier} with the specified '<em><b>Name</b></em>' from the '<em><b>Conveyed</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Classifier} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Classifier} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getConveyeds()
	 * @generated
	 */
	Classifier getConveyed(String name);

	/**
	 * Returns the value of the '<em><b>Information Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines from which source the conveyed InformationItems are initiated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Information Source</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_InformationSource()
	 * @model type="org.eclipse.uml2.uml.NamedElement" required="true" ordered="false"
	 * @generated
	 */
	EList getInformationSources();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Information Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getInformationSources()
	 * @generated
	 */
	NamedElement getInformationSource(String name);

	/**
	 * Returns the value of the '<em><b>Information Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines to which target the conveyed InformationItems are directed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Information Target</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_InformationTarget()
	 * @model type="org.eclipse.uml2.uml.NamedElement" required="true" ordered="false"
	 * @generated
	 */
	EList getInformationTargets();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Information Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getInformationTargets()
	 * @generated
	 */
	NamedElement getInformationTarget(String name);

	/**
	 * Returns the value of the '<em><b>Realizing Activity Edge</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.ActivityEdge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines which ActivityEdges will realize the specified flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realizing Activity Edge</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_RealizingActivityEdge()
	 * @model type="org.eclipse.uml2.uml.ActivityEdge" ordered="false"
	 * @generated
	 */
	EList getRealizingActivityEdges();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.ActivityEdge} with the specified '<em><b>Name</b></em>' from the '<em><b>Realizing Activity Edge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.ActivityEdge} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.ActivityEdge} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRealizingActivityEdges()
	 * @generated
	 */
	ActivityEdge getRealizingActivityEdge(String name);

	/**
	 * Returns the value of the '<em><b>Realizing Connector</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Connector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines which Connectors will realize the specified flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realizing Connector</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_RealizingConnector()
	 * @model type="org.eclipse.uml2.uml.Connector" ordered="false"
	 * @generated
	 */
	EList getRealizingConnectors();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Connector} with the specified '<em><b>Name</b></em>' from the '<em><b>Realizing Connector</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Connector} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Connector} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRealizingConnectors()
	 * @generated
	 */
	Connector getRealizingConnector(String name);

	/**
	 * Returns the value of the '<em><b>Realizing Message</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines which Messages will realize the specified flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realizing Message</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getInformationFlow_RealizingMessage()
	 * @model type="org.eclipse.uml2.uml.Message" ordered="false"
	 * @generated
	 */
	EList getRealizingMessages();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Message} with the specified '<em><b>Name</b></em>' from the '<em><b>Realizing Message</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Message} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Message} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRealizingMessages()
	 * @generated
	 */
	Message getRealizingMessage(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow can only be one of the following kind: Actor, Node, UseCase, Artifact, Class, Component, Port, Property, Interface, Package, ActivityNode, ActivityPartition and InstanceSpecification except when its classifier is a relationship (i.e. it represents a link).
	 * (self.source->forAll(p | p->oclIsKindOf(Actor) or oclIsKindOf(Node) or
	 * 
	 *   oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or oclIsKindOf(Class) or
	 * 
	 *   oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or
	 * 
	 *   oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or
	 * 
	 *   oclIsKindOf(ActivityPartition) or oclIsKindOf(InstanceSpecification))) and
	 * 
	 *     (self.target->forAll(p | p->oclIsKindOf(Actor) or oclIsKindOf(Node) or
	 * 
	 *       oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or oclIsKindOf(Class) or
	 * 
	 *       oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or
	 * 
	 *       oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or
	 * 
	 *       oclIsKindOf(ActivityPartition) or oclIsKindOf(InstanceSpecification)))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSourcesAndTargetsKind(DiagnosticChain diagnostics,
			Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow must conform with the sources and targets or conversely the targets and sources of the realization relationships.
	 * true
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateMustConform(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An information flow can only convey classifiers that are allowed to represent an information item.
	 * 
	 * 
	 * self.conveyed.represented->forAll(p | p->oclIsKindOf(Class) or oclIsKindOf(Interface)
	 * 
	 *   or oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateConveyClassifiers(DiagnosticChain diagnostics, Map context);

} // InformationFlow
