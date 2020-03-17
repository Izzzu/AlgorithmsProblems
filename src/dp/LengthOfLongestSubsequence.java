package dp;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() <= 1) {
            return A.size();
        }
        int[] inc = new int[A.size()];
        int[] dec = new int[A.size()];

        for (int i = 0; i < A.size(); i++) {
            inc[i] = 1;
            dec[i] = 1;
        }

        for (int i = 1; i < inc.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i)>A.get(j) && inc[i]<=inc[j]) {
                    inc[i] = inc[j] +1;
                }
            }
        }

        for (int i = dec.length-2; i >=0; i--) {
            for (int j = dec.length-1; j > i; j--) {
                if (A.get(i)>A.get(j) && dec[i]<=dec[j]) {
                    dec[i] = dec[j] +1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inc.length; i++) {
            max = Math.max(inc[i] + dec[i] -1, max);
        }

        return max;


    }


}
