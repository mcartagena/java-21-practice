package java8.streams;

import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (a, b) -> a > b ? a : b);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a < b ? a : b);
    }


    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 1, 9);
        // List<Integer> numbers = List.of();
        System.out.println("max value is: " + findMaxValue(numbers));
        Optional<Integer> result = findMaxValueOptional(numbers);
        if(result.isPresent()){
            System.out.println("max value is: " + result.get());
        } else {
            System.out.println("The list is empty");
        }
        Optional<Integer> resultMin = findMinValueOptional(numbers);
        if(resultMin.isPresent()){
            System.out.println("min value is: " + resultMin.get());
        } else {
            System.out.println("The list is empty");
        }
    }
}
