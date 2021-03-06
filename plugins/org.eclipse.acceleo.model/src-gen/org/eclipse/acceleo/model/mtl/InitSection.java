/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.model.mtl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.ASTNode;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Init Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.acceleo.model.mtl.InitSection#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.acceleo.model.mtl.MtlPackage#getInitSection()
 * @model
 * @generated
 */
public interface InitSection extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list. The list contents are
	 * of type {@link org.eclipse.ocl.ecore.Variable}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.acceleo.model.mtl.MtlPackage#getInitSection_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Variable> getVariable();

} // InitSection
