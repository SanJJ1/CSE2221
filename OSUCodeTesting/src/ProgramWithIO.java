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
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
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

//        final int n = 100;

        //Print all squares less than n. For example, if n is 100,
        //print 0 1 4 9 16 25 36 49 64 81.
//        int i = 0;
//        while (i * i < n) {
//            out.println(i * i);
//            i++;
//        }

        //print numbers divisible by 10 and less thatn 100
//        int i = 1;
//        final int j = 10;
//        while (i < n) {
//            if (i % j == 0) {
//                out.println(i);
//            }
//            i++;
//        }

        //print all powers of two less than n
//        int i = 0;
//        while (Math.pow(2, i) < n) {
//            out.println(Math.pow(2, i));
//            i++;
//        }

//        int s = 0;
//        for (int i = 1; i <= 10; i++) {
//            s = s + i;
//            out.println(s);
//        }
//
        int i = 0;
        int s = 0;
        while (i < 10) {
            i++;
            s = s + i;
            out.println(s);
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
