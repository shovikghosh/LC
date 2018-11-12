package containerwithmostwater;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(arr));
    }
    public int maxArea(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return sum;
    }
}