class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, target, candidates, result);
        return result;
    }
    private void backtrack(List<Integer> path, int start, int target, int[] candidates, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < candidates.length ; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrack(path, i + 1, target - candidates[i], candidates, result);
            path.remove(path.size() - 1);
        }
    }
}
