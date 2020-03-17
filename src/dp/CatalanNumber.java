package dp;

public class CatalanNumber {

    int MOD = 1000000007;
    public int chordCnt(int A) {

        long [] dp = new long[A+1];
        for (int i = 0; i <= A; i++) {
            dp[i] = -1;
        }
        return catalan(A, dp);
    }

    int catalan(int A, long[] dp) {
        if (A<=1) {
            dp[A] = 1;
            return (int)dp[A];
        }
        long res = 0;
        for (int i = 0; i < A; i++) {
            if (dp[i] == -1) {
                dp[i] = (catalan(i, dp)%MOD);
            }
            if (dp[A-i-1] == -1) {
                dp[A-i-1] = catalan(A-i-1, dp)%MOD;
            }
            res = (res + (dp[i] * dp[A-i-1])%MOD)%MOD;
        }
        return (int)res;

    }

    public static void main(String[] args) {
        System.out.println(new CatalanNumber().chordCnt(4));
    }

}
