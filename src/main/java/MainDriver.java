import twopointer.MostWaterContainer;
import twopointer.ThreeSum;

public class MainDriver {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        MostWaterContainer mwc = new MostWaterContainer();

        System.out.println(mwc.maxArea(height));


    }
}
