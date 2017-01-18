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

import java.io.Serializable;

public class Column implements Serializable {

    private String name;
    private ColumnValue value;

    Column(String name) {
        this.name = name;
    }

    public Column(String name, ColumnValue value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value.getValue();
    }

    /**
     * Compare value with the value of {@link #getName()}(case insensitive).
     *
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Column column = (Column) o;

        return name != null ? name.equalsIgnoreCase(column.name) : column.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.toLowerCase().hashCode() : 0;
    }
}
