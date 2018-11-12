package medianoftwosortedarrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = { 2, 4, 6, 8, 9 };
        int[] n2 = { 5, 7, 10, 11 };
        double x = s.findMedianSortedArrays(n1, n2);
        System.out.println(x);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int toRemove = totalLen % 2 == 1 ? totalLen - 1 : totalLen - 2;
        return findMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, toRemove);
    }

    double findMedian(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int numsToBeExcluded) {
        if (numsToBeExcluded <= 0) {
            double sum = 0.0;
            int count = 0;
            for (int i = s1; i <= e1; i++) {
                sum += nums1[i];
                count++;
            }
            for (int i = s2; i <= e2; i++) {
                sum += nums2[i];
                count++;
            }
            return sum / count;
        }
        int m1 = getMid(s1, e1);
        int m2 = getMid(s2, e2);
        int mElem1 = nums1[m1];
        int mElem2 = nums2[m2];
        int oldRem = numsToBeExcluded;
        if (mElem1 < mElem2) {
            numsToBeExcluded -= (m1 - s1);
            numsToBeExcluded -= (e2 - m2);
            s1 = m1;
            e2 = m2;
        } else {
            numsToBeExcluded -= (e1 - m1);
            numsToBeExcluded -= (m2 - s2);
            s2 = m2;
            e1 = m1;
        }
        if (oldRem == numsToBeExcluded) {

        }
        return findMedian(nums1, nums2, s1, e1, s2, e2, numsToBeExcluded);
    }

    int getMid(int start, int end) {
        return (start + end) / 2;
    }

    double getMedian(int[] nums) {
        int len = nums.length;
        if (len % 2 == 1) {
            return nums[len / 2];
        } else {
            return (nums[len] + nums[len + 1]) / 2;
        }
    }
}