class Solution {
    int[] cost;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        int n = cost.length;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n);
    }

    public int helper(int n){
        if(n < 0){
            return 0;
        }

        if(dp[n] != -1)
            return dp[n];

        int oneDown = helper(n - 1);
        int twoDown = helper(n - 2);

        return dp[n] =  Math.min(oneDown, twoDown) + ((n > cost.length - 1) ? 0 : cost[n]);
    }
}