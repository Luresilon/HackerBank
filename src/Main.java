import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 13; // Number of nodes
        List<String> edges = Arrays.asList("1 3", "3 4", "3 5", "4 6", "2 4", "7 8", "8 9", "10 11");

        Map<Integer, List<Integer>> graph = buildGraph(n, edges);
        List<Integer> weights = new ArrayList<>();

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int weight = dfs(i, graph, visited);
                weights.add(weight);
            }
        }

        double sum = 0.0;
        for (int weight : weights) {
            double logWeight = Math.log(weight);
            sum += Math.floor(logWeight);
        }

        int result = (int) sum;
        System.out.println(result);
    }

    // DFS to find the size of connected components
    private static int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int size = 1;
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, graph, visited);
            }
        }
        return size;
    }

    // Build an adjacency list representation of the graph
    private static Map<Integer, List<Integer>> buildGraph(int n, List<String> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (String edge : edges) {
            String[] parts = edge.split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return graph;
    }
}
