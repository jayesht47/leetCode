import stack.CarFleet;
import stack.DailyTemperature;
import stack.LargestRectHistogram;

public class MainDriver {

    public static void main(String[] args) {

        LargestRectHistogram lrh = new LargestRectHistogram();

        int[] heights = {2, 4};

        System.out.println(lrh.largestRectangleArea(heights));


    }
}
