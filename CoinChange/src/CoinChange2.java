import java.util.Arrays;

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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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

        out.println("Enter the amount of cents you'd like to make change for:");
        int cents = in.nextInteger();

        final int[] denoms = { 100, 50, 25, 10, 5, 1 };
        final String[] denomNames = { "dollars", "half dollars", "quarters",
                "dimes", "nickels", "pennies" };
        int[] coinCounts = { 0, 0, 0, 0, 0, 0 };

        for (int i = 0; i < denoms.length; i++) {
            out.println(cents / denoms[i] + " " + denomNames[i]);
            coinCounts[i] += (cents / denoms[i]);
            cents %= denoms[i];
        }
        System.out.println(Arrays.toString(coinCounts));
//        for (int i : coinCounts) {
//            out.println(i);
//        }
//        final int dollar = 100;
//        final int halfDollar = 50;
//        final int quarter = 25;
//        final int dime = 10;
//        final int nickel = 5;
//        out.println((cents / dollar) + " dollars");
//        cents %= dollar;
//
//        out.println((cents / halfDollar) + " half dollars");
//        cents %= halfDollar;
//
//        out.println((cents / quarter) + " quarters");
//        cents %= quarter;
//
//        out.println((cents / dime) + " dimes");
//        cents %= dime;
//
//        out.println((cents / nickel) + " nickels");
//        cents %= nickel;
//
//        out.println(cents + " pennies");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
