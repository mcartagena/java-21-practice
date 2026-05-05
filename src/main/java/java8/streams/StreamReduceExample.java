package java8.streams;

import java8.functional.interfaces.Student;
import java8.functional.interfaces.StudentDataBase;

import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static int performMultiplication(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getHightestGpa() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {
        System.out.println(performMultiplication(List.of(1, 3, 5, 7)));
        Optional<Integer> result = performMultiplicationWithoutIdentity(List.of(1, 3, 5, 7));
        System.out.println(result.isPresent());
        System.out.println(result.get());
        Optional<Integer> result1 = performMultiplicationWithoutIdentity(List.of());
        System.out.println(result1.isPresent());
        if (result1.isPresent()) {
            System.out.println(result1.get());
        }
        System.out.println("Hightest GPA student: ");
        Optional<Student> hightestGpaStudent = getHightestGpa();
        if(hightestGpaStudent.isPresent()){
            System.out.println(hightestGpaStudent.get());
        }
    }
}
