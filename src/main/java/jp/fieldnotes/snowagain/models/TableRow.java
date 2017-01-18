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

import jp.fieldnotes.snowagain.exception.ColumnNotFoundException;
import jp.fieldnotes.snowagain.models.internal.CopyUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TableRow implements Serializable {

    private HashMap<Column, ColumnValue> columns = new HashMap<>();

    public ColumnValue getValue(String columnName) throws ColumnNotFoundException {
        return columns.get(new Column(columnName));
    }

    public void addColumn(Column column, ColumnValue value) {
        this.columns.put(column, value);
    }

    public Map<Column, ColumnValue> getColumns() {
        return CopyUtils.clone(columns);
    }

}
