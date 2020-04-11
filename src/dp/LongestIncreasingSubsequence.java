package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
            Integer dp[][] = new Integer[A.size()][A.size()+1];

            return lis2(A, 0, -1, dp);
        }



        public int lis2 ( final List<Integer> A, int curr, int prev, Integer[][] dp){
            if (curr >= A.size()) {
                return 0;
            }

            if (dp[curr][prev+1] == null) {
                int c1 = 0;
                if (prev == -1 || A.get(curr) > A.get(prev)) {
                    c1 = 1 + lis2(A, curr + 1, curr, dp);
                }
                int c2 = lis2(A, curr + 1, prev, dp);


                dp[curr][prev+1]= Math.max(c1, c2);
            }

            return dp[curr][prev+1];


        }

    public int lis ( final List<Integer> A, int curr, int prev){
        if (curr >= A.size()) {
            return 0;
        }

        int c1 = 0;
        if (prev == -1 || A.get(curr) > A.get(prev)) {
            c1 = 1 + lis(A, curr + 1, curr);
        }
        int c2 = lis(A, curr + 1, prev);


        return Math.max(c1, c2);

    }

    public int lisBottomUp(final List<Integer> A) {
            int dp[] = new int[A.size()];
            dp[0] =1;

            int max = 1;
            for (int i = 1; i < A.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (A.get(i) > A.get(j) && dp[j]>=dp[i]) {
                        dp[i] = dp[j] +1;
                        max = Math.max(max, dp[i]);


                    }
                }
            }
            return max;

    }

        public static void main (String[]args){
            System.out.println(new LongestIncreasingSubsequence().lis(new ArrayList<>(Arrays.asList(28, 1, 2, 29, 30))));
        }


}
