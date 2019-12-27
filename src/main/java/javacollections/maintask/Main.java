package javacollections.maintask;

// 2. Новогодний подарок. Определить иерархию конфет и прочих сладостей.
//    Создать несколько объектов-конфет. Собрать детский подарок с определением его веса.
//    Провести сортировку конфет в подарке на основе одного из параметров.
//    Найти конфету в подарке, соответствующую заданному диапазону содержания сахара.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Gift gift =
            new Gift(
                new ArrayList<>(
                    Arrays.asList(
                        new BulkSweets("Umle", 43, 0.15, 1.0),
                        new BulkSweets("Dumle", 37, 0.3, 1.05),
                        new BulkSweets("Threemle", 40, 0.25, 0.95),
                        new BarsSweets("Mars", 68, 0.05, 1, 1.1),
                        new BarsSweets("Snickers", 48.5, 0.095, 2, 1.2),
                        new BarsSweets("Bounty", 50.2, 0.09, 3, 1.3),
                        new BarsSweets("Twix", 49.5, 0.055, 4, 1.4))));


        Scanner scanner = new Scanner(System.in);
        System.out.println("\nСодержимое подарка:");
        gift.printSweets();
        sortAndPrintGift(gift, scanner);
        filterBySugarContent(gift, scanner);
    }

    private static void filterBySugarContent(Gift gift, Scanner scanner) {
        while (true) {
            System.out.println("\nФильтрация по содержанию сахара. Введите диапазон (два числа через пробел), 0-ВЫХОД:");
            String inputStr = scanner.nextLine();
            String[] inputs = inputStr.split(" ");
            if (isNumeric(inputs[0]) && Integer.parseInt(inputs[0]) == 0) break;

            Gift filteredGift = new Gift();
            double rangeFrom = 0;
            double rangeTo = 0;

            if (inputs.length == 2 && isNumeric(inputs[1])) {
                rangeFrom = Double.parseDouble(inputs[0]);
                rangeTo = Double.parseDouble(inputs[1]);
                System.out.println(
                    "\nРезультат фильтрации для для уровня сахара между "
                        + rangeFrom + " и " + rangeTo + ":");
                filteredGift = gift.filterBySugarContent(rangeFrom, rangeTo);
            }

            if (filteredGift.getSweets().isEmpty()) {
                System.out.println("         --результат отсутствует, попробуйте изменить границы диапазона-- ");
            } else {
                gift.filterBySugarContent(rangeFrom, rangeTo).printSweets();
            }
        }
    }

    private static void sortAndPrintGift(Gift gift, Scanner scanner) {
        while (true) {
            System.out.println("\nОпции сортировки (введите цифру и нажмите ввод):\n "
                + "1-по содержанию сахара, 2-по весу конфет, 3-по цене, 4-по стоимости, 0-ВЫХОД ИЗ СОРТИРОВКИ");
            String inputStr = scanner.nextLine();
            if (isNumeric(inputStr)) {
                int option = Integer.parseInt(inputStr);
                if (option == 0) break;
                switch (option) {
                    case (1):
                        gift.sortBySugarContent();
                        System.out.println("\nСортировка по содержанию сахара:");
                        break;
                    case (2):
                        gift.sortByOverallWeight();
                        System.out.println("\nСортировка по весу конфет:");
                        break;
                    case (3):
                        gift.sortByPrice();
                        System.out.println("\nСортировка по цене:");
                        break;
                    case (4):
                        gift.sortByCost();
                        System.out.println("\nСортировка по стоимости:");
                        break;
                    default:
                        System.out.println("\nСодержимое подарка:");
                }
            } else {
                System.out.println("\nСодержимое подарка:");
            }
            gift.printSweets();
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
