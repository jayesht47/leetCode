import twopointer.TrappingRainWater;

public class MainDriver {

    public static void main(String[] args) {

        TrappingRainWater trw = new TrappingRainWater();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trw.trap(height));


    }
}
