class Solution {
    int[] nums;
    int[][][] dp;
    int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        this.nums = nums;

        int max = 0;

        for(int ele : nums)
            max = Math.max(max, ele);


        dp = new int[nums.length][max + 1][max + 1];

        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0,0,0);
    }

    public int helper(int i, int gcd1, int gcd2){

        // base case
        if(i >= nums.length){
            if(gcd1 != gcd2 || (gcd1 == 0 && gcd2 == 0)){
                return 0;
            }
            else return 1;
        }

        if(dp[i][gcd1][gcd2] != -1)
            return dp[i][gcd1][gcd2];

        // take 1 
        long take1 = helper(i + 1, gcd(gcd1, nums[i]), gcd2);
        
        // take 2
        long take2 = helper(i + 1, gcd1, gcd(gcd2, nums[i]));

        // take 3
        long noTake = helper(i + 1, gcd1, gcd2);

        return dp[i][gcd1][gcd2] = (int)(((take1 % MOD) + (take2 % MOD)) % MOD + (noTake % MOD) ) % MOD;
    }

    public  int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
}