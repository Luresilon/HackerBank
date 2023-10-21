import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialNodesInTree {
    static List<List<Integer>> adjList;
    static boolean[] special;

    static int[] dfs(int node, int parent, int dist) {
        int[] res = {node, dist};
        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                int[] subRes = dfs(neighbor, node, dist + 1);
                if (subRes[1] > res[1]) {
                    res = subRes;
                }
            }
        }
        return res;
    }

    static void markSpecial(int node, int parent, int dist, int target) {
        if (dist == target) {
            special[node] = true;
        }
        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                markSpecial(neighbor, node, dist + 1, target - 1);
            }
        }
    }

    static int[] isSpecial(int tree_nodes, int[] tree_from, int[] tree_to) {
        adjList = new ArrayList<>();
        for (int i = 0; i < tree_nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < tree_nodes - 1; i++) {
            adjList.get(tree_from[i] - 1).add(tree_to[i] - 1);
            adjList.get(tree_to[i] - 1).add(tree_from[i] - 1);
        }
        special = new boolean[tree_nodes];

        int[] end1 = dfs(0, -1, 0);
        int[] end2 = dfs(end1[0], -1, 0);

        special[end1[0]] = true;
        special[end2[0]] = true;

        markSpecial(end1[0], -1, 0, end2[1]);

        int[] result = new int[tree_nodes];
        for (int i = 0; i < tree_nodes; i++) {
            result[i] = special[i] ? 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int tree_nodes = 7;
        int[] tree_from = {1, 2, 3, 4, 3, 5, 6};
        int[] tree_to = {2, 3, 4, 5, 6, 7, 7};

        int[] result = isSpecial(tree_nodes, tree_from, tree_to);

        System.out.print("Result: ");
        for (int node : result) {
            System.out.print(node);
        }
        System.out.println();
    }
}
