package twosumiiinputarrayissorted;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return twoSum(numbers, 0, numbers.length - 1, target);
    }

    public int[] twoSum(int[] numbers, int startIdx, int endIdx, int target) {
        int sum = numbers[startIdx] + numbers[endIdx];
        if (sum == target)
            return new int[]{startIdx + 1, endIdx + 1};
        else if (sum < target) {
            startIdx = findNewStartIdx(numbers, startIdx + 1, endIdx - 1, target - numbers[endIdx]);
        } else {
            endIdx = findNewEndIdx(numbers, startIdx + 1, endIdx - 1, target - numbers[startIdx]);
        }
        return twoSum(numbers, startIdx, endIdx, target);
    }

    public int findNewStartIdx(int[] numbers, int startIdx, int endIdx, int target) {
        if (startIdx == endIdx) {
            return startIdx;
        }
        int idx = (startIdx + endIdx) / 2;
        if (idx == startIdx)
            return idx;
        int num = numbers[idx];
        if (num == target)
            return idx;
        else if (num > target) {
            return findNewStartIdx(numbers, startIdx, idx, target);
        } else {
            return findNewStartIdx(numbers, idx, endIdx, target);
        }
    }

    public int findNewEndIdx(int[] numbers, int startIdx, int endIdx, int target) {
        if (startIdx == endIdx) {
            return startIdx;
        }
        int idx = Math.ceilDiv(startIdx + endIdx, 2);
        if (idx == endIdx)
            return idx;
        int num = numbers[idx];
        if (num == target)
            return idx;
        else if (num > target) {
            return findNewEndIdx(numbers, startIdx, idx, target);
        } else {
            return findNewEndIdx(numbers, idx, endIdx, target);
        }
    }
}
