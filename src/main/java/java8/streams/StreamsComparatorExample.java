package java8.streams;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static List<Student> sortStudentsByName(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentByGpa(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentByGpaDesc(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static List<String> getStudentsNamesWithGpaGraterThan(double gpa){
        Predicate<Student> graderThan = s -> s.getGpa() > gpa;

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> graderThan.test(student))
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Students sorted by name: ");
        sortStudentsByName().forEach(System.out::println);
        System.out.println("Students sorted by gpa: ");
        sortStudentByGpa().forEach(System.out::println);
        System.out.println("Students sorted by gpa desc: ");
        sortStudentByGpaDesc().forEach(System.out::println);
        System.out.println("List of students names whose GPA is above 3.5: ");
        System.out.println(getStudentsNamesWithGpaGraterThan(3.5));

    }
}
