import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        mz.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
