package dp;

public class RegexDp {
    public int isMatch(final String A, final String B) {
        if (B.equals("*")) {
            return 1;
        }
        if (A.isEmpty() && B.isEmpty()) {
            return 1;
        }
        if (A.isEmpty() || B.isEmpty()) {
            return 0;
        }

        Boolean [][] dp = new Boolean[A.length()+1][B.length()+1];
        return isMatchRecursive(A, B, 0, 0, false, dp) ? 1 : 0;
    }

    private boolean isMatchRecursive(String a, String b, int i1, int i2, boolean star, Boolean[][] dp) {

        if (dp[i1][i2] == null) {
            if(i1 == a.length()) {
                if (i2 == b.length() || (b.charAt(i2) == '*' && i2 == b.length()-1)) {
                    dp[i1][i2] = true;
                } else if (b.charAt(i2) == '*') {
                    dp[i1][i2] = isMatchRecursive(a, b, i1, i2+1, false, dp);
                } else dp[i1][i2] = false;
            } else if (i2 == b.length()) {
                dp[i1][i2] = false;
            } else if (star) {
                dp[i1][i2]= isMatchRecursive(a, b, i1+1, i2, true, dp) || isMatchRecursive(a, b, i1+1, i2+1, false, dp) || isMatchRecursive(a, b, i1, i2+1, false, dp);
            } else if (b.charAt(i2) == '?' || b.charAt(i2) == a.charAt(i1)) {
                dp[i1][i2]= isMatchRecursive(a, b, i1+1, i2+1, false, dp);
            } else if (b.charAt(i2) == '*') {
                dp[i1][i2]= isMatchRecursive(a, b, i1, i2, true, dp);
            } else dp[i1][i2] = false;
        }
        return dp[i1][i2];

    }

    public int isMatchBottomUp(final String a, final String b) {
        if (b.equals("*")) {
            return 1;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return 1;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }

        Boolean [][] dp = new Boolean[a.length()+1][b.length()+1];

        for (int i1 = 0; i1 <=a.length(); i1++) {
            for (int i2 = 0; i2<=b.length(); i2++) {
               if (i1 == 0 && i2 == 0) {
                   dp[i1][i2] = true;
               } else if (i2>0 && b.charAt(i2-1) == '*') {
                   dp[i1][i2] = dp[i1][i2-1] || (i1>0 && dp[i1-1][i2]);
               } else if (i1>0 && i2>0 && (b.charAt(i2-1) == a.charAt(i1-1) || b.charAt(i2-1) == '?')) {
                   dp[i1][i2] = dp[i1-1][i2-1];
               } else dp[i1][i2] = false;
            }
        }

        return dp[a.length()][b.length()] ? 1 :0;
    }



    public static void main(String[] args) {
        System.out.println(new RegexDp().isMatch("caabccca", "c*"));
    }
}
