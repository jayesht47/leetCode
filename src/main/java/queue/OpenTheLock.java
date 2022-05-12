package queue;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {


    private static boolean isValid(String input, String[] deadEnds) {
//        return Arrays.stream(deadEnds).filter(s -> s.equals(input)).collect(Collectors.toList()).size() > 0;

        for (String deadEnd : deadEnds) {
            if (input.equals(deadEnd)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "1239";
        String target = "1230";
        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        queue.add(start);

        int steps = 0;

        String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};

        long before = System.nanoTime();
//        System.out.println(isValid("2002", deadEnds));
//        System.out.println(System.nanoTime() - before);
        while (!queue.isEmpty()) {

            String current = queue.remove();

            char[] inputArr = current.toCharArray();

            for (int i = 0; i < 4; i++) {
                boolean reduce = false;
                for (int j = 0; j < 2; j++) {
                    reduce = !reduce;
                    int neighbour = (int) inputArr[i] - '0'; // covert using ascii values
                    if (reduce) {

                        neighbour--;
                        if (neighbour == -1) neighbour = 9;
                        if (neighbour == 10) neighbour = 0;

                        inputArr[i] = (char) (neighbour + '0');

                        String curString = new String(inputArr);
                        System.out.println(curString);
                        if (curString.equals(target)) break;

                        if (isValid(curString, deadEnds) && !visited.contains(curString)) {
                            queue.add(curString);
                            visited.add(curString);
                        }
                    } else {
                        neighbour++;
                        if (neighbour == -1) neighbour = 9;
                        if (neighbour == 10) neighbour = 0;

                        inputArr[i] = (char) (neighbour + '0');

                        String curString = new String(inputArr);

                        if (curString.equals(target)) break;

                        if (isValid(curString, deadEnds) && !visited.contains(curString)) {
                            queue.add(curString);
                        }
                    }


                }


            }
            steps++;
        }
        System.out.println(steps);


    }
}
