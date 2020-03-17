package trees;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode A) {
        if (A == null) return 0;

        int depthLeft = maxDepth(A.left);
        int depthRight = maxDepth(A.right);

        return Math.max(depthLeft, depthRight) + 1;
    }
}
