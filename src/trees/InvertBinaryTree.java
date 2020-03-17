package trees;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode A) {

            if (A == null) {
                return A;
            }

            swap(A);

            invertTree(A.left);
            invertTree(A.right);

            return A;
    }

    private void swap(TreeNode A) {
        if (A == null) {
            return;
        }
        TreeNode node = A.right;
        A.right = A.left;
        A.left = node;
    }


}
