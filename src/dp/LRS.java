package dp;

public class LRS {
    public int findLRSLength(String str) {

        Integer dp[][] = new Integer[str.length()][str.length()];
        if (findLRSLengthRecursive(str, 0, 0, dp)>=2) {
            return 1;
        } else return 0;

    }

    private int findLRSLengthRecursive(String str, int i1, int i2, Integer[][] dp) {
        if(i1>=str.length() || i2 >= str.length()) {
            return 0;
        }
        if (dp[i1][i2] == null) {
            if (i1!=i2 && str.charAt(i1)==str.charAt(i2)) {
                dp[i1][i2]= 1+ findLRSLengthRecursive(str, i1+1, i2+1, dp);
            } else {
                int c1 = findLRSLengthRecursive(str, i1+1, i2, dp);
                int c2 = findLRSLengthRecursive(str, i1, i2+1, dp);
                dp[i1][i2]= Math.max(c1, c2);
            }
        }
        return dp[i1][i2];
    }




}
