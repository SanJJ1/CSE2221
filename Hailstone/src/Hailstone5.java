import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone5() {
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        boolean b = false;
        int n = -1;
        do {
            out.println("Enter a positive integer: ");
            String s = in.nextLine();
            if (FormatChecker.canParseInt(s)) {
                n = Integer.parseInt(s);
                if (n > 0) {
                    b = true;
                } else {
                    out.println("integer must be positive");
                }
            } else {
                out.println("must be a positive integer.");
            }
        } while (!b);

        return n;

    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream and the length of the output stream. And the
     *            maximum value of the series
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int i = n;
        int count = 0;
        int max = 0;
        final int three = 3;
        while (i != 1) {
            if (i > max) {
                max = i;
            }
            count += 1;
            out.print(i + ", ");
            if (i % 2 == 0) {
                i /= 2;
            } else {

                i = three * i + 1;
            }

        }
        out.println(1);
        out.println("Count: " + count);
        out.println("Max: " + max);

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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        do {
            int n = getPositiveInteger(in, out);
            generateSeries(n, out);
            out.println(
                    "Do you wish to calculate another series? Say \"y\" to continue: ");
        } while (in.nextLine().equals("y"));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
