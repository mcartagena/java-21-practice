package java8.method.reference;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.function.Consumer;

public class CustomerMethodReferenceExample {
    static Consumer<Student> c1 = System.out::println;
    static Consumer<Student> c2 = Student::printListOfActivities;

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
    }
}
