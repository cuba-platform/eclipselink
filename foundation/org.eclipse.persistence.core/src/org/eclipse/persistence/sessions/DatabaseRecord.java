/*******************************************************************************
 * Copyright (c) 1998, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/
package org.eclipse.persistence.sessions;

import java.util.*;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.internal.sessions.AbstractRecord;

/**
 * <p>
 * <b>Purpose</b>: Define a representation of a database row as field{@literal =>}value pairs.
 * This is the database row implementation class, the Record or java.util.Map interfaces
 * should be used to access this class instead of the implementation class.
 * <p>
 * <b>Responsibilities</b>: <ul>
 *        <li> Implement the common hashtable collection protocol.
 *        <li> Allow get and put on the field or field name.
 * </ul>
 * @see DatabaseField
 * @see Record
 * @see java.util.Map
 */
public class DatabaseRecord extends AbstractRecord {

    /**
     * INTERNAL:
     * Returns a record (of default size).
     */
    public DatabaseRecord() {
        super();
    }

    /**
     * INTERNAL:
     * Returns a record of the given initial capacity.
     * @param initialCapacity
     */
    public DatabaseRecord(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * INTERNAL:
     * Builds row from database result fields and values.
     * Note: the entire database result will share the same fields vector.
     * @param fields Vector of fields
     * @param values Vector of values
     */
    public DatabaseRecord(Vector fields, Vector values) {
        super(fields, values);
    }

    /**
     * INTERNAL:
     * Builds row from database result fields and values.
     * Note: the entire database result will share the same fields vector.
     * @param fields Vector of fields
     * @param values Vector of values
     * @param size of record
     */
    public DatabaseRecord(Vector fields, Vector values, int size) {
        super(fields, values, size);
    }

    //cuba begin
    /**
     * INTERNAL:
     * Retrieve the value for the field. If missing null is returned.
     */
    public Object get(DatabaseField key, boolean lookupField) {
        // PERF: Direct variable access.
        // ** Code duplicated in getIndicatingNoEntry, replaceAt ensure kept in synch **
        // Optimize check.
        int index = key.index;
        if (!lookupField) {
            if ((index >= 0) && (index < this.size)) {
                DatabaseField field = this.fields.get(index);
                if ((field == key) || field.equals(key)) {
                    return this.values.get(index);
                }
            }
        }
        int fieldsIndex = this.fields.indexOf(key);
        if (fieldsIndex >= 0) {
            // PERF: If the fields index was not set, then set it.
            if (index == -1) {
                key.setIndex(fieldsIndex);
            }
            return this.values.get(fieldsIndex);
        } else {
            return null;
        }
    }
    //cuba end
}
