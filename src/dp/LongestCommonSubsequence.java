package dp;

public class LongestCommonSubsequence {
    public int findLCSLength2(String s1, String s2) {

        int dp[][] = new int[2][s2.length()+1];

        int maxLength = 0;
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i%2][j] = 0;
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i%2][j] = dp[(i-1)%2][j-1] +1;
                } else {
                    dp[i%2][j] = Math.max(dp[(i)%2][j-1], dp[(i-1)%2][j]);
                }
                maxLength = Math.max(maxLength, dp[i%2][j]);

            }
        }

        return maxLength;
    }

    public int findLCSLength(String s1, String s2) {

        int dp[][] = new int[s1.length()+1][s2.length()+1];

        int maxLength = 0;
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[(i-1)][j-1] +1;

                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }
}
