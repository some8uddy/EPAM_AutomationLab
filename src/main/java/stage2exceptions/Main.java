package stage2exceptions;

import stage2exceptions.exceptions.GradeOutOfBoundsException;

import java.util.*;

public class Main {
    private static Set<Discipline> disciplines = new HashSet<>(Arrays.asList(
        new Discipline("Biology"),
        new Discipline("Mathematics"),
        new Discipline("Geology"),
        new Discipline("Physics")
    ));

    public static void main(String[] args) {
        University university = setUp();
    }

    private static University setUp() {


        Set<Faculty> faculties = new HashSet<>(Arrays.asList(
            new Faculty("Electrical Engineering", null),
            new Faculty("Science", null),
            new Faculty("Petrochemical Engineering", null)
        ));
        University university = new University("Caltech", faculties, disciplines);
        return null;
    }

    private static Set<Group> getGroups(String namePrefix, int groupCount, int groupSize) {
        Set<Group> groups = new HashSet<>();
        for (int i = 1; i < groupCount + 1; i++) {
            String groupName = namePrefix + i;
            groups.add(new Group(groupName, getStudents(groupSize)));
        }
        return groups;
    }

    private static Set<Student> getStudents(int groupSize) {
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
//
//        for (int i = 0; i < 200; i++) {
//            int rnd = random.nextInt(900000);
//            int id = rnd + 100000;
//            String faculty = faculties[rnd % faculties.length];
//            int course = rnd % 5 + 1;
//            String group = faculty.charAt(0) + "-" + course + 1;
//
//
//            StudentBuilder studentBuilder;
//            studentBuilder = new StudentBuilder()
//                .setId(id)
//                .setFaculty(faculty)
//                .setGroup(group)
//                .setCourse(course)
//                .setDateOfBirth(dob);
//
//            students[i] = studentBuilder.build();

}

