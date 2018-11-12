package reconstructitinerary;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
       // String[][] t = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] t2 =
                {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<String> li = s.findItinerary(t2);
        System.out.println(li);
    }

    public List<String> findItinerary(String[][] tickets) {
        Graph g = new Graph();
        g.createEdges(tickets);
        return g.DFS("JFK");
    }
}


class Graph {
    Set<String> cities;
    int hops;
    Map<String, LinkedList<String>> adj;

    Graph() {
        adj = new HashMap<>();
        cities = new HashSet<>();
        hops = 0;
    }

    void createEdges(String[][] tickets) {
        hops = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            boolean addedNew = cities.add(from);
            if (addedNew) {
                adj.put(from, new LinkedList<String>());
            }
            addedNew = cities.add(to);
            if (addedNew) {
                adj.put(to, new LinkedList<String>());
            }
            adj.get(from).add(to);
        }
        for (String city : cities) {
            Collections.sort(adj.get(city));
        }
    }

    List<String> DFS(String city) {
        List<String> itinerary = new LinkedList<String>();
        DFS(city, itinerary, hops);
        Collections.reverse(itinerary);
        return itinerary;
    }

    boolean DFS(String city, List<String> itinarary, int hops) {
        if (hops == 0) {
            itinarary.add(city);
            return true;
        }

        int numChildren = adj.get(city).size();
        for (int i = 0; i < numChildren; i++) {
            String to = adj.get(city).removeFirst();
            boolean isValid = DFS(to, itinarary, hops - 1);
            if (isValid) {
                itinarary.add(city);
            } else {
                adj.get(city).add(to);
            }
            if (isValid) {
                return true;
            }
        }
        return false;
    }
}
