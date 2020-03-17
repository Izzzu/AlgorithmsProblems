package dp;

import java.util.Arrays;
import java.util.List;

public class FlipArray {

    public int solve(final List<Integer> A) {

        if (A.size() == 0) {
            return 0;
        }

        int sum = A.stream().reduce(Integer::sum).orElse(0)/2;

        int [] dp = new int[sum+1];

        for (int i = 0; i <=sum; i++) {
                dp[i] = Integer.MAX_VALUE;

        }
        dp[0] = 0;
        for (int i = 0; i <A.size(); i++) {
            for (int s = sum; s >=0 ; s--) {
                if (s-A.get(i)>=0) {
                    if (dp[s-A.get(i)] != Integer.MAX_VALUE) {

                        dp[s] = Math.min(dp[s], dp[s-A.get(i)]+1);
                    }
                }
            }
        }

        for (int i = sum; i >=0 ; i--) {
            if (dp[i] != Integer.MAX_VALUE) return dp[i];
        }
        return  -1;


    }

    public static void main(String[] args) {
        System.out.println(new FlipArray().solve(Arrays.asList(8, 4, 5, 7, 6, 2)));
    }

}
