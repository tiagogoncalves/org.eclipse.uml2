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
 * $Id: InteractionUseItemProvider.java,v 1.2 2005/11/23 20:07:03 khussey Exp $
 */
package org.eclipse.uml2.uml.edit.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.uml2.uml.InteractionUse} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractionUseItemProvider
		extends InteractionFragmentItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionUseItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRefersToPropertyDescriptor(object);
			addActualGatePropertyDescriptor(object);
			addArgumentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Refers To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefersToPropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InteractionUse_refersTo_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_InteractionUse_refersTo_feature", "_UI_InteractionUse_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.Literals.INTERACTION_USE__REFERS_TO, true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Actual Gate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActualGatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InteractionUse_actualGate_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_InteractionUse_actualGate_feature", "_UI_InteractionUse_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.Literals.INTERACTION_USE__ACTUAL_GATE, true, null,
				null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
				}));
	}

	/**
	 * This adds a property descriptor for the Argument feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArgumentPropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_InteractionUse_argument_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_InteractionUse_argument_feature", "_UI_InteractionUse_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.Literals.INTERACTION_USE__ARGUMENT, true, null,
				null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
				}));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
				.add(UMLPackage.Literals.INTERACTION_USE__ACTUAL_GATE);
			childrenFeatures.add(UMLPackage.Literals.INTERACTION_USE__ARGUMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns InteractionUse.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/InteractionUse"); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((InteractionUse) object).getName();
		return label == null || label.length() == 0
			? getString("_UI_InteractionUse_type") : //$NON-NLS-1$
			getString("_UI_InteractionUse_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(InteractionUse.class)) {
			case UMLPackage.INTERACTION_USE__ACTUAL_GATE :
			case UMLPackage.INTERACTION_USE__ARGUMENT :
				fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors,
			Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ACTUAL_GATE,
			UMLFactory.eINSTANCE.createGate()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createStructuredActivityNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createCreateObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createDestroyObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createTestIdentityAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadSelfAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createClearStructuralFeatureAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createRemoveStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createAddStructuralFeatureValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createCreateLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createDestroyLinkAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createClearAssociationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createBroadcastSignalAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createSendObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createValueSpecificationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createTimeObservationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createDurationObservationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createOpaqueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createSendSignalAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createCallOperationAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createCallBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadVariableAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createClearVariableAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createAddVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createRemoveVariableValueAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createRaiseExceptionAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadExtentAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReclassifyObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadIsClassifiedObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createStartClassifierBehaviorAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadLinkObjectEndAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReadLinkObjectEndQualifierAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createCreateLinkObjectAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createAcceptEventAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createAcceptCallAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createReplyAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createUnmarshallAction()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createSequenceNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createConditionalNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createLoopNode()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.INTERACTION_USE__ARGUMENT, UMLFactory.eINSTANCE
				.createExpansionRegion()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return UMLEditPlugin.INSTANCE;
	}

}
