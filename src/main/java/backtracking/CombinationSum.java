package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(0, candidates, target, combination, res);
        return res;
    }

    private void backtrack(int i, int[] candidates, int target, List<Integer> combination, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(combination));
        else if (i >= candidates.length || target < 0) return;
        else {
            combination.add(candidates[i]);
            backtrack(i,candidates,target - candidates[i],combination,res);
            combination.remove(combination.size() - 1);
            backtrack(i + 1,candidates,target,combination,res);
        }
    }
}
