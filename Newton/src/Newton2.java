import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            non-negative number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        //sets error bound to 0.01%:
        final double epsilon = 0.0001;
        //sets first guess to x, which also accounts for if x is 0
        double r = x;
        //Check if estimate is within 0.01%
        while ((Math.abs(r * r - x) / x) > epsilon * epsilon) {
            //Revise estimate
            r = (r + (x / r)) / 2;
        }
        return r;
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
        do {
            out.println(
                    "Enter a non-negative number that you'd like to square root: ");
            out.println(sqrt(in.nextDouble()));
            out.println("Enter \'y\' to continue");
        } while (in.nextLine().equals("y"));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
