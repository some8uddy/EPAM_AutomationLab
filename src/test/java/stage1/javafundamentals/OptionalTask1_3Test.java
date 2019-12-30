package stage1.javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionalTask1_3Test {

    @Test
    public void getAverageLength() {
        assertEquals(1.6, OptionalTask1_3.getAverageLength("2 33 44 df   ".split(" ")), 0.1);
        assertEquals(1.0, OptionalTask1_3.getAverageLength("   2    3   df 3".split(" ")), 0.1);
        assertEquals(2, OptionalTask1_3.getAverageLength("  22 dff  33 44 55 66  6df5  ".split(" ")), 0.1);
        assertEquals(0, OptionalTask1_3.getAverageLength("   ".split(" ")), 0.0);
        assertEquals(0, OptionalTask1_3.getAverageLength("".split(" ")), 0.0);
        assertEquals(0, OptionalTask1_3.getAverageLength(" sd sdf  rh   ".split(" ")), 0.0);
    }
}