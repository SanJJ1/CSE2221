import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

/**
 * Program to test Glossary Project.
 *
 * @author Sanjay Janardhan NOT COMPLETE.
 *
 */
public class GlossaryTest {

    /**
     * Testing nextWordOrSeparator method.
     */
    @Test
    public void nextWordOrSeparatorOnlyOneSeperator() {
        Set<Character> separators = new Set1L<Character>();
        separators.add(' ');
        separators.add(',');
        separators.add('\t');

        String text = ",";
        int position = 0;

        String result = Glossary.nextWordOrSeparator(text, position,
                separators);
        String expectedResult = ",";

        assertEquals(expectedResult, result);
    }

}
