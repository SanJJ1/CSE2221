import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW20 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW20() {
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @param <T>
     * @param s
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public static <T> void flip(Stack<T> s) {
        Stack<T> temp = new Stack1L<>();
        while (s.length() > 0) {
            temp.push(s.pop());
        }
        s.transferFrom(temp);
    }

//    /**
//     * Reverses ("flips") {@code this}.
//     *
//     * @updates this
//     * @ensures this = rev(#this)
//     */
//    public void flip() {
//        Stack<T> temp = new Stack1L<>();
//        while (this.length() > 0) {
//            temp.push(this.pop());
//        }
//        this.transferFrom(temp);
//    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        Stack<Integer> test = new Stack1L<>();
//        test.push(3);
//        test.push(7);
//        test.push(1);
//        test.push(2);
//        test.push(6);
        out.println(test);
        flip(test);
        out.println(test);

        in.close();
        out.close();
    }

}
