package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoDisciplinesException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StudentTest {

    @Test(expected = NoDisciplinesException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NoDisciplinesException {
        new Student("Name", "Surname", null, null).getDisciplines();
        new Student("Name", "Surname", null, null)
            .removeDiscipline(new Discipline("Bio"));
        new Student("Name", "Surname", new HashSet<>(), null).getDisciplines();
        new Student("Name", "Surname", new HashSet<>(), null)
            .removeDiscipline(new Discipline("Bio"));
    }

    @Test
    public void testEquals() {
        assertNotEquals(new Student("Name", null, null, null),
            new Student("Name", null, null, null));
        Set<Student> students =
            new HashSet<>(Arrays.asList(
                new Student(null, null, null, null),
                new Student(null, null, null, null),
                new Student(null, null, null, null)
            ));
        assertEquals(3, students.size());
    }

}