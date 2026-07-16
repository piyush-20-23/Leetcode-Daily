class Solution {
    private int compute(int[] nums, int start, int end) {
        int rob_till_curr_minus_1_house = 0;
        int rob_till_curr_minus_2_house = 0;
        for(int i=start; i<=end; i++) {
            int rob_till_curr_house = Math.max(rob_till_curr_minus_1_house, rob_till_curr_minus_2_house+nums[i]);
            rob_till_curr_minus_2_house = rob_till_curr_minus_1_house;
            rob_till_curr_minus_1_house = rob_till_curr_house;
        }
        return rob_till_curr_minus_1_house;
    }
    public int rob(int[] nums) {
        return Math.max(nums[0]+compute(nums, 2, nums.length-2), compute(nums, 1, nums.length-1));
    }
}