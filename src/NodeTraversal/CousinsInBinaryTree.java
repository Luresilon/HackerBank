package NodeTraversal;

public class CousinsInBinaryTree {
    public static TreeNode xParent = null, yParent = null;
    public static int xDepth = -1, yDepth = -2;

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    public static void dfs(TreeNode root, int x, int y, int depth) {
        if(root == null) return;
        else if (root.val == x) {
            xParent = root;
            xDepth = depth;
        } else if (root.val == y) {
            yParent = root;
            yDepth = depth;
        } else {
            dfs(root.left, x, y, depth + 1);
            dfs(root.right, x, y, depth + 1);
        }
    }

    public static void main(String[] args) {

        TreeNode two = new TreeNode(2, new TreeNode(4), null);
        TreeNode three = new TreeNode(3, new TreeNode(5), null);
        TreeNode root = new TreeNode(1, two, three);
        int x = 4, y = 5;
        System.out.println(isCousins(root, x, y));
    }
}
