package dp;

import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {

        if (A.isEmpty()) {
            return 0;
        }
        int currMax = Math.max(A.get(0).get(0), A.get(1).get(0));
        int prevMax = 0;

        for (int i = 1; i < A.get(0).size(); i++) {
            int temp = Math.max(currMax, prevMax);
            currMax = prevMax + Math.max(A.get(0).get(i), A.get(1).get(i));
            prevMax = temp;
        }

        return Math.max(prevMax, currMax);
    }
}
