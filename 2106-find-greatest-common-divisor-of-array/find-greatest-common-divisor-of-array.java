class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];

        for(int i = 1; i < nums.length; i ++){
            min = (min < nums[i]) ? min : nums[i];
            nums[i] = (nums[i] > nums[i - 1]) ? nums[i] : nums[i - 1];
        }

        return gcd(min, nums[nums.length - 1]);
    }

    public int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
}