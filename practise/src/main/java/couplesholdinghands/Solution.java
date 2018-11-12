package couplesholdinghands;

//import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] row = {0, 2, 1, 3};
        System.out.println(s.minSwapsCouples(row));
    }
    public int minSwapsCouples(int[] row) {
        boolean isSafe = false;
        int swaps = 0;
        while(!isSafe) {
            int i = getFirstUnsafe(row);
            if (i < 0) {
                break;
            }
            swaps++;
        }
        return swaps;
    }

    void swap(int[] row, int src) {

    }



    int getFirstUnsafe(int[] row) {
        for(int i = 0; i < row.length; i+=2) {
            if (row[i+1] != getPair(row[i])) {
                return i;
            }
        }
        return -1;
    } 

    int getPair(int person) {
        if (person % 2 == 0) {
            return person + 1;
        } else {
            return person - 1;
        }
    }
}
