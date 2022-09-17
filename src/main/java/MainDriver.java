import algorithms.BinarySearch;
import ds.IntersectionTwoArrays2;
import ds.MaximumSubarray;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {

        IntersectionTwoArrays2 is = new IntersectionTwoArrays2();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = is.intersect(nums1, nums2);
        Arrays.stream(result).forEach(System.out::print);
    }
}
