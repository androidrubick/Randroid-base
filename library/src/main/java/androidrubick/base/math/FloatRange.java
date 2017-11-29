package androidrubick.base.math;

import android.support.annotation.NonNull;

/**
 * {@doc}
 * <p>
 * Created by Yin Yong on 2017/11/29.
 *
 * @since 1.0.0
 */
public class FloatRange {

    /**
     * @param start start
     * @param end   end
     * @since 1.0.0
     */
    @NonNull
    public static FloatRange of(float start, float end) {
        return new FloatRange(start, end);
    }

    /**
     * @param single single number range, from {@code single} to {@code single}
     * @since 1.0.0
     */
    @NonNull
    public static FloatRange of(float single) {
        return new FloatRange(single, single);
    }

    public final float start;
    public final float end;

    /**
     * @since 1.0.0
     */
    public FloatRange(float start, float end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @since 1.0.0
     */
    public float mid() {
        return (start + end) / 2;
    }

    /**
     * offset from start, ignore limit [start, end]
     *
     * @since 1.0.0
     */
    public float offset(float offset) {
        return start + offset;
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public float fixedOffset(float offset) {
        float offsets = end - start;
        if (offsets > 0) {
            offset = MathCompat.limitByRange(offset, 0, offsets);
        } else if (offsets < 0) {
            offset = MathCompat.limitByRange(offset, offsets, 0);
        }
        return offset(offset);
    }

    /**
     * offset from start, ignore limit [start, end]
     *
     * @since 1.0.0
     */
    public float ratioOffset(float offsetRatio) {
        return start + (end - start) * offsetRatio;
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public float fixedRatioOffset(float offsetRatio) {
        return start + (end - start) * MathCompat.limitByRange(offsetRatio, 0, 1);
    }
}
