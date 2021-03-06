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
package org.eclipse.persistence.tools.workbench.mappingsplugin.ui.mapping.relational;

import org.eclipse.persistence.tools.workbench.framework.context.WorkbenchContext;
import org.eclipse.persistence.tools.workbench.framework.ui.view.TabbedPropertiesPage;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.common.UiCommonBundle;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.db.UiDbBundle;
import org.eclipse.persistence.tools.workbench.mappingsplugin.ui.mapping.UiMappingBundle;


final class RelationalDirectMapMappingTabbedPropertiesPage extends TabbedPropertiesPage {

    // this value is queried reflectively during plug-in initialization
    private static final Class[] REQUIRED_RESOURCE_BUNDLES = new Class[] {
        UiCommonBundle.class,
        UiMappingBundle.class,
        UiMappingRelationalBundle.class,
        UiDbBundle.class
    };


    RelationalDirectMapMappingTabbedPropertiesPage(WorkbenchContext context) {
        super(context);
    }

    protected void initializeTabs() {
        addTab(new RelationalDirectMapGeneralPropertiesPage(getNodeHolder(), getWorkbenchContextHolder()),        "DIRECT_COLLECTION_GENERAL_TAB_TITLE");
//        addTab(new RelationalDirectMapMappingContainerOptionsPropertiesPage(getNodeHolder(), getWorkbenchContextHolder()), "DIRECT_COLLECTION_OPTIONS_TAB_TITLE");
        addTab(new RelationalDirectMapConverterPropertiesPage(getNodeHolder(), getWorkbenchContextHolder()),        "DIRECT_MAP_CONVERTER_TAB_TITLE");
        addTab(new RelationalDirectContainerMappingTableReferencePropertiesPage(getNodeHolder(), getWorkbenchContextHolder()), "DIRECT_COLLECTION_TABLE_REFERENCE_TAB_TITLE");
    }
}
