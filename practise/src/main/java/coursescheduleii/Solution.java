package coursescheduleii;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] x = s.findOrder(numCourses, prerequisites);
        for (int i = 0; i < x.length; i++) {
            //System.out.println(x[i]);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        g.createEdges(prerequisites);
        if (g.isCyclic()) {
            return new int[0];
        } else {
            List<Integer> s = g.topoSort();
            return s.stream().mapToInt(i -> i).toArray();
        }
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
            boolean isC = isCyclic(n, visited, curPath);
            if (isC) {
                return true;
            }
        }

        curPath.remove(i);
        return false;
    }

    List<Integer> topoSort() {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new LinkedList<>();
        Set<Integer> recStack = new HashSet<>();
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                topoSort(i, visited, path, recStack);
            }
        }
        return path;
    }

    void topoSort(Integer node, Set<Integer> visited, List<Integer> curPath, Set<Integer> recStack) {
        if(recStack.contains(node))
        visited.add(node);
        for (Integer n : adj.get(node)) {
            if (!visited.contains(n)) {
                topoSort(n, visited, curPath, recStack);
            }
        }
        curPath.add(node);
    }
}