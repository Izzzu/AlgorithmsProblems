package dp;

public class StringInterleaving {
    public int isInterleave(String A, String B, String C) {

        Boolean[][][] dp = new Boolean [A.length()+1][B.length()+1][C.length()+1];
        return isInterleaveRecursive(A, B, C, 0, 0, 0, dp) ? 1 : 0;
    }

    private boolean isInterleaveRecursive(String a, String b, String c, int i1, int i2, int i3, Boolean[][][] dp) {
        if (i1 == a.length() && i2 == b.length() && i3 == c.length()) {
            return true;
        }
        if (i3 == c.length()) {
            return false;
        }


        if (dp[i1][i2][i3] == null) {
            boolean b1 = false, b2 = false;
            if (i1<a.length() && a.charAt(i1) == c.charAt(i3)) {
                b1 = isInterleaveRecursive(a, b, c, i1+1, i2, i3+1, dp);
            }
            if (i2<b.length() && b.charAt(i2) == c.charAt(i3)) {
                b2 = isInterleaveRecursive(a, b, c, i1, i2+1, i3+1, dp);
            }
            dp[i1][i2][i3] = b1||b2;
        }
        return dp[i1][i2][i3];

    }
}
