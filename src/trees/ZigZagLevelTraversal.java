package trees;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        int size = 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        while(!queue.isEmpty()) {

            TreeNode head = queue.poll();
            temp.add(head.val);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }

            size--;

            if (size == 0) {
                result.add(new ArrayList<Integer>(temp));
                size = queue.size();
                temp.clear();
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if(i%2==1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }


}
