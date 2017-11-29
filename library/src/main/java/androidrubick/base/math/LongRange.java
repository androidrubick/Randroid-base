package androidrubick.base.math;

import android.support.annotation.NonNull;

/**
 * {@doc}
 * <p>
 * Created by Yin Yong on 2017/11/29.
 *
 * @since 1.0.0
 */
public class LongRange {

    /**
     * @param start start
     * @param end   end
     * @since 1.0.0
     */
    @NonNull
    public static LongRange of(long start, long end) {
        return new LongRange(start, end);
    }

    /**
     * @param single single number range, from {@code single} to {@code single}
     * @since 1.0.0
     */
    @NonNull
    public static LongRange of(long single) {
        return new LongRange(single, single);
    }

    public final long start;
    public final long end;

    /**
     * @since 1.0.0
     */
    public LongRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @since 1.0.0
     */
    public long mid() {
        return (start + end) / 2;
    }

    /**
     * offset from start, ignore limit [start, end]
     *
     * @since 1.0.0
     */
    public long offset(long offset) {
        return start + offset;
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public long fixedOffset(long offset) {
        long offsets = end - start;
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
    public long ratioOffset(float offsetRatio) {
        return start + (long) ((end - start) * offsetRatio);
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public long fixedRatioOffset(float offsetRatio) {
        return start + (long) ((end - start) * MathCompat.limitByRange(offsetRatio, 0, 1));
    }
}
