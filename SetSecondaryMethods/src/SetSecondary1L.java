import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        // TODO - fill in body
        Set<T> temp = s.newInstance();
        temp.transferFrom(s);

        while (temp.size() > 0) {
            T x = temp.removeAny();// do something with x
            if (this.contains(x)) {
                this.remove(x);
            }
            s.add(x);

        }
        return s;

    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        // TODO - fill in body
        Set<T> temp = s.newInstance();
        temp.transferFrom(s);

        while (temp.size() > 0) {
            T x = temp.removeAny(); // do something with x
            this.add(x);
            s.add(x);

        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println();
        Set<Integer> a = new Set1L<>();
        for (int i = 0; i < 20; i++) {
            a.add(i);
        }

        Set<Integer> b = new Set1L<>();
        for (int i = 0; i < 20; i++) {
            if ((i & 1) == 1) {
                b.add(i);
            }
        }

        out.println(a);
        out.println(b);

        a.remove(b);

        out.println(a);
        out.println(b);

        out.close();

    }

}