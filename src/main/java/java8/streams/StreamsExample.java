package java8.streams;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        // student name and their activities in a map

        Predicate<Student> pGradeLevel = student -> student.getGradeLevel() >=3;
        Predicate<Student> pGpa = student -> student.getGpa() >=3.9;

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
                //.stream()
                .parallelStream()
                .filter(pGradeLevel)
                .filter(pGpa)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentMap);
    }
}
