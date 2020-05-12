package dp;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
public class MaxPathBinaryTree {
    public int maxPathSum(TreeNode A) {

        if (A == null) return Integer.MIN_VALUE;
        int m = maxPathSum(A.left);
        int n = maxPathSum(A.right);


        return Math.max(Math.max(m, n), A.val + calc(A.right) + calc(A.left));
    }

    private int calc(TreeNode a) {
        if (a == null) {
            return 0;
        }

        int left = (a.left != null) ? calc(a.left) : 0;
        int right = (a.right != null) ? calc(a.right) : 0;
        int m = Math.max(left, right);

        return Math.max(m, a.val + m);
    }
}
