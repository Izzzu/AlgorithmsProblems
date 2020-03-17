package dp;

/*
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.
 */
public class NumberFactros {

    public int CountWays(int n) {

        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <=n ; i++) {
            dp[i] = dp[i-4] + dp[i-3] + dp[i-1];
        }

        return dp[n];
    }

}
