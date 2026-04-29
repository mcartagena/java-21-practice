package java8.functional.interfaces;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BiFunctionalExample {
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) -> {
        return students.stream()
                .filter(s -> studentPredicate.test(s))
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getGpa()));
    };

    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateStudentExample.pGpa));
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateStudentExample.pGradeLevel));
    }
}
