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
package jp.fieldnotes.snowagain.models;

import jp.fieldnotes.snowagain.models.internal.CopyUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Table implements Serializable {

    private String name;

    private List<PrimaryKey> primaryKeys;

    private List<TableRow> tableRows = new ArrayList<>();

    public Table(String name, List<PrimaryKey> primaryKeys) {
        this.name = name;
        this.primaryKeys = primaryKeys;
    }

    public void addRow(TableRow row) {
        this.tableRows.add(row);
    }

    public String getName() {
        return name;
    }

    public boolean hasPrimaryKeys() {
        return primaryKeys != null || !primaryKeys.isEmpty();
    }

    public List<PrimaryKey> getPrimaryKeys() {
        return CopyUtils.clone(primaryKeys);
    }

    public List<TableRow> getTableRows() {
        return CopyUtils.clone(tableRows);
    }
}
