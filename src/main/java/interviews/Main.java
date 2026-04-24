package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        listOfIntegers.stream()
                .map(num -> num * 3)
                .filter(num -> 0 == (num % 2))
                .forEach(System.out::println);
//                .peek(System.out::println)

        System.out.println(function(1,1));
        System.out.println(function(3,2));
    }

    public static String function(int row, int col){
        /* write a function that returns the color of a tile on a chess board at a specific location. (1,1) is White.
	       The board is hypothetical, it does actually need to exist within this program.
           inputs: int row, int col (where x and y >= 1)
           output: White or Black
           visualization:
        1 2 3 4
      1|W|B|W|B|
      2|B|W|B|W|
      3|W|B|W|B|
      4|B|W|B|W|
      ex:
      fun(1,1) returns "W"
      fun(3,2) returns "B"
     */
         if(row < 1 || row > 4){
             return null;
         }
         if(col < 1 || col > 4){
             return null;
         }

        if ((row + col) % 2 == 0) {
            return "W";
        } else {
            return "B";
        }
    }

}
