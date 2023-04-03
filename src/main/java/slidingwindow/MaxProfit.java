package slidingwindow;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int leftP = 0;
        int rightP = 1;
        int lowest = Integer.MAX_VALUE;
        int highest = 0;
        int maxProfit = 0;

        while (rightP < prices.length) {
            if (prices[leftP] < lowest) {
                lowest = prices[leftP];
                highest = prices[leftP];
                leftP++;
            } else
                leftP++;

            if (prices[rightP] > lowest && prices[rightP] > highest) {
                highest = prices[rightP];
                rightP++;
            } else
                rightP++;

            if (highest > lowest)
                maxProfit = Math.max(maxProfit, highest - lowest);
        }

        return maxProfit;
    }
}