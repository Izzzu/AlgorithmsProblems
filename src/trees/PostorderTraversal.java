package trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return new ArrayList<>();
        }
        res.addAll(postorderTraversal(A.left));
        res.addAll(postorderTraversal(A.right));
        res.add(A.val);

        return res;
    }

    public ArrayList<Integer> postorderTraversalIterate(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(A);
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null && node.left == null) {
                res.add(node.val);
                stack.pop();
            }
            if (node.right!=null) {
                stack.push(node.right);
                //node.right = null;
            }
            if (node.left!=null) {
                stack.push(node.left);
                //node.left = null;
            }
        }

        return res;
    }
}
