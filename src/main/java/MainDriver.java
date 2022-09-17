import algorithms.BinarySearch;
import ds.BuyandSellStock;
import ds.IntersectionTwoArrays2;
import ds.MaximumSubarray;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        BuyandSellStock bs = new BuyandSellStock();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(bs.maxProfit(prices));
    }
}
