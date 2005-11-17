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
 * $Id: BehavioredClassifierImpl.java,v 1.1 2005/11/14 22:26:05 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetEObjectContainmentWithInverseEList;
import org.eclipse.uml2.common.util.SupersetEObjectContainmentEList;
import org.eclipse.uml2.common.util.SupersetEObjectWithInverseResolvingEList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.BehavioredClassifierOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviored Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getOwnedBehaviors <em>Owned Behavior</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getClientDependencies <em>Client Dependency</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getClassifierBehavior <em>Classifier Behavior</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getInterfaceRealizations <em>Interface Realization</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.BehavioredClassifierImpl#getOwnedTriggers <em>Owned Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehavioredClassifierImpl
		extends ClassifierImpl
		implements BehavioredClassifier {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioredClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.eINSTANCE.getBehavioredClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedMembers() {
		List ownedMember = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_MEMBER);
		if (ownedMember == null) {
			eVirtualSet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_MEMBER,
				ownedMember = new DerivedUnionEObjectEList(NamedElement.class,
					this, UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_MEMBER,
					new EStructuralFeature[]{
						UMLPackage.eINSTANCE.getNamespace_OwnedRule(),
						UMLPackage.eINSTANCE.getClassifier_OwnedUseCase(),
						UMLPackage.eINSTANCE
							.getBehavioredClassifier_OwnedBehavior(),
						UMLPackage.eINSTANCE
							.getBehavioredClassifier_OwnedTrigger()}));
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedElements() {
		List ownedElement = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_ELEMENT);
		if (ownedElement == null) {
			eVirtualSet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_ELEMENT,
				ownedElement = new DerivedUnionEObjectEList(Element.class,
					this, UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_ELEMENT,
					new EStructuralFeature[]{
						UMLPackage.eINSTANCE.getElement_OwnedComment(),
						UMLPackage.eINSTANCE.getNamedElement_NameExpression(),
						UMLPackage.eINSTANCE.getNamespace_ElementImport(),
						UMLPackage.eINSTANCE.getNamespace_PackageImport(),
						UMLPackage.eINSTANCE.getNamespace_OwnedMember(),
						UMLPackage.eINSTANCE
							.getTemplateableElement_TemplateBinding(),
						UMLPackage.eINSTANCE
							.getTemplateableElement_OwnedTemplateSignature(),
						UMLPackage.eINSTANCE.getClassifier_Generalization(),
						UMLPackage.eINSTANCE.getClassifier_Substitution(),
						UMLPackage.eINSTANCE.getClassifier_CollaborationUse(),
						UMLPackage.eINSTANCE.getClassifier_OwnedSignature(),
						UMLPackage.eINSTANCE
							.getBehavioredClassifier_InterfaceRealization()}));
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedBehaviors() {
		List ownedBehavior = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR);
		if (ownedBehavior == null) {
			eVirtualSet(
				UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR,
				ownedBehavior = new SupersetEObjectContainmentEList(
					Behavior.class,
					this,
					UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR,
					new int[]{UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR}));
		}
		return ownedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior createOwnedBehavior(EClass eClass) {
		Behavior newOwnedBehavior = (Behavior) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		getOwnedBehaviors().add(newOwnedBehavior);
		return newOwnedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior createOwnedBehavior() {
		Behavior newOwnedBehavior = UMLFactory.eINSTANCE.createBehavior();
		getOwnedBehaviors().add(newOwnedBehavior);
		return newOwnedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getOwnedBehavior(String name) {
		for (Iterator i = getOwnedBehaviors().iterator(); i.hasNext();) {
			Behavior ownedBehavior = (Behavior) i.next();
			if (name.equals(ownedBehavior.getName())) {
				return ownedBehavior;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getClientDependencies() {
		List clientDependency = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY);
		if (clientDependency == null) {
			eVirtualSet(
				UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY,
				clientDependency = new SupersetEObjectWithInverseResolvingEList.ManyInverse(
					Dependency.class,
					this,
					UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY,
					new int[]{UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION,
						UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION},
					UMLPackage.DEPENDENCY__CLIENT));
		}
		return clientDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getClassifierBehavior() {
		Behavior classifierBehavior = (Behavior) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR);
		return classifierBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifierBehavior(Behavior newClassifierBehavior) {
		if (newClassifierBehavior != null
			&& !getOwnedBehaviors().contains(newClassifierBehavior)) {
			getOwnedBehaviors().add(newClassifierBehavior);
		}
		Behavior classifierBehavior = newClassifierBehavior;
		Object oldClassifierBehavior = eVirtualSet(
			UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR,
			classifierBehavior);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR,
				oldClassifierBehavior == EVIRTUAL_NO_VALUE
					? null
					: oldClassifierBehavior, classifierBehavior));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getInterfaceRealizations() {
		List interfaceRealization = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION);
		if (interfaceRealization == null) {
			eVirtualSet(
				UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION,
				interfaceRealization = new SubsetEObjectContainmentWithInverseEList(
					InterfaceRealization.class,
					this,
					UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION,
					new int[]{UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY},
					UMLPackage.INTERFACE_REALIZATION__IMPLEMENTING_CLASSIFIER));
		}
		return interfaceRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRealization createInterfaceRealization() {
		InterfaceRealization newInterfaceRealization = UMLFactory.eINSTANCE
			.createInterfaceRealization();
		getInterfaceRealizations().add(newInterfaceRealization);
		return newInterfaceRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRealization getInterfaceRealization(String name) {
		for (Iterator i = getInterfaceRealizations().iterator(); i.hasNext();) {
			InterfaceRealization interfaceRealization = (InterfaceRealization) i
				.next();
			if (name.equals(interfaceRealization.getName())) {
				return interfaceRealization;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedTriggers() {
		List ownedTrigger = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER);
		if (ownedTrigger == null) {
			eVirtualSet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER,
				ownedTrigger = new EObjectContainmentEList(Trigger.class, this,
					UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER));
		}
		return ownedTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger createOwnedTrigger() {
		Trigger newOwnedTrigger = UMLFactory.eINSTANCE.createTrigger();
		getOwnedTriggers().add(newOwnedTrigger);
		return newOwnedTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getOwnedTrigger(String name) {
		for (Iterator i = getOwnedTriggers().iterator(); i.hasNext();) {
			Trigger ownedTrigger = (Trigger) i.next();
			if (name.equals(ownedTrigger.getName())) {
				return ownedTrigger;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassBehavior(DiagnosticChain diagnostics,
			Map context) {
		return BehavioredClassifierOperations.validateClassBehavior(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
					return ((InternalEList) getEAnnotations()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
					return ((InternalEList) getClientDependencies()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
					return ((InternalEList) getElementImports()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
					return ((InternalEList) getPackageImports()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
					return ((InternalEList) getOwnedRules()).basicAdd(otherEnd,
						msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
					TemplateParameter templateParameter = (TemplateParameter) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER);
					if (templateParameter != null)
						msgs = ((InternalEObject) templateParameter)
							.eInverseRemove(
								this,
								UMLPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT,
								TemplateParameter.class, msgs);
					return basicSetTemplateParameter(
						(TemplateParameter) otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(
						otherEnd,
						UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER,
						msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
					return ((InternalEList) getTemplateBindings()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
					TemplateSignature ownedTemplateSignature = (TemplateSignature) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE);
					if (ownedTemplateSignature != null)
						msgs = ((InternalEObject) ownedTemplateSignature)
							.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
									- UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE,
								null, msgs);
					return basicSetOwnedTemplateSignature(
						(TemplateSignature) otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
					return ((InternalEList) getGeneralizations()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
					return ((InternalEList) getPowertypeExtents()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
					return ((InternalEList) getUseCases()).basicAdd(otherEnd,
						msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
					return ((InternalEList) getSubstitutions()).basicAdd(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
					RedefinableTemplateSignature ownedSignature = (RedefinableTemplateSignature) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE);
					if (ownedSignature != null)
						msgs = ((InternalEObject) ownedSignature)
							.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
									- UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE,
								null, msgs);
					return basicSetOwnedSignature(
						(RedefinableTemplateSignature) otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
					return ((InternalEList) getInterfaceRealizations())
						.basicAdd(otherEnd, msgs);
				default :
					return eDynamicInverseAdd(otherEnd, featureID, baseClass,
						msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
					return ((InternalEList) getEAnnotations()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT :
					return ((InternalEList) getOwnedComments()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
					return ((InternalEList) getClientDependencies())
						.basicRemove(otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION :
					return basicSetNameExpression(null, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
					return ((InternalEList) getElementImports()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
					return ((InternalEList) getPackageImports()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
					return ((InternalEList) getOwnedRules()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
					return basicSetTemplateParameter(null, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
					return eBasicSetContainer(
						null,
						UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER,
						msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
					return ((InternalEList) getTemplateBindings()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
					return basicSetOwnedTemplateSignature(null, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
					return ((InternalEList) getGeneralizations()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
					return ((InternalEList) getPowertypeExtents()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE :
					return ((InternalEList) getOwnedUseCases()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
					return ((InternalEList) getUseCases()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
					return ((InternalEList) getSubstitutions()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE :
					return ((InternalEList) getCollaborationUses())
						.basicRemove(otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
					return basicSetOwnedSignature(null, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR :
					return ((InternalEList) getOwnedBehaviors()).basicRemove(
						otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
					return ((InternalEList) getInterfaceRealizations())
						.basicRemove(otherEnd, msgs);
				case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER :
					return ((InternalEList) getOwnedTriggers()).basicRemove(
						otherEnd, msgs);
				default :
					return eDynamicInverseRemove(otherEnd, featureID,
						baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME :
				return getName();
			case UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY :
				return getVisibility();
			case UMLPackage.BEHAVIORED_CLASSIFIER__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
				return getElementImports();
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
				return getPackageImports();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
				return getOwnedRules();
			case UMLPackage.BEHAVIORED_CLASSIFIER__MEMBER :
				return getMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__IMPORTED_MEMBER :
				return getImportedMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_MEMBER :
				return getOwnedMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
				return getOwningTemplateParameter();
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE :
				return getPackage();
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
				return getTemplateBindings();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
				return getOwnedTemplateSignature();
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_ABSTRACT :
				return isAbstract()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
				return getGeneralizations();
			case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
				return getPowertypeExtents();
			case UMLPackage.BEHAVIORED_CLASSIFIER__FEATURE :
				return getFeatures();
			case UMLPackage.BEHAVIORED_CLASSIFIER__INHERITED_MEMBER :
				return getInheritedMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_CLASSIFIER :
				return getRedefinedClassifiers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERAL :
				return getGenerals();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE :
				return getOwnedUseCases();
			case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
				return getUseCases();
			case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
				return getSubstitutions();
			case UMLPackage.BEHAVIORED_CLASSIFIER__ATTRIBUTE :
				return getAttributes();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REPRESENTATION :
				return getRepresentation();
			case UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE :
				return getCollaborationUses();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
				return getOwnedSignature();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR :
				return getOwnedBehaviors();
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR :
				return getClassifierBehavior();
			case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
				return getInterfaceRealizations();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER :
				return getOwnedTriggers();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
				getElementImports().clear();
				getElementImports().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
				getPackageImports().clear();
				getPackageImports().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE :
				setPackage((org.eclipse.uml2.uml.Package) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_ABSTRACT :
				setIsAbstract(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
				getPowertypeExtents().clear();
				getPowertypeExtents().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__INHERITED_MEMBER :
				getInheritedMembers().clear();
				getInheritedMembers().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_CLASSIFIER :
				getRedefinedClassifiers().clear();
				getRedefinedClassifiers().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERAL :
				getGenerals().clear();
				getGenerals().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE :
				getOwnedUseCases().clear();
				getOwnedUseCases().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
				getUseCases().clear();
				getUseCases().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
				getSubstitutions().clear();
				getSubstitutions().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REPRESENTATION :
				setRepresentation((CollaborationUse) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE :
				getCollaborationUses().clear();
				getCollaborationUses().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
				setOwnedSignature((RedefinableTemplateSignature) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR :
				getOwnedBehaviors().clear();
				getOwnedBehaviors().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR :
				setClassifierBehavior((Behavior) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
				getInterfaceRealizations().clear();
				getInterfaceRealizations().addAll((Collection) newValue);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER :
				getOwnedTriggers().clear();
				getOwnedTriggers().addAll((Collection) newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME :
				setName(NAME_EDEFAULT);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY :
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
				getElementImports().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
				getPackageImports().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
				getOwnedRules().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE :
				setPackage((org.eclipse.uml2.uml.Package) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_ABSTRACT :
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
				getGeneralizations().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
				getPowertypeExtents().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__INHERITED_MEMBER :
				getInheritedMembers().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_CLASSIFIER :
				getRedefinedClassifiers().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERAL :
				getGenerals().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE :
				getOwnedUseCases().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
				getUseCases().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
				getSubstitutions().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REPRESENTATION :
				setRepresentation((CollaborationUse) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE :
				getCollaborationUses().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
				setOwnedSignature((RedefinableTemplateSignature) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR :
				getOwnedBehaviors().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR :
				setClassifierBehavior((Behavior) null);
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
				getInterfaceRealizations().clear();
				return;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER :
				getOwnedTriggers().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UMLPackage.BEHAVIORED_CLASSIFIER__EANNOTATIONS :
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNER :
				return isSetOwner();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT :
				List ownedComment = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME :
				String name = eVirtualIsSet(UMLPackage.BEHAVIORED_CLASSIFIER__NAME)
					? (String) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__NAME)
					: NAME_EDEFAULT;
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY :
				return eVirtualIsSet(UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY)
					&& eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__VISIBILITY) != VISIBILITY_EDEFAULT;
			case UMLPackage.BEHAVIORED_CLASSIFIER__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY :
				List clientDependency = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__NAME_EXPRESSION) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT :
				List elementImport = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__ELEMENT_IMPORT);
				return elementImport != null && !elementImport.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT :
				List packageImport = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE_IMPORT);
				return packageImport != null && !packageImport.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE :
				List ownedRule = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_RULE);
				return ownedRule != null && !ownedRule.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__MEMBER :
				return isSetMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__IMPORTED_MEMBER :
				return !getImportedMembers().isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_MEMBER :
				return isSetOwnedMembers();
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_PARAMETER) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNING_TEMPLATE_PARAMETER :
				return getOwningTemplateParameter() != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__PACKAGE :
				return getPackage() != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING :
				List templateBinding = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TEMPLATE_SIGNATURE) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__IS_ABSTRACT :
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION :
				List generalization = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__GENERALIZATION);
				return generalization != null && !generalization.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT :
				List powertypeExtent = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__POWERTYPE_EXTENT);
				return powertypeExtent != null && !powertypeExtent.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__FEATURE :
				return isSetFeatures();
			case UMLPackage.BEHAVIORED_CLASSIFIER__INHERITED_MEMBER :
				return !getInheritedMembers().isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_CLASSIFIER :
				List redefinedClassifier = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__REDEFINED_CLASSIFIER);
				return redefinedClassifier != null
					&& !redefinedClassifier.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__GENERAL :
				return !getGenerals().isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE :
				List ownedUseCase = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_USE_CASE);
				return ownedUseCase != null && !ownedUseCase.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE :
				List useCase = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__USE_CASE);
				return useCase != null && !useCase.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION :
				List substitution = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__SUBSTITUTION);
				return substitution != null && !substitution.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__ATTRIBUTE :
				return isSetAttributes();
			case UMLPackage.BEHAVIORED_CLASSIFIER__REPRESENTATION :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__REPRESENTATION) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE :
				List collaborationUse = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__COLLABORATION_USE);
				return collaborationUse != null && !collaborationUse.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_SIGNATURE) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR :
				List ownedBehavior = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR);
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR :
				return eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR) != null;
			case UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION :
				List interfaceRealization = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__INTERFACE_REALIZATION);
				return interfaceRealization != null
					&& !interfaceRealization.isEmpty();
			case UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER :
				List ownedTrigger = (List) eVirtualGet(UMLPackage.BEHAVIORED_CLASSIFIER__OWNED_TRIGGER);
				return ownedTrigger != null && !ownedTrigger.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
			|| eIsSet(UMLPackage.eINSTANCE
				.getBehavioredClassifier_OwnedBehavior())
			|| eIsSet(UMLPackage.eINSTANCE
				.getBehavioredClassifier_OwnedTrigger());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements()
			|| eIsSet(UMLPackage.eINSTANCE
				.getBehavioredClassifier_InterfaceRealization());
	}

} //BehavioredClassifierImpl