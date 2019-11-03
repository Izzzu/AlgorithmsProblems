package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetWithDuplicates {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        if (A == null)
            return null;

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        generateSubsets(A, temp, result, 0);
        result.add(0, new ArrayList<>());
        return result;

    }

    private void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int index) {

        for (int i = index; i<A.size(); i++) {

            if (i>index && A.get(i) == A.get(i-1))
                continue;

            temp.add(A.get(i));
            result.add(new ArrayList<>(temp));
            generateSubsets(A, temp, result, i+1);
            temp.remove(temp.size()-1);
        }

    }


}
