package jp.fieldnotes.snowagain;
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

import java.util.HashMap;

public class MockComparator extends AbstractComparator {

    private ComparatorTest.MapOperator operator;

    public MockComparator(ComparatorTest.MapOperator operator) {
        this.operator = operator;
    }

    @Override
    protected Object before() throws Exception {
        return new HashMap<>(this.operator.getSource());
    }

    @Override
    protected Object after() throws Exception {
        return new HashMap<>(this.operator.getSource());
    }
}
