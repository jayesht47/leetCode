package ds;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int currentLowest = Integer.MAX_VALUE, currentHighest = 0, currentMaxProfit = 0;
        for (int price : prices) {
            if (price < currentLowest) {
                currentLowest = price;
                currentHighest = 0;
            }
            if (price > currentHighest)
                currentHighest = price;
            int currentProfit = currentHighest - currentLowest;
            currentMaxProfit = Math.max(currentProfit, currentMaxProfit);
        }
        return currentMaxProfit;
    }
}
