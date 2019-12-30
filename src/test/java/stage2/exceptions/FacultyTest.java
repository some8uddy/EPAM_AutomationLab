package stage2.exceptions;

import org.junit.Test;
import stage2.exceptions.customexceptions.NoGroupsOnFacultyException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FacultyTest {

    @Test(expected = NoGroupsOnFacultyException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoGroupsOnFacultyException {
        new Faculty("Name", null).getGroups();
        new Faculty("Name", null).removeGroup(new Group("SomeName", new HashSet<>()));
        new Faculty("Name", null).getGroupByName("SomeName");
        new Faculty("Name", new HashSet<>()).getGroups();
        new Faculty("Name", new HashSet<>()).removeGroup(new Group("SomeName", new HashSet<>()));
        new Faculty("Name", new HashSet<>()).getGroupByName("SomeName");
    }

    @Test
    public void testGetGroupByName() throws NoGroupsOnFacultyException {
        String groupName = "EE-1";
        String facultyName = "Science";
        Group testGroup = new Group(groupName, null);
        Faculty faculty = new Faculty(facultyName,new HashSet<>(Arrays.asList(testGroup)));
        assertEquals(testGroup, faculty.getGroupByName(groupName));
    }

    @Test
    public void testEquals() {
        assertEquals(new Faculty("Name", null), new Faculty("Name", new HashSet<>(Collections.emptySet())));
        assertNotEquals(new Faculty("Name", null), new Faculty("AnotherName", null));

        Set<Faculty> faculties =
            new HashSet<>(Arrays.asList(
                new Faculty("Name", null),
                new Faculty("AnotherName", null),
                new Faculty("Name", null)
            ));
        assertEquals(2, faculties.size());
    }

    @Test
    public void testHashCode() {
        assertEquals(new Faculty("Name", null), new Faculty("Name", new HashSet<>(Collections.emptySet())));
    }
}