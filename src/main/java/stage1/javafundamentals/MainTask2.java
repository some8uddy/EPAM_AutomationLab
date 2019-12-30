package stage1.javafundamentals;

//2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class MainTask2 {

    public static void main(String[] args) {
        System.out.println(getReversedArgs(args));
    }

    static String getReversedArgs(String[] args) {
        String reversedArgs = "";
        if (args.length != 0) {
            for (int i = args.length - 1; i >= 0; i--) {
                reversedArgs += args[i] + " ";
            }
        }
        return reversedArgs.trim();
    }
}
