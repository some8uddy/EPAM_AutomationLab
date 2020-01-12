package stage2.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории,
// например"D:/movies".Записать в текстовый файл структуру папок и файлов в виде,похожем на выполнение программы tree/F.

public class TreeToFile {

    private File startingDirectory;
    private String outputFileName;

    protected TreeToFile(File startingDirectory, String outputFileName) {
        this.startingDirectory = startingDirectory;
        this.outputFileName = outputFileName;
    }

    protected void writeTreeToFile() {
        List<File> fileTreeList = getFileTreeAsList(startingDirectory, new ArrayList<>(Arrays.asList(startingDirectory)));
        List<String> formattedOutputList = getListFormattedForOutput(fileTreeList);
        File outputFile = new File(outputFileName);
        printToFile(outputFile, formattedOutputList);
    }

    protected int getNestingDepth(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if ('\\' == string.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    protected String getFormattedString(File entry, int rootNestingDepth) {
        String pathString = entry.getPath();
        int nameFirstIndex = pathString.lastIndexOf("\\") + 1;
        int nestingDepth = getNestingDepth(pathString);
        StringBuilder formattedString = new StringBuilder();
        if (nestingDepth != rootNestingDepth) {
            for (int i = 0; i < nestingDepth - rootNestingDepth - 1; i++) {
                formattedString.append("|    ");
            }
            formattedString.append("|---");
        }
        formattedString.append(pathString.substring(nameFirstIndex));
        return formattedString.toString();
    }

    private void printToFile(File outputFile, List<String> outputList) {
        try (FileWriter out = new FileWriter(outputFile)) {
            for (String entry : outputList) {
                out.write(entry);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getListFormattedForOutput(List<File> fileTreeAsList) {
        int startingPathNestingDepth = getNestingDepth(startingDirectory.getPath());
        List<String> formattedList = new ArrayList<>();
        for (File entry : fileTreeAsList) {
            formattedList.add(getFormattedString(entry, startingPathNestingDepth));
        }
        return formattedList;
    }

    private List<File> getFileTreeAsList(File dir, List<File> list) {
        File[] folderEntries = dir.listFiles();
        assert folderEntries != null;
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                list.add(entry);
                getFileTreeAsList(entry, list);
                continue;
            }
            list.add(entry);
        }
        return list;
    }
}
