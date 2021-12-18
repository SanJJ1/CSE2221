import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of some {@code NaturalNumber} secondary
 * operations implemented as static methods: increment, decrement, and
 * printWithCommas, toStringWithCommas.
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW12 {

    /**
     * Constant needed to print/convert {@code NaturalNumber} with commas.
     */
    private static final NaturalNumber ONE_THOUSAND = new NaturalNumber2(1000);

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW12() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        NaturalNumber n2 = n.newInstance();
        n2.copyFrom(n);
        int x = n2.divideBy10();

        if (n2.isZero()) {
            return 1;
        } else {
            return 1 + numberOfDigits(n2);
        }
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        NaturalNumber n2 = n.newInstance();
        n2.copyFrom(n);
        int x = n2.divideBy10();
        if (n2.isZero()) {
            return x;
        } else {
            return x + sumOfDigits(n2);
        }
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits2(NaturalNumber n) {
        NaturalNumber n2 = n.newInstance();
        n2.copyFrom(n);
        NaturalNumber x = new NaturalNumber2(n2.divideBy10());
        if (n2.isZero()) {
            return x;
        } else {
            x.add(sumOfDigits2(n2));
            return x;
        }
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {

        int x = n.divideBy10();
        if (n.isZero()) {
            n.multiplyBy10(x / 2);
        } else {
            NaturalNumber n2 = new NaturalNumber2(0);
            n2.copyFrom(n);
            divideBy2(n);
            if (n2.divideBy10() % 2 == 0) {
                n.multiplyBy10(x / 2);
            } else {
                n.multiplyBy10((x + NaturalNumber.RADIX) / 2);
            }
        }
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        int l = s.length() - 1;
        if (l == -1) {
            return false;
        }
        if (l > 1) {
            return s.charAt(0) == s.charAt(l)
                    && isPalindrome(s.substring(1, l));
        } else {
            if (l == 0) {
                return true;
            } else {
                return s.charAt(0) == s.charAt(1);
            }
        }
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

        final int testInt = 102;
        NaturalNumber test = new NaturalNumber2(testInt);

        out.println("Test Original: " + test);

        out.println("Number of Digits: " + numberOfDigits(test));
        out.println("Sum of Digits: " + sumOfDigits(test));
        out.println("Sum of Digits version 2: " + sumOfDigits2(test));

        out.println("Test: " + test);

        for (int i = 0; i < 1000; i++) {
            NaturalNumber test2 = new NaturalNumber2(i);
            divideBy2(test2);
            if (test2.toInt() != i / 2) {
                out.println(test2 + " " + i + " ");
            }
        }
        divideBy2(test);
        out.println("Divide by 2 test: " + test);

        String s = "abba";

        out.println(isPalindrome(s));
        out.println(s);
        in.close();
        out.close();
    }

}
