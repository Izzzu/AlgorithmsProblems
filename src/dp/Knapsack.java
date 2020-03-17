package dp;

public class Knapsack {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (profits.length != weights.length || profits.length == 0) {
            return 0;
        }

        int n = profits.length;
        int[] dp = new int[capacity+1];

        for (int c = 0; c < capacity + 1; c++) {
            if (weights[0]<=c)
                dp[c] = profits[0];
        }

        for (int i = 1; i < n + 1; n++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[c-weights[i]];
                }
                profit2 = dp[c];

                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }
}
