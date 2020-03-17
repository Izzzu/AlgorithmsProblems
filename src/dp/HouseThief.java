package dp;

public class HouseThief {

    public int findMaxSteal(int[] wealth) {
        int dp[] = new int[wealth.length+1];

        dp[0] = 0;
        dp[1] = wealth[0];

        for (int i = 2; i <= wealth.length; i++) {
            dp[i] = Math.max(dp[i-2] + wealth[i-1], dp[i-1]);
        }

        return dp[wealth.length];
    }
}
