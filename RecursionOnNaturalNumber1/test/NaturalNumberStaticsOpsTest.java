import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for NaturalNumberStaticsOps.
 *
 * @author Sanjay Janardhan
 *
 */
public class NaturalNumberStaticsOpsTest {

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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
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
        String str = NaturalNumberStaticOps.toStringWithCommas(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(str, "2,147,483,645");
        assertEquals(toTest, n.toInt()); // necessary to check if n is restored.
    }
}
