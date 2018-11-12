package kthlargest;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {7,6,5,4,3,2,1};
        int k = 5;
        int kl = s.findKthLargest(nums, k);
        System.out.println(kl);
    }

    public int findKthLargest(int[] nums, int k) {
        return getKth(nums, 0, nums.length - 1, k);
    }

    int getKth(int[] nums, int l, int r, int k) {
        int i;
        int[] medians;
        int len = r - l + 1;
        medians = new int[(nums.length + 4) / 5];
        for (i = 0; i < len / 5; i++) {
            medians[i] = getMedian(nums, l + i * 5, 5);
        }
        if (i * 5 < len) {
            medians[i] = getMedian(nums, l + i * 5, len % 5);
            i++;
        }
        int mom = i == 1 ? medians[0] : getKth(medians, 0, i - 1, i / 2);

        int pos = partition(nums, l, r, mom);
        if (pos - l == k - 1) {
            return nums[pos];
        } else if (pos - l > k - 1) {
            return getKth(nums, l, pos - 1, k);
        } else {
            return getKth(nums, pos + 1, r, k + l - pos - 1);
        }
    }

    int partition(int[] arr, int l, int r, int pivot) {
        int i = l;
        do {
            if (pivot == arr[i]) {
                swap(arr, i, r);
                break;
            }
        } while (++i < r);
        i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] >= pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        return i;
    }

    int getMedian(int[] nums, int start, int len) {
        int limit = start + len;
        for (int i = start; i < limit; i++) {
            for (int j = i + 1; j < limit; j++) {
                if (nums[i] <= nums[j])
                    swap(nums, i, j);
            }
        }
        return nums[start + len / 2];
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
