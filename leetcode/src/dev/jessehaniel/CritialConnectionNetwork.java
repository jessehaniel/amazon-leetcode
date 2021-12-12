package dev.jessehaniel;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CritialConnectionNetwork {

    // There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections
    // forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi.
    // Any server can reach other servers directly or indirectly through the network.
    // A critical connection is a connection that, if removed, will make some servers
    // unable to reach some other server.
    // Return all critical connections in the network in any order.

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<SimpleEntry<Integer, Integer>, Boolean> connDict;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.formGraph(n, connections);
        this.dfs(0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (SimpleEntry<Integer, Integer> criticalConnection : this.connDict.keySet()) {
            result.add(new ArrayList<>(Arrays.asList(criticalConnection.getKey(), criticalConnection.getValue())));
        }

        return result;
    }

    private int dfs(int node, int discoveryRank) {

        // That means this node is already visited. We simply return the rank.
        if (this.rank.get(node) != null) {
            return this.rank.get(node);
        }

        // Update the rank of this node.
        this.rank.put(node, discoveryRank);

        // This is the max we have seen till now. So we start with this instead of INT_MAX or something.
        int minRank = discoveryRank + 1;

        for (Integer neighbor : this.graph.get(node)) {

            // Skip the parent.
            Integer neighRank = this.rank.get(neighbor);
            if (neighRank != null && neighRank == discoveryRank - 1) {
                continue;
            }

            // Recurse on the neighbor.
            int recursiveRank = this.dfs(neighbor, discoveryRank + 1);

            // Step 1, check if this edge needs to be discarded.
            if (recursiveRank <= discoveryRank) {
                int sortedU = Math.min(node, neighbor), sortedV = Math.max(node, neighbor);
                this.connDict.remove(new SimpleEntry<>(sortedU, sortedV));
            }

            // Step 2, update the minRank if needed.
            minRank = Math.min(minRank, recursiveRank);
        }

        return minRank;
    }

    private void formGraph(int n, List<List<Integer>> connections) {

        this.graph = new HashMap<>();
        this.rank = new HashMap<>();
        this.connDict = new HashMap<>();

        // Default rank for unvisited nodes is "null"
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<>());
            this.rank.put(i, null);
        }

        for (List<Integer> edge : connections) {

            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);

            int sortedU = Math.min(u, v);
            int sortedV = Math.max(u, v);
            connDict.put(new SimpleEntry<>(sortedU, sortedV), true);
        }
    }

    public static void main(String[] args) {
        var app = new CritialConnectionNetwork();
        var output = app.criticalConnections(4, List.of(List.of(0,1), List.of(1,2), List.of(2,0), List.of(1,3)));
        System.out.println(output);//[1,3]
        output = app.criticalConnections(2, List.of(List.of(0,1)));
        System.out.println(output);//[0,1]
    }

}
