package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoFacultiesException;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

public class UniversityTest {

    @Test(expected = NoFacultiesException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoFacultiesException {
        new University("Name", null, null).getFaculties();
        new University("Name", null, null).removeFaculty(new Faculty("SomeName", new HashSet<>()));
        new University("Name", null, null).getFacultyByName("SomeName");
        new University("Name", new HashSet<>(), null).getFaculties();
        new University("Name", new HashSet<>(), null).removeFaculty(new Faculty("SomeName", new HashSet<>()));
        new University("Name", new HashSet<>(), null).getFacultyByName("SomeName");
    }

    @Test
    public void testGetFacultyByName() throws NoFacultiesException {
        String facultyName = "Science";
        Faculty testFaculty = new Faculty(facultyName, null);
        University university = new University("Name", new HashSet<>(Arrays.asList(testFaculty)), null);
        assertEquals(testFaculty, university.getFacultyByName(facultyName));
    }
}