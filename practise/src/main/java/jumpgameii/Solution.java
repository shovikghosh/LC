package jumpgameii;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] visited = new boolean[nums.length];
        return jump(nums, visited, q, 0);
    }

    private int jump(int[] nums, boolean[] visited, Queue<Integer> q, int steps) {
        Queue<Integer> tq = new LinkedList<>();
        while (!q.isEmpty()) {
            int position = q.poll();
            if (position >= nums.length - 1)
                return steps;
            int nextPossiblePosition = nums[position] + position;
            while (nextPossiblePosition > position) {
                if (nextPossiblePosition < nums.length && !visited[nextPossiblePosition]) {
                    tq.add(nextPossiblePosition);
                    visited[nextPossiblePosition] = true;
                }
                nextPossiblePosition--;
            }
        }
        return jump(nums, visited, tq, steps + 1);
    }
}
