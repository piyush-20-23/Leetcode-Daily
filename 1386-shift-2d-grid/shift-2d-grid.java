class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(k >= m*n) k = k % (m*n);

        int[] ans = new int[m * n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                ans[(i * n) + j] = grid[i][j];
            }
        }

        ans = reverse(ans, 0, m*n - k - 1);
        ans = reverse(ans, m*n - k, m*n - 1);
        ans = reverse(ans, 0, m*n - 1);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i ++){
            res.add(new ArrayList<>());
        }
        
        // iterate ans and fill res according to the rows
        for(int i = 0; i < m * n; i++) {
            res.get(i / n).add(ans[i]);
        }

        return res;
    }

    public int[] reverse(int[] ans, int start, int end){
        while(start < end){
            int swapEle = ans[start];
            ans[start] = ans[end];
            ans[end] = swapEle;

            start ++;
            end --;
        }
        return ans;
    }
}