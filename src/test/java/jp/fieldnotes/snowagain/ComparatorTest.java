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


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComparatorTest {

    MapOperator operator;

    @BeforeEach
    public void before() {
        this.operator = new MapOperator((m) -> {
            m.put("key1", "value1");
            m.put("key2", "value2");
            m.put("key3", "value3");
        });
    }

    @Test
    public void testDiffWithOperation() {
        Comparator comparator = new MockComparator(operator);
        Result result = comparator.execute(() -> {
            operator.getSource().put("key2", "value2-update");
            operator.getSource().remove("key3");
        });
        assertThat(result.hasChanges(), is(true));
    }

    @Test
    public void testDiffWithNonOperation() {
        Comparator comparator = new MockComparator(operator);
        Result result = comparator.execute(() -> {
        });
        assertThat(result.hasChanges(), is(false));
    }


    public static class MapOperator {

        private Map<String, String> source;

        public MapOperator(Consumer<Map<String, String>> f) {
            this.source = new HashMap<>();
            f.accept(this.source);
        }

        public Map<String, String> getSource() {
            return source;
        }
    }

}
