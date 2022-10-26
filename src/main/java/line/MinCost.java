package line;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class MinCost {



    int minimumCost(int[][] map){
        // write your code in Java 11



        return -1;
    }

    // The following may not need to be modified
    public int solution(int rows, int cols, String input) {
        int[][] costs = new int[rows][cols];
        final Scanner in = new Scanner(new BufferedReader(new StringReader(input)));
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                costs[i][j] = in.nextInt();
            }
        }
        return minimumCost(costs);
    }
}
