package stage1.javacollections.optionaltasks;

import java.io.*;
import java.util.LinkedList;

//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class OptionalTask1 {

    public static void main(String[] args) throws IOException {
        LinkedList<String> stack = new LinkedList<>();

        try (BufferedReader in = new BufferedReader(new FileReader("src/main/resources/OptionalTask1Data.txt"))) {
            String nextString;
            while ((nextString = in.readLine()) != null) {
                stack.push(nextString);
            }
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/OptionalTask1Data.txt"))) {
            while (!stack.isEmpty()) {
                out.write(stack.pop());
                out.write("\n");
            }
        }
    }
}
