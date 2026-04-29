package java8.functional.interfaces;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> toUpper = s -> s.toUpperCase();
    static Function<String, String> toAddSome = s -> s.concat(" Default");

    public static void main(String[] args) {
        System.out.println("Result : " + toUpper.andThen(toAddSome).apply("java8"));
        System.out.println("Result : " + toUpper.compose(toAddSome).apply("java8"));
    }
}
