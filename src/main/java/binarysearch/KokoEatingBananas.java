package binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        piles = Arrays.stream(piles).sorted().toArray();
        int maxN = piles[piles.length - 1];

        //Applying BS to this range
        int start = 1;
        int end = maxN;
        int mid = (start + end) / 2;
        int minK = Integer.MAX_VALUE;
        while (start <= end) {

            if (checkValidK(mid, piles, h) < 0) {
                start = mid + 1;
                mid = (start + end) / 2;
            }else {
                minK = Math.min(minK, mid);
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        return minK;
    }

    public int checkValidK(int k, int[] piles, int h) {
        int hoursTaken = 0;
        for (int pile : piles) {
            hoursTaken += (int) Math.ceil((double) pile / k);
        }
        return h - hoursTaken;
    }
}
