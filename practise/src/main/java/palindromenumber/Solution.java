package palindromenumber;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString().equals(s);
    }
}
