package androidrubick.base.utils;

import org.junit.Test;

/**
 * <p>
 * Created by Yin Yong on 2018/1/30.
 */
public class DummyRuntimeExceptionTest {
    @Test
    public void test() {
        try {
            a();
        } catch (DummyRuntimeException e) {
            e.printStackTrace();
        }
    }

    private void a() throws DummyRuntimeException {
        try {
            b();
        } catch (Throwable e) {
            throw new DummyRuntimeException(e);
        }
    }

    private void b() {
        throw new RuntimeException("b");
    }
}