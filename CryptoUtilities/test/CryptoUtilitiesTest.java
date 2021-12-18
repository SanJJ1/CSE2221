import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Sanjay Janardhan
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_5_11() {
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(11);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_LargerThanInteger() {
        NaturalNumber n = new NaturalNumber2("264140488587");
        NaturalNumber nExpected = new NaturalNumber2("264140488587");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_0_3_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber pExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_13_2_19() {
        NaturalNumber n = new NaturalNumber2(13);
        NaturalNumber nExpected = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isPrime2
     */

    // edge case
    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    @Test
    public void testIsPrime2_4() {
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber nExpected = new NaturalNumber2(4);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(false, isPrime);
    }

    public void testIsPrime2_71() {
        NaturalNumber n = new NaturalNumber2(71);
        NaturalNumber nExpected = new NaturalNumber2(71);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(false, isPrime);
    }

    @Test
    public void testIsPrime2_3303018663590467721789291() {
        NaturalNumber n = new NaturalNumber2("3303018663590467721789291");
        NaturalNumber nExpected = new NaturalNumber2(
                "3303018663590467721789291");
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    @Test
    public void testIsPrime2_140684214418742806905950016377713() {
        NaturalNumber n = new NaturalNumber2(
                "140684214418742806905950016377713");
        NaturalNumber nExpected = new NaturalNumber2(
                "140684214418742806905950016377713");
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(false, isPrime);
    }

    /*
     * Tests of generateNextLikelyPrime
     */

    // edge case
    @Test
    public void testGenerateNextLikelyPrime_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(3);
        CryptoUtilities.generateNextLikelyPrime(n);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    @Test
    public void testGenerateNextLikelyPrime_3() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber nExpected = new NaturalNumber2(5);
        CryptoUtilities.generateNextLikelyPrime(n);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    @Test
    public void testGenerateNextLikelyPrime_71() {
        NaturalNumber n = new NaturalNumber2(71);
        NaturalNumber nExpected = new NaturalNumber2(73);
        CryptoUtilities.generateNextLikelyPrime(n);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    @Test
    public void testGenerateNextLikelyPrime_6047() {
        NaturalNumber n = new NaturalNumber2(6047);
        NaturalNumber nExpected = new NaturalNumber2(6053);
        CryptoUtilities.generateNextLikelyPrime(n);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, isPrime);
    }

    /*
     * Test for isWitnessToCompositeness
     */
    @Test
    public void testIsWitnessToCompositeness_5_3() {
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber nExpected = new NaturalNumber2(4);
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        boolean isWit = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(nExpected, n);
        assertEquals(true, isWit);
    }

    @Test
    public void testIsWitnessToCompositeness_2348_123() {
        NaturalNumber n = new NaturalNumber2(2348);
        NaturalNumber nExpected = new NaturalNumber2(2348);
        NaturalNumber w = new NaturalNumber2(123);
        NaturalNumber wExpected = new NaturalNumber2(123);
        boolean isWit = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(nExpected, n);
        assertEquals(true, isWit);
    }

    @Test
    public void testIsWitnessToCompositeness_68719476736_16() {
        NaturalNumber n = new NaturalNumber2("68719476736");
        NaturalNumber nExpected = new NaturalNumber2("68719476736");
        NaturalNumber w = new NaturalNumber2(16);
        NaturalNumber wExpected = new NaturalNumber2(16);
        boolean isWit = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(nExpected, n);
        assertEquals(true, isWit);
    }

}