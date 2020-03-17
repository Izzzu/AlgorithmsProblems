package trees;

import java.util.ArrayList;

public class RoottoLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        sum(A, B, result, new ArrayList<>());

        return result;

    }

    public void sum(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {

        if (A == null) return;
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A.right == null && A.left == null && A.val == B) {
            result.add(temp);
        }

        temp.add(A.val);
        sum(A.left, B-A.val , result, new ArrayList<>(temp));
        sum(A.right, B-A.val , result, new ArrayList<>(temp));


    }
}
