package androidrubick.base.utils;

import org.junit.Test;

/**
 * <p>
 * Created by Yin Yong on 2018/1/30.
 */
public class DummyExceptionTest {

    @Test
    public void test() {
        try {
            a();
        } catch (DummyException e) {
            e.printStackTrace();
        }
    }

    private void a() throws DummyException {
        try {
            b();
        } catch (Throwable e) {
            throw new DummyException(e);
        }
    }

    private void b() {
        throw new RuntimeException("b");
    }

}