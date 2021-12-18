import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Sanjay Janardhan
 *
 */
public final class HW18 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW18() {
    }

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        String m = q.front();
        for (String s : q) {
            if (order.compare(s, m) < 0) {
                m = s + "";
            }
        }
        boolean removed = false;
        for (int i = 0; i <= q.length(); i++) {
            String k = q.dequeue();
            if (order.compare(m, k) == 0 && !removed) {
                removed = true;

            } else {
                q.enqueue(k);
            }
        }
        return m;
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        Queue<String> temp = new Queue1L<String>();
        int l = q.length();
        for (int i = 0; i < l; i++) {
            temp.enqueue(removeMin(q, order));
        }
        q.transferFrom(temp);
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

        Queue<String> q2 = new Queue1L<String>();

        q2.enqueue("g");
        q2.enqueue("d");
        q2.enqueue("a");
        q2.enqueue("f");
        q2.enqueue("s");
        q2.enqueue("z");
        q2.enqueue("c");

        Comparator<String> ci = new StringLT();
        out.println(q2);
        String m = removeMin(q2, ci);
        out.println(m);
        out.println(q2);
        q2.enqueue(m);

        sort(q2, ci);
        out.println(q2);

        in.close();
        out.close();
    }

}
