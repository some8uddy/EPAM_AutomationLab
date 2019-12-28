package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoGroupsOnFacultyException;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FacultyTest {

    @Test(expected = NoGroupsOnFacultyException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoGroupsOnFacultyException {
        new Faculty("Name",null).getGroups();
        new Faculty("Name",null).removeGroup(new Group("SomeName", new HashSet<>()));
        new Faculty("Name", new HashSet<>()).getGroups();
        new Faculty("Name",new HashSet<>()).removeGroup(new Group("SomeName", new HashSet<>()));
    }

    @Test
    public void testEquals() {
        assertEquals(new Faculty("Name", null), new Faculty("Name", new HashSet<>(Collections.emptySet())));
        assertNotEquals(new Faculty("Name", null), new Faculty("AnotherName",null));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Faculty("Name", null), new Faculty("Name", new HashSet<>(Collections.emptySet())));
    }
}