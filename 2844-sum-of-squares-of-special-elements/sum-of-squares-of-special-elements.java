class Solution {
    public int sumOfSquares(int[] nums) {
        int proSum = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i ++){
            if(n % (i + 1) == 0){
                proSum += nums[i] * nums[i];
            }
        }

        return proSum;
    }
}