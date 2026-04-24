package imperativevsdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,3,4,5,5,6,7,8,8,9,10);

        /**
         * Imperative
         */

        List<Integer> result1 = new ArrayList<>();
        for(Integer num: integerList){
            if(!result1.contains(num)){
                result1.add(num);
            }
        }

        System.out.println("Imperative result: " + result1);

        /**
         * Declarative
         */
        List<Integer> result2 = integerList.stream()
                .distinct().toList();

        System.out.println("Declarative result: " + result2);

    }
}
