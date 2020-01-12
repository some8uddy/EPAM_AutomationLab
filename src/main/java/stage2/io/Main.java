package stage2.io;

import java.io.File;
//Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории,
//например "D:/movies". Записать в текстовый файл структуру папок и файлов в виде,
// похожем на выполнение программы tree /F.
// Если в качестве параметра в программу передается не путь к директории,
// а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
//
//    Количество папок
//    Количество файлов
//    Среднее количество файлов в папке
//    Среднюю длину названия файла

public class Main {

    private static final String OUTPUT_FILE_NAME = "./src/main/resources/Stage2IoTreeToFileOutput.txt";

    public static void main(String[] args) {
        String path = args[0].replace("/", "\\");
        File file = new File(path);

        if (file.isDirectory()) {
            new TreeToFile(file, OUTPUT_FILE_NAME).writeTreeToFile();
        } else {
            if (".txt".equals(FileTreeInformer.getExtension(path))) {
                new FileTreeInformer(file).printFileTreeInfo();
            }
        }
    }
}
