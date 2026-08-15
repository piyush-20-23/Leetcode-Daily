class Solution {
    public int longestSubsequence(int[] nums) {
        int xorVal = 0;
        for(int i = 0; i < nums.length; i ++){
            xorVal = xorVal ^ nums[i];
            
        }
        if(xorVal == 0){
            return nums.length - 1;
        }
        return nums.length;
    }
}