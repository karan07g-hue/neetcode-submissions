class Solution {
    public int search(int[] nums, int target) {
      int n = nums.length;
      int pivot = findPivot( nums, n);
      int idx = binarySearch(0, pivot - 1, nums, target);
      if(idx != -1){
        return idx;
      }
      idx = binarySearch(pivot, n - 1, nums, target);
      return idx;  
    }
    int findPivot(int[] nums, int n){
        int lo = 0;
        int hi = n - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
    int binarySearch(int lo, int hi, int[] nums, int target){
        int idx = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                idx = mid;
                break;
            } else if(nums[mid] > target){
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        return idx;
    }
}