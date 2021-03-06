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
package org.eclipse.persistence.testing.tests.workbenchintegration;

import org.eclipse.persistence.testing.models.directmap.DirectMapMappingsSystem;

/**
 *  This test system uses the DirectMapMapping test system to test the
 *  integration between the Mapping Workbench and the Foundation Library. To do
 *  this, it writes our test project to an XML file and then reads the XML file
 *  and runs the DirectMapMapping tests on it.
 */
public class DirectMapMappingMWIntergrationSystem extends DirectMapMappingsSystem {
    public static String PROJECT_FILE = "MWIntegrationTestDirectMapMappingProject";

    public DirectMapMappingMWIntergrationSystem() {
        super();
        buildProject();
    }

    protected void buildProject() {
        project = WorkbenchIntegrationSystemHelper.buildProjectXML(project, PROJECT_FILE);
    }
}
