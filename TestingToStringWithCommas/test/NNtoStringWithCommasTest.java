import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for NNtoStringWithCommas1.
 *
 * @author Sanjay Janardhan
 *
 */
public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas5.toStringWithCommas(n);
    }

    /**
     * Test for 5 as routine case for 1 digit number.
     */
    @Test
    public void toStringWithCommas1() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 5;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "5");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 0 since 0 is a boundary case.
     */
    @Test
    public void toStringWithCommas2() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 0;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "0");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 13 as routine two digit case.
     */
    @Test
    public void toStringWithCommas3() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 13;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "13");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 748 as routine three digit case.
     */
    @Test
    public void toStringWithCommas4() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 748;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "748");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 9834 as routine four digit case with one comma.
     */
    @Test
    public void toStringWithCommas5() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 9834;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "9,834");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 198347123 as routine 9 digit case with two commas.
     */
    @Test
    public void toStringWithCommas6() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 198347123;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "198,347,123");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 2147483645 as routine 10 digit case with three commas.
     */
    @Test
    public void toStringWithCommas7() {
        /*
         * Set up variables and call method under test
         */
        final int toTest = 2147483645;
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "2,147,483,645");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }

    /**
     * Test for 2147483648 as tough 10 digit case with three commas. This is
     * tough since this is above integer limit.
     */
    @Test
    public void toStringWithCommas8() {
        /*
         * Set up variables and call method under test
         */
        final String toTest = "2147483648";
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "2,147,483,648");
        assertEquals(toTest, n.toString()); // necessary to check if n is restored.
    }

    /**
     * Test for 9223372036854775809 as tough 10 digit case with six commas.
     * Tough because of the sheer size and above long limit in java.
     */
    @Test
    public void toStringWithCommas9() {
        /*
         * Set up variables and call method under test
         */
        final String toTest = "9223372036854775809";
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "9,223,372,036,854,775,809");
        assertEquals(toTest, n.toString()); // necessary to check if n is restored.
    }

    /**
     * Test for 1001 as tough 4 digit case with 1 commas. Tough because zeroes
     * in between.
     */
    @Test
    public void toStringWithCommas10() {
        /*
         * Set up variables and call method under test
         */
        final String toTest = "1001";
        NaturalNumber n = new NaturalNumber2(toTest);
        String str = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "1,001");
        assertEquals(toTest, n.toString()); // necessary to check if n is restored.
    }

}
