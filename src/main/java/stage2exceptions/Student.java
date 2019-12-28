package stage2exceptions;

import stage2exceptions.exceptions.NoDisciplinesException;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Student {
    private static int counter = 0;

    private int id;
    private String name;
    private String surname;
    private Set<Discipline> disciplines;
    private Map<Discipline, Marks> academicPerformance;

    public Student(String name, String surname, Set<Discipline> disciplines, Map<Discipline, Marks> academicPerformance) {
        this.id = ++counter;
        this.name = name;
        this.surname = surname;
        this.disciplines = disciplines;
        this.academicPerformance = academicPerformance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Discipline> getDisciplines() throws NoDisciplinesException {
        if (disciplines == null || disciplines.isEmpty()) {
            throw new NoDisciplinesException("There is no disciplines for " + name + " student set.");
        }
        return disciplines;
    }

    public boolean removeDiscipline(Discipline discipline) throws NoDisciplinesException {
        if (disciplines == null || disciplines.isEmpty()) {
            throw new NoDisciplinesException("There is no disciplines for " + name + " student set.");
        }
        return disciplines.remove(discipline);
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Map<Discipline, Marks> getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(Map<Discipline, Marks> academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
