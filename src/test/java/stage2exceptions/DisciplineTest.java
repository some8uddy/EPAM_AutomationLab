package stage2exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

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
    }

    @Test
    public void testHashCode() {
        assertEquals(new Discipline("Bio").hashCode(), new Discipline("Bio").hashCode());
    }
}