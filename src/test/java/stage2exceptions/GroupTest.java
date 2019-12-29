package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoStudentsInGroupException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GroupTest {

    @Test(expected = NoStudentsInGroupException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoStudentsInGroupException {
        new Group("Name", null).getStudents();
        new Group("Name", null).removeStudent(new Student("Bob", "Smith", null, null));
        new Group("Name", new HashSet<>()).getStudents();
        new Group("Name", new HashSet<>()).removeStudent(new Student("Bob", "Smith", null, null));
    }

    @Test
    public void testEquals() {
        assertEquals(new Group("Name", null), new Group("Name", new HashSet<>(Collections.emptySet())));
        assertNotEquals(new Group("Name", null), new Group("AnotherName", null));

        Set<Group> groups =
            new HashSet<>(Arrays.asList(
                new Group("Name", null),
                new Group("AnotherName", null),
                new Group("Name", null)
            ));
        assertEquals(2, groups.size());
    }

    @Test
    public void testHashCode() {
        assertEquals(new Group("Name", null), new Group("Name", new HashSet<>(Collections.emptySet())));
    }
}