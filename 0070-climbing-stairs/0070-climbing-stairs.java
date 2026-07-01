class Solution {
    int[] memo;
    public int climbStairs(int n) {
        this.memo = new int[n + 1];

        return recursion(n);
    }

    public int recursion(int n){
        //base 
        if(n < 3)
            return n;
        
        if (memo[n] != 0){
            return memo[n];
        }
        
        return memo[n] = recursion(n-1) + recursion(n-2);
    }
}