package stage2.exceptions;

import org.junit.Test;

import java.util.*;

import static stage2.exceptions.Main.*;

public class MainTest {

    @Test
    public void testGetRandomMarks() {
        System.out.println("\n\nTestGetRandomMarks results:\n----------------------------------");
        Map<Discipline, Marks> marks = getRandomMarks();
        for (Map.Entry<Discipline, Marks> entry : marks.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue().getMarks());
        }
        System.out.println();
    }

    @Test
    public void testGetSomeStudents() {
        System.out.print("\nTestGetSomeStudents results:\n----------------------------------");
        Set<Student> students = getSomeStudents(20);
        for (Student s : students) {
            System.out.print(s);
        }
    }

    @Test
    public void testGetSomeGroups() {
        System.out.print("\nTestGetSomeGroups results:\n----------------------------------");
        Set<Group> groups = getSomeGroups("EE-", 3,5);
        for (Group g : groups) {
            System.out.println(g);
        }
    }

    @Test
    public void testGetSomeFaculties() {
        System.out.println("\nTestGetSomeFaculties results:\n----------------------------------");
        int groupCount = 2;
        int groupSize = 10;
        Set<Faculty> faculties = getSomeFaculties(Arrays.asList("Name", "Another Name"), groupCount, groupSize);
        for (Faculty f : faculties) {
            System.out.print(f);
        }
    }

    @Test
    public void testGetSomeUniversity() {
        int groupCount = 3;
        int groupSize = 10;
        System.out.println("\nTestGetSomeUniversity results:\n----------------------------------");
        University university = getSomeUniversity(groupCount, groupSize);
        System.out.println(university);
    }
}