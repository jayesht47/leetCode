package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OpenTheLock {


    private boolean isValid(String input, List<String> deadEnds) {
        return !deadEnds.contains(input);
    }

    public static void main(String[] args) {
        String start = "1239";

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()) {

            String current = queue.remove();

            char[] inputArr = current.toCharArray();

            for (int i = 0; i < 4; i++) {

                int neighbour = (int) inputArr[i] - '0'; // covert using ascii values
                neighbour--;
                if (neighbour == -1) neighbour = 9;
                if (neighbour == 10) neighbour = 0;


            }
        }


    }
}
