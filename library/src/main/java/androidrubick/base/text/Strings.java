package androidrubick.base.text;

import static androidrubick.base.utils.Preconditions.checkArgument;
import static androidrubick.base.utils.Preconditions.checkNotNull;

/**
 * utilities of string
 *
 * @author Yin Yong
 *
 * @since 1.0
 */
public class Strings {

	/**
	 * no instance needed
	 */
	private Strings() { /*no instance*/ }
	
	/**
	 * null-value String
     *
     * @since 1.0
	 */
    public static final String NULL = "null";
	/**
	 * empty String
     *
     * @since 1.0
	 */
    public static final String EMPTY = "";

	/**
	 * check this target string is <code>null</code> or empty; <br/>
	 * if <code>checkContentNull</code> is set true,
	 * it'll also check if it is a "null" string, ignoring Case.
	 * @param target target string to check
	 * @param checkContentNull if is set true,
	 * it'll also check if it is a "null" string, ignoring Case.
     *
     * @since 1.0
	 */
	public static boolean isEmpty(CharSequence target, boolean checkContentNull) {
		// check if target is null, or a len == 0 string
		return ((null == target)
				|| (target.length() == 0)
				|| (checkContentNull && NULL.equals(target.toString())));
	}
	
	/**
	 * check this target string is null or empty;
	 * @param target target string to check
	 * @see #isEmpty(CharSequence, boolean) isEmpty(String, false)
     *
     * @since 1.0
	 */
	public static boolean isEmpty(CharSequence target) {
		return isEmpty(target, false);
	}

    /**
     * Returns a string, of length at least {@code minLength}, consisting of
     * {@code string} prepended with as many copies of {@code padChar} as are
     * necessary to reach that length. For example,
     *
     * <ul>
     * <li>{@code padStart("7", 3, '0')} returns {@code "007"}
     * <li>{@code padStart("2010", 3, '0')} returns {@code "2010"}
     * </ul>
     *
     * <p>See {@link java.util.Formatter} for a richer set of formatting capabilities.
     *
     * @param string the string which should appear at the end of the result
     * @param minLength the minimum length the resulting string must have. Can be
     *     zero or negative, in which case the input string is always returned.
     * @param padChar the character to insert at the beginning of the result until
     *     the minimum length is reached
     * @return the padded string
     *
     * @since 1.0
     */
    public static String padStart(String string, int minLength, char padChar) {
        checkNotNull(string);  // eager for GWT.
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }
        sb.append(string);
        return sb.toString();
    }

    /**
     * Returns a string, of length at least {@code minLength}, consisting of
     * {@code string} appended with as many copies of {@code padChar} as are
     * necessary to reach that length. For example,
     *
     * <ul>
     * <li>{@code padEnd("4.", 5, '0')} returns {@code "4.000"}
     * <li>{@code padEnd("2010", 3, '!')} returns {@code "2010"}
     * </ul>
     *
     * <p>See {@link java.util.Formatter} for a richer set of formatting capabilities.
     *
     * @param string the string which should appear at the beginning of the result
     * @param minLength the minimum length the resulting string must have. Can be
     *     zero or negative, in which case the input string is always returned.
     * @param padChar the character to append to the end of the result until the
     *     minimum length is reached
     * @return the padded string
     *
     * @since 1.0
     */
    public static String padEnd(String string, int minLength, char padChar) {
        checkNotNull(string);  // eager for GWT.
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        sb.append(string);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }
        return sb.toString();
    }

    /**
     * Returns a string consisting of a specific number of concatenated copies of
     * an input string. For example, {@code repeat("hey", 3)} returns the string
     * {@code "heyheyhey"}.
     *
     * @param string any non-null string
     * @param count the number of times to repeat it; a nonnegative integer
     * @return a string containing {@code string} repeated {@code count} times
     *     (the empty string if {@code count} is zero)
     * @throws IllegalArgumentException if {@code count} is negative
     *
     * @since 1.0
     */
    public static String repeat(String string, int count) {
        checkNotNull(string);  // eager for GWT.

        if (count <= 1) {
            checkArgument(count >= 0, "invalid count: %s", count);
            return (count == 0) ? "" : string;
        }

        // IF YOU MODIFY THE CODE HERE, you must update StringsRepeatBenchmark
        final int len = string.length();
        final long longSize = (long) len * (long) count;
        final int size = (int) longSize;
        if (size != longSize) {
            throw new ArrayIndexOutOfBoundsException(
                    "Required array size too large: " + longSize);
        }

        final char[] array = new char[size];
        string.getChars(0, len, array, 0);
        int n;
        for (n = len; n < size - n; n <<= 1) {
            System.arraycopy(array, 0, array, n, n);
        }
        System.arraycopy(array, 0, array, n, size - n);
        return new String(array);
    }

    /**
     * Returns the longest string {@code prefix} such that
     * {@code a.toString().startsWith(prefix) && b.toString().startsWith(prefix)},
     * taking care not to split surrogate pairs. If {@code a} and {@code b} have
     * no common prefix, returns the empty string.
     *
     * @since 1.0
     */
    public static String commonPrefix(CharSequence a, CharSequence b) {
        checkNotNull(a);
        checkNotNull(b);

        int maxPrefixLength = Math.min(a.length(), b.length());
        int p = 0;
        while (p < maxPrefixLength && a.charAt(p) == b.charAt(p)) {
            p++;
        }
        if (validSurrogatePairAt(a, p - 1) || validSurrogatePairAt(b, p - 1)) {
            p--;
        }
        return a.subSequence(0, p).toString();
    }

    /**
     * Returns the longest string {@code suffix} such that
     * {@code a.toString().endsWith(suffix) && b.toString().endsWith(suffix)},
     * taking care not to split surrogate pairs. If {@code a} and {@code b} have
     * no common suffix, returns the empty string.
     *
     * @since 1.0
     */
    public static String commonSuffix(CharSequence a, CharSequence b) {
        checkNotNull(a);
        checkNotNull(b);

        int maxSuffixLength = Math.min(a.length(), b.length());
        int s = 0;
        while (s < maxSuffixLength
                && a.charAt(a.length() - s - 1) == b.charAt(b.length() - s - 1)) {
            s++;
        }
        if (validSurrogatePairAt(a, a.length() - s - 1)
                || validSurrogatePairAt(b, b.length() - s - 1)) {
            s--;
        }
        return a.subSequence(a.length() - s, a.length()).toString();
    }

    /**
     * True when a valid surrogate pair starts at the given {@code index} in the
     * given {@code string}. Out-of-range indexes return false.
     *
     * @since 1.0
     */
    public static boolean validSurrogatePairAt(CharSequence string, int index) {
        return index >= 0 && index <= (string.length() - 2)
                && Character.isHighSurrogate(string.charAt(index))
                && Character.isLowSurrogate(string.charAt(index + 1));
    }

}
