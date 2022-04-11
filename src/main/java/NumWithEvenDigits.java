public class NumWithEvenDigits {


    public static int findNumbers(int[] nums) {

        int totEvenCount = 0;

        for (int num : nums) {
            int digitCount = 0;
            int tempNum = num;

            while (tempNum > 0) {
                digitCount++;
                tempNum /= 10;
            }

            if ((digitCount % 2) == 0) {
                totEvenCount++;
            }

        }

        return totEvenCount;
    }

    public static void main(String[] args) {

//        int[] testArr = {0, 1, 1, 1, 1234, 999, 12, 12, 1};
          int[] testArr = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(testArr));

    }
}
