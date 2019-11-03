package backtracking;

import java.util.*;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int B) {
        Collections.sort(list);
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
        ArrayList<Integer> A = new ArrayList<>(hashSet);

        LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();
        combinations(A, B, 0, new ArrayList<Integer>(), 0, result);
        return new ArrayList<>(result);

    }

    public void combinations(ArrayList<Integer> A,int B, int index, ArrayList<Integer> combinations, int sum, LinkedHashSet<ArrayList<Integer>> result) {
        if (index>=A.size() || sum>B) {
            return;
        }
        if (sum == B) {
            Collections.sort(combinations);
            result.add(new ArrayList<>(combinations));
            return;
        }
        for (int i = index; i<A.size() && sum+A.get(i)<=B; i++) {
            combinations.add(A.get(i));
            sum +=A.get(i);
            combinations(A, B, index, combinations, sum, result);
            combinations.remove(combinations.size()-1);
            sum -= A.get(i);
        }


    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new ArrayList(Arrays.asList( 8, 10, 6, 11, 1, 16, 8)), 28));
    }
}
