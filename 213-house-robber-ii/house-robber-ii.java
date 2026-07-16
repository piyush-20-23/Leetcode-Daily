class Solution {
    int[] nums;
    int dp[][];
    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];
        this.nums = nums;
        dp = new int[nums.length + 1][2];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return Math.max(rob(1, nums.length - 1), rob(0, nums.length - 2));
    }

    public int rob(int start, int i){
        if(i < 0 || i < start){
            return 0;
        }

        if(dp[i][start] != -1)
            return dp[i][start];

        int take = rob(start, i - 2) + nums[i];
        int skip = rob(start, i - 1);

        return dp[i][start] = Math.max(take, skip);
    }
}