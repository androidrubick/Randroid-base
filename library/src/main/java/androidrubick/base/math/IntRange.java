package androidrubick.base.math;

import android.support.annotation.NonNull;

/**
 * {@doc}
 * <p>
 * Created by Yin Yong on 2017/11/29.
 *
 * @since 1.0.0
 */
public class IntRange {

    /**
     * @param start start
     * @param end   end
     * @since 1.0.0
     */
    @NonNull
    public static IntRange of(int start, int end) {
        return new IntRange(start, end);
    }

    /**
     * @param single single number range, from {@code single} to {@code single}
     * @since 1.0.0
     */
    @NonNull
    public static IntRange of(int single) {
        return new IntRange(single, single);
    }

    public final int start;
    public final int end;

    /**
     * @since 1.0.0
     */
    public IntRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @since 1.0.0
     */
    public int mid() {
        return (start + end) / 2;
    }

    /**
     * offset from start, ignore limit [start, end]
     *
     * @since 1.0.0
     */
    public int offset(int offset) {
        return start + offset;
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public int fixedOffset(int offset) {
        int offsets = end - start;
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
    public int ratioOffset(float offsetRatio) {
        return start + (int) ((end - start) * offsetRatio);
    }

    /**
     * offset from start, include limit [start, end]
     *
     * @since 1.0.0
     */
    public int fixedRatioOffset(float offsetRatio) {
        return start + (int) ((end - start) * MathCompat.limitByRange(offsetRatio, 0, 1));
    }
}
