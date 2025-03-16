package mergesortedarray;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2idx = n - 1;
        int nums1idx = m - 1;
        int finalidx = n + m - 1;
        while (finalidx >= 0 ) {
            if (nums2idx < 0) {
                nums1[finalidx--] = nums1[nums1idx--];
            } else
            if (nums1idx <  0  || nums2[nums2idx] > nums1[nums1idx]) {
                nums1[finalidx--] = nums2[nums2idx--];
            } else {
                nums1[finalidx--] = nums1[nums1idx--];
            }
        }
    }
}
