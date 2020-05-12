package dp;

public class LIS {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length+1];

        int max = 1;


        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]> nums[j] && dp[i]<= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
