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

import javax.sql.DataSource;

public class DatabaseComparator extends AbstractComparator {

    private DataSource dataSource;

    private DatabaseCompareOption option;

    /**
     * Constructor.
     * @param dataSource DataSource using for compare.
     */
    public DatabaseComparator(DataSource dataSource, DatabaseCompareOption option) {
        this.dataSource = dataSource;
        this.option = option;
    }

    @Override
    protected Object before() throws Exception {
        return null;
    }

    @Override
    protected Object after() throws Exception {
        return null;
    }
}
