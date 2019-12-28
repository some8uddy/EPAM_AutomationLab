package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.GradeOutOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;

public class MarksTest {

    @Test(expected = GradeOutOfBoundsException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws GradeOutOfBoundsException {
        new Marks(Arrays.asList(1, 2, -1, 1));
        new Marks(new ArrayList<>()).setMarks(Arrays.asList(2, 2, 10, 11));
        new Marks(new ArrayList<>()).addMark(11);
        new Marks(new ArrayList<>()).addMark(-1);
    }
}