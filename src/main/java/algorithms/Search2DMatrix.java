package algorithms;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        //finding which row contains target
        int start = 0;
        int mid = rows / 2;
        int end = rows - 1;
        int targetRow = -1;
        while (start <= end) {
            if (target <= matrix[mid][cols - 1]) {
                if (matrix[mid][0] <= target && target <= matrix[mid][cols - 1]) {
                    targetRow = mid;
                    break;
                }
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        if (targetRow == -1) return false; // element not present
        else {
            start = 0;
            end = cols - 1;
            mid = (start + end) / 2;

            while (start <= end) {
                if (target == matrix[targetRow][mid])
                    return true;
                else if (target < matrix[targetRow][mid]) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                } else {
                    start = mid + 1;
                    mid = (start + end) / 2;
                }
            }
            return false;
        }

    }
}
