package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinations(A, B, 0, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);

    }

    public void combinations(ArrayList<Integer> A,int B, int index, ArrayList<Integer> combinations, ArrayList<ArrayList<Integer>> result) {

        if (0 == B) {
            ArrayList<Integer> list = new ArrayList<>(combinations);
            //Collections.sort(list);
            result.add(list);
            return;
        }
        if (index>=A.size() || B<0) {
            return;
        }
        for (int i = index; i<A.size(); i++) {
            Integer val = A.get(i);
            if (i > index && val ==A.get(i-1)) {
                continue;
            }
            combinations.add(val);

            if (val <=B) {
                combinations(A, B- val, i+1, combinations, result);

            }
            combinations.remove(combinations.size()-1);

        }
        return;

    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum(new ArrayList<>(Arrays.asList( 8, 10, 6, 11, 1, 16, 8)), 28));
    }
}
