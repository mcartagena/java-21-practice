package problems.pairs;

import java.util.Arrays;
import java.util.HashSet;

public class FindPairs {
    public boolean findPairBruteForce(int[] arr, int sum) {
        // Implementation goes here
        // O(n2) solution for demonstration purposes
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean findPairUsingSortArray(int[] arr, int sum) {
        // Implementation goes here
        // O(n log n) solution for demonstration purposes
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == sum) {
                return true;
            } else if (currentSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    public boolean findPairUsingHashing(int[] arr, int sum) {
        // Implementation goes here
        // O(n) solution for demonstration purposes
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = sum - num;
            if (set.contains(complement)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }   
}
