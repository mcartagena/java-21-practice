package java8.streams;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.Optional;

public class StreamFindAnyFirstExample {

    public static Optional<Student> findAnyStudent(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.6)
                .peek(System.out::println)
                .findAny();
    }

    public static Optional<Student> findFirstStudent(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.6)
                .peek(System.out::println)
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if(studentOptionalFindAny.isPresent()){
            System.out.println("Found Any student: " + studentOptionalFindAny.get());
        } else {
            System.out.println("Student Not Found");
        }

        Optional<Student> studentOptionalFirstAny = findFirstStudent();
        if(studentOptionalFirstAny.isPresent()){
            System.out.println("Found First student: " + studentOptionalFirstAny.get());
        } else {
            System.out.println("Student Not Found");
        }
    }
}
