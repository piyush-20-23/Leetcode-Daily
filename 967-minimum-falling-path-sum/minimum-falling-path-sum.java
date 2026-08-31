class Solution {
    int[][] mat;
    int[][] dp;

    public int dfs(int i, int j){
        // base case
        // bound check 
        if(i >= mat.length || j >= mat[0].length || i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        // memoi
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        dp[i][j] = mat[i][j] + (
            Math.min(
                dfs(i + 1, j - 1), 
                Math.min(
                    dfs(i + 1, j), 
                    dfs(i + 1, j + 1))
            )
        );

        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        this.mat = matrix;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix[0].length; i ++){
            dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }

        for(int i = 0; i < matrix[0].length; i ++){
            min = Math.min(min, dfs(0, i));
        }




        return min;
    }
}