package twosumiiinputarrayissorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void twoSum() {
        int[] numbers = new int[] {2,7,11,15};
        int target = 9;
        Solution s = new Solution();
        int[] res = s.twoSum(numbers, target);
        assertEquals(res[0], 1);
        assertEquals(res[1], 2);
    }

    @Test
    void twoSum_2() {
        int[] numbers = new int[] {2,3,4};
        int target = 6;
        Solution s = new Solution();
        int[] res = s.twoSum(numbers, target);
        assertEquals(res[0], 1);
        assertEquals(res[1], 3);
    }

    @Test
    void twoSum_3() {
        int[] numbers = new int[] {-1,0};
        int target = -1;
        Solution s = new Solution();
        int[] res = s.twoSum(numbers, target);
        assertEquals(res[0], 1);
        assertEquals(res[1], 2);
    }
}
