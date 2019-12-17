package javafundamentals;

//4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и
//        вывести результат на консоль.

public class MainTask4 {

    public static void main(String[] args) {
        try {
            System.out.println("Сумма чисел: " + getSum(args));
            System.out.println("Произведение чисел: " + getProduct(args));
        } catch (Exception e) {
            System.out.println("Пожалуйста перезапустите программу," +
                " используя целые числа в качестве аргументов командной строки.");
        }

    }

    static Integer getSum(String[] args) throws Exception {
        int sum = Integer.parseInt(args[0]);

        for (int i = 1; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        return sum;
    }

    static Integer getProduct(String[] args) throws Exception {
        int product = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i++) {
            product *= Integer.parseInt(args[i]);
        }
        return product;
    }
}