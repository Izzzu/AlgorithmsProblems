package trees;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
        public ArrayList<Integer> recoverTree(TreeNode A) {



            inOrder(A);
    //        if (first != null && second != null) {
    //            int val = first.val;
    //            first.val = second.val;
    //            second.val = val;
    //        }
            if (first != null && second != null) {

                return new ArrayList<Integer>(Arrays.asList(first.val, second.val));
            }
            else return new ArrayList<>();

        }

    private void inOrder(TreeNode a) {
        if (a == null) {
            return;
        }

        inOrder(a.left);

        if (pre == null) {
            pre = a;
        } else {
            if (pre.val > a.val) {
                if (first == null) {
                    first = pre;
                }
                second = a;
            }
            pre = a;
        }

        inOrder(a.right);
    }
}
