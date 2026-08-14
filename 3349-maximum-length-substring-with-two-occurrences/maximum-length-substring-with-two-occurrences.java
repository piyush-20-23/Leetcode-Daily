class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        int len = 0;

        int[] map = new int[26];

        int l = 0;

        for(int r = 0; r < s.length(); r ++){
            int charIndex = s.charAt(r) - 'a';
            map[charIndex] ++;
            len ++;

            while(map[charIndex] > 2 && l <= r){
                map[s.charAt(l) - 'a'] --;
                len --;
                l ++;
            }

            maxLen = Math.max(maxLen, len);

        }

        return maxLen;
    }
}