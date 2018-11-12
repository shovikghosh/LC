package continuoussubarraysum;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3 };
        System.out.println(s.checkSubarraySum(nums, 5));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (k == 0) {
            return has2ContinuousZeros(nums);
        }
        if (k < 0) {
            k = -k;
        }
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int last = 0;
        for (int n : nums) {
            sum += n;
            sum %= k;
            if (set.contains(sum)) {
                return true;
            }
            set.add(last);
            last = sum;
        }
        return false;
    }

    boolean has2ContinuousZeros(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        //System.out.println("Shovik");
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }
            i++;
        }
        return false;
    }
}
