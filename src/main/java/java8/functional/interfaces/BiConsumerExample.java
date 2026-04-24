package java8.functional.interfaces;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void nameAndActivities(){
        BiConsumer<String, List<String>> studentActivities = (a, b) -> System.out.println(a + ":" + b);

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> studentActivities.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String, String> aAnbB = (a, b) -> System.out.println("a: " + a + ", b: " + b);
        aAnbB.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("multiplication is: " + (a*b));
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("Division is: " + (a/b));

        multiply.andThen(division).accept(10, 5);

        System.out.println("---------");

        nameAndActivities();
    }
}
