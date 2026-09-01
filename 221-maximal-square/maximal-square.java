class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
            }
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                } 
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i - 1][j], dp[i-1][j-1]));
            }
        }

for(int[] row : dp){
    System.out.println(Arrays.toString(row));
}

        int maxVal = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        return maxVal * maxVal;
    }
}