package dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int minS = 0;
        int maxEnd = 0;
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (end - start >= maxEnd - minS) {
                            minS = start;
                            maxEnd = end;
                        }

                    }
                }
            }

        }
        return s.substring(minS, maxEnd + 1);

    }
}
