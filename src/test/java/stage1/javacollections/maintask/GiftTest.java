package stage1.javacollections.maintask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GiftTest {

    private static Sweets candy = new BulkSweets("Umle", 43, 0.15, 1.0);
    private static Sweets candy1 = new BulkSweets("Dumle", 37, 0.3, 1.05);
    private static Sweets candy2 = new BulkSweets("Threemle", 40, 0.25, 0.95);

    private static Sweets candy3 = new BarsSweets("Mars", 68, 0.05, 1, 1.1);
    private static Sweets candy4 = new BarsSweets("Snickers", 48.5, 0.095, 2, 1.2);
    private static Sweets candy5 = new BarsSweets("Bounty", 50.2, 0.09, 3, 1.3);
    private static Sweets candy6 = new BarsSweets("Twix", 49.5, 0.055, 4, 1.4);

    private static Gift gift;

    @Test
    public void testAddCandy() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);

        assertEquals(candy, gift.getSweets().get(0));
        assertEquals(candy1, gift.getSweets().get(1));
        assertEquals(candy2, gift.getSweets().get(2));
    }

    @Test
    public void testRemoveCandy() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);

        assertEquals(3, gift.getSweets().size());
        assertEquals(candy, gift.removeCandy(0));
        assertEquals(candy1, gift.removeCandy(0));
        assertEquals(candy2, gift.removeCandy(0));
        assertEquals(0, gift.getSweets().size());
    }

    @Test
    public void testRemoveLast() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);
        gift.addCandy(candy3);
        gift.addCandy(candy4);

        assertEquals(5, gift.getSweets().size());
        assertEquals(candy4, gift.removeLast());
        assertEquals(candy3, gift.removeLast());
        assertEquals(candy2, gift.removeLast());
        assertEquals(candy1, gift.removeLast());
        assertEquals(candy, gift.removeLast());
        assertEquals(0, gift.getSweets().size());
    }

    @Test
    public void testGetSweets() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);
        gift.addCandy(candy3);
        gift.addCandy(candy4);

        List<Sweets> testList = new ArrayList<>();
        testList.add(candy);
        testList.add(candy1);
        testList.add(candy2);
        testList.add(candy3);
        testList.add(candy4);

        assertEquals(candy, gift.getSweets().get(0));
        assertEquals(candy4, gift.getSweets().get(4));
        assertEquals(testList.size(), gift.getSweets().size());
    }

    @Test
    public void testGetGiftWeight() {
        gift = new Gift();
        gift.addCandy(candy);
        assertEquals(0.15, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy1);
        assertEquals(0.45, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy2);
        assertEquals(0.7, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy3);
        assertEquals(0.75, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy4);
        assertEquals(0.94, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy5);
        assertEquals(1.21, gift.getGiftWeight(), 0.01);

        gift.addCandy(candy6);
        assertEquals(1.43, gift.getGiftWeight(), 0.01);
    }

    @Test
    public void testGetGiftCost() {
        gift = new Gift();
        gift.addCandy(candy);
        assertEquals(0.15, gift.getGiftCost(), 0.01);

        gift.addCandy(candy1);
        assertEquals(0.465, gift.getGiftCost(), 0.01);

        gift.addCandy(candy2);
        assertEquals(0.7025, gift.getGiftCost(), 0.00001);

        gift.addCandy(candy3);
        assertEquals(1.8025, gift.getGiftCost(), 0.00001);

        gift.addCandy(candy4);
        assertEquals(4.2025, gift.getGiftCost(), 0.00001);

        gift.addCandy(candy5);
        assertEquals(8.1025, gift.getGiftCost(), 0.00001);

        gift.addCandy(candy6);
        assertEquals(13.7025, gift.getGiftCost(), 0.00001);
    }

    @Test
    public void testSorting() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);
        gift.addCandy(candy3);
        gift.addCandy(candy4);
        gift.addCandy(candy5);
        gift.addCandy(candy6);

        gift.sortBySugarContent();
        assertEquals(candy1, gift.getSweets().get(0));
        assertEquals(candy3, gift.getSweets().get(6));

        gift.sortByOverallWeight();
        assertEquals(candy3, gift.getSweets().get(0));
        assertEquals(candy1, gift.getSweets().get(6));

        gift.sortByPrice();
        assertEquals(candy2, gift.getSweets().get(0));
        assertEquals(candy6, gift.getSweets().get(6));

        gift.sortByCost();
        assertEquals(candy, gift.getSweets().get(0));
        assertEquals(candy6, gift.getSweets().get(6));
    }

    @Test
    public void testFilterBySugarContent() {
        gift = new Gift();
        gift.addCandy(candy);
        gift.addCandy(candy1);
        gift.addCandy(candy2);
        gift.addCandy(candy3);
        gift.addCandy(candy4);
        gift.addCandy(candy5);
        gift.addCandy(candy6);

        Gift filteredGift = gift.filterBySugarContent(20, 30);
        assertEquals(0, filteredGift.getSweets().size());

        filteredGift = gift.filterBySugarContent(40, 40);
        assertEquals(1, filteredGift.getSweets().size());
        assertEquals(candy2, filteredGift.getSweets().get(0));

        filteredGift = gift.filterBySugarContent(50, 40);
        assertEquals(4, filteredGift.getSweets().size());
        assertEquals(candy, filteredGift.getSweets().get(0));
        assertEquals(candy2, filteredGift.getSweets().get(1));
        assertEquals(candy4, filteredGift.getSweets().get(2));
        assertEquals(candy6, filteredGift.getSweets().get(3));
    }
}