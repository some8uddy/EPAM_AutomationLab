package stage1.javaclasses;

import java.time.LocalDate;
import java.util.Random;

//    Создать классы, спецификации которых приведены ниже.
//    Определить конструкторы и методы setТип(), getТип(), toString().
//    Определить дополнительно методы в классе, создающем массив объектов.
//    Задать критерий выбора данных и вывести эти данные на консоль.
//    В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//
//    1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.//
//    Создать массив объектов. Вывести:
//    a) список студентов заданного факультета;
//    b) списки студентов для каждого факультета и курса;
//    c) список студентов, родившихся после заданного года;
//    d) список учебной группы.

public class Main {

    public static void main(String[] args) {
        //Create array of students and fill it with some data like id, faculty, course, group and date of birth
        Student[] students = new Student[150];
        String[] faculties = {"Chemical", "Mathematical", "Biological", "Physical"};
        setUpStudentData(students, faculties);

        //Print all students:
        printAllStudents(students);

        //Print students by following criteria:

        //by set faculty
        String faculty = faculties[2];
        printByFaculty(students, faculty);

        //by each faculty and course
        printByFacultyAndCourse(students, faculties);

        //born after set date of birth
        LocalDate date = LocalDate.of(1994, 1, 1);
        printBornAfter(students, date);

        //by set group name
        String group = "M-21";
        printByGroup(students, group);
    }

    private static void printAllStudents(Student[] students) {
        System.out.println("All students:\n--------------------------------- ");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static void setUpStudentData(Student[] students, String[] faculties) {
        Random random = new Random();
        for (int i = 0; i < students.length; i++) {
            int rnd = random.nextInt(900000);
            int id = rnd + 100000;
            String faculty = faculties[rnd % faculties.length];
            int course = rnd % 5 + 1;
            String group = faculty.charAt(0) + "-" + course + 1;
            LocalDate dob = LocalDate.of(1990 + rnd % 7, rnd % 12 + 1, rnd % 30 + 1);

            StudentBuilder studentBuilder;
            studentBuilder = new StudentBuilder()
                .setId(id)
                .setFaculty(faculty)
                .setGroup(group)
                .setCourse(course)
                .setDateOfBirth(dob);

            students[i] = studentBuilder.build();
        }
    }

    private static void printByFaculty(final Student[] students, final String faculty) {
        System.out.println("Students from " + faculty + " faculty:\n--------------------------------- ");
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    private static void printByFacultyAndCourse(final Student[] students, final String[] faculties) {
        for (String faculty : faculties) {
            for (int i = 1; i < 6; i++) {
                System.out.println("Students from " + i + " course studying at " + faculty + " faculty:" +
                    "\n--------------------------------- ");
                for (Student student : students) {
                    if (student.getFaculty().equals(faculty) && student.getCourse() == i) {
                        System.out.println(student);
                    }
                }
                System.out.println();
            }
        }
    }

    private static void printBornAfter(final Student[] students, final LocalDate date) {
        System.out.println("Students born after " + date + ":\n--------------------------------- ");
        for (Student student : students) {
            if (student.getDateOfBirth() != null && student.getDateOfBirth().isAfter(date)) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    private static void printByGroup(final Student[] students, final String group) {
        System.out.println("Students from " + group + "group:\n--------------------------------- ");
        for (Student student : students) {
            if (student.getGroup() != null && student.getGroup().equals(group)) {
                System.out.println(student);
            }
        }
        System.out.println();
    }
}
