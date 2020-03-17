package trees;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode A) {
        if (A == null) return 0;
        if (A.right == null && A.left == null) return 1;

        int depthLeft = Integer.MAX_VALUE;
        if (A.left!= null) depthLeft = minDepth(A.left);
        int depthRight = Integer.MAX_VALUE;
        if (A.right!= null) depthRight = minDepth(A.right);

        return Math.min(depthLeft, depthRight) + 1;
    }
}
