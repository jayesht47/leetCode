package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirArr = {{0, 1, 0, -1},
                                     {1, 0, -1, 0}};

    private boolean isValidNode(int x, int y, int[][] image, boolean[][] visited, int initColor) {
        return x >= 0 && y >= 0 && x < image.length && y < image[0].length && !visited[x][y] && image[x][y] == initColor;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));
        int initColor = image[sr][sc];
        visited[sr][sc] = true;
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (int i = 0; i < 4; i++) {
                int adjacentX = n.x + dirArr[0][i];
                int adjacentY = n.y + dirArr[1][i];

                if (isValidNode(adjacentX, adjacentY, image, visited, initColor)) {
                    visited[adjacentX][adjacentY] = true;
                    image[adjacentX][adjacentY] = color;
                    queue.add(new Node(adjacentX, adjacentY));
                }
            }
        }
        return image;
    }

    public static void display2DArray(int[][] inputArr) {
        for (int[] ints : inputArr) {
            for (int j = 0; j < inputArr[0].length; j++) {
                System.out.print(" " + ints[j] + " ");
            }
            System.out.println();
        }
    }
}
