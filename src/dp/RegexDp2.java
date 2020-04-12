package dp;

public class RegexDp2 {
    public int isMatch(final String text, final String pattern) {
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        return match(text, pattern, 0, 0, dp) ? 1 : 0;
    }

    public boolean match(String text, String pattern, int i, int j, boolean[][] dp) {
        if (pattern.isEmpty()) dp[i][j] = text.isEmpty();
        else if (j == pattern.length()) {
            dp[i][j] = (i == text.length());
        } else {
            boolean firstMatch = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));

            if (j < pattern.length() - 1 && pattern.charAt(j) == '*') {
                dp[i][j] = match(text, pattern, i, j + 2, dp) || (firstMatch && match(text, pattern, i + 1, j, dp));
            } else if (firstMatch) {
                dp[i][j] = match(text, pattern, i + 1, j + 1, dp);
            } else dp[i][j] = false;
        }


        return dp[i][j];
    }
}
