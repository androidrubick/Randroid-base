package androidrubick.base.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>
 * Created by Yin Yong on 2018/1/30.
 */
public class PrimitivesTest {
    @Test
    public void isPrimitive() throws Exception {
        assertTrue(Primitives.isPrimitive(byte.class));
        assertFalse(Primitives.isPrimitive(Byte.class));

        assertTrue(Primitives.isPrimitive(char.class));
        assertFalse(Primitives.isPrimitive(Character.class));

        assertTrue(Primitives.isPrimitive(int.class));
        assertFalse(Primitives.isPrimitive(Integer.class));

        assertTrue(Primitives.isPrimitive(float.class));
        assertFalse(Primitives.isPrimitive(Float.class));

        assertTrue(Primitives.isPrimitive(long.class));
        assertFalse(Primitives.isPrimitive(Long.class));

        assertTrue(Primitives.isPrimitive(double.class));
        assertFalse(Primitives.isPrimitive(Double.class));

        assertTrue(Primitives.isPrimitive(boolean.class));
        assertFalse(Primitives.isPrimitive(Boolean.class));

        assertFalse(Primitives.isPrimitive(Object.class));
    }

    @Test
    public void isWrapperType() throws Exception {
        assertFalse(Primitives.isWrapperType(byte.class));
        assertTrue(Primitives.isWrapperType(Byte.class));

        assertFalse(Primitives.isWrapperType(char.class));
        assertTrue(Primitives.isWrapperType(Character.class));

        assertFalse(Primitives.isWrapperType(int.class));
        assertTrue(Primitives.isWrapperType(Integer.class));

        assertFalse(Primitives.isWrapperType(float.class));
        assertTrue(Primitives.isWrapperType(Float.class));

        assertFalse(Primitives.isWrapperType(long.class));
        assertTrue(Primitives.isWrapperType(Long.class));

        assertFalse(Primitives.isWrapperType(double.class));
        assertTrue(Primitives.isWrapperType(Double.class));

        assertFalse(Primitives.isWrapperType(boolean.class));
        assertTrue(Primitives.isWrapperType(Boolean.class));

        assertFalse(Primitives.isWrapperType(Object.class));
    }

    @Test
    public void wrap() throws Exception {
        assertSame(Primitives.wrap(byte.class), Byte.class);
        assertSame(Primitives.wrap(char.class), Character.class);
        assertSame(Primitives.wrap(int.class), Integer.class);
        assertSame(Primitives.wrap(float.class), Float.class);
        assertSame(Primitives.wrap(long.class), Long.class);
        assertSame(Primitives.wrap(double.class), Double.class);
        assertSame(Primitives.wrap(boolean.class), Boolean.class);

        assertSame(Primitives.wrap(Double.class), Double.class);
        assertSame(Primitives.wrap(Object.class), Object.class);
    }

    @Test
    public void unwrap() throws Exception {
        assertSame(Primitives.unwrap(Object.class), Object.class);

        assertSame(Primitives.unwrap(Object.class), Object.class);
    }

    @Test
    public void defValueOf() throws Exception {
        assertSame(Primitives.defValueOf(Object.class), null);
        assertSame(Primitives.defValueOf(Boolean.class), null);
    }

}