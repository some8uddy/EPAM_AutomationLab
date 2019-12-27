package javafundamentals;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class MainTask3 {

    public static void main(String[] args) {
        try {
            int count = Integer.parseInt(args[0]);
            System.out.println("Случайные числа с переходом на новую строку:");
            for (int i = 0; i <= count; i++) {
                System.out.println("[" + i + "] " + Math.random());
            }
            System.out.println("Случайные числа без перехода на новую строку:");
            for (int i = 0; i <= count; i++) {
                System.out.print("[" + i + "] " + Math.random() + " ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста перезапустите программу," +
                " используя целое число в качестве аргумента командной строки.");
        }
    }
}

