package androidrubick.base.utils;

/**
 * <p/>
 * <p/>
 * Created by Yin Yong on 15/7/2.
 *
 * @since 1.0
 */
public class Exceptions {
    private Exceptions() { }

    /**
     * cast or wrap target {@link Throwable} to a {@link RuntimeException}
     *
     * @since 1.0.0
     */
    public static RuntimeException asRuntime(Throwable e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new DummyRuntimeException(e);
    }

    /**
     * create a {@link RuntimeException} by the specific {@code msg}
     *
     * @since 1.0.0
     */
    public static RuntimeException asRuntime(String msg) {
        return new RuntimeException(msg);
    }

}
