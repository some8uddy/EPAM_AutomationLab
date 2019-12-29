package stage2exceptions;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DisciplineTest {

    @Test
    public void testGetName() {
        Discipline discipline = new Discipline("Math");
        assertEquals("Math", discipline.getName());
    }

    @Test
    public void testSetName() {
        Discipline discipline = new Discipline("Math");
        discipline.setName("Bio");
        assertEquals("Bio", discipline.getName());
    }

    @Test
    public void testEquals() {
        assertEquals(new Discipline("Bio"), new Discipline("Bio"));
        assertNotEquals(new Discipline("Bio"), new Discipline("Math"));

        Set<Discipline> disciplineSet =
            new HashSet<>(Arrays.asList(
                new Discipline("Math"),
                new Discipline("Bio"),
                new Discipline("Math")
            ));
        assertEquals(2, disciplineSet.size());
    }

    @Test
    public void testHashCode() {
        assertEquals(new Discipline("Bio").hashCode(), new Discipline("Bio").hashCode());
    }
}