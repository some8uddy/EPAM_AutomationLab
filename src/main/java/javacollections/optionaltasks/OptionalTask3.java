package javacollections.optionaltasks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 3.   Создать список из элементов каталога и его подкаталогов.

public class OptionalTask3 {

    public static void main(String[] args) {
        List<File> filesList;
        File startDirectory = new File(".");
        filesList = getFilesFromDirectory(startDirectory, new ArrayList<>());
        for (File entry : filesList) {
            System.out.println(entry);
        }
    }

    private static List<File> getFilesFromDirectory(File dir, List<File> list) {
        File[] folderEntries = dir.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                getFilesFromDirectory(entry, list);
                continue;
            }
            list.add(entry);
        }
        return list;
    }
}
