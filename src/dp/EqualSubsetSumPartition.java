package dp;

public class EqualSubsetSumPartition {
    
    static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int capacity = sum / 2;

        boolean dp[] = new boolean[capacity + 1];
        for (int c = 0; c < capacity+1; c++) {
            if (c == num[0]) {
                dp[c] = true;
            } else {
                dp[c] = false;
            }
        }
        for (int i = 1; i < num.length; i++) {
            for (int c = capacity; c >=0; c--) {
                if (!dp[c]) {
                    if (c>=num[i]) {
                        dp[c] = dp[c-num[i]];
                    }
                }
            }
        }

        return dp[capacity];
    }

    static boolean canPartition2(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int capacity = sum / 2;
        Boolean [][] dp = new Boolean[num.length][capacity+1];
        return canPartitionrRec(num, capacity, 0, dp);


    }

    static boolean canPartitionrRec(int[] num, int sum, int currInd, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (currInd >= num.length || num.length == 0) {
            return false;
        }

        if (dp[currInd][sum] == null) {
            if (sum >= num[currInd]) {
                if (canPartitionrRec(num, sum - num[currInd], currInd + 1, dp)) {
                    dp[currInd][sum] = true;
                    return true;
                }
            }

            dp[currInd][sum] = canPartitionrRec(num, sum, currInd + 1, dp);
        }

        return dp[currInd][sum];


    }

}
