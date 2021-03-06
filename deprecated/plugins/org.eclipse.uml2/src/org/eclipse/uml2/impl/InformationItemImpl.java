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
 * $Id: InformationItemImpl.java,v 1.27 2006/04/10 20:40:18 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.CollaborationOccurrence;
import org.eclipse.uml2.InformationItem;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.InformationItemImpl#getRepresenteds <em>Represented</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformationItemImpl extends ClassifierImpl implements InformationItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRepresenteds() <em>Represented</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresenteds()
	 * @generated
	 * @ordered
	 */
	protected EList representeds = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.INFORMATION_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRepresenteds() {
		if (representeds == null) {
			representeds = new EObjectResolvingEList(Classifier.class, this, UML2Package.INFORMATION_ITEM__REPRESENTED);
		}
		return representeds;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    public Classifier getRepresented(String name) {
		return getRepresented(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getRepresented(String name, boolean ignoreCase, EClass eClass) {
		representedLoop: for (Iterator i = getRepresenteds().iterator(); i.hasNext(); ) {
			Classifier represented = (Classifier) i.next();
			if (eClass != null && !eClass.isInstance(represented))
				continue representedLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(represented.getName()) : name.equals(represented.getName())))
				continue representedLoop;
			return represented;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.INFORMATION_ITEM__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.INFORMATION_ITEM__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.INFORMATION_ITEM__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.INFORMATION_ITEM__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.INFORMATION_ITEM__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.INFORMATION_ITEM__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.INFORMATION_ITEM__NAME:
				return getName();
			case UML2Package.INFORMATION_ITEM__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.INFORMATION_ITEM__VISIBILITY:
				return getVisibility();
			case UML2Package.INFORMATION_ITEM__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.INFORMATION_ITEM__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.INFORMATION_ITEM__MEMBER:
				return getMembers();
			case UML2Package.INFORMATION_ITEM__OWNED_RULE:
				return getOwnedRules();
			case UML2Package.INFORMATION_ITEM__IMPORTED_MEMBER:
				return getImportedMembers();
			case UML2Package.INFORMATION_ITEM__ELEMENT_IMPORT:
				return getElementImports();
			case UML2Package.INFORMATION_ITEM__PACKAGE_IMPORT:
				return getPackageImports();
			case UML2Package.INFORMATION_ITEM__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.INFORMATION_ITEM__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.INFORMATION_ITEM__PACKAGEABLE_ELEMENT_VISIBILITY:
				return getPackageableElement_visibility();
			case UML2Package.INFORMATION_ITEM__PACKAGE:
				return getPackage();
			case UML2Package.INFORMATION_ITEM__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.INFORMATION_ITEM__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.INFORMATION_ITEM__FEATURE:
				return getFeatures();
			case UML2Package.INFORMATION_ITEM__IS_ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.INFORMATION_ITEM__INHERITED_MEMBER:
				return getInheritedMembers();
			case UML2Package.INFORMATION_ITEM__GENERAL:
				return getGenerals();
			case UML2Package.INFORMATION_ITEM__GENERALIZATION:
				return getGeneralizations();
			case UML2Package.INFORMATION_ITEM__ATTRIBUTE:
				return getAttributes();
			case UML2Package.INFORMATION_ITEM__REDEFINED_CLASSIFIER:
				return getRedefinedClassifiers();
			case UML2Package.INFORMATION_ITEM__SUBSTITUTION:
				return getSubstitutions();
			case UML2Package.INFORMATION_ITEM__POWERTYPE_EXTENT:
				return getPowertypeExtents();
			case UML2Package.INFORMATION_ITEM__OWNED_USE_CASE:
				return getOwnedUseCases();
			case UML2Package.INFORMATION_ITEM__USE_CASE:
				return getUseCases();
			case UML2Package.INFORMATION_ITEM__REPRESENTATION:
				return getRepresentation();
			case UML2Package.INFORMATION_ITEM__OCCURRENCE:
				return getOccurrences();
			case UML2Package.INFORMATION_ITEM__REPRESENTED:
				return getRepresenteds();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UML2Package.INFORMATION_ITEM__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__NAME:
				setName((String)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__ELEMENT_IMPORT:
				getElementImports().clear();
				getElementImports().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__PACKAGE_IMPORT:
				getPackageImports().clear();
				getPackageImports().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility((VisibilityKind)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__IS_LEAF:
				setIsLeaf(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.INFORMATION_ITEM__IS_ABSTRACT:
				setIsAbstract(((Boolean)newValue).booleanValue());
				return;
			case UML2Package.INFORMATION_ITEM__GENERALIZATION:
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__REDEFINED_CLASSIFIER:
				getRedefinedClassifiers().clear();
				getRedefinedClassifiers().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__SUBSTITUTION:
				getSubstitutions().clear();
				getSubstitutions().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__POWERTYPE_EXTENT:
				getPowertypeExtents().clear();
				getPowertypeExtents().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_USE_CASE:
				getOwnedUseCases().clear();
				getOwnedUseCases().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__USE_CASE:
				getUseCases().clear();
				getUseCases().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__REPRESENTATION:
				setRepresentation((CollaborationOccurrence)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__OCCURRENCE:
				getOccurrences().clear();
				getOccurrences().addAll((Collection)newValue);
				return;
			case UML2Package.INFORMATION_ITEM__REPRESENTED:
				getRepresenteds().clear();
				getRepresenteds().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UML2Package.INFORMATION_ITEM__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.INFORMATION_ITEM__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.INFORMATION_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.INFORMATION_ITEM__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.INFORMATION_ITEM__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.INFORMATION_ITEM__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case UML2Package.INFORMATION_ITEM__ELEMENT_IMPORT:
				getElementImports().clear();
				return;
			case UML2Package.INFORMATION_ITEM__PACKAGE_IMPORT:
				getPackageImports().clear();
				return;
			case UML2Package.INFORMATION_ITEM__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.INFORMATION_ITEM__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.INFORMATION_ITEM__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility(PACKAGEABLE_ELEMENT_VISIBILITY_EDEFAULT);
				return;
			case UML2Package.INFORMATION_ITEM__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UML2Package.INFORMATION_ITEM__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case UML2Package.INFORMATION_ITEM__GENERALIZATION:
				getGeneralizations().clear();
				return;
			case UML2Package.INFORMATION_ITEM__REDEFINED_CLASSIFIER:
				getRedefinedClassifiers().clear();
				return;
			case UML2Package.INFORMATION_ITEM__SUBSTITUTION:
				getSubstitutions().clear();
				return;
			case UML2Package.INFORMATION_ITEM__POWERTYPE_EXTENT:
				getPowertypeExtents().clear();
				return;
			case UML2Package.INFORMATION_ITEM__OWNED_USE_CASE:
				getOwnedUseCases().clear();
				return;
			case UML2Package.INFORMATION_ITEM__USE_CASE:
				getUseCases().clear();
				return;
			case UML2Package.INFORMATION_ITEM__REPRESENTATION:
				setRepresentation((CollaborationOccurrence)null);
				return;
			case UML2Package.INFORMATION_ITEM__OCCURRENCE:
				getOccurrences().clear();
				return;
			case UML2Package.INFORMATION_ITEM__REPRESENTED:
				getRepresenteds().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UML2Package.INFORMATION_ITEM__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.INFORMATION_ITEM__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.INFORMATION_ITEM__OWNER:
				return isSetOwner();
			case UML2Package.INFORMATION_ITEM__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.INFORMATION_ITEM__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.INFORMATION_ITEM__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.INFORMATION_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.INFORMATION_ITEM__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.INFORMATION_ITEM__VISIBILITY:
				return isSetVisibility();
			case UML2Package.INFORMATION_ITEM__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.INFORMATION_ITEM__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.INFORMATION_ITEM__MEMBER:
				return isSetMembers();
			case UML2Package.INFORMATION_ITEM__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case UML2Package.INFORMATION_ITEM__IMPORTED_MEMBER:
				return !getImportedMembers().isEmpty();
			case UML2Package.INFORMATION_ITEM__ELEMENT_IMPORT:
				return elementImports != null && !elementImports.isEmpty();
			case UML2Package.INFORMATION_ITEM__PACKAGE_IMPORT:
				return packageImports != null && !packageImports.isEmpty();
			case UML2Package.INFORMATION_ITEM__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.INFORMATION_ITEM__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.INFORMATION_ITEM__PACKAGEABLE_ELEMENT_VISIBILITY:
				return isSetPackageableElement_visibility();
			case UML2Package.INFORMATION_ITEM__PACKAGE:
				return getPackage() != null;
			case UML2Package.INFORMATION_ITEM__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.INFORMATION_ITEM__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.INFORMATION_ITEM__FEATURE:
				return isSetFeatures();
			case UML2Package.INFORMATION_ITEM__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case UML2Package.INFORMATION_ITEM__INHERITED_MEMBER:
				return !getInheritedMembers().isEmpty();
			case UML2Package.INFORMATION_ITEM__GENERAL:
				return !getGenerals().isEmpty();
			case UML2Package.INFORMATION_ITEM__GENERALIZATION:
				return generalizations != null && !generalizations.isEmpty();
			case UML2Package.INFORMATION_ITEM__ATTRIBUTE:
				return isSetAttributes();
			case UML2Package.INFORMATION_ITEM__REDEFINED_CLASSIFIER:
				return redefinedClassifiers != null && !redefinedClassifiers.isEmpty();
			case UML2Package.INFORMATION_ITEM__SUBSTITUTION:
				return substitutions != null && !substitutions.isEmpty();
			case UML2Package.INFORMATION_ITEM__POWERTYPE_EXTENT:
				return powertypeExtents != null && !powertypeExtents.isEmpty();
			case UML2Package.INFORMATION_ITEM__OWNED_USE_CASE:
				return ownedUseCases != null && !ownedUseCases.isEmpty();
			case UML2Package.INFORMATION_ITEM__USE_CASE:
				return useCases != null && !useCases.isEmpty();
			case UML2Package.INFORMATION_ITEM__REPRESENTATION:
				return representation != null;
			case UML2Package.INFORMATION_ITEM__OCCURRENCE:
				return occurrences != null && !occurrences.isEmpty();
			case UML2Package.INFORMATION_ITEM__REPRESENTED:
				return representeds != null && !representeds.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}


} //InformationItemImpl
