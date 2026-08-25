class Solution {
    int[][] dp;
    int m;
    int n;

    public int solve(int i, int j){
        // base case
        // out of bound
        if(i >= m || j >= n){
            return 0;
        }

        // end of matrix
        if(i == m-1 && j == n-1){
            return 1;
        }

        // check dp 
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        return dp[i][j] = solve(i + 1, j) + solve(i, j + 1);
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        this.m = m;
        this.n = n;

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0);
    }
}