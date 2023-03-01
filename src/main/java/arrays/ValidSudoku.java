package arrays;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> rowSet;
        HashSet<Character> colSet;

        for (char[] chars : board) {
            rowSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (chars[j] != '.') {
                    if (rowSet.contains(chars[j]))
                        return false;
                    else
                        rowSet.add(chars[j]);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            colSet = new HashSet<>();
            for (char[] chars : board) {
                if (chars[i] != '.') {
                    if (colSet.contains(chars[i]))
                        return false;
                    else
                        colSet.add(chars[i]);
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!isSubBlockValid(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean isSubBlockValid(char[][] board, int x, int y) {
        int endX = x + 3;
        int endY = y + 3;
        HashSet<Character> blockSet = new HashSet<>();
        for (int i = x; i < endX; i++) {

            for (int j = y; j < endY; j++) {
                if (board[i][j] != '.') {
                    if (blockSet.contains(board[i][j]))
                        return false;
                    else
                        blockSet.add(board[i][j]);
                }
            }
        }
        return true;
    }

}
