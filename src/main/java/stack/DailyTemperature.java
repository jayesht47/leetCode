package stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
//            Stack<Integer> stack = new Stack<>();
            int daysCount = 1;
            boolean greaterFound = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    greaterFound = true;
                    break;
                } else
                    daysCount++;
            }
            if (greaterFound)
                result[i] = daysCount;
            else
                result[i] = 0;
        }
        return result;
    }
}
