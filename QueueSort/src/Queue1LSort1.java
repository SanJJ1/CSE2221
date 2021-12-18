import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
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
     * (q * <removeMin>) is permutation of #q  and
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

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        // TODO - fill in body
        Queue<String> temp = new Queue1L<String>();
        int l = this.length();
        for (int i = 0; i < l; i++) {
            temp.enqueue(removeMin(this, order));
        }
        this.transferFrom(temp);

    }

}