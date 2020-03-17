package dp;

public class CountOfSubsetSum {

    static int countSubsets(int[] num, int sum) {
        int [] dp = new int[sum+1];
        dp[0] = 1;
        for (int s = 1; s < sum; s++) {
            if (num[0]==s) {
                dp[s] = 1;
            } else {
                dp[s] = 0;
            }
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s > 0 ; s--) {
                if (s-num[i]>=0) {
                    dp[s] += dp[s-num[i]];
                }
            }
        }
        return dp[sum];
    }
}
