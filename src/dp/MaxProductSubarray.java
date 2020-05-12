package dp;

import java.util.List;

public class MaxProductSubarray {
    public int maxProduct(final List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }
        int min = A.get(0);
        int max = A.get(0);
        int res = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            int val = A.get(i);
            if (val <0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(val, min*val);
            max = Math.max(val, max*val);
            res = Math.max(res, max);
        }

        return res;
    }
}
