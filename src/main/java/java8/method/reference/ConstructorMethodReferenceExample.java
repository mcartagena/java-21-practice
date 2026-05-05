package java8.method.reference;

import java8.functional.interfaces.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReferenceExample {
    static Supplier<Student> studentSupplier = Student::new;
    static Function<String,Student> studentSupplierWithName = Student::new;


    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(studentSupplierWithName.apply("Marcelo"));
    }
}
