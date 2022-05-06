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

    static int row_size, col_size = 0;

    /**
     * Helper class for each Node
     */
    static class Node {
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
    private static boolean isValid(int x, int y, boolean[][] visited, char[][] input) {
        if (x < 0 || y < 0 || x >= row_size || y >= col_size) return false;
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
    private static boolean isWater(int x, int y, char[][] input) {
        return input[x][y] == '0';
    }

    public static int numIslands(char[][] grid) {

        int numberOfIslands = 0;
        row_size = grid.length;
        col_size = grid[0].length;

        boolean[][] visited = new boolean[row_size][col_size];

        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Node> islandQueue = new LinkedList<>();

        //adding first node(0,0) to nodeQueue and marking it as visited.
        nodeQueue.add(new Node(0, 0));
        islandQueue.add(new Node(0, 0));
        visited[0][0] = true;

        int lastIslandQLength = 0;
        while (!nodeQueue.isEmpty()) {
            //deque
            Node curNode = nodeQueue.remove();
            if (!islandQueue.isEmpty()) islandQueue.remove();

            int curX = curNode.x;
            int curY = curNode.y;

            //Checking all adjacent nodes

            boolean island = true;
            for (int i = 0; i < 4; i++) {

                int adjX = curX + dirArr[0][i];//row
                int adjY = curY + dirArr[1][i];//col

                if (isValid(adjX, adjY, visited, grid)) {

                    if (!isWater(adjX, adjY, grid)) {
                        islandQueue.add(new Node(adjX, adjY));
                    }

                    //If valid adding to queue and marking as visited
                    nodeQueue.add(new Node(adjX, adjY));
                    visited[adjX][adjY] = true;
                }

                //checking if node is island
//                if (adjX >= 0 && adjY >= 0 && adjX < row_size && adjY < col_size && grid[adjX][adjY] != '0') {
//                    island = false;
//                }

            }

            if (lastIslandQLength > 0 && islandQueue.isEmpty()) {
                numberOfIslands++;
            }
            lastIslandQLength = islandQueue.size();

        }


        return numberOfIslands;
    }


    //Driver for local
    public static void main(String[] args) {


        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));

    }


}
