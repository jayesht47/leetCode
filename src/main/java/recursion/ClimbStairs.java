package recursion;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    Map<Integer, Integer> memory = new HashMap<>();

    public int climbStairs(int n) {
        if (memory.containsKey(n)) return memory.get(n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        memory.put(n, res);
        return res;
    }
}
