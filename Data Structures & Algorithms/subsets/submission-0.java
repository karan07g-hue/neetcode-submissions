class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, result);
        return result;
    }
    private void backtrack(List<Integer> path, int start, int[] nums,  List<List<Integer>> result){
        result.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(path, i + 1, nums, result);
            path.remove(path.size() - 1);
        }
    }
}
