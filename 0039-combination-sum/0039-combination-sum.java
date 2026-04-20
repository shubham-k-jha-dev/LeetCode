class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    static void combinations(List<List<Integer>> result, int[] candidates, int target, List<Integer> curr, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                combinations(result, candidates, target - candidates[i], curr, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}