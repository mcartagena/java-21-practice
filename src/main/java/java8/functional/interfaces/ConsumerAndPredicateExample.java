package java8.functional.interfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicateExample {
    // Students which grade level is grader or equal to 3
    static Predicate<Student> pGradeLevel = s -> s.getGradeLevel() >= 3;

    // Students which gpa is grader or equal to 3.9
    static Predicate<Student> pGpa = s -> s.getGpa() >= 3.9;

    static BiPredicate<Integer, Double> p = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    static BiConsumer<String, List<String>> c1 = (name, activities) -> System.out.println(name + " : " + activities);

    static Consumer<Student> c = s -> c1.accept(s.getName(), s.getActivities());

    public static void main(String[] args) {
        System.out.println("With two predicates...");
        StudentDataBase.getAllStudents().stream()
                .filter(s -> pGradeLevel.and(pGpa).test(s))
                .forEach(student -> c.accept(student));

        System.out.println("With BiPredicate...");
        StudentDataBase.getAllStudents().stream()
                .filter(student -> p.test(student.getGradeLevel(), student.getGpa()))
                .forEach(student -> c.accept(student));
    }
}
