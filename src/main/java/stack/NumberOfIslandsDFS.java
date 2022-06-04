package stack;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslandsDFS {

    public static final int[][] dir = {{1, 0, -1, 0}, {0, 1, 0, -1}};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(int x, int y, char[][] grid, boolean[][] visited) {
        return (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != '0' && !visited[x][y]);
    }


    public void DFS(Node cur, boolean[][] visited, char[][] grid) {

        int x = cur.x;
        int y = cur.y;

        for (int i = 0; i < 4; i++) {

            int curx = x + dir[0][i];
            int cury = y + dir[1][i];


            if (isValid(curx, cury, grid, visited)) {
                visited[curx][cury] = true;
                DFS(new Node(curx,cury), visited, grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    Node node = new Node(i, j);
                    DFS(node, visited, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

}
