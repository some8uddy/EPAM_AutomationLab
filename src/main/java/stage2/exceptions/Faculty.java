package stage2.exceptions;

import stage2.exceptions.customexceptions.NoGroupsOnFacultyException;

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
        assureGroupsExistence();
        return groups;
    }

    public boolean removeGroup(Group group) throws NoGroupsOnFacultyException {
        assureGroupsExistence();
        return groups.remove(group);
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Group getGroupByName(String name) throws NoGroupsOnFacultyException {
        assureGroupsExistence();
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    private void assureGroupsExistence() throws NoGroupsOnFacultyException {
        if (groups == null || groups.isEmpty()) {
            throw new NoGroupsOnFacultyException("There is no groups for " + name + " faculty set.");
        }
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

    @Override
    public String toString() {
        return "\n- " + name + " faculty:" + groups;
    }
}
