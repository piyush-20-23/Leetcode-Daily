class Solution {
    int[] nums;
    Integer[][] dp;

    public int recursion(int currIndex, int prevIndex){

        
        if(currIndex == nums.length)
            return 0;
        
        if(dp[currIndex][prevIndex + 1] != null)    
            return dp[currIndex][prevIndex + 1];
        

        int skip = recursion(currIndex + 1, prevIndex);

        int take = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex])
            take = recursion(currIndex + 1, currIndex) + 1;

        dp[currIndex][prevIndex + 1] = (take > skip) ? take : skip;

        return dp[currIndex][prevIndex + 1]; 
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.dp = new Integer[nums.length][nums.length + 1];
        return recursion(0, -1);
    }
}