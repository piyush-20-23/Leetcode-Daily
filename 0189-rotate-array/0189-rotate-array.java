class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1){
            return;
        }
        if(k > nums.length){
            k = k % nums.length;
        }
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i ++){
            int pos = (k + i) % nums.length;

            ans[pos] = nums[i];
        }
        for(int i = 0; i < nums.length; i ++){
            nums[i] = ans[i];
        }
        return;
    }
}