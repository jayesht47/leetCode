package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Islands leetcode solution with queue BFS
 */
public class NumberOfIslands {


    /**
     * Direction Array for checking all neighbors of
     * any node
     */
    static int[][] dirArr = {{1, 0, -1, 0}, {0, 1, 0, -1}};

     int row_size, col_size = 0;

     int numberOfIslands = 0;

    /**
     * Helper class for each Node
     */
     class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Utility function to check validity of a Node
     * Checks for out of bounds, already visited or
     * if it is a water node i.e '0' value
     *
     * @param x       x cord of Node
     * @param y       y cord of node
     * @param visited visitedArr
     * @param input   inputArr
     * @return validity status
     */
    private  boolean isValid(int x, int y, boolean[][] visited, char[][] input) {
        if (x < 0 || y < 0 || x >= row_size || y >= col_size || isWater(x, y, input)) return false;
        return !visited[x][y];
    }

    /**
     * Check if it is a water node i.e '0' value
     *
     * @param x     x cord of Node
     * @param y     y cord of node
     * @param input inputArr
     * @return if it is water node or not
     */
    private  boolean isWater(int x, int y, char[][] input) {
        return input[x][y] == '0';
    }

    public  void BFS(int x, int y, boolean[][] visited, char[][] input) {

        Queue<Node> nodeQueue = new LinkedList<>();

        //adding first node(0,0) to nodeQueue and marking it as visited.
        nodeQueue.add(new Node(x, y));
        visited[x][y] = true;


        while (!nodeQueue.isEmpty()) {
            //deque
            Node curNode = nodeQueue.remove();
            int curX = curNode.x;
            int curY = curNode.y;

            //Checking all adjacent nodes
            boolean island = true;
            for (int i = 0; i < 4; i++) {

                int adjX = curX + dirArr[0][i];//row
                int adjY = curY + dirArr[1][i];//col

                if (isValid(adjX, adjY, visited, input)) {

                    //If valid adding to queue and marking as visited
                    nodeQueue.add(new Node(adjX, adjY));
                    visited[adjX][adjY] = true;
                }
            }
        }
    }

    public  int numIslands(char[][] grid) {

        row_size = grid.length;
        col_size = grid[0].length;

        boolean[][] visited = new boolean[row_size][col_size];

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numberOfIslands++;
                    BFS(i, j, visited, grid);
                }
            }
        }


        return numberOfIslands;
    }


    //Driver for local
    public  void main(String[] args) {


        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));

    }


}
