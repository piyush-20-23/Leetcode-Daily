class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] colSum = new int[n];
        int[] rowSum = new int[m];

        for(int[] pos : indices){
            rowSum[pos[0]] ++;
            colSum[pos[1]] ++;
        }

        int oddCount = 0;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                int matrixSum = rowSum[j] + colSum[i];
                if(matrixSum % 2 == 1)
                    oddCount ++;
            }
        }

        return oddCount;
    }
}