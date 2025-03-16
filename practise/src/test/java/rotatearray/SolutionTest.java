package rotatearray;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        int nums[] = {1,2,3,4,5,6,7};
        int expectedNums[] = {5,6,7,1,2,3,4};
        s.rotate(nums, 3);
        Assertions.assertArrayEquals(nums, expectedNums);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int nums[] = {-1,-100,3,99};
        int expectedNums[] = {3,99,-1,-100};
        s.rotate(nums, 2);
        Assertions.assertArrayEquals(nums, expectedNums);
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int nums[] = {1,2};
        int expectedNums[] = {2,1};
        s.rotate(nums, 5);
        Assertions.assertArrayEquals(nums, expectedNums);
    }
}
