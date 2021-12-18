import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Program with implementation of some {@code NaturalNumber} secondary
 * operations implemented as static methods: increment, decrement, and
 * printWithCommas, toStringWithCommas.
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW13 {

    /**
     * Constant needed to print/convert {@code NaturalNumber} with commas.
     */
    private static final NaturalNumber ONE_THOUSAND = new NaturalNumber2(1000);

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW13() {
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        NaturalNumber x = n.newInstance();
        x.setFromInt(n.divideBy10());
        if (!n.isZero()) {
            x.multiply(productOfDigits1(n));
        }
        return x;

    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        NaturalNumber x = n.newInstance();
        NaturalNumber n2 = n.newInstance();
        n2.copyFrom(n);
        x.setFromInt(n2.divideBy10());
        if (!n2.isZero()) {
            x.multiply(productOfDigits1(n2));
        }
        return x;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt2(NaturalNumber n) {
        NaturalNumber n2 = n.newInstance();
        n2.copyFrom(n);
        int x = n2.divideBy10();
        if (!n2.isZero()) {
            x += NaturalNumber.RADIX * toInt2(n2);
        }
        return x;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";

        boolean tagPresent = false;

        if (xml.isTag()) {
            if (xml.label().equals(tag)) {
                tagPresent = true;
            }
            for (int i = 0; i < xml.numberOfChildren(); i++) {
                if (findTag(xml.child(i), tag)) {
                    tagPresent = true;
                }
            }
        }

        return tagPresent;
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

//        NaturalNumber test2 = new NaturalNumber2(439857);
//
//        out.print(toInt2(test2) * 1);

//        String url = "https://www.yahoo.com/news/rss/";
//        XMLTree xml = new XMLTree2(url);
//        out.println(findTag(xml, "rsss"));

        /*
         * Initialize an array of NaturalNumbers with values 1 through 5.
         */
        NaturalNumber[] array = new NaturalNumber[5];
        NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = count;
            count.increment();
        }

        for (int i = 0; i < array.length; i++) {
            out.println(array[i]);
        }

        in.close();
        out.close();
    }

}
