package trees;

import java.util.ArrayList;

public class InOrderTraversalOfCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A.isEmpty()) {
            return null;
        }
        if (A.size() == 1) {
            return new TreeNode(A.get(0));
        }
        int rootInd = findRootIndex(A);
        TreeNode root  = new TreeNode(A.get(rootInd));
        if (rootInd == 0) {
            root.right = buildTree(new ArrayList<>(A.subList(rootInd + 1, A.size())));
        } else if (rootInd == A.size()-1) {
            root.left = buildTree(new ArrayList<>(A.subList(0, rootInd)));
        } else {
            root.left = buildTree(new ArrayList<>(A.subList(0, rootInd)));
            root.right = buildTree(new ArrayList<>(A.subList(rootInd + 1, A.size())));
        }

        return root;

    }

    private int findRootIndex(ArrayList<Integer> a) {
        int ind = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > max){
                max = a.get(i);
                ind = i;
            }
        }

        return ind;
    }
}
