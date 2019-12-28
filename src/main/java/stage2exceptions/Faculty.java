package stage2exceptions;

import stage2exceptions.exceptions.NoGroupsOnFacultyException;

import java.util.Objects;
import java.util.Set;

public class Faculty {
    private String name;
    private Set<Group> groups;

    public Faculty(String name, Set<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() throws NoGroupsOnFacultyException {
        if (groups == null || groups.isEmpty()) {
            throw new NoGroupsOnFacultyException("There is no groups for " + name + " faculty set.");
        }
        return groups;
    }

    public boolean removeGroup(Group group) throws NoGroupsOnFacultyException {
        if (groups == null || groups.isEmpty()) {
            throw new NoGroupsOnFacultyException("There is no groups for " + name + " faculty set.");
        }
        return groups.remove(group);
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(getName(), faculty.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
