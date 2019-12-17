package javacollections.optionaltasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

public class OptionalTask4 {

    public static void main(String[] args) {
        List<String> poem = new ArrayList<>();
        poem.add("По несчастью или к счастью,");
        poem.add("Истина проста:");
        poem.add("Никогда не возвращайся");
        poem.add("В прежние места.");
        poem.add("Даже если пепелище");
        poem.add("Выглядит вполне,");
        poem.add("Не найти того, что ищем,");
        poem.add("Ни тебе, ни мне.");

        System.out.println("До сортировки:\n--------------------");
        printList(poem);
        poem.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("\nПосле сортировки:\n--------------------");
        printList(poem);
    }

    private static void printList(List<String> poem) {
        for (String s : poem) {
            System.out.println(s);
        }
    }
}
