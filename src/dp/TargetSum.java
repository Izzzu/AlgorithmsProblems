package dp;

public class TargetSum {
    public int findTargetSubsets(int[] num, int t) {
        int targetSum = 0;
        for (int n : num) {
            targetSum += n;
        }

        if (targetSum<=0 || (t+targetSum) % 2 == 1) {
            return 0;
        }

        int sum = (t + targetSum)/2;

        int [] dp = new int[sum+1];

        dp[0] =1;
        for (int s = 1; s < sum + 1; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if (s-num[i]>=0) {
                    dp[s] += dp[s-num[i]];
                }
            }
        }

        return dp[sum];
    }
}
