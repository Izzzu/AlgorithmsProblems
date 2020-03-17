package dp;

/*
We are given a ribbon of length ‘n’ and a set of possible ribbon lengths.
Now we need to cut the ribbon into the maximum number of pieces that
comply with the above-mentioned possible lengths.
Write a method that will return the count of pieces.
 */
public class MaximumRibbonCut {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int n = ribbonLengths.length;
        int [][] dp = new int[n+1][total+1];

        for (int i = 0; i < total+1; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int t = 1; t < total +1 ; t++) {

                dp[i][t] = dp[i-1][t];
                if (t-ribbonLengths[i-1] >=0 && dp[i][t-ribbonLengths[i-1]] != Integer.MIN_VALUE) {
                    dp[i][t] = Math.max(dp[i][t], dp[i][t-ribbonLengths[i-1]]+1);
                }
            }
        }

        return (dp[n][total] != Integer.MIN_VALUE) ? dp[n][total] : -1;
    }
}
