class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int take = rob(nums, i - 2) + nums[i];
        int skip = rob(nums, i - 1);
        int result = Math.max(take, skip);
        memo[i] = result;
        return result;
    }
}