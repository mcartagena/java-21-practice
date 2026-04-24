package java8.functional.interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    public static void printStudents() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(c2);

    }

    public static void printNameAndActivities() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(c3.andThen(c4));
    }

    public static void printNameAndActivitiesUsingCondition() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                c3.andThen(c4).accept(student);
            }
        });

    }

    public static void main(String[] args) {
        Consumer<String> upperFrase = (s1) -> System.out.println(s1.toUpperCase());

        upperFrase.accept("java8");

        System.out.println("----------");

        printStudents();

        System.out.println("----------");

        printNameAndActivities();

        System.out.println("----------");

        printNameAndActivitiesUsingCondition();
    }
}
