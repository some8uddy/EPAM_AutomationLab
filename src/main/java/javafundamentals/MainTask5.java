package javafundamentals;

//5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
// Осуществить проверку корректности ввода чисел.

public class MainTask5 {

    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                System.out.println("Месяц " + getMonth(args) + ".");
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста перезапустите программу," +
                    " используя целое число от 1 до 12 в качестве аргумента командной строки.");
            }
        }
    }

    static String getMonth(String[] args) throws NumberFormatException {
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
            "Сентябрь",
            "Октябрь", "Ноябрь", "Декабрь"};
        int num = Integer.parseInt(args[0]);
        return months[num - 1];
    }
}
