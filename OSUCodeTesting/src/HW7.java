import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author S. Janardhan
 */
public final class HW7 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW7() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
//        1a
//        String s = in.nextLine();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isUpperCase(s.charAt(i))) {
//                out.print(s.charAt(i));
//            }
//        }

//        1b
//        String s = in.nextLine();
//        for (int i = 0; i < s.length(); i++) {
//            if (i % 2 == 0) {
//                out.print(s.charAt(i));
//            }
//        }
//

//        1c
//        String temp = in.nextLine();
//        String vowels = "aeiouAEIOU";
//        String s = "";
//        for (int i = 0; i < temp.length(); i++) {
//            if (vowels.indexOf(temp.charAt(i)) >= 0) {
//                s += "_";
//            } else {
//                s += temp.charAt(i);
//
//            }
//        }
//        out.print(s);

//        1d
//        String s = in.nextLine();
//        String vowels = "aeiouAEIOU";
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (vowels.indexOf(s.charAt(i)) > 0) {
//                count++;
//            }
//        }
//        out.print(count);

//        1e
//        String s = in.nextLine();
//        String vowels = “aeiouAEIOU”;
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (vowels.indexOf(scharAt(i)) > 0) {
//                out.print(i);
//            }
//        }
        int[] a = { 1, 2, 3, 3 };

//        question 3
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//
//        for (int j : a) {
//            if (j > max) {
//                max = j;
//            }
//            if (j < min) {
//                min = j;
//            }
//        }
//        out.print(max + " : " + min);

        boolean isOrdered = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                isOrdered = false;
            }
        }
        out.print(isOrdered);

        out.print("[");
        for (int j : a) {
            out.print(j + ", ");
        }
        out.print("]");

        in.close();
        out.close();
    }

}
