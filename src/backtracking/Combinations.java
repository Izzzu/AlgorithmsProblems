package backtracking;

import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinations(A, B, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void combinations(int A, int B, int offset, ArrayList<Integer> combinations,
                              ArrayList<ArrayList<Integer>> result) {

        if (combinations.size()==B) {
            result.add(new ArrayList<>(combinations));
            return;
        }
        int numRem = B - combinations.size();
        for (int i = offset; i<=A && numRem <= A-i+1; i++) {
            combinations.add(i);
            combinations(A, B, i+1, combinations, result);
            combinations.remove(combinations.size()-1);
        }
    };

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(1, 1));
    }
}
