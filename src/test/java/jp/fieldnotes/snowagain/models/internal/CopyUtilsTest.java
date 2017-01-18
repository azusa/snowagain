package jp.fieldnotes.snowagain.models.internal;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by azusa on 2017/01/14.
 */
class CopyUtilsTest {
    @Test
    void canClone() {

        Map<String, String> input = Collections.singletonMap("key", "value");
        Map<String, String> ret = (Map<String, String>) CopyUtils.clone((Serializable) input);
        assertFalse(input == ret);
        assertEquals(input, ret);


    }

}