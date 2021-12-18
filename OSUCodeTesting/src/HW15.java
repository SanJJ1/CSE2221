import java.util.concurrent.ThreadLocalRandom;

import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class HW15 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW15() {
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *     where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {
        int x;
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < q.length(); i++) {
            x = q.dequeue();
            if (m > x) {
                m = x;
            }
            q.enqueue(x);

        }
        return m;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        int x;
        int[] m = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        for (int i = 0; i < q.length(); i++) {
            x = q.dequeue();
            if (m[0] > x) {
                m[0] = x + 0;
            }
            if (m[1] < x) {
                m[1] = x + 0;
            }
            q.enqueue(x);

        }
        return m;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}. Using the Noah's Ark
     * Algorithm.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMaxNoah(Queue<Integer> q) {
        int[] m = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        for (int i = 0; i < q.length(); i++) {
            int x = q.dequeue();
            int y = q.dequeue();
            if (x < y) {
                if (m[0] > x) {
                    m[0] = x + 0;
                }
                if (m[1] < y) {
                    m[1] = y + 0;
                }
            } else {
                if (m[0] > y) {
                    m[0] = y + 0;
                }
                if (m[1] < x) {
                    m[1] = x + 0;
                }
            }

            q.enqueue(x);
            q.enqueue(y);

        }
        return m;
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

        Queue<Integer> qi = new Queue1L<>();
        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 1001);
            qi.enqueue(randomNum);
        }
        out.println("Before: " + qi);

        out.println(min(qi));
        int[] a = minAndMax(qi);
        out.println(a[0] + " " + a[1]);

        out.println("After: " + qi);

        in.close();
        out.close();
    }

}
