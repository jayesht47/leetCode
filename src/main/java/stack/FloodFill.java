package stack;

/**
 * Flash fill algo to fill color like ms paint
 */
public class FloodFill {

    private static void printPicture(int[][] picture) {
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                System.out.print(picture[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void dfsFill(int x, int y, int[][] picture, int valueToFill, int curValue) {

        if (x < 0 || y < 0 || x >= picture.length || y >= picture[0].length) return;
        if (picture[x][y] != curValue) return;

        if (picture[x][y] == curValue) {
            picture[x][y] = valueToFill;
        }


        dfsFill(x + 1, y, picture, valueToFill, curValue);
        dfsFill(x - 1, y, picture, valueToFill, curValue);
        dfsFill(x, y + 1, picture, valueToFill, curValue);
        dfsFill(x, y - 1, picture, valueToFill, curValue);

    }

    public static void floodFillImage(int x, int y, int[][] picture, int valueToFill) {

        int curValue = picture[x][y];
        if (curValue == valueToFill) return;
        dfsFill(x, y, picture, 3, curValue);

    }


    public static void main(String[] args) {


        int[][] picture =
                {
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 0, 0, 1, 1, 0, 1, 1},
                        {1, 2, 2, 2, 2, 0, 1, 0},
                        {1, 1, 1, 2, 2, 0, 1, 0},
                        {1, 1, 1, 2, 2, 2, 2, 0},
                        {1, 1, 1, 1, 1, 2, 1, 1},
                        {1, 1, 1, 1, 1, 2, 2, 1},
                };

        System.out.println("Before Flash fill");
        printPicture(picture);
        floodFillImage(4, 4, picture, 3);
        System.out.println("After Flash fill");
        printPicture(picture);

    }

}
