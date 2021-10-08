import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author S. Janardhan
 */
public final class HW4 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW4() {
        // no code needed here
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return hi
     */
    boolean allTheSame(int x, int y, int z) {
        boolean b = false;
        if ((x == y) && (y == z) && (x == z)) {
            b = true;
        }
        return b;
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return boolean value if x != y != z
     */
    boolean allDifferent(int x, int y, int z) {
        boolean b = false;
        if ((x != y) && (y != z) && (x != z)) {
            b = true;
        }
        return b;
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return boolean value if ints x, y, z are in ascending order.
     */
    boolean sorted(int x, int y, int z) {
        boolean b = false;
        if ((x <= y) && (y <= z) && (x <= z)) {
            b = true;
        }
        return b;
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

        // finds sum of even integers from 2 to 100 inclusive.
//        final int loopEnd = 100;
//        int sum = 0;
//        for (int i = 2; i <= loopEnd; i += 2) {
//            sum += i;
//        }
//        output.println(sum);

        //finds the sum of odd integers between a and b inclusive
//        final int b = 20;
//        int sum = 0;
//        for (int a = 0; a <= b; a++) {
//            if (a % 2 == 1) {
//                sum += a;
//            }
//        }
//        output.println(sum);

//        final int var = input.nextInteger();
//        char[] s = Integer.toString(var).toCharArray();
//        int sum = 0;
//        for (int i = 0; i < s.length; i++) {
//            if (i % 2 == 0) {
//                sum += Character.getNumericValue(s[i]);
//            }
//        }
//        output.println(sum);

//        final int var = input.nextInteger();
//        char[] s = Integer.toString(var).toCharArray();
//        int sum = 0;
//        for (int i = s.length - 1; i > 0 - 1; i--) {
//            if (i % 2 == 1) {
//                sum += Character.getNumericValue(s[i]);
//            }
//        }
//        output.println(sum);
//
//        int a = 5;
//        int b = 3;
//        int temp = a;
//        a = b;
//        b = temp;
//
//        output.println(a);
//        output.println(b);

        input.close();
        output.close();
    }

}
