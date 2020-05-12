package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    public int coinchange3(ArrayList<Integer> A, int B) {
        Integer dp [][] = new Integer[B+1][A.size()];
        return coinChangeRec(A, B, 0, dp);
    }

    private int coinChangeRec(ArrayList<Integer> a, int total, int currentIndex, Integer[][] dp) {
        if (a.size() == 0 || currentIndex>=a.size()) {
            return 0;
        }
        if (total == 0) {
            return 1;
        }

        if (dp[total][currentIndex] != null) {
            return dp[total][currentIndex];
        }

        long s1 = 0;
        if (a.get(currentIndex) <= total) {
            s1 = coinChangeRec(a, total - a.get(currentIndex), currentIndex, dp);
        }
        long s2 = coinChangeRec(a, total, currentIndex+1, dp);
        dp[total][currentIndex] = (int)((s1% 1000007+s2% 1000007)% 1000007);
        return dp[total][currentIndex];
    }
    public int coinchange2(ArrayList<Integer> A, int B) {
        int dp [][] = new int[B+1][A.size()];

        for (int i = 0; i < A.size(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= B; i++) {
            for (int j = 0; j < A.size(); j++) {
                if (j>0) {
                    dp[i][j] = (dp[i][j-1]% 1000007);
                }
                if (i-A.get(j)>=0) {
                    dp[i][j] = ((dp[i][j]% 1000007)+ (dp[i-A.get(j)][j]% 1000007))% 1000007;
                }

            }
        }
        return dp[B][A.size()-1];
    }



    public static void main(String[] args) {
        System.out.println(new CoinChange().coinchange2(new ArrayList<>(Arrays.asList(1, 2, 3 )), 4));
    }
}
