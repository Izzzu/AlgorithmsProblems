package dp;

public class LongestPalindromicSubsequenceTopDown {
    public int findLPSLength(String st) {
        Integer [][] dp = new Integer[st.length()][st.length()];

        return findLPSLengthReq(0, st.length()-1, st, dp);
    }

    private int findLPSLengthReq(int start, int end, String s, Integer [][] dp) {
        if (start >end) {
            return 0;
        }

        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 2+ findLPSLengthReq(start +1, end+1, s, dp);
                return dp[start][end];
            }

            int c1 = findLPSLengthReq(start+1, end, s, dp);
            int c2 = findLPSLengthReq(start, end-1, s, dp);

            dp[start][end] = Math.max(c1, c2);
        }
        return dp[start][end];

    }
}
