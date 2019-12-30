package stage2.exceptions;

import org.junit.Test;
import stage2.exceptions.customexceptions.GradeOutOfBoundsException;
import stage2.exceptions.customexceptions.NoStudentsInGroupException;

import java.util.*;

import static org.junit.Assert.*;

public class GroupTest {

    @Test(expected = NoStudentsInGroupException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoStudentsInGroupException {
        new Group("Name", null).getStudents();
        new Group("Name", null).removeStudent(new Student("Bob", "Smith", null, null));
        new Group("Name", null).getMarksByDiscipline(new Discipline("Mathematics"));
        new Group("Name", new HashSet<>()).getStudents();
        new Group("Name", new HashSet<>()).removeStudent(new Student("Bob", "Smith", null, null));
        new Group("Name", new HashSet<>()).getMarksByDiscipline(new Discipline("Mathematics"));
    }

    @Test
    public void testGetMarksByDiscipline() throws GradeOutOfBoundsException, NoStudentsInGroupException {
        Map<Discipline, Marks> academicPerformance = new HashMap<>();
        academicPerformance.put(new Discipline("Mathematics"), new Marks(Arrays.asList(1,2,3,4,5,6)));
        academicPerformance.put(new Discipline("Physics"), new Marks(Arrays.asList(10,9,8,7)));
        Student student1 = new Student("Bob","",null, academicPerformance);
        Student student2 = new Student("John","",null, academicPerformance);
        Group group = new Group("EE-1", new HashSet<>(Arrays.asList(student1, student2)));
        assertEquals(12, group.getMarksByDiscipline(new Discipline("Mathematics")).size());
        assertEquals(8, group.getMarksByDiscipline(new Discipline("Physics")).size());
        assertTrue(group.getMarksByDiscipline(new Discipline("Mathematics")).contains(1));
        assertFalse(group.getMarksByDiscipline(new Discipline("Mathematics")).contains(10));
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