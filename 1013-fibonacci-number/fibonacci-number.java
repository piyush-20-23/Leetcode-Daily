class Solution {
    int[] memo;

    public int helper(int n){
        if(n == 0 || n == 1) 
            return n;

        if(memo[n] != -1){
            return memo[n];
        }        

        memo[n] = helper(n - 1) + helper(n - 2);
        return memo[n];
    }
    public int fib(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }
}