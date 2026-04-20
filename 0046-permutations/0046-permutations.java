class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    static void permutation(List<List<Integer>> result, int[] nums, List<Integer> curr, boolean[] arr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr[i]) {
                continue;
            }

            arr[i] = true;
            curr.add(nums[i]);
            
            permutation(result, nums, curr, arr);
            
            curr.remove(curr.size() - 1);
            arr[i] = false;
        }
    }
}