package trees;


import apple.laf.JRSUIUtils;
import com.sun.deploy.panel.ITreeNode;

class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class FindSuccessor {
    public TreeNode getSuccessor(TreeNode a, int b) {


        TreeNode current = find(a, b);

        if (current == null ) {
            return null;
        }
        if (current.right != null) {
            return findMin(current.right);
        } else {
            TreeNode succ = null;
            TreeNode ancestor = a;
            while(ancestor != current) {
                if (current.val < ancestor.val) {
                    succ = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return succ;
        }

    }

    private TreeNode findMin(TreeNode right) {
        TreeNode temp = right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    private TreeNode find(TreeNode a, int b) {
        if (a == null) {
            return null;
        }
        TreeNode c = a;
        while(c.val != b) {
            if (b>c.val) {
                c = c.right;
            } else {
                c = c.left;
            }
        }

        return c;
    }
}
