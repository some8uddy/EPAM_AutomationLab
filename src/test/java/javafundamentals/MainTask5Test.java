package javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTask5Test {

    @Test(expected = NumberFormatException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NumberFormatException {
        MainTask5.getMonth(new String[]{"asda"});
        MainTask5.getMonth(new String[]{"0"});
        MainTask5.getMonth(new String[]{"13"});
    }

    @Test
    public void getMonth() throws NumberFormatException {
        assertEquals("Январь", MainTask5.getMonth(new String[]{"1", "2", "3"}));
        assertEquals("Декабрь", MainTask5.getMonth(new String[]{"12"}));
    }
}