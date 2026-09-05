class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        long[] min = new long[len];

        min[len - 1] = nums[len - 1];
        for(int i = len - 2; i >= 0; i --){
            min[i] = (nums[i] < min[i + 1]) ? nums[i] : min[i + 1];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i ++){
            max = (nums[i] > max) ? nums[i] : max;
            if(max - min[i] <= k){
                return i;
            }
        }
        return -1;
        
    }
}