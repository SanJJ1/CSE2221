import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW19 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW19() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        charSet.clear();
        for (Character c : str.toCharArray()) {
            if (!charSet.contains(c)) {
                charSet.add(c);
            }
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        String ret = "";
        int i = position;
        if (separators.contains(text.charAt(i))) {
            do {
                ret += text.charAt(i);
                i++;
            } while (separators.contains(text.charAt(i - 1))
                    && i < text.length());

        } else {
            do {
                ret += text.charAt(i);
                i++;
            } while (!separators.contains(text.charAt(i - 1))
                    && i < text.length());
        }
        if (i < text.length()) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        String s = "b";
        Set<Character> sSet = new Set1L<Character>();
        generateElements(s, sSet);
        out.println(s);
        out.println(sSet);
        String text = "asdf";
        out.println(nextWordOrSeparator(text, 0, sSet));

        in.close();
        out.close();
    }

}
