package javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTask4Test {

    @Test(expected = NumberFormatException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws NumberFormatException {
        MainTask4.getSum(new String[]{"asda", "20", "30"});
        MainTask4.getProduct(new String[]{"asda", "20", "30"});
    }

    @Test
    public void getSum() throws NumberFormatException {
        assertEquals(new Integer(6), MainTask4.getSum(new String[]{"1", "2", "3"}));
        assertEquals(new Integer(0), MainTask4.getSum(new String[]{"10", "20", "-30"}));
        assertEquals(new Integer(60), MainTask4.getSum(new String[]{"10", "20", "30"}));
    }

    @Test
    public void getProd() throws NumberFormatException {
        assertEquals(new Integer(6), MainTask4.getProduct(new String[]{"1", "2", "3"}));
        assertEquals(new Integer(0), MainTask4.getProduct(new String[]{"10", "20", "0"}));
        assertEquals(new Integer(-6000), MainTask4.getProduct(new String[]{"10", "20", "-30"}));
    }
}