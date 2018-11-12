package minencode;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String x = "ABCABCDABCABC";
        System.out.println(s.encodedLength(x));
    }
    int encodedLength(String s) {
        int ptr = 1;
        int len = s.length();
        int reduction = 0;
        while (ptr <= len / 2) {
            if (isCollapsible(s, ptr)) {
                reduction += ptr - 1;
            }
            ptr++;
        }
        return s.length() - reduction;
    }

    boolean isCollapsible(String str, int partition) {
        String left = str.substring(0, partition);
        String right = str.substring(partition, partition * 2);
        return left.equals(right);
    }
}
