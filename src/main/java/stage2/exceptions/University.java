package stage2.exceptions;

import stage2.exceptions.customexceptions.NoFacultiesException;

import java.util.Set;

public class University {
    private String name;
    private Set<Faculty> faculties;
    private Set<Discipline> disciplines;

    public University(String name, Set<Faculty> faculties, Set<Discipline> disciplines) {
        this.name = name;
        this.faculties = faculties;
        this.disciplines = disciplines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculty> getFaculties() throws NoFacultiesException {
        assureFacultiesExistence();
        return faculties;
    }

    public boolean removeFaculty(Faculty faculty) throws NoFacultiesException {
        assureFacultiesExistence();
        return faculties.remove(faculty);
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Faculty getFacultyByName(String name) throws NoFacultiesException {
        assureFacultiesExistence();
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(name)) {
                return faculty;
            }
        }
        return null;
    }

    private void assureFacultiesExistence() throws NoFacultiesException {
        if (faculties == null || faculties.isEmpty()) {
            throw new NoFacultiesException("There is no faculties in " + name + " University.");
        }
    }

    @Override
    public String toString() {
        return name + " University:" + faculties;
    }
}
