package stage1.javafundamentals;

//3. Вывести на консоль те числа, длина которых меньше средней длины по всем числам, а также длину.

import java.util.Scanner;

public class OptionalTask1_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите числа через пробел и нажмите клавишу Ввод.");
        String inputStr = scan.nextLine();

        String[] str = inputStr.split(" ");
        double avLength =
            Math.round(getAverageLength(str) * 100) / 100.0;          //two decimal places format
        System.out.println("Средняя длина чисел: " + avLength);
        System.out.println("Числа короче средней длины: ");
        prntNumbersShorterThanAverage(str, avLength);
    }

    static void prntNumbersShorterThanAverage(String[] str, double avLength) {
        for (int i = 0; i < str.length; i++) {
            String tmp = str[i].trim();
            if (OptionalTask1_1.isNumeric(tmp) && tmp.length() < avLength) {
                System.out.print(str[i] + " ");
            }
        }
    }

    static double getAverageLength(String[] str) {
        int fullLength = 0;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (OptionalTask1_1.isNumeric(str[i].trim())) {
                fullLength += str[i].trim().length();
                count += 1;
            }
        }
        if (fullLength > 0) {
            return (double) fullLength / count;
        }
        return 0;
    }
}
