package java8.functional.interfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> p = (i) -> {
            return i%2==0;
        };
        System.out.println(p.test(4));

        Predicate<Integer> p1 = i -> i%2==0;
        Predicate<Integer> p2 = i -> i%5==0;

        System.out.println("Is event and divisible to 5 " + p1.and(p2).test(10));
        System.out.println("Is event and divisible to 5 " + p1.and(p2).test(8));
        System.out.println("Is event or divisible to 5 " + p1.or(p2).test(8));
        System.out.println("Is event or divisible to 5 negated " + p1.or(p2).negate().test(8));
    }
}
