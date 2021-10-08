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
public final class CheckPassord {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassord() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param pwCandidate
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String pwCandidate, SimpleWriter out) {
        int conditionsSatisfied = 0;
        String pwPasses = "";
        String pwProblems = "";
        final int minimumPwLength = 8;
        if (pwCandidate.length() < minimumPwLength + 1) {
            conditionsSatisfied -= Integer.MAX_VALUE;
            pwProblems += "\npassword is not at least 8 characters.";
        }
        if (containsUpperCaseLetter(pwCandidate)) {
            conditionsSatisfied++;
        } else {
            pwProblems += "\npassword should contain at least 1 uppercase character";
        }
        if (containsLowerCaseLetter(pwCandidate)) {
            conditionsSatisfied++;
        } else {
            pwProblems += "\npassword should contain at least 1 lowercase character";
        }
        if (containsDigit(pwCandidate)) {
            conditionsSatisfied++;
        } else {
            pwProblems += "\npassword should contain at least 1 digit";
        }
        if (conditionsSatisfied > 1) {
            pwPasses = "Your password is good enough";
            if (pwProblems.length() > 1) {
                pwPasses += ", but your";
            } else {
                pwPasses += ".";
            }
        } else {
            pwPasses = "Your password is not good enough.";

        }
        out.println(pwPasses + pwProblems);

    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean containsUpperCase = false;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            }
        }
        return containsUpperCase;
    }

    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        boolean containsLowerCase = false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            }
        }
        return containsLowerCase;

    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigit(String s) {
        boolean containsDigit = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
            }
        }
        return containsDigit;

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
        out.println("enter your password:");
        String password = in.nextLine();
        checkPassword(password, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
