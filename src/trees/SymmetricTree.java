package trees;

public class SymmetricTree {

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isMirrored(A, A);
    }

    private int isMirrored(TreeNode a, TreeNode b) {
        if (b == null && a == null) {
            return 1;
        } else if (a != null && b != null && a.val == b.val && isMirrored(a.right, b.left) == 1 && isMirrored(a.left, b.right) == 1) {
            return 1;
        }
        return 0;
    }
}
