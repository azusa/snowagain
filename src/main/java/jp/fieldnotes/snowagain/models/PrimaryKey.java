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
import java.util.Arrays;
import java.util.List;

public class PrimaryKey implements Serializable {

    private List<Column> keys;

    public PrimaryKey(Column... column) {
        this.keys = Arrays.asList(column);
    }

    public List<Column> getKeys() {
        return CopyUtils.clone(keys);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimaryKey that = (PrimaryKey) o;

        return keys != null ? keys.equals(that.keys) : that.keys == null;
    }

    @Override
    public int hashCode() {
        return keys != null ? keys.hashCode() : 0;
    }
}
