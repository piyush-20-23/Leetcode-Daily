class Solution {

    int[] memo;

    public int solve(int n, int[] costs){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return costs[0] + 1;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int min = Math.min(
            solve(n - 1, costs) + costs[n - 1] + 1, 
            Math.min(
                solve(n - 2, costs) + costs[n - 1] + 4,
                solve(n - 3, costs) + costs[n - 1] + 9 
            )
        );
        return memo[n] = min;
    }

    public int climbStairs(int n, int[] costs) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solve(n, costs);
    }
}