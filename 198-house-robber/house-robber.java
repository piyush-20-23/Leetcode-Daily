class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];

        int first = 0;
        int second = 0;
        int temp = 0;

        for(int i = 0; i < nums.length; i ++){
            temp = first;
            first = Math.max(second + nums[i], first);
            second = temp;

            // dp[i] = Math.max(dp[i-2] + nums[i - 1], dp[i-1]);
        }

        //return dp[nums.length];
        return first;
    }
}