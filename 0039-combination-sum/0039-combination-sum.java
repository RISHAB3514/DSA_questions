
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> current, List<List<Integer>> result) {
        
        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all candidates starting from index
        for (int i = index; i < candidates.length; i++) {
            
            if (candidates[i] > target) {
                continue;
            }

            // Choose the candidate
            current.add(candidates[i]);

            // Same index because elements can be reused
            backtrack(candidates, target - candidates[i], i, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
