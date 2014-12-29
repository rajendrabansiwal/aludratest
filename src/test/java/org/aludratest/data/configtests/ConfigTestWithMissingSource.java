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
package org.aludratest.data.configtests;

import org.aludratest.data.PersonBean;
import org.aludratest.testcase.Test;
import org.aludratest.testcase.data.Source;

/**
 * Tests the {@link TestConfigInfoHelper} with a test case 
 * that refers a missing Excel file.
 * @author Volker Bergmann
 */
@SuppressWarnings("javadoc")
public class ConfigTestWithMissingSource extends AbstractConfigTest {

    @Test
    public void test(@Source(uri = "non_existing.xls") PersonBean person) {
        throw new AssertionError("This is not expected to be called");
    }

}