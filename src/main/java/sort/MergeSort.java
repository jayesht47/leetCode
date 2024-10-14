package sort;

public class MergeSort {
    public int[] sortArray(int[] input) {
        return mergeSort(input, 0, input.length - 1);
    }

    private int[] mergeSort(int[] input, int start, int end) {
        if (start < end) {
            if (end - start + 1 == 1) return input;
            int mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
        return input;
    }

    private void merge(int[] input, int start, int mid, int end) {
        int length1 = mid - start + 1;
        int length2 = end - mid;

        int[] left = new int[length1];
        int[] right = new int[length2];

        for (int i = 0; i < length1; i++) {
            left[i] = input[i + start];
        }

        for (int i = 0; i < length2; i++) {
            right[i] = input[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < length1 && j < length2) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else {
                input[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            input[k] = left[i];
            i++;
            k++;
        }

        while (j < length2) {
            input[k] = right[j];
            j++;
            k++;
        }

    }

}
