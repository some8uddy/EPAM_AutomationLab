package stage1.javacollections.maintask;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarsSweetsTest {

    private static Sweets candy = new BarsSweets("Umle", 20, 2.5, 3, 1.5);
    private static Sweets candy1 = new BarsSweets("Dumle", 30, 0, 5, 1.3);
    private static Sweets candy2 = new BarsSweets("Threemle", 40, 2, 7, 0);
    private static Sweets candy3 = new BarsSweets("Fourmle", 50, 2, 0, 7);

    @Test
    public void testCost() {
        assertEquals(4.5, candy.getCost(), 0.01);
        assertEquals(6.5, candy1.getCost(), 0.01);
        assertEquals(0, candy2.getCost(), 0.01);
        assertEquals(0, candy3.getCost(), 0.01);
    }

    @Test
    public void testOverallWeight() {
        assertEquals(7.5, candy.getOverallWeight(), 0.01);
        assertEquals(0, candy1.getOverallWeight(), 0.01);
        assertEquals(14, candy2.getOverallWeight(), 0.01);
        assertEquals(0, candy3.getOverallWeight(), 0.01);
    }

}