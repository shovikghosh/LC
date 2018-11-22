package courseschedule;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 3;
        int[][] prerequisites = {{1,0}, {1,2}};
        boolean r = s.canFinish(numCourses, prerequisites);
        System.out.println(r);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        g.createEdges(prerequisites);
        return !g.isCyclic();
    }
}


class Graph {
    int V;
    List<List<Integer>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    void createEdges(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
           adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }

    boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> curPath = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (isCyclic(i, visited, curPath)) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclic(int i, Set<Integer> visited, Set<Integer> curPath) {
        if (curPath.contains(i)) {
            return true;
        }
        if (visited.contains(i)) {
            return false;
        }

        visited.add(i);
        curPath.add(i);

        for (Integer n : adj.get(i)) {
            boolean isC =  isCyclic(n, visited, curPath);
            if (isC) {
                return true;
            }
        }

        curPath.remove(i);
        return false;
    }
}
