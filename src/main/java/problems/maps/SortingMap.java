package problems.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingMap {
    public static void main(String[] args) {
        Map<Integer, String> toSort = Map.of(1,"Maria", 2, "Ana", 9, "Juan");
        Map<Integer, String> sortedMap = toSort.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
    }
}
