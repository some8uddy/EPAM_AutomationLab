package stage2.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории,
// например"D:/movies".Записать в текстовый файл структуру папок и файлов в виде,похожем на выполнение программы tree/F.

public class treeToFile {

    private static int startingPathNestingDepth;

    public static void main(String[] args) {
        String startingPath = args[0].replace("/", "\\");
        startingPathNestingDepth = getNestingDepth(startingPath);
        File startDirectory = new File(startingPath);
        List<String> filesList = getFilesFromDirectory(startDirectory, new ArrayList<>(Arrays.asList(startingPath)));
        try (FileWriter out = new FileWriter("src/main/resources/Stage2IoTreeToFileOutput.txt")) {
            for (String entry : filesList) {
                out.write(entry);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFilesFromDirectory(File dir, List<String> list) {
        File[] folderEntries = dir.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                list.add(getFormattedString(entry));
                getFilesFromDirectory(entry, list);
                continue;
            }
            list.add(getFormattedString(entry));
        }
        return list;
    }

    private static String getFormattedString(File entry) {
        String initialString = entry.getPath();
        int lastElementStartIndex = initialString.lastIndexOf("\\");
        int count = getNestingDepth(initialString);
        StringBuilder formattedString = new StringBuilder();
        for (int i = 0; i < count - startingPathNestingDepth - 1; i++) {
            formattedString.append("|    ");
        }
        formattedString.append("|---");
        formattedString.append(initialString.substring(lastElementStartIndex + 1));
        return formattedString.toString();
    }

    private static int getNestingDepth(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if ('\\' == string.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
