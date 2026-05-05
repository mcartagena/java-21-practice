package java8.streams;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StremsFlatMapExample {

    static List<String> getAllStudentsActivities(){
        List<String> result = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return result;
    }

    static Set<String> getAllStudentsActivitiesBySet(){
        Set<String> result = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        return result;
    }

    static long getTotalStudentsActivities(){
        long result = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getAllStudentsActivities());
        System.out.println(getAllStudentsActivitiesBySet());
        System.out.println(getTotalStudentsActivities());
    }
}
