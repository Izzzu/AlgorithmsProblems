package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestAreaOfRectangleWithPermutations {

    public int solve(ArrayList<ArrayList<Integer>> A) {

        if (A.size()==0) {
            return 0;
        }

        int[][] count = new int[A.size()][A.get(0).size()];

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (i == 0) {
                    count[i][j] = A.get(i).get(j);
                } else if (A.get(i).get(j) == 1) {
                    count[i][j] = count[i-1][j]+1;
                } else {
                    count[i][j] = 0;
                }
            }
        }

        for (int[] ints : count) {

            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints[i]*(-1);
            }
            Arrays.sort(ints);
            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints[i]*(-1);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                int maxAr = count[i][j] * (j+1);
                max = Math.max(max, maxAr);
            }
        }

        return max;



    }
}
