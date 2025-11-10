package problems.pairs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindPairsTest {

    private final FindPairs finder = new FindPairs();

    @Test
    public void testFindPairBruteForce_basicTrue() {
        int[] arr = {1, 4, 45, 6, 10, -8};
        assertTrue(finder.findPairBruteForce(arr, 16)); // 10 + 6
    }

    @Test
    public void testFindPairBruteForce_basicFalse() {
        int[] arr = {1, 2, 3, 4};
        assertFalse(finder.findPairBruteForce(arr, 100));
    }

    @Test
    public void testFindPairBruteForce_nullOrShortArray() {
        assertFalse(finder.findPairBruteForce(null, 5));
        assertFalse(finder.findPairBruteForce(new int[]{}, 5));
        assertFalse(finder.findPairBruteForce(new int[]{1}, 1));
    }

    @Test
    public void testFindPairBruteForce_duplicates() {
        int[] arr = {5, 5};
        assertTrue(finder.findPairBruteForce(arr, 10));
    }

    @Test
    public void testFindPairUsingSortArray_basicTrue() {
        int[] arr = {1, 4, 45, 6, 10, -8};
        assertTrue(finder.findPairUsingSortArray(arr, 16)); // 10 + 6
    }

    @Test
    public void testFindPairUsingSortArray_basicFalse() {
        int[] arr = {1, 2, 3, 4};
        assertFalse(finder.findPairUsingSortArray(arr, 100));
    }

    @Test
    public void testFindPairUsingSortArray_nullOrShortArray() {
        assertFalse(finder.findPairUsingSortArray(null, 5));
        assertFalse(finder.findPairUsingSortArray(new int[]{}, 5));
        assertFalse(finder.findPairUsingSortArray(new int[]{1}, 1));
    }

    @Test
    public void testFindPairUsingSortArray_duplicates() {
        int[] arr = {5, 5};
        assertTrue(finder.findPairUsingSortArray(arr, 10));
    }

    @Test
    public void testFindPairUsingHashing_basicTrue() {
        int[] arr = {1, 4, 45, 6, 10, -8};
        assertTrue(finder.findPairUsingHashing(arr, 16)); // 10 + 6
    }

    @Test
    public void testFindPairUsingHashing_basicFalse() {
        int[] arr = {1, 2, 3, 4};
        assertFalse(finder.findPairUsingHashing(arr, 100));
    }

    @Test
    public void testFindPairUsingHashing_nullOrShortArray() {
        assertFalse(finder.findPairUsingHashing(null, 5));
        assertFalse(finder.findPairUsingHashing(new int[]{}, 5));
        assertFalse(finder.findPairUsingHashing(new int[]{1}, 1));
    }

    @Test
    public void testFindPairUsingHashing_duplicates() {
        int[] arr = {5, 5};
        assertTrue(finder.findPairUsingHashing(arr, 10));
    }

    @Test
    public void testFindPairWithNegativeNumbers() {
        int[] arr = {-3, 1, 4, 2, -1};
        assertTrue(finder.findPairBruteForce(arr, 1)); // -3 + 4
        assertTrue(finder.findPairUsingSortArray(arr, 1));
        assertTrue(finder.findPairUsingHashing(arr, 1));
    }

    @Test
    public void testFindPairWithZeroSum() {
        int[] arr = {0, 0, 1, 2};
        assertTrue(finder.findPairBruteForce(arr, 0));
        assertTrue(finder.findPairUsingSortArray(arr, 0));
        assertTrue(finder.findPairUsingHashing(arr, 0));
    }
}
