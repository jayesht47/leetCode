package line;

public class Bingo {

    private int checkForBingo(int[][] board, boolean[][] visited, int x, int y) {

        //checking for vertical bingo
        boolean isVerticalBingo = true;
        int verticalBingoCount = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i][y]) {
                verticalBingoCount += board[i][y];
            } else {
                isVerticalBingo = false;
                break;
            }
        }

        //checking for horizontal bingo
        boolean isHorizontalBingo = true;
        int horizontalBingoCount = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i][y]) {
                horizontalBingoCount += board[i][y];
            } else {
                isHorizontalBingo = false;
                break;
            }
        }

        //checking for diagonal bingo
        boolean isDiagonalBingo = true;
        int diagonalBingoCount = 0;
        if (visited.length % 2 != 0 && x == y) {
            // upper diagonal
            for (int i = x; i >= 0; i--) {
                if (visited[i][i])
                    diagonalBingoCount += board[i][i];
                else {
                    isDiagonalBingo = false;
                    break;
                }
            }
            //lower diagonal
            if (isDiagonalBingo) {
                for (int i = x + 1; i < board.length; i++) {
                    if (visited[i][i])
                        diagonalBingoCount += board[i][i];
                    else {
                        isDiagonalBingo = false;
                        break;
                    }
                }
            }
        }

        int minBingo = Integer.MAX_VALUE;
        if (isVerticalBingo)
            minBingo = Math.min(verticalBingoCount, minBingo);

        if (isHorizontalBingo)
            minBingo = Math.min(horizontalBingoCount, minBingo);

        if (isDiagonalBingo)
            minBingo = Math.min(diagonalBingoCount, minBingo);

        return minBingo;

    }


    public String bingo(int[][] board, int[] inputs) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        int visitedCounter = 0;
        for (int element : inputs) {
            for (int i = 0; i < board.length; i++) {
                boolean breakFlag = false;
                for (int j = 0; j < board[0].length; j++) {
                    if (element == board[i][j]) {
                        visitedCounter++;
                        visited[i][j] = true;
                        breakFlag = true;
                        if (visitedCounter > 2) {
                            int minBingo = checkForBingo(board, visited, i, j);
                            if (minBingo != Integer.MAX_VALUE)
                                return Integer.toString(minBingo);
                        }
                        break;
                    }
                }
                if (breakFlag) break;
            }
        }
        return "-1";
    }

    // The following may not need to be modified
    public String solution(int n, int[] rawBoard, int[] inputs) {
        final int[][] board = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = rawBoard[i * n + j];
            }
        }
        return bingo(board, inputs);
    }
}
