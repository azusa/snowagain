/*
 * Copyright 2017 Hiroyuki Onaka.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.fieldnotes.snowagain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DatabaseCompareOptionTest {

    @Test
    public void testCreate_WithNonQualifyName(){
        DatabaseCompareOption result = DatabaseCompareOption.tables("table1", "table2").quote(true).create();
        assertThat(result.getTabaleNames(), is(Arrays.asList("\"table1\"", "\"table2\"")));
    }

    @Test
    public void testCreate_WithNonQualifyNameNoQuote(){
        DatabaseCompareOption result = DatabaseCompareOption.tables("table1", "table2").quote(false).create();
        assertThat(result.getTabaleNames(), is(Arrays.asList("table1", "table2")));
    }

    @Test
    public void testCreate_WithQualifyNameWithSchemaNoQuote(){
        DatabaseCompareOption result = DatabaseCompareOption.tables("table1", "table2").schema("public").create();
        assertThat(result.getTabaleNames(), is(Arrays.asList("public.table1", "public.table2")));
    }

    @Test
    public void testCreate_WithQualifyNameWithSchema(){
        DatabaseCompareOption result = DatabaseCompareOption.tables("table1", "table2").schema("public").quote(true).create();
        assertThat(result.getTabaleNames(), is(Arrays.asList("\"public\".\"table1\"", "\"public\".\"table2\"")));
    }

}