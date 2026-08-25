class Solution {
    List<List<Integer>> tri;
    List<List<Integer>> dp;

    public int solve(int i, int row){
        // base case
        if (row >= tri.size() || i >= tri.get(row).size()) {
            return 0;
        }

        // memoi
        if(dp.get(row).get(i) != null){
            return dp.get(row).get(i);
        }

        // recursion 
        int ans = tri.get(row).get(i) +
                Math.min(
                    solve(i, row + 1),
                    solve(i + 1, row + 1)
                );

        dp.get(row).set(i, ans);

        return ans;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        this.tri = triangle;
        this.dp = new ArrayList<>();
        
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(null);
            }

            dp.add(row);
        }

        return solve(0,0);
    }
}