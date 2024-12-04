package NodeTraversal;

//Leetcode problem: 2583
//Method: BFS Level Traversal

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInABinaryTree {

    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> bfsQueue = new LinkedList<>();

        bfsQueue.add(root);

        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            long sum = 0;

            for(int i = 0;i < size; i++) {
                TreeNode poppedNode = bfsQueue.poll();
                assert poppedNode != null;
                sum += poppedNode.val;
                if(poppedNode.left != null) bfsQueue.add(poppedNode.left);
                if(poppedNode.right != null) bfsQueue.add(poppedNode.right);
            }
            pq.add(sum);
        }
        if(pq.size() < k) return -1L;
        else {
            for(int i = 0; i < k - 1; i++) pq.poll();
            return pq.isEmpty() ? -1L : pq.peek();
        }
    }
    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, four, six);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8, two, one);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9, three, seven);
        TreeNode root = new TreeNode(5, eight, nine);

        System.out.println(kthLargestLevelSum(root, 2));

    }
}



