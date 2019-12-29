package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class KthPermutation {
// wrong solution for lexiographical order
    public String getPermutation(int A, int B) {

        ArrayList<Integer> combinations = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            combinations.add(i);
        }
        int[] count = new int[1];
        count[0] = 0;

        return permutations(count, B, combinations, 0, A - 1);

    }

    private String permutations(int[] count, int b, ArrayList<Integer> combinations, int left, int right) {
        if (left == right) {
            count[0] ++;

            if (count[0] == b) {
                return stringFromCombinations(combinations);

            }
        }
        for (int i = left; i <= right; i++) {
            Collections.swap(combinations, i, left);
            String p = permutations(count, b, combinations, left + 1, right);
            if (!p.isEmpty()) {
                return p;
            }

            Collections.swap(combinations, i, left);
        }
        return "";
    }

    private String stringFromCombinations(ArrayList<Integer> combinations) {
        StringBuilder s = new StringBuilder();
        for (Integer combination : combinations) {
            s.append(combination);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(3, 5));
    }

}
