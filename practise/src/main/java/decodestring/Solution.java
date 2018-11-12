package decodestring;

import java.util.*;

class Solution {
    public String decodeString(String s) {
        String res = "";
        String[] cArr = s.split("");
        return "";
    }

    public String getString(String[] cArr, int start) {
        String res = "";
        int i = start;
        int len = cArr.length;
        boolean lastCharInt = false;
        while (i < len) {
            String cStr = cArr[i];
            if (cStr.equals("[")) {
                lastCharInt = false;

            } else if (cStr.equals("]")) {
                lastCharInt = false;

            } else if (isInt(cStr)) {
                if (!lastCharInt) {
                    //res +=  getString(cArr, );
                }
                lastCharInt = true;
            } else {
                // is string
                lastCharInt = false;
                res += cStr;
            }
        }
        return "";//jghd
    }

    boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

