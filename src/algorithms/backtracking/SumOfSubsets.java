package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubsets {
    private void dfs(int col, int currSum, List<Integer> values, int targetSum, List<Integer> currList, List<List<Integer>> result) {

        if(currSum == targetSum) {
            result.add(new ArrayList<>(currList));
        }

        for(; col < values.size(); col++) {
            if(values.get(col) + currSum > targetSum) continue;
            int lastIndex = currList.size();
            currList.add(values.get(col));
            dfs(col + 1, currSum + values.get(col), values,
                    targetSum, currList, result);
            currList.remove(lastIndex);
        }
    }

    public List<List<Integer>> sumOfSubsets(List<Integer> values, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, values, targetSum, new ArrayList<>(), result);
        return result;
    }
}
