import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Glossary Project.
 *
 * @author Sanjay Janardhan
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
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
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        charSet.clear();
        for (Character c : str.toCharArray()) {
            if (!charSet.contains(c)) {
                charSet.add(c);
            }
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        String value = "";
        int index = position;
        if (separators.contains(text.charAt(position))) {
            while (separators.contains(text.charAt(index))) {
                index++;
            }
            value = text.substring(position, index);
        } else {
            while (!separators.contains(text.charAt(index))) {
                index++;
            }
            value = text.substring(position, index);
        }
        return value;
    }

    /**
     * Takes the the term and a map containing all terms and definitions and the
     * output folder. Outputs an html file with the term and definition in the
     * output folder.
     *
     * @param term
     *            the term for which the page is being created
     * @param m
     *            the map containing all the terms and definitions
     * @param folder
     *            the output folder of all the html files
     * @updates out.content
     * @requires [term has no spaces] and out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML page with the term and definition]
     * </pre>
     */
    public static void createPage(String term, Map<String, String> m,
            String folder) {
        SimpleWriter out = new SimpleWriter1L(folder + "//" + term + ".html");

        // Prints header
        out.println("<html>\n<head>\n\t<title>" + term + "</title>\n</head>");

        // Prints term
        out.println("<body>\n<h2><b><i><font color=\"red\">" + term
                + "</font></i></b></h2>\n");

        // Prints definition
        out.print("<blockquote>");

        int position = 0;
        String def = m.value(term);
        Set<Character> seps = new Set1L<Character>();
        generateElements(" \t,.", seps);
        while (position < def.length() - 1) {
            String token = nextWordOrSeparator(def, position, seps);
            if (m.hasKey(token)) {
                out.println("<a href=\"" + token + ".html\">" + token + "</a>");
            } else {
                out.println(token);
            }
            position += token.length();
        }

        out.print("</blockquote>\n");

        // Prints footer
        out.println("<hr />\r\n<p>Return to <a href=\"index.html\">index</a>."
                + "</p>\r\n</body>\r\n</html>");

        out.close();
    }

    /**
     * Takes the queue of terms and an output folder, and creates an html file
     * in the output folder with a list of all the terms hyperlinked.
     *
     * @param terms
     *            the queue with all the terms
     * @param folder
     *            the output folder of all the html files
     * @updates out.content
     * @requires out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML page with the terms]
     * </pre>
     */
    public static void indexPage(Queue<String> terms, String folder) {

        SimpleWriter out = new SimpleWriter1L(folder + "//index.html");

        // Prints header
        out.println("<html>\r\n" + "<head>\r\n" + "<title>Glossary</title>\r\n"
                + "</head>");

        // Prints body header
        out.println("<body>\r\n" + "<h2>Glossary</h2>\r\n" + "<hr />\r\n"
                + "<h3>Index</h3>\r\n" + "<ul>");

        // Prints term page links
        Queue<String> temp = new Queue1L<String>();
        while (terms.length() > 0) {
            String term = terms.dequeue();
            out.println(
                    "<li><a href=\"" + term + ".html\">" + term + "</a></li>");
            temp.enqueue(term);
        }
        terms.transferFrom(temp);

        // Prints footer
        out.println("</ul>\r\n" + "</body>\r\n" + "</html>");

        out.close();
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
         * Put your main program code here; it may call myMethod as shown
         */
        out.println("Enter the input file name:");
        String ifname = in.nextLine();

        SimpleReader fin = new SimpleReader1L(ifname);

        out.println("Enter the output folder name:");
        String oFname = in.nextLine();

        Queue<String> terms = new Queue1L<String>();
        Map<String, String> m = new Map1L<>();

        while (!fin.atEOS()) {
            String term = fin.nextLine();
            terms.enqueue(term);
            String definition = "";
            String line = "";
            do {
                line = fin.nextLine();
                definition += " " + line;
            } while (line != "");

            m.add(term, definition);
        }

        Comparator<String> ci = new StringLT();
        sort(terms, ci);

        // Creates index page
        indexPage(terms, oFname);

        // Iterates through terms, and creates page for each term
        Queue<String> temp = new Queue1L<String>();
        while (terms.length() > 0) {
            String term = terms.dequeue();
            createPage(term, m, oFname);

            temp.enqueue(term);
        }
        terms.transferFrom(temp);

        /*
         * Close input and output streams
         */
        fin.close();
        in.close();
        out.close();
    }

}
