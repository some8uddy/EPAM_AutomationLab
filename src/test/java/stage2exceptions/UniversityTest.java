package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoFacultiesException;
import java.util.HashSet;

public class UniversityTest {

    @Test(expected = NoFacultiesException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoFacultiesException {
        new University("Name",null, null).getFaculties();
        new University("Name",null, null).removeFaculty(new Faculty("SomeName", new HashSet<>()));
        new University("Name", new HashSet<>(), null).getFaculties();
        new University("Name",new HashSet<>(), null).removeFaculty(new Faculty("SomeName", new HashSet<>()));
    }
}