package rotatearray;

class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        if(k == nums.length)
            return;
        int barrier = nums.length - k;
        reverse(nums, 0, barrier - 1);
        reverse(nums, barrier, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int nums[], int start, int end) {
        if(start >= end)
            return;
        int mid = (start + end)/2;
        while(start <= mid && start < end) {
            swap(nums,start++,end--);
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int t = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = t;
    }
}
