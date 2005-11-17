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
 * $Id: Operation.java,v 1.1 2005/11/14 22:25:56 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An operation is owned by a class and may be invoked in the context of objects that are instances of that class. It is a typed element and a multiplicity element.
 * An expression contains language-specific text strings used to describe a value or values, and an optional specification of the languages.
 * 
 * One predefined language for specifying expressions is OCL. Natural language or programming languages may also be used.
 * 
 * 
 * An operation is a behavioral feature of a classifier that specifies the name, type, parameters, and constraints for invoking an associated behavior.
 * An operation may invoke both the execution of method behaviors as well as other behavioral responses.
 * Operation specializes TemplateableElement in order to support specification of template operations and bound operations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Operation#isQuery <em>Is Query</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#isOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getClass_ <em>Class </em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getPreconditions <em>Precondition</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getPostconditions <em>Postcondition</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getRedefinedOperations <em>Redefined Operation</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getBodyCondition <em>Body Condition</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Operation#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation
		extends BehavioralFeature, ParameterableElement, TemplateableElement {

	/**
	 * Returns the value of the '<em><b>Is Query</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Query</em>' attribute.
	 * @see #setIsQuery(boolean)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_IsQuery()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#isQuery <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Query</em>' attribute.
	 * @see #isQuery()
	 * @generated
	 */
	void setIsQuery(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefines the corresponding property from Basic to derive this information from the return result for this Operation.
	 * Specifies whether the return parameter is ordered or not, if present.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_IsOrdered()
	 * @model default="false" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#isOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefines the corresponding property from Basic to derive this information from the return result for this Operation.
	 * Specifies whether the return parameter is unique or not, if present.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_IsUnique()
	 * @model default="true" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#isUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefines the corresponding property from Basic to derive this information from the return result for this Operation.
	 * Specifies the lower multiplicity of the return parameter, if present.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Lower()
	 * @model default="1" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefines the corresponding property from Basic to derive this information from the return result for this Operation.
	 * Specifies the upper multiplicity of the return parameter, if present.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Upper()
	 * @model default="1" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * Returns the value of the '<em><b>Class </b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Class#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class that owns the operation.
	 * The class that owns this operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class </em>' container reference.
	 * @see #setClass_(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Class_()
	 * @see org.eclipse.uml2.uml.Class#getOwnedOperations
	 * @model opposite="ownedOperation" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getClass_ <em>Class </em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class </em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass_(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints on the state of the system when the Operation is invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Precondition</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Precondition()
	 * @model type="org.eclipse.uml2.uml.Constraint" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getPreconditions();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Constraint} with the specified '<em><b>Name</b></em>' from the '<em><b>Precondition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Constraint} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Constraint} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getPreconditions()
	 * @generated
	 */
	Constraint getPrecondition(String name);

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints specifying the state of the system when the Operation is completed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postcondition</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Postcondition()
	 * @model type="org.eclipse.uml2.uml.Constraint" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getPostconditions();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Constraint} with the specified '<em><b>Name</b></em>' from the '<em><b>Postcondition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Constraint} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Constraint} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getPostconditions()
	 * @generated
	 */
	Constraint getPostcondition(String name);

	/**
	 * Returns the value of the '<em><b>Redefined Operation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Operations that are redefined by this Operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined Operation</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_RedefinedOperation()
	 * @model type="org.eclipse.uml2.uml.Operation" ordered="false"
	 * @generated
	 */
	List getRedefinedOperations();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.Operation} with the specified '<em><b>Name</b></em>' from the '<em><b>Redefined Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Operation} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.Operation} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRedefinedOperations()
	 * @generated
	 */
	Operation getRedefinedOperation(String name);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.DataType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DataType that owns this Operation.
	 * The DataType that owns this Property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Datatype</em>' container reference.
	 * @see #setDatatype(DataType)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Datatype()
	 * @see org.eclipse.uml2.uml.DataType#getOwnedOperations
	 * @model opposite="ownedOperation" ordered="false"
	 * @generated
	 */
	DataType getDatatype();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getDatatype <em>Datatype</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype</em>' container reference.
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(DataType value);

	/**
	 * Returns the value of the '<em><b>Body Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional Constraint on the result values of an invocation of this Operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body Condition</em>' reference.
	 * @see #setBodyCondition(Constraint)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_BodyCondition()
	 * @model resolveProxies="false" ordered="false"
	 * @generated
	 */
	Constraint getBodyCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getBodyCondition <em>Body Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Condition</em>' reference.
	 * @see #getBodyCondition()
	 * @generated
	 */
	void setBodyCondition(Constraint value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefines the corresponding property from Basic to derive this information from the return result for this Operation.
	 * Specifies the return result of the operation, if present.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Type()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Interface#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Interface that owns this Operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface</em>' container reference.
	 * @see #setInterface(Interface)
	 * @see org.eclipse.uml2.uml.UMLPackage#getOperation_Interface()
	 * @see org.eclipse.uml2.uml.Interface#getOwnedOperations
	 * @model opposite="ownedOperation" ordered="false"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Operation#getInterface <em>Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' container reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An operation can have at most one return parameter; i.e., an owned parameter with the direction set to 'return'
	 * self.ownedParameter->select(par | par.direction = #return)->size() <= 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateAtMostOneReturn(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A bodyCondition can only be specified for a query operation.
	 * bodyCondition->notEmpty() implies isQuery
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateOnlyBodyForQuery(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this operation has a return parameter, lower equals the value of lower for that parameter. Otherwise lower is not defined.
	 * If this operation has a return parameter, lower equals the value of lower for that parameter. Otherwise lower is not defined.
	 * 
	 * 
	 * result = if returnResult()->notEmpty() then returnResult()->any().lower else Set{} endif
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='spec'"
	 * @generated
	 */
	int lowerBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this operation has a return parameter, upper equals the value of upper for that parameter. Otherwise upper is not defined.
	 * If this operation has a return parameter, upper equals the value of upper for that parameter. Otherwise upper is not defined.
	 * 
	 * 
	 * result = if returnResult()->notEmpty() then returnResult()->any().upper else Set{} endif
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='spec'"
	 * @generated
	 */
	int upperBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query returnResult() returns the set containing the return parameter of the Operation if one exists, otherwise, it returns an empty set
	 * result = ownedParameter->select (par | par.direction = #return)
	 * <!-- end-model-doc -->
	 * @model type="org.eclipse.uml2.uml.Parameter" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='spec'"
	 * @generated
	 */
	List returnResult();

} // Operation