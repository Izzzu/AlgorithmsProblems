package dp;

public class EditDistance {
    public int minDistance(String A, String B) {

        Integer [][] dp = new Integer[A.length()+1][B.length()+1];
        return editDistance(A, B, 0, 0, dp);
    }

    private int editDistance(String a, String b, int i1, int i2, Integer[][] dp) {
        if (dp[i1][i2] == null) {
            if (a.length() == i1) {
                dp[i1][i2] = b.length()-i2;
            } else
            if (b.length() == i2) {
                dp[i1][i2] = a.length()-i1;
            } else if (a.charAt(i1) == b.charAt(i2)) {
                dp[i1][i2] = editDistance(a, b, i1+1, i2+1, dp);
            } else {
                int rem = 1+editDistance(a, b, i1+1, i2, dp);
                int ins = 1+editDistance(a, b, i1, i2+1, dp);
                int rep = 1+editDistance(a, b, i1+1, i2+1, dp);
                dp[i1][i2]= Math.min(rem, Math.min(ins, rep));

            }
        }
        return dp[i1][i2];

    }
}


