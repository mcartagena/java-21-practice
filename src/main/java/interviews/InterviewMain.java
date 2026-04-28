package interviews;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewMain {
    public static void main(String[] args) {
        // how many incidences are of each String
        String[] arr = {"java","spring", "java","sql","Spring"};

        Map<String, Long> result = Arrays.stream(arr)
                .map(m -> m.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}
