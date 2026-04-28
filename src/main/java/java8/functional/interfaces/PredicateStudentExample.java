package java8.functional.interfaces;

import java.util.function.Predicate;

public class PredicateStudentExample {
    // Students which grade level is grader or equal to 3
    static Predicate<Student> pGradeLevel = s -> s.getGradeLevel() >= 3;

    // Students which gpa is grader or equal to 3.9
    static Predicate<Student> pGpa = s -> s.getGpa() >= 3.9;

    public static void main(String[] args) {

        // all students
        System.out.println("All Students");
        StudentDataBase.getAllStudents()
                        .forEach(System.out::println);

        // list of students filter by grade level
        System.out.println("Students which grade level is grader or equal to 3:");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGradeLevel.test(s))
                .forEach(System.out::println);

        // list of students filter by gpa
        System.out.println("Students which gpa is grader or equal to 3.9:");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGpa.test(s))
                .forEach(System.out::println);

        // list of students filter by grade level and gpa
        System.out.println("Students filter by grade level and gpa:");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGradeLevel.and(pGpa).test(s))
                .forEach(System.out::println);

        // list of students filter by grade level or gpa
        System.out.println("Students filter by grade level or gpa:");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGradeLevel.or(pGpa).test(s))
                .forEach(System.out::println);

        // list of students filter by grade level or gpa negative
        System.out.println("Students filter by grade level or gpa negative:");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGradeLevel.or(pGpa).negate().test(s))
                .forEach(System.out::println);


    }
}
