import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Prompts the user for their name and outputs it right after
 *
 * @author S.Janardhan
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
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
        out.println("What is your name? \nEnter here:");
        String s = in.nextLine();
        out.println("Hello " + s);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
