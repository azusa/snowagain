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

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import jp.fieldnotes.snowagain.exception.ConversationException;

/**
 * Abstract class for {@link Comparator}.
 * <p>
 * Describe comparation logic in subclass
 */
public abstract class AbstractComparator implements Comparator {

    public AbstractComparator() {
    }

    @Override
    public Result execute(Executor e) {
        try {
            Object before = before();

            e.run();

            Object after = after();

            DiffNode diffNode = ObjectDifferBuilder.buildDefault().compare(after, before);
            return new Result(diffNode);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ConversationException(ex);
        }

    }

    /**
     * Get an Object to be compared.
     *
     * @return an Object to be compared
     * @throws Exception a thrown Exception.
     */
    protected abstract Object before() throws Exception;

    /**
     * Get an Object to compare to.
     *
     * @return an Object to compare to
     * @throws Exception a throws Exception.
     */
    protected abstract Object after() throws Exception;


}
