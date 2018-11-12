package subarraysumequalsk;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 1, 1};
        int res = s.subarraySum(arr, 2);
        System.out.println(res);
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int target = sum - k;
            count += preSum.getOrDefault(target, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int len = 1; len <= nums.length; len++) {
            int sum = 0;
            for (int p = 0; p < len; p++) {
                sum += nums[p];
            }
            if (sum == k) {
                count++;
            }
            for (int i = 1; i + len - 1 < nums.length; i++) {
                sum = sum + nums[len + i - 1] - nums[i - 1];
                // System.out.println("LEN:" + len + ":" + "I:" + i + ":" + sum);
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
