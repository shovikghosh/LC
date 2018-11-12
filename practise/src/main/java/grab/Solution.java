package grab;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, 14));
        System.out.println(s.solution(48, 98));
    }
    public String solution(int A, int B) {
        return generate(A, B, 2, 2, "", A+B);
    }

    String generate(int A, int B, int aCount, int bCount, String uptilNow, int total) {
        if(A>B) {
            if (A > 0 && aCount > 0) {
                String x = generate(A - 1, B, aCount - 1, 2, uptilNow + "a", total);
                if (x.length() == total) {
                    return x;
                } else {
                    return generate(A, B - 1, 2, bCount - 1, uptilNow + "b", total);
                }

            } else if (B > 0 && bCount > 0) {
                return generate(A, B - 1, 2, bCount - 1, uptilNow + "b", total);
            } else {
                return uptilNow;
            }
        } else {
            if (B > 0 && bCount > 0) {
                String x = generate(A, B - 1, 2, bCount - 1, uptilNow + "b", total);
                if (x.length() == total) {
                    return x;
                } else {
                    return generate(A - 1, B, aCount - 1, 2, uptilNow + "a", total);
                }

            } else if (A > 0 && aCount > 0) {
                return generate(A - 1, B, aCount - 1, 2, uptilNow + "a", total);
            } else {
                return uptilNow;
            }
        }
        
    }
}