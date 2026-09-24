class Solution {
    public int sumDigits(int n){
        int sum = 0;

        while(n > 0){
            int digit = n % 10;

            sum += digit;

            n = n / 10;
        }

        return sum;
    }

    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i ++){
            if(i == sumDigits(nums[i])){
                return i;
            }
        }

        return -1;
    }
}