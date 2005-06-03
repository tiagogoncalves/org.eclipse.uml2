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
 * $Id: UML2Importer.java,v 1.9 2005/06/02 14:12:16 khussey Exp $
 */
package org.eclipse.uml2.ecore.importer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.emf.importer.ModelImporter;

import org.eclipse.emf.importer.util.ImporterUtil;

import org.eclipse.uml2.Stereotype;
import org.eclipse.uml2.UML2Package;

import org.eclipse.uml2.util.UML2Resource;
import org.eclipse.uml2.util.UML2Util;

public class UML2Importer
		extends ModelImporter {

	protected final Map options = new HashMap();

	public Map getOptions() {
		return options;
	}

	public String getID() {
		return "org.eclipse.uml2.ecore.importer"; //$NON-NLS-1$
	}

	public GenModel getGenModel() {

		if (genModel == null) {

			if (options
				.get(
					UML2Util.UML22EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE)
				.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__DUPLICATE_FEATURES)
					.equals(UML2Util.OPTION__PROCESS)
				|| options
					.get(
						UML2Util.UML22EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE)
					.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__DUPLICATE_OPERATIONS)
					.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__REDEFINING_OPERATIONS)
					.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__REDEFINING_PROPERTIES)
					.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__SUBSETTING_PROPERTIES)
					.equals(UML2Util.OPTION__PROCESS)
				|| options.get(
					UML2Util.UML22EcoreConverter.OPTION__UNION_PROPERTIES)
					.equals(UML2Util.OPTION__PROCESS)) {

				genModel = org.eclipse.uml2.codegen.ecore.genmodel.GenModelFactory.eINSTANCE
					.createGenModel();
			} else {
				genModel = GenModelFactory.eINSTANCE.createGenModel();
			}

			genModel.setImporterID(getID());
		}
		return genModel;
	}

	protected IStatus doComputeEPackages(IProgressMonitor progressMonitor)
			throws Exception {
		IStatus status = Status.OK_STATUS;
		List locationURIs = getModelLocationURIs();

		if (locationURIs.isEmpty()) {
			status = new Status(IStatus.ERROR, ImporterPlugin.ID,
				ImporterUtil.ACTION_DEFAULT, UML2ImporterPlugin.INSTANCE
					.getString("_UI_SpecifyAValidUML2Model_message"), null); //$NON-NLS-1$
		} else {
			progressMonitor.beginTask("", 2); //$NON-NLS-1$
			progressMonitor.subTask(UML2ImporterPlugin.INSTANCE.getString(
				"_UI_Loading_message", new Object[]{locationURIs})); //$NON-NLS-1$

			Collection packages = new ArrayList();

			ResourceSet uml2ResourceSet = createResourceSet();

			for (Iterator i = locationURIs.iterator(); i.hasNext();) {
				Resource uml2Resource = uml2ResourceSet.getResource((URI) i
					.next(), true);

				EcoreUtil.resolveAll(uml2Resource);

				packages.addAll(EcoreUtil.getObjectsByType(uml2Resource
					.getContents(), UML2Package.eINSTANCE.getPackage()));
			}

			progressMonitor.worked(1);

			BasicDiagnostic diagnostics = new BasicDiagnostic(
				ImporterPlugin.ID, ImporterUtil.ACTION_DEFAULT,
				UML2ImporterPlugin.INSTANCE
					.getString("_UI_ProblemsEncounteredProcessing_message"), //$NON-NLS-1$
				null);

			Map context = new HashMap();
			context.put(UML2Util.QualifiedTextProvider.class,
				UML2Util.QualifiedTextProvider.DEFAULT);

			getEPackages().addAll(new UML2Util.UML22EcoreConverter() {

				protected void processEcoreTaggedValues(EPackage ePackage,
						org.eclipse.uml2.Package package_, Map options,
						DiagnosticChain diagnostics, Map context) {

					super.processEcoreTaggedValues(ePackage, package_, options,
						diagnostics, context);

					Stereotype ePackageStereotype = getAppliedEcoreStereotype(
						package_, UML2Util.STEREOTYPE_NAME__E_PACKAGE);

					if (null != ePackageStereotype) {
						EPackageInfo ePackageInfo = getEPackageInfo(ePackage);

						if (package_.hasValue(ePackageStereotype,
							UML2Util.PROPERTY_NAME__BASE_PACKAGE)) {

							getEPackageInfo(ePackage).setBasePackage(
								(String) package_.getValue(ePackageStereotype,
									UML2Util.PROPERTY_NAME__BASE_PACKAGE));
						}

						if (package_.hasValue(ePackageStereotype,
							UML2Util.PROPERTY_NAME__PREFIX)) {

							getEPackageInfo(ePackage).setPrefix(
								(String) package_.getValue(ePackageStereotype,
									UML2Util.PROPERTY_NAME__PREFIX));
						}
					}
				}

			}.convert(packages, options, diagnostics, context));

			progressMonitor.done();

			if (Diagnostic.OK < diagnostics.getSeverity()) {
				status = BasicDiagnostic.toIStatus(diagnostics);
			}
		}

		return status;
	}

	public void adjustEPackage(IProgressMonitor progressMonitor,
			EPackage ePackage) {
		EPackageInfo ePackageInfo = getEPackageInfo(ePackage);
		String name = ePackage.getName();

		if (ePackageInfo.getPrefix() == null) {
			ePackageInfo.setPrefix(Character.toUpperCase(name.charAt(0))
				+ name.substring(1));
		}

		String ecoreFileName = null;
		GenPackage genPackage = getGenPackage(ePackage);

		if (genPackage != null) {
			String ePackagePath = genPackage.getEcorePackage().eResource()
				.getURI().lastSegment();
			ecoreFileName = URI.decode(ePackagePath);
		} else {
			ecoreFileName = ePackage.eResource() == null
				? name + ".ecore" //$NON-NLS-1$
				: ePackage.eResource().getURI().lastSegment();
		}

		ePackageInfo.setEcoreFileName(ecoreFileName);
	}

	protected void adjustGenModel(IProgressMonitor progressMonitor) {
		super.adjustGenModel(progressMonitor);

		URI genModelURI = createFileURI(getGenModelPath().toString());

		for (Iterator i = getModelLocationURIs().iterator(); i.hasNext();) {
			getGenModel().getForeignModel().add(
				makeRelative((URI) i.next(), genModelURI).toString());
		}
	}

	protected void loadOriginalGenModel(URI genModelURI) {
		super.loadOriginalGenModel(genModelURI);

		StringBuffer text = new StringBuffer();

		for (Iterator i = getOriginalGenModel().getForeignModel().iterator(); i
			.hasNext();) {

			String value = (String) i.next();

			if (value.endsWith('.' + UML2Resource.FILE_EXTENSION)) {
				text.append(makeAbsolute(URI.createURI(value), genModelURI)
					.toString());
				text.append(" "); //$NON-NLS-1$
			}
		}

		setModelLocation(text.toString().trim());
	}

}