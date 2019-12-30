package stage2.exceptions;

import org.junit.Test;
import stage2.exceptions.customexceptions.GradeOutOfBoundsException;
import stage2.exceptions.customexceptions.NoDisciplinesException;

import java.util.*;

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

    @Test
    public void getAverageMark() throws GradeOutOfBoundsException {
        Map<Discipline, Marks> academicPerformance = new HashMap<>();
        academicPerformance.put(new Discipline("Mathematics"), new Marks(Arrays.asList(1,2,3,4,5,6)));
        academicPerformance.put(new Discipline("Physics"), new Marks(Arrays.asList(10,9,8,7,6,5)));
        Student student = new Student("Bob","",null, academicPerformance);
        assertEquals(5.5, student.getAverageMark(), 0.001);
    }
}