package trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return new ArrayList<>();
        }
        res.addAll(inorderTraversal(A.left));
        res.add(A.val);
        res.addAll(inorderTraversal(A.right));

        return res;
    }

    public ArrayList<Integer> inorderTraversalIterate(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        while(current!= null || stack.size() != 0) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            current =  stack.pop();
            res.add(current.val);

            current = current.right;
        }
        return res;
    }
}
