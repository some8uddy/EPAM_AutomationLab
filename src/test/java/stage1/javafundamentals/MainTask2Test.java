package stage1.javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTask2Test {

    @Test
    public void getReversedArgs() {
        assertEquals("3 2 1", MainTask2.getReversedArgs(new String[]{"1", "2", "3"}));
        assertEquals("Dow John", MainTask2.getReversedArgs(new String[]{"John", "Dow"}));
        assertEquals("", MainTask2.getReversedArgs(new String[]{}));
    }
}