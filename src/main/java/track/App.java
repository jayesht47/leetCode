package track;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static int getClosestUnOccupiedSizeTableIndex(int n, List<Integer> tableData, boolean[] occupiedTables) {
        int minIndex = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < tableData.size(); i++) {
            if (!occupiedTables[i]) {
                int diff = tableData.get(i) - n;
                if (diff > 0 && diff < minDiff) {
                    minDiff = diff;
                    minIndex = i;
                    if (minDiff == 0)
                        return i;
                }
            }
        }
        return minIndex;
    }

    private static int getMinPopLoss(int x, int y, List<Integer> tableData, List<Integer> guestData) {

        boolean[] occupiedTables = new boolean[tableData.size()];
        int tableCounter = 0;
        for (int i = 0; i < guestData.size(); i++) {

            for (int j = 0; j < tableData.size(); j++) {
                if (!occupiedTables[tableCounter]) {
                    int remainingPeople = Integer.MAX_VALUE;
                    while (remainingPeople > 0) {
                        remainingPeople = tableData.get(j) - guestData.get(i);
                        occupiedTables[j] = true;
                        tableCounter++;
                        if (remainingPeople > 0) {
                            int index = getClosestUnOccupiedSizeTableIndex(remainingPeople, tableData, occupiedTables);
                        }
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {


//        String[] lines = getStdin();
        String[] lines = {"4 2 5 3", "4 5 1 1", "7 3"};
        int n = 0;
        int m = 0;
        int x = 0;
        int y = 0;
        List<Integer> tableData = new ArrayList<>();
        List<Integer> guestData = new ArrayList<>();
        for (int i = 0, l = lines.length; i < l; i++) {
            String output = String.format("line[%s]: %s", i, lines[i]);
            System.out.println(output);
            if (i == 0) {
                String[] line1 = lines[i].split(" ");
                n = Integer.parseInt(line1[0]);
                m = Integer.parseInt(line1[1]);
                x = Integer.parseInt(line1[2]);
                y = Integer.parseInt(line1[3]);
            }
            if (i == 1) {
                String[] line2 = lines[i].split(" ");
                for (String e : line2) {
                    tableData.add(Integer.parseInt(e));
                }
            }
            if (i == 2) {
                String[] line2 = lines[i].split(" ");
                for (String e : line2) {
                    guestData.add(Integer.parseInt(e));

                }
            }
        }
        guestData.sort((a, b) -> b - a);
        tableData.sort((a, b) -> b - a);
        boolean[] test = {false,false,false,false};
        System.out.println(getClosestUnOccupiedSizeTableIndex(3,tableData,test));
//        getMinPopLoss(x, y, tableData, guestData);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
