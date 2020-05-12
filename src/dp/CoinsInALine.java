package dp;

import java.util.ArrayList;

public class CoinsInALine {
    public int maxcoin(ArrayList<Integer> A) {

        Integer dp[][] = new Integer[A.size()][A.size()];
        return maxCoinRec(A, 0, A.size()-1, dp);
    }

    private int maxCoinRec(ArrayList<Integer> a, int start, int end, Integer[][] dp) {

        if (start>end) {
            return 0;
        }
        if (dp[start][end] == null) {
            int maxA = a.get(start) + Math.min(maxCoinRec(a, start+2, end, dp), maxCoinRec(a, start+1, end-1, dp)) ;
            int maxB = a.get(end) + Math.min(maxCoinRec(a, start, end-2, dp), maxCoinRec(a, start+1, end-1, dp));
            dp[start][end] = Math.max(maxA, maxB);
        }

        return dp[start][end];
    }
}
