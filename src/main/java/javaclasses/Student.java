package javaclasses;

import java.time.LocalDate;

//    Создать классы, спецификации которых приведены ниже.
//    Определить конструкторы и методы setТип(), getТип(), toString().
//    Определить дополнительно методы в классе, создающем массив объектов.
//    Задать критерий выбора данных и вывести эти данные на консоль.
//    В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//
//    1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
//    Создать массив объектов. Вывести:
//    a) список студентов заданного факультета;
//    b) списки студентов для каждого факультета и курса;
//    c) список студентов, родившихся после заданного года;
//    d) список учебной группы.

class Student {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student() {
        this(0, "....", "....",
            "....", null, "....",
            "....", "....", 0, "....");
    }

    public Student(int id, String surname, String name, String patronymic,
                   LocalDate dateOfBirth, String address, String phone,
                   String faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    protected Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.surname = studentBuilder.surname;
        this.name = studentBuilder.name;
        this.patronymic = studentBuilder.patronymic;
        this.dateOfBirth = studentBuilder.dateOfBirth;
        this.address = studentBuilder.address;
        this.phone = studentBuilder.phone;
        this.faculty = studentBuilder.faculty;
        this.course = studentBuilder.course;
        this.group = studentBuilder.group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", surn='" + surname + '\'' +
            ", name='" + name + '\'' +
            ", patron='" + patronymic + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", addr='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", facul='" + faculty + '\'' +
            ", cour=" + course +
            ", grp='" + group + '\'' +
            '}';
    }
}
