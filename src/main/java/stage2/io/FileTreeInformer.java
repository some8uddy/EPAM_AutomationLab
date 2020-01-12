package stage2.io;

// Если в качестве параметра в программу передается не путь к директории,
// а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
//
//    Количество папок
//    Количество файлов
//    Среднее количество файлов в папке
//    Среднюю длину названия файла

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTreeInformer {

    private File file;

    protected FileTreeInformer(File file) {
        this.file = file;
    }

    protected static String getExtension(String path) {
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension = path.substring(i);
        }
        return extension;
    }

    protected void printFileTreeInfo() {
        List<String> fileTree = readFileTree(file);
        int directoryCount = 0;
        int fileCount = 0;
        StringBuilder allFileNames = new StringBuilder();
        for (String entry : fileTree) {
            if (isFolder(entry)) {
                directoryCount++;
            } else {
                fileCount++;
                allFileNames.append(parseFileName(entry));
            }
        }

        System.out.printf("%n Количество папок: %d" +
                "%n Количество файлов: %d" +
                "%n Среднее количество файлов в папке: %.2f" +
                "%n Средняя длина названия файла: %.2f" +
                "%n",
            directoryCount,
            fileCount,
            (double) fileCount / directoryCount,
            (double) allFileNames.length() / fileCount);
    }

    protected String parseFileName(String string) {
        String searchSequence = "|---";
        int startIndex = string.lastIndexOf(searchSequence) + searchSequence.length();
        int endIndex = string.length() - getExtension(string).length();
        return string.substring(startIndex, endIndex);
    }

    protected boolean isFolder(String string) {
        return getExtension(string).length() == 0;
    }

    private List<String> readFileTree(File inputFile) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
