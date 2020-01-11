package stage2.exceptions;

import stage2.exceptions.customexceptions.GradeOutOfBoundsException;
import stage2.exceptions.customexceptions.NoFacultiesException;
import stage2.exceptions.customexceptions.NoGroupsOnFacultyException;
import stage2.exceptions.customexceptions.NoStudentsInGroupException;

import java.util.*;

public class UniversityUtil {

    /**
     * Prints to console the average mark by given discipline for entire university.
     *
     * @param university university where average mark is computed.
     * @param discipline discipline for which average mark is computed.
     */
    static void printAverageMarkByDisciplineForEntireUniversity(University university, Discipline discipline) {
        List<Integer> marks = new ArrayList<>();
        try {
            for (Faculty faculty : university.getFaculties()) {
                for (Group group : faculty.getGroups()) {
                    marks.addAll(group.getMarksByDiscipline(discipline));
                }
            }

            System.out.printf("%nAverage mark for %s discipline for entire university is %.2f%n%s%n",
                discipline, getAverageMark(marks), getLine());
        } catch (NoStudentsInGroupException | NoGroupsOnFacultyException | NoFacultiesException e) {
            e.printStackTrace();
        }
    }

    static void printAverageMarksByFacultyGroupDiscipline(University university, String facultyName,
                                                          String groupName, Discipline discipline) {
        try {
            List<Integer> marks;
            marks = university.getFacultyByName(facultyName).getGroupByName(groupName).
                getMarksByDiscipline(discipline);

            System.out.printf("%nAverage mark for %s discipline for group %s on %s faculty is %.2f%n%s%n",
                discipline, groupName, facultyName, getAverageMark(marks), getLine());
        } catch (NoStudentsInGroupException | NoGroupsOnFacultyException | NoFacultiesException e) {
            e.printStackTrace();
        }
    }

    static void printAverageMarksForStudent(Student student) {
        System.out.println(String.format("%nStudent %s has following academic performance:%n" +
                "\t%s%n" +
                "" +
                "%nStudent's average mark is %.2f%n" +
                getLine(),
            student.getName(),
            student.getAcademicPerformance().toString(),
            student.getAverageMark()));
    }

    protected static String getLine() {
        return "______________________________________________________________________________" +
            "______________________________________________________________________________";
    }

    protected static double getAverageMark(List<Integer> marks) {
        int sum = 0;
        for (Integer i : marks) {
            sum += i;
        }
        return (double) sum / marks.size();
    }

    /**
     * Returns {@code University} with specified faculties having groups and students with marks assigned.
     * Group count is equal for each faculty.
     * Student count is equal for each group.
     * Each student has random marks assigned, however disciplines are the same for all students.
     *
     * @param facultyNames list of faculty names.
     * @param groupCount   count of groups at each faculty.
     * @param groupSize    count of students in each group.
     * @param disciplines  set of disciplines for which random marks are generated.
     * @return university with specified faculties having groups and students with marks assigned.
     */
    protected static University getRandomUniversity(String universityName,
                                                    List<String> facultyNames,
                                                    int groupCount,
                                                    int groupSize,
                                                    Set<Discipline> disciplines) {

        return new University(universityName,
            getRandomFaculties(facultyNames, groupCount, groupSize, disciplines),
            disciplines);
    }

    /**
     * Returns set {@code Set<Faculty>} of specified size with faculties having groups and students with marks assigned.
     * Group count is equal for each faculty.
     * Student count is equal for each group.
     * Each student has random marks assigned, however disciplines are the same for all students.
     *
     * @param facultyNames list of faculty names.
     * @param groupCount   count of groups at each faculty.
     * @param groupSize    count of students in each group.
     * @param disciplines  set of disciplines for which random marks are generated.
     * @return set of specified size with faculties having groups and students with marks assigned.
     */
    protected static Set<Faculty> getRandomFaculties(List<String> facultyNames,
                                                     int groupCount,
                                                     int groupSize,
                                                     Set<Discipline> disciplines) {
        Set<Faculty> faculties = new HashSet<>();
        for (String name : facultyNames) {
            String namePrefix = name.substring(0, 2).toUpperCase() + "-";
            faculties.add(new Faculty(name, getRandomGroups(namePrefix, groupCount, groupSize, disciplines)));
        }
        return faculties;
    }

    /**
     * Returns set {@code Set<Group>} of specified size with groups having specified name prefix and
     * random students with random marks assigned to each group.
     * Method automatically adds increasing number as postfix for each following group name.
     * Student count is equal for each group.
     * Each student has random marks assigned, however disciplines are the same for all students.
     *
     * @param namePrefix  groups name prefix.
     * @param groupCount  count of groups.
     * @param groupSize   count of students in each group.
     * @param disciplines set of disciplines for which random marks are generated.
     * @return set of specified size with groups having specified name prefix and random students
     * with random marks assigned to each group.
     */
    protected static Set<Group> getRandomGroups(String namePrefix,
                                                int groupCount,
                                                int groupSize,
                                                Set<Discipline> disciplines) {
        Set<Group> groups = new HashSet<>();
        for (int i = 1; i < groupCount + 1; i++) {
            String groupName = namePrefix + i;
            groups.add(new Group(groupName, getRandomStudents(groupSize, disciplines)));
        }
        return groups;
    }

    /**
     * Returns set {@code Set<Student>} of specified size with random students.
     * Each student has random marks assigned, however disciplines are the same for all students.
     *
     * @param countOfStudents count of students in the returned set.
     * @param disciplines     set of disciplines for which random marks are generated.
     * @return set of random students with random marks for specified disciplines.
     */
    protected static Set<Student> getRandomStudents(int countOfStudents, Set<Discipline> disciplines) {
        Set<Student> students = new HashSet<>();
        for (int i = 0; i < countOfStudents; i++) {
            students.add(new Student("...", "...", disciplines, getRandomMarks(disciplines)));
        }
        return students;
    }

    /**
     * Returns map {@code Map<Discipline, Marks>} with random marks for specified set of
     * disciplines.
     * Marks lie between 0 (inclusive) and 10 (inclusive).
     * Method returns from 0 (inclusive) to 10 (inclusive) marks for each specified discipline.
     *
     * @param disciplines set of disciplines for which random marks are generated.
     * @return map with random marks for specified set of disciplines.
     */
    protected static Map<Discipline, Marks> getRandomMarks(Set<Discipline> disciplines) {
        Map<Discipline, Marks> marks = new HashMap<>();
        int maximumMarksCount = 10;
        int maximumGrade = 10;
        Random random = new Random();
        for (Discipline discipline : disciplines) {
            int marksCount = random.nextInt(maximumMarksCount + 1);
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
