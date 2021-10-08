import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class Greg {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private Greg() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        final double epsilon = .00000001;
        double add = 1;
        double pi = 0;
        int i = 0;
        while (Math.abs(add) > epsilon) {
            pi += add;
            i++;
            add = Math.pow(-1, i) / ((2 * i) + 1);
        }
        pi *= 4;

        output.print(pi);

        input.close();
        output.close();
    }

}
