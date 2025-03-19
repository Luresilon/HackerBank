package Medium;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindEventualSageStates {

    public static boolean dfs(int node, int[][] adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj[node]) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }


    public static List<Integer> eventualSafeStates(int[][] graphs) {
        List<Integer> safeNodes = new ArrayList<>();
//        List<Integer> safeNeigh = new ArrayList<>();

        for(int i = 0; i < graphs.length; i++) {
            if(graphs[i].length == 0) safeNodes.add(i);
        }

        for(int i = 0; i < graphs.length; i++) {
            if(graphs[i].length == 0) continue;
            if(graphs[i].length == 1 && safeNodes.contains(graphs[i][0])) safeNodes.add(i);
        }

        return safeNodes.stream().sorted(Comparator.comparingInt(Integer -> Integer)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] graphs = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graphs2 = {{1,2},{2, 3},{5},{0},{5}, {}, {}};
        int[][] graphs3 = {{},{0, 2, 3, 4},{3},{4},{}};

        System.out.print(eventualSafeStates(graphs3));
    }
}
