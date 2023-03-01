package ds;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter1 = m - 1, counter2 = n - 1, resCounter = m + n - 1;
        while (resCounter >= 0) {
            if (counter1 >= 0 && counter2 >= 0) {
                if (nums1[counter1] >= nums2[counter2]) {
                    nums1[resCounter] = nums1[counter1];
                    counter1--;
                } else {
                    nums1[resCounter] = nums2[counter2];
                    counter2--;
                }
            } else if (counter1 >= 0) {
                nums1[resCounter] = nums1[counter1];
                counter1--;
            } else {
                nums1[resCounter] = nums2[counter2];
                counter2--;
            }
            resCounter--;
        }
    }
}
