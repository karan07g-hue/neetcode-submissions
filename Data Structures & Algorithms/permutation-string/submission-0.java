class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1F = new int[26];
        int[] winF = new int[26];
        int len = s1.length();
        for(int i = 0; i < len; i++){
            s1F[s1.charAt(i) - 'a']++;
            winF[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1F, winF)) return true;

        for(int i = len; i < s2.length(); i++){
            winF[s2.charAt(i) - 'a']++;
            winF[s2.charAt(i - len) - 'a']--;
            if(Arrays.equals(s1F, winF)) return true;
        }
        return false;
    }
}
