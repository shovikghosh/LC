package lexicographicallysmalleststringafteroperationswithconstraint;

class Solution {
    public String getSmallestString(String s, int k) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (k > 0 && idx < s.length()) {
            char ch = s.charAt(idx++);
            int steps = getStepsToA(ch);
            if (steps < k) {
                sb.append('a');
                k-= steps;
            } else if (steps == k) {
                sb.append('a');
                k = 0;
            } else {
                char sm = getSmallestLetter(ch, k);
                sb.append(sm);
                k = 0;
            }
        }
        sb.append(s.substring(idx));
        return sb.toString();
    }

    public int getStepsToA(char ch) {
        int v = ch - 'a';
        if (v > 13)
            return 26 - v;
        else return v;
    }

    public char getSmallestLetter(char ch, int k) {
        return (char)((ch - 'a') - k + 'a');
    }
}
