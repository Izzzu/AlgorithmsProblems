package dp;

public class NdigitsNumbersWithNDigitsSum {

    public static final int MOD = 1000000007;

    public int solve(int N, int sum) {
        if (N== 0) {
            return 0;
        }

        long [] dp = new long[sum+1];

        for (int i = 0; i <= sum; i++) {
            for (int j = 1; j <=9; j++) {
                if (i == j) {
                    dp[i] += 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int s = sum; s >=0; s--) {

                for (int j = 1; j <=9 ; j++) {
                    if (s>=j)
                        dp[s] = (dp[s] + (dp[s-j])%MOD)%MOD;
                    else {
                        break;
                    }
                }

            }
        }

        return (int)(dp[sum]%MOD);
    }
}
