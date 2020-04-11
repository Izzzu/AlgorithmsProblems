package dp;

public class LongestPalindromicSubstringTopDown {
    public int findLPSLength(String st) {
        int dp[][] = new int[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            for (int j = 0; j < st.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return findLPSLength(st, 0, st.length() - 1, dp);

    }

    private int findLPSLength(String st, int start, int end, int[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (dp[start][end] == -1) {
            if (st.charAt(start) == st.charAt(end) && end - start - 1 == findLPSLength(st, start + 1, end - 1, dp)) {
                dp[start][end] = end - start - 1 + 2;
            } else {
                int c1 = findLPSLength(st, start + 1, end, dp);
                int c2 = findLPSLength(st, start, end - 1, dp);
                dp[start][end] = Math.max(c1, c2);
            }


        }

        return dp[start][end];


    }
}
