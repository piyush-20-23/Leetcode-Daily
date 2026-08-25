class Solution {
    int[][] grid;
    int m;
    int n;
    int[][] dp;

    public int solve(int i, int j){
        // base case
        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }
        if(i == m-1 && j == n- 1){
            // only add one when at final position 
            return 1;
        }

        // memoization 
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // recursion 
        return dp[i][j] = solve(i + 1, j) + solve(i, j + 1);

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.m = grid.length;
        this.n = grid[0].length;

        dp = new int[m + 1][n + 1];

        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        return solve(0,0);
    }
}