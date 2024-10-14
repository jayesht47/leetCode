package sort;

public class InsertionSort {
    public int[] sortArray(int[] input) {
        if (input.length == 1) return input;
        for (int i = 1; i < input.length; i++) {
            int j = i - 1;
            while (j >= 0 && input[j] > input[j + 1]) {
                int tmp = input[j + 1];
                input[j + 1] = input[j];
                input[j] = tmp;
                j--;
            }
        }
        return input;
    }
}
