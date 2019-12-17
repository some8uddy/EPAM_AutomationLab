package javafundamentals;

//2. Вывести числа в порядке возрастания значений их длины.

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask1_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите несколько чисел через пробел и нажмите клавишу Ввод");

        String inputStr = scan.nextLine();
        String[] tmpArr = inputStr.split(" ");

        sort(tmpArr);
        System.out.println("Числа отсортированные по длине:");
        System.out.println(Arrays.toString(tmpArr));
    }

    static void sort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].length() > arr[j].length()) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(String[] arr, int ind1, int ind2) {
        String tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}
