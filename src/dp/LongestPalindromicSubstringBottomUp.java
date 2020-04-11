package dp;

public class LongestPalindromicSubstringBottomUp {
    public int findLPSLength(String st) {
        boolean [][] dp = new boolean [st.length()][st.length()];

        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
        }

        int maxLength = 0;
        for (int start = st.length()-1; start >=0; start--) {
            for (int end = start +1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    if (end-start == 1 || dp[start+1][end-1]) {
                        dp[start][end] = true;
                        maxLength = Math.max(end-start+1, maxLength);
                    }
                }
            }
            
        }

        return maxLength;

    }
}
