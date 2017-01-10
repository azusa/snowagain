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

import java.util.ArrayList;
import java.util.List;

/**
 * Database Compare Options.(Table Names. Schema Names, Whether quote name or not)
 */
public class DatabaseCompareOption {

    private String[] tableNames;

    private String schemaName;

    private boolean quote = false;

    private DatabaseCompareOption(String[] tableNames, String schemaName, boolean quote) {
        this.tableNames = tableNames;
        this.schemaName = schemaName;
        this.quote = quote;
    }

    public static DatabaseCompareBuilder tables(String ... tableNames){
        return new DatabaseCompareBuilder(tableNames);
    }

    public List<String> getTabaleNames(){
        List<String> tableNames = new ArrayList<>();
        for (String name : this.tableNames){
            String qualifyName;
            if (schemaName != null){
                if (quote) {
                    qualifyName = "\"" + schemaName + "\"" + "." + "\"" + name + "\"";
                } else {
                    qualifyName = schemaName + "." + name;
                }
            } else {
                if (quote){
                    qualifyName = "\"" + name + "\"";
                } else {
                    qualifyName = name;
                }

            }
            tableNames.add(qualifyName);
        }
        return tableNames;
    }

    public static class DatabaseCompareBuilder {
        private String[] tableNames;

        private String schemaNames;

        private boolean quote = false;

        private DatabaseCompareBuilder(String[] tableNames) {
            this.tableNames = tableNames;
        }

        public DatabaseCompareBuilder schema(String schemaName){
            this.schemaNames = schemaName;
            return this;
        }

        public DatabaseCompareBuilder quote(boolean quote) {
            this.quote = quote;
            return this;
        }

        public DatabaseCompareOption create(){
            return new DatabaseCompareOption(tableNames, schemaNames, quote);
        }

    }
}
