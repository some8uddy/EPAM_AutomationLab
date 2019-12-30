package stage1.javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class OptionalTask1_2Test {

    @Test
    public void swap() {
        String[] arr1 = {"b", "a"};
        String[] arr2 = {"a", "b"};
        OptionalTask1_2.swap(arr1, 0, 1);
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void sort() {
        String[] tmpArr = {"231233", "3245", "35635433", "1", "21", "123"};
        String[] sortedArr = {"1", "21", "123", "3245", "231233", "35635433"};
        OptionalTask1_2.sort(tmpArr);
        assertArrayEquals(sortedArr, tmpArr);
        tmpArr = new String[]{"1234", "123", "1", "12", "1", "123", "1", "1234", "1", "12345", "1", "12"};
        sortedArr = new String[]{"1", "1", "1", "1", "1", "12", "12", "123", "123", "1234", "1234", "12345"};
        OptionalTask1_2.sort(tmpArr);
        assertArrayEquals(sortedArr, tmpArr);
    }
}