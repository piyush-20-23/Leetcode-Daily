class Solution {
    public int longestSubsequence(int[] nums) {
        int xorVal = 0;
        boolean allZero = true;
        for(int i = 0; i < nums.length; i ++){
            xorVal = xorVal ^ nums[i];
            if (nums[i] != 0) allZero = false;
        }
        if(xorVal == 0){
            if(allZero) return 0;
            else return nums.length - 1;
        }
        return nums.length;
    }
}