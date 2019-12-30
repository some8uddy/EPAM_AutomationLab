package stage2.exceptions;

import org.junit.Test;
import stage2.exceptions.customexceptions.GradeOutOfBoundsException;

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