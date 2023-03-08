import binarysearch.Search2DMatrix;

public class MainDriver {

    public static void main(String[] args) {

        Search2DMatrix s2m = new Search2DMatrix();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 30;

        System.out.println(s2m.searchMatrix(matrix, target));


    }
}
