package dp;


public class PalindromPartitioningTopDown {

    public int findMPPCuts(String st) {
        Boolean[][] p = new Boolean[st.length()][st.length()];
        Integer dp[][] = new Integer[st.length()][st.length()];
        return findRecursive(st, 0, st.length() - 1, p, dp);
    }

    private int findRecursive(String s, int start, int end, Boolean[][] p, Integer[][] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] == null) {
            if (isPalindrome(s, start, end, p)) {
                dp[start][end]= 0;
            } else {

                int minCuts = end - start;
                for (int i = start; i <= end; i++) {
                    if (isPalindrome(s, start, i, p)) {
                        minCuts = Math.min(minCuts, 1 + findRecursive(s, i + 1, end, p, dp));
                    }
                }
                dp[start][end] = minCuts;
            }

        }
        return dp[start][end];

    }

    private boolean isPalindrome(String s, int start, int end, Boolean[][] p) {
        if (p[start][end] == null) {
            int i = start;
            int j = end;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    p[start][end] = false;
                    break;
                }
                i++;
                j--;
            }
            if (p[start][end] == null) {
                int k = start, m = end;
                while(k<=m) {
                    p[k][m] = true;
                    k++;
                    m--;
                }

            }
        }
        return p[start][end];

    }


}
