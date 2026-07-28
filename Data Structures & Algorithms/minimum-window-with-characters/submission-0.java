class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] have = new int[128];
        int required = 0;
        for(char c : t.toCharArray()){
            if(need[c]++ == 0) required++;
        }
        int satisfied = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            have[c]++;
            if(have[c] == need[c]) satisfied++;

            while(satisfied == required){
                if(right - left + 1 < bestLen){
                    bestStart = left;
                    bestLen = right - left + 1;
                }
                char lc = s.charAt(left);
                have[lc]--;
                if(have[lc] < need[lc]) satisfied--;
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}