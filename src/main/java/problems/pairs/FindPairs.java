package problems.pairs;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Utility class with several methods to determine whether there exists a pair of
 * integers in an array whose sum equals a target value.
 *
 * <p>This class provides three different approaches with different time/space
 * trade-offs:
 * <ul>
 *   <li>{@link #findPairBruteForce(int[], int)} — O(n^2) time, O(1) extra space</li>
 *   <li>{@link #findPairUsingSortArray(int[], int)} — O(n log n) time (due to
 *       sorting), O(1) extra space (if in-place sort) or O(n) depending on sort
 *       implementation</li>
 *   <li>{@link #findPairUsingHashing(int[], int)} — O(n) time on average, O(n)
 *       extra space</li>
 * </ul>
 *
 * <p>Behavior notes:
 * <ul>
 *   <li>If the input array is {@code null} or has fewer than two elements the
 *       methods return {@code false} (no pair can exist).</li>
 *   <li>Duplication in the input array is allowed; a valid pair may use the
 *       same numeric value twice only if it appears twice in the array.</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * int[] arr = {1, 4, 45, 6, 10, -8};
 * new FindPairs().findPairUsingHashing(arr, 16); // returns true (10 + 6)
 * </pre>
 */
public class FindPairs {

    /**
     * Brute-force approach: check all unique pairs (i, j) with i &lt; j.
     *
     * @param arr the input array; may be {@code null}
     * @param sum the target sum to search for
     * @return {@code true} if two elements in {@code arr} add up to {@code sum},
     *         {@code false} otherwise
     * @complexity Time: O(n^2), Space: O(1)
     */
    public boolean findPairBruteForce(int[] arr, int sum) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        // O(n^2) solution for demonstration purposes
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Two-pointer approach after sorting the array.
     *
     * <p>Sorts the array and uses a left/right pointer to find a pair with the
     * desired sum. This is efficient when extra space must be minimal, but note
     * that sorting modifies the input array in-place.
     *
     * @param arr the input array; may be {@code null}
     * @param sum the target sum to search for
     * @return {@code true} if two elements in {@code arr} add up to {@code sum},
     *         {@code false} otherwise
     * @complexity Time: O(n log n) due to sorting, Space: O(1) extra (depends on
     *             sorting implementation)
     * @implNote this method sorts the provided array in-place using
     *           {@link Arrays#sort(int[])}; if the caller needs the original
     *           order preserve a copy before calling.
     */
    public boolean findPairUsingSortArray(int[] arr, int sum) {
        if (arr == null || arr.length < 2) {
            return false;
        }

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

    /**
     * Hashing approach: for each element {@code x} check whether {@code (sum - x)}
     * has already been seen.
     *
     * @param arr the input array; may be {@code null}
     * @param sum the target sum to search for
     * @return {@code true} if two elements in {@code arr} add up to {@code sum},
     *         {@code false} otherwise
     * @complexity Time: O(n) on average, Space: O(n)
     */
    public boolean findPairUsingHashing(int[] arr, int sum) {
        if (arr == null || arr.length < 2) {
            return false;
        }

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
