package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integers) {
        return integers.stream()
                .limit(3)
                .reduce((a, b) -> a + b);
    }

    public static Optional<Integer> skip(List<Integer> integers) {
        return integers.stream()
                .skip(3)
                .reduce((a, b) -> a + b);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> result = limit(integers);
        if(result.isPresent()){
            System.out.println("The result for limit is: " + result.get());
        } else {
            System.out.println("Not value found...");
        }

        Optional<Integer> skipResult = skip(integers);
        if(skipResult.isPresent()){
            System.out.println("The result for skip is: " + skipResult.get());
        } else {
            System.out.println("Not value found...");
        }
    }
}
