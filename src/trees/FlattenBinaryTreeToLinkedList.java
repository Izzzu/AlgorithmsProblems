package trees;

import apple.laf.JRSUIUtils;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode a) {
        TreeNode current = a;
        Stack<TreeNode> stack = new Stack<>();

        while(current!= null) {
            if (current.right!= null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                current.right = current.left;
                current.left = null;
                current = current.right;
            } else {
                if (!stack.isEmpty()) {
                    TreeNode treeNode = stack.pop();
                    current.right = treeNode;
                    current = current.right;
                } else {
                    current = null;
                }
            }

        }

        return a;
    }
}
