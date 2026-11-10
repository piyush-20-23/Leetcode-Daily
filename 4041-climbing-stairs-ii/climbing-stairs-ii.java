
class Solution {

    int[] memo;

    public int solve(int n, int[] costs) {
        if (n <= 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int min = solve(n - 1, costs) + costs[n - 1] + 1;

        if (n >= 2) {
            min = Math.min(min,
                solve(n - 2, costs) + costs[n - 1] + 4);
        }

        if (n >= 3) {
            min = Math.min(min,
                solve(n - 3, costs) + costs[n - 1] + 9);
        }

        return memo[n] = min;
    }

    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solve(n, costs);
    }
}
