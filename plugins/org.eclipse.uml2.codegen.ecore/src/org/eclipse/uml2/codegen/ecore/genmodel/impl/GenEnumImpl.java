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
 * $Id: GenEnumImpl.java,v 1.6 2006/12/14 15:45:13 khussey Exp $
 */
package org.eclipse.uml2.codegen.ecore.genmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.codegen.ecore.genmodel.GenEnum;
import org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GenEnumImpl
		extends org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumImpl
		implements GenEnum {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenEnumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenModelPackage.Literals.GEN_ENUM;
	}

} //GenEnumImpl
