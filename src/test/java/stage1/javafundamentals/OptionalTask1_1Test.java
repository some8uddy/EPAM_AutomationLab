package stage1.javafundamentals;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalTask1_1Test {

    @Test
    public void getLongest() {
        assertEquals("123", OptionalTask1_1.getLongest(new String[]{"1", "123", "12", "dfsdfks"}));
        assertEquals("123.123", OptionalTask1_1.getLongest(new String[]{"1", "123", "12", "dfsdfks", "123.123", "123456"}));
    }

    @Test
    public void getShortest() {
        assertEquals("1", OptionalTask1_1.getShortest(new String[]{"1", "123", "12", "dfsdfks"}));
        assertEquals("9", OptionalTask1_1.getShortest(new String[]{"11", "123", "12", "dfsdfks", "9", "123.123", "123456"}));
    }

    @Test
    public void isNumeric() {
        assertTrue(OptionalTask1_1.isNumeric("123"));
        assertTrue(OptionalTask1_1.isNumeric("123.123"));
        assertFalse(OptionalTask1_1.isNumeric("sdfs"));
        assertFalse(OptionalTask1_1.isNumeric("1sdfs"));
        assertFalse(OptionalTask1_1.isNumeric(""));
    }
}