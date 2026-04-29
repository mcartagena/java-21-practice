package java8.functional.interfaces;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Student> supplierStudent = () -> new Student("Marcelo",4,3.4, "male", List.of("soccer", "reading","running"));
        Supplier<List<Student>> students = () -> StudentDataBase.getAllStudents();

        System.out.println("Student: " + supplierStudent.get());

        System.out.println("Students: " + students.get());

    }
}
