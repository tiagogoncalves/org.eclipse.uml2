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
package org.eclipse.uml2.internal.operation;

import org.eclipse.uml2.LiteralInteger;

/**
 * A static utility class that provides operations related to literal integers.
 */
public final class LiteralIntegerOperations
	extends UML2Operations {

	/**
	 * Constructs a new Literal Integer Operations. This constructor should
	 * never be called because this is a static utility class.
	 */
	private LiteralIntegerOperations() {
		super();
	}

	public static int integerValue(LiteralInteger literalInteger) {
		return literalInteger.getValue();
	}

	public static boolean isComputable(LiteralInteger literalInteger) {
		return true;
	}

}