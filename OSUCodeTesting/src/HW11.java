import static java.lang.Math.pow;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author S. Janardhan
 */
public final class HW11 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW11() {
        // no code needed here
    }

    /**
     * Returns the {@code r}-th root of {@code n}.
     *
     * @param n
     *            the number to which we want to apply the root
     * @param r
     *            the root
     * @return the root of the number
     * @requires n >= 0 and r > 0
     * @ensures root ^ (r) <= n < (root + 1) ^ (r)
     */

    private static int root(int n, int r) {
        int lowEnough = 0;
        int tooHigh = n;
        while (tooHigh - lowEnough > 1) {
            int a = (lowEnough + tooHigh) / 2;
            if (pow(a, r) <= n) {
                lowEnough = a;
            } else {
                tooHigh = a;
            }
        }
        return lowEnough;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        final int n = 1000;
        final int r = 3;

        int root = root(n, r);
        out.println(root);
        in.close();
        out.close();
    }

}
