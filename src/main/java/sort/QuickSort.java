package sort;

public class QuickSort {
    public int[] sortArray(int[] input) {
        return quickSort(input, 0, input.length - 1);
    }

    public int[] quickSort(int[] input, int start, int end) {

        if (end - start + 1 <= 1) return input;
        int pivot = input[end];

        int counter1 = start;

        for (int i = start; i < end; i++) {
            if (input[i] < pivot) {
                //swap
                int temp = input[counter1];
                input[counter1] = input[i];
                input[i] = temp;
                counter1++;
            }
        }
        //swapping pivot with count1 element
        int temp = input[counter1];
        input[counter1] = input[end];
        input[end] = temp;

        quickSort(input, start, counter1 - 1);
        quickSort(input, counter1 + 1, end);

        return input;
    }
}
