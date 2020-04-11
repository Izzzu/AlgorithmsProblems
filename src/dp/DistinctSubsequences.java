package dp;

public class DistinctSubsequences {
    public int numDistinct(String A, String B) {

        if (B.length()>A.length()) {
            return 0;
        }
        int dp[][] = new int[A.length()+1][B.length()+1];
        for (int i = 0; i <= A.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= B.length(); i++) {
            for (int j = 1; i <= A.length(); i++) {
                int s1 = dp[i][j-1];
                int s2 = 0;
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    s2 = dp[i-1][j-1];
                }
                dp[i][j] = s1 + s2;

            }
        }

        return dp[B.length()][A.length()];


    }
}
