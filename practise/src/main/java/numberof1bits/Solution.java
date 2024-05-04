package numberof1bits;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += (n&0b1);
            n = n>>1;
        }
        return count;
    }
}
