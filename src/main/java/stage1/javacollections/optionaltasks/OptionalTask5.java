package stage1.javacollections.optionaltasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в
// конец, а положительные — в начало списка.

public class OptionalTask5 {

    public static void main(String[] args) {
        List<Integer> numbersList = getRandomFilledList();
        System.out.println("До перестановки:\n--------------------\n"
            + numbersList.toString());
        moveNegativesToEnd(numbersList);
        System.out.println("\nПосле перестановки:\n--------------------\n"
            + numbersList.toString());
    }

    private static void moveNegativesToEnd(List<Integer> listToSort) {
        int listSize = listToSort.size();
        for (int i = 0; i < listSize; i++) {
            if (listToSort.get(i) < 0) {
                listToSort.add(listToSort.remove(i--));
                listSize--;
            }
        }
    }

    private static List<Integer> getRandomFilledList() {
        List<Integer> listToBeFilled = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 40; i++) {
            listToBeFilled.add(random.nextInt(10) - 5);
        }
        return listToBeFilled;
    }
}
