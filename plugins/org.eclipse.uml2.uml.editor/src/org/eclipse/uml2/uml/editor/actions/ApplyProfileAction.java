/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: ApplyProfileAction.java,v 1.6 2006/10/10 20:40:49 khussey Exp $
 */
package org.eclipse.uml2.uml.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.editor.UMLEditorPlugin;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class ApplyProfileAction
		extends UMLCommandAction {

	public ApplyProfileAction() {
		super();
	}

	protected Command createActionCommand(EditingDomain editingDomain,
			Collection collection) {

		if (collection.size() == 1
			&& collection.iterator().next() instanceof org.eclipse.uml2.uml.Package) {

			return IdentityCommand.INSTANCE;
		}

		return UnexecutableCommand.INSTANCE;
	}

	public void run(IAction action) {

		if (command != UnexecutableCommand.INSTANCE) {
			final org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) collection
				.iterator().next();

			final List choiceOfValues = new ArrayList();

			ResourceSet resourceSet = package_.eResource().getResourceSet();

			try {
				resourceSet.getResource(URI
					.createURI(UMLResource.STANDARD_PROFILE_URI), true);

				resourceSet.getResource(URI
					.createURI(UMLResource.ECORE_PROFILE_URI), true);
			} catch (Exception e) {
				// ignore
			}

			for (Iterator resources = resourceSet.getResources().iterator(); resources
				.hasNext();) {

				Iterator allContents = ((Resource) resources.next())
					.getAllContents();

				while (allContents.hasNext()) {

					new UMLSwitch() {

						public Object caseProfile(Profile profile) {

							if (profile.isDefined()) {
								ProfileApplication profileApplication = package_
									.getProfileApplication(profile);

								if (profileApplication == null
									|| profileApplication
										.getAppliedDefinition() != profile
										.getDefinition()) {

									choiceOfValues.add(profile);
								}
							}

							return profile;
						}
					}.doSwitch((EObject) allContents.next());
				}
			}

			Collections.sort(choiceOfValues, new TextComparator());

			String label = UMLEditorPlugin.INSTANCE
				.getString("_UI_ApplyProfileActionCommand_label"); //$NON-NLS-1$

			final FeatureEditorDialog dialog = new FeatureEditorDialog(
				workbenchPart.getSite().getShell(), getLabelProvider(),
				package_, UMLPackage.Literals.PROFILE, Collections.EMPTY_LIST,
				label, choiceOfValues);
			dialog.open();

			if (dialog.getReturnCode() == FeatureEditorDialog.OK) {
				editingDomain.getCommandStack().execute(
					new RefreshingChangeCommand(editingDomain, new Runnable() {

						public void run() {

							for (Iterator profiles = dialog.getResult()
								.iterator(); profiles.hasNext();) {

								package_
									.applyProfile((Profile) profiles.next());
							}
						}
					}, label));
			}
		}
	}

}
