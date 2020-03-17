package dp;

public class SubsetSum {

    static boolean canPartition(int[] num, int sum) {
        if (num.length == 0)
            return false;

        boolean [] dp = new boolean[sum+1];

        for (int c = 0; c<=sum; c++) {
            if (num[0]==c) {
                dp[c] = true;
            }
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >=0; s--) {

                if (!dp[s]) {
                    if(s>=num[i]) {
                        dp[s] = dp[s-num[i]];
                    }
                }
            }
        }

        return dp[sum];
    }
}
