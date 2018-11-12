package grab2;

class Solution {
    public int solution(int[] a) {
        return getCount(a);
    }

    int getCount(int[] a) {
        boolean[] isDec = new boolean[1001];
        int n = a.length;
        isDec[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                break;
            }
            isDec[i] = true;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 == n || (isDec[i + 1] && (i == 0 || a[i + 1] >= a[i - 1]))) {
                ans++;
            }
            // if(i!=0 && a[i]<a[i-1]) {
            // break;
            // }
        }
        return ans;
    }
}