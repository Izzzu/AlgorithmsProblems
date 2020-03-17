package trees;

public class LowestCommonAncestor {
    public int lca(TreeNode A, int B, int C) {
            boolean b= exists(A, B);
            boolean c= exists(A, C);
            if (b&&c) {
                TreeNode lca = findLCA(A, B, C);

                if (lca!= null){
                    return lca.val;
                } else {
                    return -1;
                }
            } else{
                return -1;
        }
    }

    private TreeNode findLCA(TreeNode node, int b, int c) {
        if (node == null) {
            return null;
        } else {
            if (node.val == b || node.val == c) {
                return node;
            }
            TreeNode left = findLCA(node.left, b, c);
            TreeNode right = findLCA(node.right, b, c);
            if (left != null && right != null) {
                return node;
            } else if (left!= null) {
                return left;
            } else return right;
        }
    }

    private boolean exists(TreeNode a, int val) {

        if (a == null) {
            return false;
        } else {
            if (a.val == val || exists(a.left, val)) {
                return true;
            } else {
                return exists(a.right, val);
            }
        }
    }
}
