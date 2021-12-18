import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Sanjay Janardhan
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        String s = exp.label();
        NaturalNumber returnValue = new NaturalNumber2(0);
        if (s.equals("number")) {
            int number = Integer.parseInt(exp.attributeValue("value"));
            if (number < 0) {
                Reporter.fatalErrorToConsole("Divide by zero");
            }
            returnValue.setFromInt(number);

        } else if (s.equals("plus")) {
            returnValue.transferFrom(evaluate(exp.child(0)));
            returnValue.add(evaluate(exp.child(1)));

        } else if (s.equals("minus")) {
            // Errors if the difference will be negative.
            returnValue.transferFrom(evaluate(exp.child(0)));
            NaturalNumber subtrahend = evaluate(exp.child(1));
            if (returnValue.compareTo(subtrahend) == -1) {
                Reporter.fatalErrorToConsole(
                        "Subtracting results in negative number");
            }
            returnValue.subtract(subtrahend);

        } else if (s.equals("times")) {
            returnValue.transferFrom(evaluate(exp.child(0)));
            returnValue.multiply(evaluate(exp.child(1)));

        } else if (s.equals("divide")) {
            // Errors if the divisor is negative or zero.
            returnValue.transferFrom(evaluate(exp.child(0)));
            NaturalNumber divisor = evaluate(exp.child(1));

            if (divisor.compareTo(new NaturalNumber2(0)) == -1) {
                Reporter.fatalErrorToConsole("Divide by negative");
            }
            if (divisor.compareTo(new NaturalNumber2(0)) == 0) {
                Reporter.fatalErrorToConsole("Divide by zero");
            }
            returnValue.divide(divisor);
        }
        return returnValue;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
