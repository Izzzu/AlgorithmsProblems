package dp;

public class ArrangeII {
    public int arrange(String A, int K) {
        int n = A.length();
        if (K>n) {
            return -1;
        }

        int dp[][] = new int[n+1][K+1];
        for (int i = 0; i < n + 1; i++) {
            for(int j = 0; j< K + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= K; j++) {

                int w = 0;
                int b = 0;
                for (int l = i; l >=1; l--) {
                    w += (A.charAt(l-1) == 'W') ? 1 : 0;
                    b += (A.charAt(l-1) == 'B') ? 1 : 0;
                    if(dp[l-1][j-1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[l-1][j-1] + w*b);
                    }

                }
            }
        }

        return dp[n][K];
    }
}
