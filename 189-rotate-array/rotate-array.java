class Solution {

    public void reverse(int[] nums, int startIndex, int endIndex){
        while(startIndex < endIndex){
            int swapEle = nums[startIndex];
           
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = swapEle;

            startIndex ++;
            endIndex --;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return;
        if(k > n) 
            k = k % n;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n-k, n - 1);
        reverse(nums, 0, n-1);
    }
}