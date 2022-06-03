package stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
//            Stack<Integer> stack = new Stack<>();
            int daysCount = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    daysCount++;
                    break;
                } else
                    daysCount++;
            }
            result[i] = daysCount;
        }
        return result;
    }
}
