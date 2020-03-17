package trees;

import java.util.Stack;

public class BSTIterator {

    private TreeNode current;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return current != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        int val = 0;
        while(true) {
            if (current != null) {
                stack.push(current);
                current = current.left;
                continue;
            }

            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            val = node.val;
            current = node.right;
            break;
        }
        return val;
    }
}
