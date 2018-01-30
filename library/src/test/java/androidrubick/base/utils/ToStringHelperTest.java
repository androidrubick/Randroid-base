package androidrubick.base.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>
 * Created by Yin Yong on 2018/1/30.
 */
public class ToStringHelperTest {
    private static class A {

    }

    @Test
    public void omitNullValues() throws Exception {
        assertEquals(Objects.toStringHelper(A.class)
                .omitNullValues()
                .add("a", 1)
                .addValue(null)
                .add("b", null)
                .toString(),
                "A{a=1}");
    }

}