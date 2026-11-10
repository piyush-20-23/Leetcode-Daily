class Solution {

    public int solve(int n, int[] costs){
        if(n <= 0){
            return 0;
        }

        int prev1 = 0;
        int prev2 = 0;
        int prev3 = 0;

        for(int i = 1; i <= n; i ++){
            int curr = costs[i-1] + 1 + prev1;

            if(i >= 2){
                curr = Math.min(
                    curr,
                    costs[i-1] + 4 + prev2
                );
            }

            if(i >= 3){
                curr = Math.min(
                    curr, 
                    costs[i-1] + 9 + prev3
                );
            }

            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;

        }

        return prev1;
    }

    public int climbStairs(int n, int[] costs) {
        return solve(n, costs);
    }
}