package javaclasses;

import java.time.LocalDate;

public class StudentBuilder {

    protected int id = 0;
    protected String surname = "....";
    protected String name = "....";
    protected String patronymic = "....";
    protected LocalDate dateOfBirth;
    protected String address = "....";
    protected String phone = "....";
    protected String faculty = "....";
    protected int course = 0;
    protected String group = "....";

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public StudentBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentBuilder setFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public StudentBuilder setCourse(int course) {
        this.course = course;
        return this;
    }

    public StudentBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}
