import java.util.Arrays;

public class SquaresOfSortedArr {

    public static int[] sortedSquares(int[] nums) {


        //using Javas Methods
//        int[] resArr = Arrays.stream(nums).map(num -> num * num).toArray();
//
//        Arrays.sort(resArr);

        int[] res = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                res[i] = nums[start] * nums[start];
                start++;
            } else {
                res[i] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {


        int[] testArr = {-6, -3, -2, 1, 0, 4, 6};

        int[] res = sortedSquares(testArr);

        Arrays.stream(res).forEach(System.out::println);


    }

}
