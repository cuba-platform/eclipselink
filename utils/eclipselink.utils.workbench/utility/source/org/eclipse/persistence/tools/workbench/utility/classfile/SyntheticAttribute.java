/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.tools.workbench.utility.classfile;

import java.io.IOException;

import org.eclipse.persistence.tools.workbench.utility.classfile.tools.ClassFileDataInputStream;
import org.eclipse.persistence.tools.workbench.utility.io.IndentingPrintWriter;


/**
 * This class models a synthetic attribute:
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *
 * See "The Java Virtual Machine Specification" Chapter 4.
 *
 * This attribute is sorta deprecated - the ACC_SYNTHETIC flag should
 * be used instead to mark a class, field, or method "synthetic"
 */
public class SyntheticAttribute extends Attribute {

    /**
     * Construct a synthetic attribute from the specified stream
     * of byte codes.
     */
    SyntheticAttribute(ClassFileDataInputStream stream, short nameIndex, AttributePool pool) throws IOException {
        super(stream, nameIndex, pool);
    }

    void initializeInfo(ClassFileDataInputStream stream) throws IOException {
        // the synthetic attribute has no info...
    }

    void displayInfoStringOn(IndentingPrintWriter writer) {
        // there's nothing to print...
    }

    public boolean isSynthetic() {
        return true;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
