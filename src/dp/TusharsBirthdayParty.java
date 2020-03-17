package dp;

import java.util.Arrays;
import java.util.List;

public class TusharsBirthdayParty {
    public int solve(final List<Integer> A, final List<Integer> dishesFill, final List<Integer> dishesCosts) {
        if (A.size() == 0) {
            return 0;
        }

        int maxCap = A.stream().max(Integer::compareTo).orElse(-1);

        int [][] dp = new int[dishesFill.size()+1][maxCap+1];

        for (int i = 0; i < maxCap + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dishesFill.size() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dishesFill.size()+1; i++) {
            for (int c = 1; c < maxCap+1; c++) {

                if (c<dishesFill.get(i-1) || dp[i][c-dishesFill.get(i-1)] == Integer.MAX_VALUE) {
                    dp[i][c] = dp[i-1][c];
                } else {
                    dp[i][c] = Math.min(dp[i-1][c], dp[i][c-dishesFill.get(i-1)]+dishesCosts.get(i-1));
                }
            }
        }

        int res = 0;

        for (int i = 0; i < A.size(); i++) {
            res += dp[dishesFill.size()][A.get(i)];
        }
        return res==Integer.MAX_VALUE ? -1 : res;



    }

    public static void main(String[] args) {
        System.out.println(new TusharsBirthdayParty().solve(Arrays.asList(2, 3, 1, 5, 4 ), Arrays.asList(3, 2, 4, 1), Arrays.asList( 1, 2, 5, 10)));
    }
}
