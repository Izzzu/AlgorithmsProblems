package trees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPostOrder {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        if (A.size() == 0 && B.size() == 0) {
            return null;
        }
        int rootValPost = B.get(B.size()-1);
        TreeNode root = new TreeNode(rootValPost);

        int rootIndIn = A.indexOf(rootValPost);

        List<Integer> leftIn = A.subList(0, rootIndIn);
        List<Integer> leftIPost = B.subList(0, rootIndIn);
        List<Integer> rightIn = A.subList(rootIndIn+1, A.size());
        List<Integer> rightPost = B.subList(rootIndIn, A.size()-1);

        root.left = buildTree(new ArrayList<>(leftIn), new ArrayList<>(leftIPost));
        root.right = buildTree(new ArrayList<>(rightIn), new ArrayList<>(rightPost));

        return root;

    }
}
