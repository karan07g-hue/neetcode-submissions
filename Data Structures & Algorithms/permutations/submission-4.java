class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), new boolean[nums.length], nums, result);
        return result;
    }
    private void backtrack(List<Integer> path, boolean[] used, int[] nums, List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(path, used, nums, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
