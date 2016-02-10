package jp.fieldnotes.snowagain;

import org.junit.gen5.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by h.onaka on 2016/02/10.
 */
public class HelloTest {

    @Test
    public void testHello(){

        assertThat(new Hello().hello(), is("Hello, World!"));
    }



}
