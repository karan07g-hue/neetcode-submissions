class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m * n - 1;

        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(matrix[mid/n][mid%n] < target){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        if(matrix[lo/n][lo % n ]== target){
            return true;
        }
        return false;
    }
}
