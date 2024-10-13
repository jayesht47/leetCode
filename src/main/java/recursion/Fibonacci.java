package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fibonacci {
    Map<Integer, Integer> fibMap = new HashMap<>();

    public int fib(int n) {
        if (fibMap.containsKey(n)) return fibMap.get(n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = fib(n - 1) + fib(n - 2);
        fibMap.put(n, res);
        return res;
    }
}
