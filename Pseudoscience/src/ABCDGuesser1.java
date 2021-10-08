import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author S. Janardhan
 *
 */
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean b = false;
        double n = -1;
        do {
            out.println("Enter a positive real number: ");
            String s = in.nextLine();
            if (FormatChecker.canParseDouble(s)) {
                n = Double.parseDouble(s);
                if (n > 0) {
                    b = true;
                } else {
                    out.println("number must be positive");
                }
            } else {
                out.println("must be a positive real number.");
            }
        } while (!b);

        return n;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean b = false;
        double n = -1;
        do {
            out.println("Enter a positive real number not equal to one: ");
            String s = in.nextLine();
            if (FormatChecker.canParseDouble(s)) {
                n = Double.parseDouble(s);
                if (n > 0) {
                    if (n == 1) {
                        out.println("must not be equal to one");
                    } else {
                        b = true;
                    }
                } else {
                    out.println("number must be positive and not equal to one");
                }
            } else {
                out.println("must be a positive real number not equal to one");
            }
        } while (!b);

        return n;

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
         * Put your main program code here
         */
        double mu = 0;
        double w = 1;
        double x = 1;
        double y = 1;
        double z = 1;

        out.println("Enter mu: ");
        mu = getPositiveDouble(in, out);

        out.println("Enter w: ");
        w = getPositiveDoubleNotOne(in, out);

        out.println("Enter x: ");
        x = getPositiveDoubleNotOne(in, out);

        out.println("Enter y: ");
        y = getPositiveDoubleNotOne(in, out);

        out.println("Enter z: ");
        z = getPositiveDoubleNotOne(in, out);

        final double[] pv = { -5, -4, -3, -2, -1, -1.0 / 2, -1.0 / 3, -1.0 / 4,
                0, 1.0 / 4, 1.0 / 3, 1.0 / 2, 1, 2, 3, 4, 5 };

        /*
         * The next few ~30 lines calculate the possible powers of w, x, y, and
         * z before the loop instead of inside the loop, so that it's only done
         * once beforehand. These values are used repeatedly in the loop.
         */

        double[] ws = new double[pv.length];
        int i = 0;
        while (i < pv.length) {
            ws[i] = Math.pow(w, pv[i]);
            i++;
        }

        double[] xs = new double[pv.length];
        i = 0;
        while (i < pv.length) {
            xs[i] = Math.pow(x, pv[i]);
            i++;
        }

        double[] ys = new double[pv.length];
        i = 0;
        while (i < pv.length) {
            ys[i] = Math.pow(y, pv[i]);
            i++;
        }

        double[] zs = new double[pv.length];
        i = 0;
        while (i < pv.length) {
            zs[i] = Math.pow(z, pv[i]);
            i++;
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        i = 0;
        int j;
        int k;
        int l;
        double minError = Double.MAX_VALUE;
        double curError;

        double val;
        while (i < pv.length) {
            j = 0;
            while (j < pv.length) {
                k = 0;
                while (k < pv.length) {
                    l = 0;
                    while (l < pv.length) {
                        val = ws[i] * xs[j] * ys[k] * zs[l];

                        curError = Math.abs(val - mu);
                        if (curError < minError) {
                            minError = curError;
                            a = i;
                            b = j;
                            c = k;
                            d = l;
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        out.println("a = " + pv[a]);
        out.println("b = " + pv[b]);
        out.println("c = " + pv[c]);
        out.println("d = " + pv[d]);

        double approx = ws[a] * xs[b] * ys[c] * zs[d];

        out.println("the best approximation is " + approx);

        final int numToPercent = 100;
        double relativeError = Math.abs(mu - approx) / mu * numToPercent;

        out.print("the relative error is ");
        out.print(relativeError, 2, false);
        out.print("%");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();

    }

}
