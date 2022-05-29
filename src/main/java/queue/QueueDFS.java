package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDFS {
    static int ROW_SIZE = 0;
    static int COL_SIZE = 0;

    /**
     * direction Array to check all neighbours of any point
     * row+1,col+0,row+0,col+1,row-1,col+0,row+0,col-1
     */
    private static int[][] directionArr = {{1, 0, -1, 0}, {0, 1, 0, -1}};

    /**
     * Node class for maintaining each node
     */
    static class Node {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * Utility function to check if the node is not out of bounds and not already visited
     *
     * @param x       xCord of Node
     * @param y       yCord of Node
     * @param visited arr of visited Noded
     * @return if node is valid or not
     */
    public static boolean isValid(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= ROW_SIZE || y >= COL_SIZE) return false;
        if (visited[x][y]) return false;
        return true;
    }

    /**
     * @param x       inital node x
     * @param y       inital node y
     * @param input   input 2d arr
     * @param visited
     */
    public static void BFS(int x, int y, int[][] input, boolean[][] visited) {

        Queue<QueueBFS.Node> nodeQueue = new LinkedList<>();

        //adding first element to queue and setting it as vitied
        nodeQueue.add(new QueueBFS.Node(x, y));
        visited[x][y] = true;

        while (!nodeQueue.isEmpty()) {
            //deque
            QueueBFS.Node currentNode = nodeQueue.remove();
            int curX = currentNode.x;
            int curY = currentNode.y;

            //printing the node
            System.out.print(input[curX][curY] + " ");

            //Visiting all adjacent cells
            //Iterating over the directionArr
            for (int i = 0; i < 4; i++) {

                int adjacentX = curX + directionArr[0][i]; //row
                int adjacentY = curY + directionArr[1][i]; //col

                if (isValid(adjacentX, adjacentY, visited)) {
                    //If it is a valid node adding to queue and marking as visited
                    nodeQueue.add(new QueueBFS.Node(adjacentX, adjacentY));
                    visited[adjacentX][adjacentY] = true;
                }

            }

        }


    }


    //Driver code
    public static void main(String[] args) {

        // Given input matrix
        int grid[][] =
                {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

        ROW_SIZE = grid.length;
        COL_SIZE = grid[0].length;

        //visited arr
        boolean[][] visited = new boolean[ROW_SIZE][COL_SIZE];


        BFS(0, 0, grid, visited);

    }
}

