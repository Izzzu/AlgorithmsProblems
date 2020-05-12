package dp;

import java.util.List;

public class BuySellStockII {
    public int maxProfit(final List<Integer> A) {

        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (Integer stock : A) {
            if (stock > min) profit += stock-min;
            min = stock;
        }
        return profit;
    }
}
