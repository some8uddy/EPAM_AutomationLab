package stage2exceptions;

import stage2exceptions.exceptions.NoStudentsInGroupException;

import java.util.Objects;
import java.util.Set;

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
}
