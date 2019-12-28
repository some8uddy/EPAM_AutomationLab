package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoStudentsInGroupException;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.*;

public class GroupTest {

    @Test(expected = NoStudentsInGroupException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoStudentsInGroupException {
        new Group("Name",null).getStudents();
        new Group("Name",null).removeStudent(new Student("Bob", "Smith", null, null));
        new Group("Name", new HashSet<>()).getStudents();
        new Group("Name", new HashSet<>()).removeStudent(new Student("Bob", "Smith", null, null));
    }

    @Test
    public void testEquals() {
        assertEquals(new Group("Name", null), new Group("Name", new HashSet<>(Collections.emptySet())));
        assertNotEquals(new Group("Name", null), new Group("AnotherName",null));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Group("Name", null), new Group("Name", new HashSet<>(Collections.emptySet())));
    }
}