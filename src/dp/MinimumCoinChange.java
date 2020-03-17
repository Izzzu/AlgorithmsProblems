package dp;

public class MinimumCoinChange {

    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        int [][] dp = new int[n][total+1];

        for(int t = 0; t<total+1; t++) {
            dp[0][t] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int t = 1; t < total+1; t++) {
                if (i>0) {
                    dp[i][t] = dp[i-1][t];
                }
                if (t-denominations[i]>=0 && dp[i][t-denominations[i]]!= Integer.MAX_VALUE) {
                    dp[i][t] = Math.min(dp[i][t], dp[i][t-denominations[i]]+1);
                }
            }
        }

        return dp[n-1][total] != Integer.MAX_VALUE ? dp[n-1][total] : -1;
    }

}
