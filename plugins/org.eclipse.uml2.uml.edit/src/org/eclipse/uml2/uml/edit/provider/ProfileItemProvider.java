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
 * $Id: ProfileItemProvider.java,v 1.1 2005/11/14 22:11:33 khussey Exp $
 */
package org.eclipse.uml2.uml.edit.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.uml2.common.edit.command.SubsetAddCommand;
import org.eclipse.uml2.common.edit.command.SubsetReplaceCommand;
import org.eclipse.uml2.common.edit.command.SupersetRemoveCommand;
import org.eclipse.uml2.common.edit.command.SupersetReplaceCommand;

import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.uml2.uml.Profile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileItemProvider
		extends PackageItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileItemProvider(AdapterFactory adapterFactory) {
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

			addOwnedStereotypePropertyDescriptor(object);
			addMetaclassReferencePropertyDescriptor(object);
			addMetamodelReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Owned Stereotype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedStereotypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Profile_ownedStereotype_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_Profile_ownedStereotype_feature", "_UI_Profile_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.eINSTANCE.getProfile_OwnedStereotype(), true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Metaclass Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaclassReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Profile_metaclassReference_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_Profile_metaclassReference_feature", "_UI_Profile_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.eINSTANCE.getProfile_MetaclassReference(), true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Metamodel Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetamodelReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
					.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Profile_metamodelReference_feature"), //$NON-NLS-1$
				getString(
					"_UI_PropertyDescriptor_description", "_UI_Profile_metamodelReference_feature", "_UI_Profile_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				UMLPackage.eINSTANCE.getProfile_MetamodelReference(), true,
				null, null, null));
	}

	/**
	 * This returns Profile.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/Profile"); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Profile) object).getName();
		return label == null || label.length() == 0
			? getString("_UI_Profile_type") : //$NON-NLS-1$
			getString("_UI_Profile_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == UMLPackage.eINSTANCE
			.getNamedElement_NameExpression()
			|| childFeature == UMLPackage.eINSTANCE
				.getPackage_PackagedElement()
			|| childFeature == UMLPackage.eINSTANCE.getNamespace_OwnedRule();

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
				new Object[]{getTypeText(childObject),
					getFeatureText(childFeature), getTypeText(owner)});
		}
		return super.getCreateChildText(owner, feature, child, selection);
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

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection collection, int index) {
		if (feature == UMLPackage.eINSTANCE.getProfile_OwnedStereotype()) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getPackage_PackagedElement()}, collection, index);
		}
		if (feature == UMLPackage.eINSTANCE.getProfile_MetaclassReference()) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getNamespace_ElementImport()}, collection, index);
		}
		if (feature == UMLPackage.eINSTANCE.getProfile_MetamodelReference()) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getNamespace_PackageImport()}, collection, index);
		}
		return super
			.createAddCommand(domain, owner, feature, collection, index);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection collection) {
		if (feature == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getProfile_OwnedStereotype()}, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getNamespace_ElementImport()) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getProfile_MetaclassReference()}, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getNamespace_PackageImport()) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.eINSTANCE.getPackage_AppliedProfile(),
					UMLPackage.eINSTANCE.getProfile_MetamodelReference()},
				collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createReplaceCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Command createReplaceCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, EObject value, Collection collection) {
		if (feature == UMLPackage.eINSTANCE.getProfile_OwnedStereotype()) {
			return new SubsetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getPackage_PackagedElement()}, value, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getProfile_MetaclassReference()) {
			return new SubsetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getNamespace_ElementImport()}, value, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getProfile_MetamodelReference()) {
			return new SubsetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getNamespace_PackageImport()}, value, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
			return new SupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getProfile_OwnedStereotype()}, value, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getNamespace_ElementImport()) {
			return new SupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{UMLPackage.eINSTANCE
					.getProfile_MetaclassReference()}, value, collection);
		}
		if (feature == UMLPackage.eINSTANCE.getNamespace_PackageImport()) {
			return new SupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.eINSTANCE.getPackage_AppliedProfile(),
					UMLPackage.eINSTANCE.getProfile_MetamodelReference()},
				value, collection);
		}
		return super.createReplaceCommand(domain, owner, feature, value,
			collection);
	}

}