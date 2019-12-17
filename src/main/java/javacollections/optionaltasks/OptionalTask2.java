package javacollections.optionaltasks;

import java.util.LinkedList;
import java.util.Scanner;

// 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном
// порядке.

public class OptionalTask2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число.");
        String inputLine = scanner.nextLine();
        System.out.println("Число в обратном порядке: " + reverse(inputLine));
        scanner.close();
    }

    private static String reverse(String inputLine) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < inputLine.length(); i++) {
            stack.push(inputLine.charAt(i));
        }
        String ouputLine = "";
        while (stack.peek() != null) {
            ouputLine += stack.pop();
        }
        return ouputLine;
    }
}
