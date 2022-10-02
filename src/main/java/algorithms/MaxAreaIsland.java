package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaIsland {

    class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirArr = {{1, 0, -1, 0}, {0, 1, 0, -1}};

    private boolean isValid(int[][] grid, boolean[][] visited, Node node) {
        return node.x >= 0 && node.y >= 0 && node.x < grid.length && node.y < grid[0].length && !visited[node.x][node.y];
    }

    private boolean isValidIsland(int[][] grid, Node node) {
        return grid[node.x][node.y] == 1;
    }

    private int checkIslandLength(int[][] grid, boolean[][] visited, Node startPoint) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startPoint);
        int islandSize = 1;
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            for (int i = 0; i < 4; i++) {
                int adjX = curNode.x + dirArr[0][i];
                int adjY = curNode.y + dirArr[1][i];
                Node adjNode = new Node(adjX, adjY);
                if (isValid(grid, visited, adjNode)) {
                    visited[adjNode.x][adjNode.y] = true;
                    if (isValidIsland(grid, adjNode)) {
                        islandSize++;
                        queue.add(adjNode);
                    }
                }
            }
        }
        return islandSize;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxAreaOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Node curNode = new Node(i, j);
                for (int k = 0; k < 4; k++) {
                    if (isValid(grid, visited, curNode)) {
                        visited[curNode.x][curNode.y] = true;
                        if (isValidIsland(grid, curNode)) {
                            int islandLength = checkIslandLength(grid, visited, curNode);
                            maxAreaOfIsland = Math.max(maxAreaOfIsland, islandLength);
                        }
                    }
                }
            }
        }
        return maxAreaOfIsland;
    }


}
