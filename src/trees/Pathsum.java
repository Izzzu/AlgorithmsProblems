package trees;

public class Pathsum {

    public int hasPathSum(TreeNode A, int B) {

        if (A == null) return 0;
        if (A.left == null && A.right == null && B == A.val) return 1;
        if (hasPathSum(A.left, B - A.val) == 1 || hasPathSum(A.right, B-A.val) == 1) return 1;
        else return 0;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1000);
        treeNode.right = new TreeNode(200);
        System.out.println(new Pathsum().hasPathSum(treeNode, 1000));
    }

}
