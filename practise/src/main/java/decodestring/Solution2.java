package decodestring;

import java.util.*;

class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String str = "sd2[f2[e]g]i";
        //str  = "2[a]bcde2[f]";
        str = "1[" + str + "]";
        String ans = s.decodeString(str);
        System.out.println(ans);
    }
    public String decodeString(String s) {
        Stack<Integer> multiplier = new Stack<>();
        Stack<String> ch = new Stack<>();
        String[] cArr = s.split("");
        int i = 0;
        String seq = "";
        String pre = "";
        boolean lastCharInt = true;
        do {
            String cStr = cArr[i++];
            if (cStr.equals("[")) {
                lastCharInt = false;
                Integer m = Integer.parseInt(seq);
                multiplier.push(m);
                seq = "";
            }  else if (cStr.equals("]")) {
                lastCharInt = false;
                if (seq.length() != 0) {
                    ch.push(seq);
                    seq = "";
                }
                String temp = pre + getRepeatedStr(ch.pop(), multiplier.pop());
                pre = "";
                ch.push(temp);
                multiplier.push(1);
            } else {
                boolean curCharInt = isInt(cStr);
                if ((!lastCharInt) && curCharInt) {
                    lastCharInt = true;
                    pre = seq;
                    seq = cStr;
                } else {
                    seq += cStr;
                }
            }
        } while(i < cArr.length);
        String res = "";
        while(!ch.isEmpty()) {
            res = ch.pop() + res;
        }
        return res;
    }

    String getRepeatedStr(String str, int times) {
        String res = "";
        while(times-- > 0) {
            res += str;
        }
        return res;
    }

    boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
}
