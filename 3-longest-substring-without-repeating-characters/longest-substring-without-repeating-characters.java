class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        Set<Character> hs = new HashSet<>();
        int l = 0;
        for(int r = 0; r < s.length(); r ++){
            char ch = s.charAt(r);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l ++;
            }
            

            hs.add(ch);
            maxLen = (maxLen > hs.size()) ? maxLen : hs.size();
        }
        return maxLen;
    }
}