class Solution {
    public int search(int[] nums, int target) {
        int lo = 0; 
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] >= target){
                hi = mid;
            }
            else
            lo = mid + 1;
        }
        if(nums[lo] == target){
            return lo;
        }
        return -1;
    }
}
