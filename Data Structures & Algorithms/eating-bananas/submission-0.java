class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for(int p : piles){
            hi = Math.max(p, hi);
        }
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(canEat(piles, mid, h)){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    boolean canEat(int[] piles, int mid, int h){
        long actualHours = 0;
        for(int p : piles){
            actualHours += p/ mid;
            if(p %mid != 0)
                actualHours++;
            }
            return actualHours <= h;
        }
    }
