package firstmissingpositive;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 7, 8, 9, 11, 12};
        int x = s.firstMissingPositive(nums);
        System.out.println(x);
    }

    public int firstMissingPositive(int[] nums) {
        int pCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                pCount++;
                set.add(n);
            }
        }
        for (int i = 1; i <= pCount; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return pCount + 1;
    }
}