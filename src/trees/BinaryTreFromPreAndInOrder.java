package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreFromPreAndInOrder {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer>B ) {

        if (A.size() == 0 && B.size() == 0) {
            return null;
        }
        int rootValPre = A.get(0);
        TreeNode root = new TreeNode(rootValPre);

        int rootIndIn = B.indexOf(rootValPre);

        List<Integer> leftIn = B.subList(0, rootIndIn);
        List<Integer> leftIPre = rootIndIn>=1 ? A.subList(1, rootIndIn+1) : new ArrayList<>();
        List<Integer> rightIn = B.subList(rootIndIn+1, A.size());
        List<Integer> rightPre =  A.subList(rootIndIn+1, A.size());

        root.left = buildTree( new ArrayList<>(leftIPre), new ArrayList<>(leftIn));
        root.right = buildTree( new ArrayList<>(rightPre), new ArrayList<>(rightIn));

        return root;

    }
}
