package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticProgression {

    public int solve(final List<Integer> A) {

        Map<Integer, Integer>[]  dp = new Map[A.size()];
        int max = 1;
        for (int i = 0; i < A.size(); i++) {
            dp[i] = new HashMap();

            for (int j = i-1; j >=0 ; j--) {
                int diff = A.get(i) - A.get(j);
                Integer previous = dp[i].getOrDefault(diff, 0);
                Integer fromJ = dp[j].getOrDefault(diff, 1);
                int localMax = Math.max(previous, fromJ + 1);
                max = Math.max(max, localMax);
                dp[i].put(diff, localMax);

            }
        }

        return max;
    }
}
