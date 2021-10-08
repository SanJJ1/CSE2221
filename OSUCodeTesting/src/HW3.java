import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author S. Janardhan
 */
public final class HW3 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW3() {
        // no code needed here
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double x = xCoord;
        double y = yCoord;
        boolean b = false;

        if (((x - 1) * (x - 1) + (y - 1) * (y - 1)) < 1) {
            b = true;
        }
        return b;
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {
        int count = 0;
        Random rand = new Random1L();
        for (int i = 0; i < n; i++) {
            if (pointIsInCircle(rand.nextDouble() * 2, rand.nextDouble() * 2)) {
                count++;
            }

        }
        return count;
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
        final int n = 4000000;
        double pi = (double) numberOfPointsInCircle(n) / n * 4;
        output.println(pi);

        input.close();
        output.close();
    }

}
