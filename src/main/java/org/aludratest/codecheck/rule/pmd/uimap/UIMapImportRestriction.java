/*
 * Copyright (C) 2010-2014 Hamburg Sud and the contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aludratest.codecheck.rule.pmd.uimap;

import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;

import org.aludratest.codecheck.rule.pmd.ImportRestrictions;
import org.aludratest.service.gui.AludraGUI;
import org.aludratest.service.gui.component.GUIComponent;
import org.aludratest.service.gui.web.uimap.UIMap;
import org.aludratest.service.gui.web.uimap.UIMapHelper;
import org.aludratest.service.gui.web.uimap.UIMapUtility;
import org.aludratest.service.locator.Locator;
import org.aludratest.service.locator.element.ElementLocators;

/**
 * See <code>src/main/resources/pmd-rules-aludra.xml</code> or the project Site
 * for rule description.
 * 
 * @author falbrech
 * 
 */
public class UIMapImportRestriction extends ImportRestrictions {

    private static final Class<?>[] ALLOWED_IMPORT_PARENTS = { GUIComponent.class, Locator.class, UIMap.class, UIMapHelper.class,
        UIMapUtility.class, AludraGUI.class, ElementLocators.class };

    @Override
    protected String getImportViolationMessage(String importName) {
        return "Illegal import for a UIMap class: " + importName;
    }

    @Override
    protected Class<?>[] getAllowedImportParents() {
        return ALLOWED_IMPORT_PARENTS;
    }

    @Override
    public Object visit(ASTClassOrInterfaceDeclaration node, Object data) {
        if (!isUIMapClass(node) || node.isAbstract()) {
            return null;
        }

        return super.visit(node, data);
    }

}
