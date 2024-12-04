package NodeTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode Problem: 2641
public class CousinsInBinaryTreeII {
    public static TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Integer> levelSums = new ArrayList<>();
        nodeQueue.offer(root);

        bfsSum(root, nodeQueue, levelSums);

        return bfsUpdate(root, nodeQueue, levelSums);
    }

    public static void bfsSum(TreeNode root, Queue<TreeNode> nodeQueue, List<Integer> levelSums) {
        while(!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            int levelSum = 0;

            for(int i = 0; i < levelSize; i++) {
                TreeNode tmp = nodeQueue.poll();
                assert tmp != null;
                levelSum += tmp.val;

                if(tmp.left != null) nodeQueue.offer(tmp.left);
                if(tmp.right != null) nodeQueue.offer(tmp.right);
            }
            levelSums.add(levelSum);
        }
    }

    public static TreeNode bfsUpdate(TreeNode root, Queue<TreeNode> nodeQueue, List<Integer> levelSums) {
        nodeQueue.offer(root);
        root.val = 0;
        int levelIndex = 1;

        while(!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                assert currentNode != null;
                int siblingSum =
                        (currentNode.left != null ? currentNode.left.val : 0) +
                        (currentNode.right != null ? currentNode.right.val : 0);

                if(currentNode.left != null) {
                    currentNode.left.val = levelSums.get(levelIndex) - siblingSum;
                    nodeQueue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    currentNode.right.val = levelSums.get(levelIndex) - siblingSum;
                    nodeQueue.offer(currentNode.right);
                }
            }
            levelIndex++;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9, null, new TreeNode(7));
        TreeNode four = new TreeNode(4, new TreeNode(1), new TreeNode(10));
        TreeNode root = new TreeNode(5, four, nine);

        System.out.println(replaceValueInTree(root).right.right.val);
    }
}
