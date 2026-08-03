class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, target, nums, result);
        return result;
    }
    private void backtrack(List<Integer> path, int start, int target, int[] nums, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(path, i, target - nums[i], nums, result);
            path.remove(path.size() - 1);
        }
    }
}
