import algorithms.BinarySearch;
import algorithms.IsBadVersion;
import algorithms.RotateArray;
import algorithms.SearchInsertPosition;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        r.rotate(nums, k);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
