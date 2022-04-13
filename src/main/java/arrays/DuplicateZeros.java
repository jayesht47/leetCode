package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DuplicateZeros {


    public static void duplicateZeros(int[] arr) {

        int[] input = arr.clone();
//        Very slow solution faster than 6% submissions
//        for (int i = 0; i < arr.length; i++) {
//
//            if (arr[i] == 0) {
//                for (int j = i + 1; j < arr.length; j++) {
//
//                    arr[j] = input[j - 1];
//                }
//                i++;
//                input = arr.clone();
//            }
//        }
        int zeroCount = 0;

//        Much better solution faster than 96% submissions
        for (int i = 0; i < arr.length; i++) {

            if (i + zeroCount < arr.length) {
                if (input[i] == 0) {
                    zeroCount++;
                    arr[i + zeroCount - 1] = input[i];
                    if (i + zeroCount < arr.length) {
                        arr[i + zeroCount] = input[i];
                    }

                } else {
                    arr[i + zeroCount] = input[i];

                }
            }
        }

    }

//    1 0 2 3
//    1 0 0 2


    public static void main(String[] args) {
        int[] test = {8,4,5,0,0,0,0,7};
        //[]
//        1, 0, 2, 3, 0, 4, 5, 0
//        []
        duplicateZeros(test);

        Arrays.stream(test).forEach(value -> System.out.println(value));

    }

}
