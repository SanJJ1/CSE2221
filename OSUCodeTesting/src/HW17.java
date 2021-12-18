import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW17 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW17() {
    }

//    /**
//     * Reverses ("flips") {@code this}.
//     *
//     * @updates this
//     * @ensures this = rev(#this)
//     */
//    public void flip() {
//        if (this.length() > 0) {
//            T data = this.dequeue();
//            this.flip();
//            this.enqueue(data);
//        }
//    }

    /**
     * Reverses ("flips") {@code q}.
     *
     * @param <T>
     * @param q
     *
     * @updates q
     * @ensures q = rev(#q)
     */
    public static <T> void flip(Queue<T> q) {
        if (q.length() > 0) {
            T temp = q.dequeue();
            flip(q);
            q.enqueue(temp);
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

        in.close();
        out.close();
    }

}
