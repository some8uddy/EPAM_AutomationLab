package stage2exceptions;

import org.junit.Test;
import stage2exceptions.exceptions.NoDisciplinesException;
import java.util.HashSet;

import static org.junit.Assert.*;

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
    }

}