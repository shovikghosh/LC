package maximumproductsubarray;

class Solution {
    public int maxProduct(int[] nums) {
        return calculate(nums);
    }

    int calculate(int[] nums) {
        int min, max, val, tempMin, tempMax, x, y;
        min = max = val = nums[0];
        int i = 0;
        while (++i < nums.length) {
            x = nums[i] * min;
            y = nums[i] * max;
            tempMin = Math.min(x, y);
            tempMax = Math.max(x, y);
            min = Math.min(nums[i], tempMin);
            max = Math.max(nums[i], tempMax);
            val = Math.max(val, max);
        }
        return val;
    }

}