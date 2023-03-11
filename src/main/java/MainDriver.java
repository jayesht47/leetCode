import binarysearch.KokoEatingBananas;
import binarysearch.Search2DMatrix;

public class MainDriver {

    public static void main(String[] args) {

        KokoEatingBananas keb = new KokoEatingBananas();

        int[] piles = {30,11,23,4,20};
        int h = 5;

        System.out.println(keb.minEatingSpeed(piles,h));


    }
}
