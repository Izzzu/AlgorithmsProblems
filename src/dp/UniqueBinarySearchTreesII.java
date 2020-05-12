package dp;

public class UniqueBinarySearchTreesII {
    public int numTrees(int A) {

        int dp[] = new int[A+1];
        dp[0] = 1;

        for (int i = 1; i<=A; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] = dp[i] + dp[j-1]* dp[i-j];
            }
        }
        return dp[A];
    }
}
