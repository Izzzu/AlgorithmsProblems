package trees;

import com.sun.javafx.tools.ant.CSSToBinTask;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();

        if (A == null) {
            return res;
        }
        res.add(A.val);
        res.addAll(preorderTraversal(A.left));
        res.addAll(preorderTraversal(A.right));

        return res;
    }

    public ArrayList<Integer> preorderTraversalIterate(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }

        return res;
    }


}
