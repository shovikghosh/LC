package longestcommonprefix;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = { "aa", "aa", "aaa"};
        System.out.println(s.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = "";
        int i = 0;
        while (true) {
            Character c = null;
            for (String s : strs) {
                try {
                    if (c != null) {
                        if (c == s.charAt(i)) {
                            continue;
                        } else {
                            return common;
                        }
                    } else {
                        c = s.charAt(i);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    return common;
                }
            }
            common = common + c.toString();
            i++;
        }
    }
}