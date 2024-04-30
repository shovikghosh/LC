package jumpgameii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testJump() {
        int[] nums = {2,3,1,1,4};
        Solution s = new Solution();
        assertEquals(2, s.jump(nums));
    }

    @Test
    public void testJump_2() {
        int[] nums = {2,3,0,1,4};
        Solution s = new Solution();
        assertEquals(2, s.jump(nums));
    }

    @Test
    public void testJump_3() {
        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};

        Solution s = new Solution();
        assertEquals(13, s.jump(nums));
    }

    @Test
    public void testJump_4() {
        int[] nums = new int[1000];
        int idx = 0;
        for (int i = 1000; i > 0 ; i--) {
            nums[idx++] = i;
        }

        Solution s = new Solution();
        assertEquals(1, s.jump(nums));
    }
}
