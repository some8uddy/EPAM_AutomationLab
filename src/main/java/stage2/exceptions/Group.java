package stage2.exceptions;

import stage2.exceptions.customexceptions.NoStudentsInGroupException;

import java.util.*;

public class Group {
    private String name;
    private Set<Student> students;

    public Group(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() throws NoStudentsInGroupException {
        assureStudentsExistence();
        return students;
    }

    public boolean removeStudent(Student student) throws NoStudentsInGroupException {
        assureStudentsExistence();
        return students.remove(student);
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    /**
     * Returns a list with marks for specified discipline.
     *
     * @param discipline the discipline for which marks are returned.
     * @return a List<Integer> with marks for specified discipline.
     * @throws NoStudentsInGroupException if there are no students for this group set.
     */
    public List<Integer> getMarksByDiscipline(Discipline discipline) throws NoStudentsInGroupException {
        assureStudentsExistence();
        List<Integer> marksList = new ArrayList<>();
        for (Student s : students) {
            Map<Discipline, Marks> academicPerformance = s.getAcademicPerformance();
            for (Map.Entry<Discipline, Marks> entry : academicPerformance.entrySet()) {
                if (entry.getKey().equals(discipline)) {
                    marksList.addAll(entry.getValue().getMarks());
                }
            }
        }
        return marksList;
    }

    /**
     * Checks if there are any students associated with this group.
     *
     * @throws NoStudentsInGroupException if there are no students for this group set.
     */
    private void assureStudentsExistence() throws NoStudentsInGroupException {
        if (students == null || students.isEmpty()) {
            throw new NoStudentsInGroupException("There is no students for " + name + " group set.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getName(), group.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "\n----Group " + name + ":" + students;
    }
}
