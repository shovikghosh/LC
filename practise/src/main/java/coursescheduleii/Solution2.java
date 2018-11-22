package coursescheduleii;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] x = s.findOrder(numCourses, prerequisites);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph2 g = new Graph2(numCourses);
        g.createEdges(prerequisites);
        List<Integer> s = g.topoSort();
        return s.stream().mapToInt(i -> i).toArray();
    }
}

class Graph2 {
    int V;
    List<List<Integer>> adj;
    Map<Integer, Integer> indegree;

    Graph2(int v) {
        V = v;
        adj = new ArrayList<>();
        indegree = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
            indegree.put(i,0);
        }
    }

    void createEdges(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            int t = indegree.get(prerequisites[i][1]);
            indegree.put(prerequisites[i][1], t + 1);
        }
    }

    // Kahn's Algo
    List<Integer> topoSort() {
        Stack<Integer> S = new Stack<>();
        List<Integer> L = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree.get(i) == 0) {
                S.push(i);
            }
        }

        while (!S.isEmpty()) {
            int n = S.pop();
            L.add(n);
            for (int m : adj.get(n)) {
                int id = indegree.get(m);
                id--;
                indegree.put(m, id);
                if (id == 0) {// when we have set 0
                    S.push(m);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree.get(i) != 0) {
                return new LinkedList<>();
            }
        }
        Collections.reverse(L);
        return L;
    }
}