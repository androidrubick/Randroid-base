package androidrubick.base.utils;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * <p>
 * Created by Yin Yong on 2018/1/30.
 */
public class NumberUtilsTest {
    @Test
    public void format() throws Exception {
        assertEquals(NumberUtils.format(100.341523, 2), "100.34");
        assertEquals(NumberUtils.format(100.344999, 2), "100.34");
        assertEquals(NumberUtils.format(100.3449999999999, 2), "100.34");
        assertEquals(NumberUtils.format(100.344999999999999999999999, 2), "100.35");
        assertEquals(NumberUtils.format(100.348523, 2), "100.35");

        Locale.setDefault(Locale.FRANCE);
        assertEquals(NumberUtils.format(100.341523, 2), "100,34");
    }

    @Test
    public void getNumberSign() throws Exception {
        assertEquals(NumberUtils.getNumberSign(0, false), "");
        assertEquals(NumberUtils.getNumberSign(0, true), "");

        assertEquals(NumberUtils.getNumberSign(1, false), "+");
        assertEquals(NumberUtils.getNumberSign(1, true), "");

        assertEquals(NumberUtils.getNumberSign(-0, false), "");
        assertEquals(NumberUtils.getNumberSign(-0, true), "");

        assertEquals(NumberUtils.getNumberSign(-1, false), "-");
        assertEquals(NumberUtils.getNumberSign(-1, true), "-");
    }

    @Test
    public void formatByUnit() throws Exception {
        assertEquals(NumberUtils.formatByUnit(101, 10, "两", "斤"), "10斤");

        assertEquals(NumberUtils.formatByUnit(101, 10, 2, "两", "斤"), "10.10斤");

        assertEquals(NumberUtils.formatByUnit(88.2, 10, 8, 2, "毫米", "厘米", "分米"), "0.88分米");
    }

}