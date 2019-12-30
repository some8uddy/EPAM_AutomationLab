package stage2.exceptions;

import stage2.exceptions.customexceptions.GradeOutOfBoundsException;
import stage2.exceptions.customexceptions.NoFacultiesException;
import stage2.exceptions.customexceptions.NoGroupsOnFacultyException;
import stage2.exceptions.customexceptions.NoStudentsInGroupException;

import java.util.*;

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

public class Main {
    private static Set<Discipline> disciplines = new HashSet<>(Arrays.asList(
        new Discipline("Biology"),
        new Discipline("Mathematics"),
        new Discipline("Geology"),
        new Discipline("Physics")
    ));

    private static List<String> facultyNames = new ArrayList<>(
        Arrays.asList("Electrical Engineering", "Science", "Petrochemical Engineering"));

    public static void main(String[] args) {

        //Посчитать средний балл по всем предметам студента
        getAverageMarksForStudent("Bob");

        //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        String facultyName = "Science";
        String groupName = "SC-1";
        Discipline discipline = new Discipline("Biology");
        int groupCount = 2;
        int groupSize = 3;
        University university = getSomeUniversity(groupCount, groupSize);
        System.out.println(university);
        getAverageMarksByFacultyGroupDiscipline(university, facultyName, groupName, discipline);


        //Посчитать средний балл по предмету для всего университета
        groupCount = 1;
        groupSize = 1;
        discipline = new Discipline("Biology");
        university = getSomeUniversity(groupCount, groupSize);
        System.out.println(university);
        getAverageMarksByDisciplineForEntireUniversity(university, discipline);
    }

    private static void getAverageMarksByDisciplineForEntireUniversity(University university, Discipline discipline) {
        List<Integer> marks = new ArrayList<>();
        try {
            for (Faculty faculty : university.getFaculties()) {
                try {
                    for (Group group : faculty.getGroups()) {
                        try {
                            marks.addAll(group.getMarksByDiscipline(discipline));
                        } catch (NoStudentsInGroupException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoGroupsOnFacultyException e) {
                    e.printStackTrace();
                }
            }
            int sum = 0;
            for (Integer i : marks) {
                sum += i;
            }
            System.out.printf("\nAverage mark for %s discipline for entire university is %.2f\n",
                discipline, (double) sum / marks.size());
            System.out.println("-----------------------------------------------------------------------------------\n");
        } catch (NoFacultiesException e) {
            e.printStackTrace();
        }
    }

    private static void getAverageMarksByFacultyGroupDiscipline(University university, String facultyName,
                                                                String groupName, Discipline discipline) {
        try {
            List<Integer> marks;
            marks = university.getFacultyByName(facultyName).getGroupByName(groupName).
                getMarksByDiscipline(discipline);
            int sum = 0;
            for (Integer i : marks) {
                sum += i;
            }
            System.out.printf("\nAverage mark for %s discipline for group %s on %s faculty is %.2f\n",
                discipline, groupName, facultyName, (double) sum / marks.size());
            System.out.println("-----------------------------------------------------------------------------------\n");
        } catch (NoStudentsInGroupException | NoGroupsOnFacultyException | NoFacultiesException e) {
            e.printStackTrace();
        }
    }

    private static void getAverageMarksForStudent(String name) {
        Student student = new Student(name, "", null, getRandomMarks());
        System.out.printf("\nStudent %s has following getAcademicPerformance:\n    %s",
            student.getName(),
            student.getAcademicPerformance().toString());
        System.out.printf("\nHis average mark is %.2f\n", student.getAverageMark());
        System.out.println("-----------------------------------------------------------------------------------\n");
    }

    protected static University getSomeUniversity(int groupCount, int groupSize) {
        String universityName = "Caltech";
        return new University(universityName, getSomeFaculties(facultyNames, groupCount, groupSize), disciplines);
    }

    protected static Set<Faculty> getSomeFaculties(List<String> facultyNames, int groupCount, int groupSize) {
        Set<Faculty> faculties = new HashSet<>();
        for (String name : facultyNames) {
            String namePrefix = name.substring(0, 2).toUpperCase() + "-";
            faculties.add(new Faculty(name, getSomeGroups(namePrefix, groupCount, groupSize)));
        }
        return faculties;
    }

    protected static Set<Group> getSomeGroups(String namePrefix, int groupCount, int groupSize) {
        Set<Group> groups = new HashSet<>();
        for (int i = 1; i < groupCount + 1; i++) {
            String groupName = namePrefix + i;
            groups.add(new Group(groupName, getSomeStudents(groupSize)));
        }
        return groups;
    }

    protected static Set<Student> getSomeStudents(int groupSize) {
        Set<Student> students = new HashSet<>();
        for (int i = 0; i < groupSize; i++) {
            students.add(new Student("...", "...", disciplines, getRandomMarks()));
        }
        return students;
    }

    protected static Map<Discipline, Marks> getRandomMarks() {
        Map<Discipline, Marks> marks = new HashMap<>();
        int maximumMarksCount = 10;
        int maximumGrade = 10;
        Random random = new Random();
        for (Discipline discipline : disciplines) {
            int marksCount = random.nextInt(maximumMarksCount);
            Integer[] currentDisciplineMarks = new Integer[marksCount];
            for (int i = 0; i < marksCount; i++) {
                currentDisciplineMarks[i] = random.nextInt(maximumGrade + 1);
            }
            try {
                marks.put(discipline, new Marks(Arrays.asList(currentDisciplineMarks)));
            } catch (GradeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return marks;
    }
}

