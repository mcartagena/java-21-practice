package java8.functional.interfaces;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionStudentExample {
    static Function<List<Student>, Map<String, Double>> studentFunction = students -> {
        return students.stream()
                .filter(s -> PredicateStudentExample.pGradeLevel.test(s))
                .collect(Collectors.toMap(s -> s.getName(), s-> s.getGpa()));
    };

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
    }
}
