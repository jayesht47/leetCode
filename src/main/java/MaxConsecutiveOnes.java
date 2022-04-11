public class MaxConsecutiveOnes {


    public static int findMaxConsecutiveOnes(int[] nums) {

        int maxConsOnes = 0;
        int onesCount = 0;

        for (int i : nums) {
            if (i == 0) {
                if (onesCount > maxConsOnes) {
                    maxConsOnes = onesCount;
                }
                onesCount = 0;
            } else {
                onesCount++;
            }
        }
        if (onesCount > maxConsOnes) {
            maxConsOnes = onesCount;
        }
        return maxConsOnes;
    }


    public static void main(String[] args) {


        int[] testArr = {0, 1, 1, 1, 0, 0, 0, 1, 1};

        System.out.println(findMaxConsecutiveOnes(testArr));
    }

}
