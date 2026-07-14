class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;
            int target = -nums[i];

            while( l < r){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if(sum < target) l++;
                else r--;
            }
        }

        return result;
    }
}
