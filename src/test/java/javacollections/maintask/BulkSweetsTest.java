package javacollections.maintask;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BulkSweetsTest {

    private static Sweets candy = new BulkSweets("Umle", 20, 2, 1.5);
    private static Sweets candy1 = new BulkSweets("Dumle", 30, 0, 1.5);
    private static Sweets candy2 = new BulkSweets("Threemle", 40, 2.2, 1.5);

    @Test
    public void testCost() {
        assertEquals(3, candy.getCost(), 0.01);
        assertEquals(0, candy1.getCost(), 0.01);
        assertEquals(3.3, candy2.getCost(), 0.01);
    }
}