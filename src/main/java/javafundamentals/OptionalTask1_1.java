package javafundamentals;

//1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

import java.util.Scanner;

public class OptionalTask1_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите несколько чисел через пробел и нажмите клавишу Ввод");

        String inputStr = scan.nextLine();
        String[] tmpArr = inputStr.split(" ");

        String shortest = getShortest(tmpArr);
        String longest = getLongest(tmpArr);

        if ("".equals(longest)) {
            System.out.println("Ни одного числа не найдено.");
        } else {
            System.out.println(
                "Самое короткое число " + shortest + ", длиной в " + shortest.length() + " разр.");
            System.out.println(
                "Самое длинное число " + longest + ", длиной в " + longest.length() + " разр.");
        }
    }

    static String getLongest(String[] strings) {
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            String nextRec = strings[i].trim();
            if (isNumeric(nextRec)) {
                if (nextRec.length() > result.length()) {
                    result = nextRec;
                }
            }
        }
        return result;
    }

    static String getShortest(String[] strings) {
        String result =
            "                                                                                         "
                +
                "                                                                                                   "
                +
                "                                                                                                   "
                +
                "                                                                                                   "
                +
                "                                                                                                   "
                +
                "                                                                                                   ";
        for (int i = 0; i < strings.length; i++) {
            String nextRec = strings[i].trim();
            if (isNumeric(nextRec)) {
                if (nextRec.length() < result.length()) {
                    result = nextRec;
                }
            }
        }
        return result;
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
