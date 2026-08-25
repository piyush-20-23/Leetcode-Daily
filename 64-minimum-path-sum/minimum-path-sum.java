class Solution {
    int m;
    int n;
    int[][] grid;
    int[][] dp;

    public int solve(int i, int j){
        // base condition 
        if(i == 0 || j == 0){
            return dp[i][j];
        }

        // memoization 
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        // recursion 
        return dp[i][j] = grid[i][j] + Math.min(
            solve(i - 1, j), 
            solve(i, j - 1)
        );
    }

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m + 1][n + 1];

        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        dp[0][0] = grid[0][0];

        for(int i = 1; i < m; i ++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i ++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }


        return solve(m-1, n-1);

    }
}