package stage2.exceptions;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class UniversityUtilTest {

    private Set<Discipline> disciplines = new HashSet<>(Arrays.asList(
        new Discipline("Biology"),
        new Discipline("Mathematics"),
        new Discipline("Geology"),
        new Discipline("Physics")
    ));

    @Test
    public void testGetAverageMark() {
        assertEquals(3, UniversityUtil.getAverageMark(Arrays.asList(1, 2, 3, 4, 5)), 0.01);
        assertEquals(0, UniversityUtil.getAverageMark(Arrays.asList(-1, 1, -2, 2)), 0.01);
    }

    @Test
    public void testGetRandomMarks() {
        System.out.println("\n\nTestGetRandomMarks results:\n----------------------------------");
        Map<Discipline, Marks> marks = UniversityUtil.getRandomMarks(disciplines);
        for (Map.Entry<Discipline, Marks> entry : marks.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue().getMarks());
        }
        System.out.println();
    }

    @Test
    public void testGetRandomStudents() {
        System.out.print("\nTestGetSomeStudents results:\n----------------------------------");
        Set<Student> students = UniversityUtil.getRandomStudents(20, disciplines);
        for (Student s : students) {
            System.out.print(s);
        }
    }

    @Test
    public void testGetRandomGroups() {
        System.out.print("\nTestGetSomeGroups results:\n----------------------------------");
        Set<Group> groups = UniversityUtil.getRandomGroups("EE-", 3, 5, disciplines);
        for (Group g : groups) {
            System.out.println(g);
        }
    }

    @Test
    public void testGetRandomFaculties() {
        System.out.println("\nTestGetSomeFaculties results:\n----------------------------------");
        int groupCount = 2;
        int groupSize = 10;
        Set<Faculty> faculties = UniversityUtil
            .getRandomFaculties(Arrays.asList("Name", "Another Name"), groupCount, groupSize, disciplines);
        for (Faculty f : faculties) {
            System.out.print(f);
        }
    }

    @Test
    public void testGetRandomUniversity() {
        List<String> facultyNames = new ArrayList<>(
            Arrays.asList("Electrical Engineering", "Science", "Petrochemical Engineering"));
        String universityName = "Caltech";
        int groupCount = 3;
        int groupSize = 10;
        System.out.println("\nTestGetSomeUniversity results:\n----------------------------------");
        University university = UniversityUtil
            .getRandomUniversity(universityName, facultyNames, groupCount, groupSize, disciplines);
        System.out.println(university);
    }
}