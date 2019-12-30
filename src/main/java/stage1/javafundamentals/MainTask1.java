package stage1.javafundamentals;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.

public class MainTask1 {

    public static void main(String[] args) {
        System.out.println(getResponse(args));
    }

    static String getResponse(String[] args) {
        String response = "Hello Mr.";
        String defaultName = " No-name";

        if (args.length == 0) {
            response += defaultName;
        } else {
            for (int i = 0; i < args.length; i++) {
                response += (" " + args[i]);
            }
        }
        response += "!!!";
        return response;
    }
}

