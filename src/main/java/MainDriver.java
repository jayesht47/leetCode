import algoDep.ListNode;
import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {


        int[][] image =  {{1 , 1, 1},
                        {1 , 1 , 0},
                        {1 , 0 , 1}};

        int[][] result = new FloodFill().floodFill(image,1,1,2);

        FloodFill.display2DArray(result);


    }
}
