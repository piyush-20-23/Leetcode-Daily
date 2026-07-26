class Solution {
    int[] memo;
    public int solve(int n){
        if(n <= 2){
            return n;
        }

        if(memo[n] != -1)
            return memo[n];


        return memo[n] = solve(n-1) + solve(n-2);
    }

    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n+1; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}