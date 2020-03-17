package trees;


import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInTree {
    public int kthsmallest(TreeNode A, int B) {

        List<Integer> list = new ArrayList<>();
        inOrder(A, list);
        return list.get(B-1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {

        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }
}
