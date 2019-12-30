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
        if (students == null || students.isEmpty()) {
            throw new NoStudentsInGroupException("There is no students for " + name + " group set.");
        }
        return students;
    }

    public boolean removeStudent(Student student) throws NoStudentsInGroupException {
        if (students == null || students.isEmpty()) {
            throw new NoStudentsInGroupException("There is no students for " + name + " group set.");
        }
        return students.remove(student);
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public List<Integer> getMarksByDiscipline(Discipline discipline) throws NoStudentsInGroupException {
        if (students == null || students.isEmpty()) {
            throw new NoStudentsInGroupException("There is no students for " + name + " group set.");
        }
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
