package NodeTraversal;

import javax.swing.plaf.ColorUIResource;
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
    TreeNode(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) return;

        this.val = Integer.parseInt(nodes[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
    }
}
