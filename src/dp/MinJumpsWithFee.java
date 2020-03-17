package dp;

public class MinJumpsWithFee {
        public int findMinFee(int[] fee) {

            int dp[] = new int[fee.length+1];

            dp[0] = 0;
            dp[1] = fee[0];
            dp[2] = fee[0];
            dp[3] = fee[0];

            for (int step = 4; step <= fee.length; step++) {
                dp[step] = Math.min(dp[step-1] + fee[step-1], Math.min(dp[step-2] + fee[step-2], dp[step-3] +fee[step-3]));
            }

            return dp[fee.length];
        }
}
