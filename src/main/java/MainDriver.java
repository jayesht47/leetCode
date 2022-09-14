import algorithms.BinarySearch;

public class MainDriver {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {2,5};
        int target = 2;
        System.out.println(bs.search(nums, target));
    }
}
