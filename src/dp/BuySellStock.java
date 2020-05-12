package dp;

import java.util.List;

public class BuySellStock {
    public int maxProfit(final List<Integer> A) {

        if(A.isEmpty()) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.size(); j++) {
                max = Math.max(A.get(j)-min, max);
                min = Math.min(A.get(j), min);
        }

        return Math.max(max, 0);
    }

    public int maxProfit2(final List<Integer> A) {

        if(A.isEmpty()) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (Integer stock : A) {
            max = Math.max(stock-min, max);
            min = Math.min(stock, min);
        }


        return Math.max(max, 0);
    }
}
