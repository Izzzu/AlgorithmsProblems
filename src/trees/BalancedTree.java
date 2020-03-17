package trees;

public class BalancedTree {

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
 
    public int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }
        if(getHeight(A)==-1) {
            return 0;
        }
        return 1;
    }

    private int getHeight(TreeNode a) {
        if(a == null) {
            return 0;
        }
        int left = getHeight(a.left);
        int right = getHeight(a.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right)+1;

    }

}
