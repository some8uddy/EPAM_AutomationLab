package stage2.exceptions;

//    В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
//    У каждого студента есть несколько учебных предметов по которым он получает оценки.
//    Необходимо реализовать иерархию студентов, групп и факультетов.
//
//    Посчитать средний балл по всем предметам студента
//    Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//    Посчитать средний балл по предмету для всего университета
//
//    Релизовать следующие исключения:
//
//    Оценка ниже 0 или выше 10
//    Отсутсвие предметов у студента (должен быть хотя бы один)
//    Отсутствие студентов в группе
//    Отсутствие групп на факультете
//    Отсутствие факультетов в университете

import java.util.*;

import static stage2.exceptions.UniversityUtil.*;

public class Main {

    private static Set<Discipline> disciplines = new HashSet<>(Arrays.asList(
        new Discipline("Biology"),
        new Discipline("Mathematics"),
        new Discipline("Geology"),
        new Discipline("Physics")
    ));

    private static List<String> facultyNames = new ArrayList<>(
        Arrays.asList("Electrical Engineering", "Science", "Petrochemical Engineering"));

    private static String universityName = "Caltech";

    public static void main(String[] args) {

        //Посчитать средний балл по всем предметам студента
        Student student = new Student("Bob", "", disciplines, getRandomMarks(disciplines));
        System.out.print(String.format(
            "%s%nЗадание 1: \"Посчитать средний балл по всем предметам студента\"%n", getLine()));
        printAverageMarksForStudent(student);


        //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        String facultyName = "Science";
        String groupName = "SC-1";
        Discipline discipline = new Discipline("Biology");
        int groupCount = 2;
        int groupSize = 3;
        University university = getRandomUniversity(universityName, facultyNames, groupCount, groupSize, disciplines);
        System.out.print(String.format(
            "%n%s%nЗадание 2: \"Посчитать средний балл по конкретному предмету" +
                " в конкретной группе и на конкретном факультете\"%n%n%s%n", getLine(), university));
        printAverageMarksByFacultyGroupDiscipline(university, facultyName, groupName, discipline);


        //Посчитать средний балл по предмету для всего университета
        groupCount = 1;
        groupSize = 1;
        discipline = new Discipline("Biology");
        university = getRandomUniversity(universityName, facultyNames, groupCount, groupSize, disciplines);
        System.out.print(String.format(
            "%n%s%nЗадание 3: \"Посчитать средний балл по предмету для всего университета\"%n%n%s%n", getLine(), university));
        printAverageMarkByDisciplineForEntireUniversity(university, discipline);
    }
}

