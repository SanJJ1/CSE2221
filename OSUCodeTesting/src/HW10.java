import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author S. Janardhan
 */
public final class HW10 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW10() {
        // no code needed here
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber temp = new NaturalNumber2(n1);
        n1.transferFrom(n2);
        n2.transferFrom(temp);
//        n1.copyFrom(n2);
//        n2.copyFrom(temp);
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        n.power(2);
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
        final int a = 371;
        final int b = 568;
        NaturalNumber x = new NaturalNumber2(a);
        NaturalNumber y = new NaturalNumber2(b);
        swapNN(x, y);
        out.println("x: " + x.toString());
        out.println("y: " + y.toString());
        square(x);
        out.println("x once squared: " + x.toString());

        in.close();
        out.close();
    }

}
