class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int len = 0;
        int product = 1;
        int left = 0;
        int right = 0;

        while(right < nums.length){
            product *= nums[right];

            while(product >= k && left <= right){
                product /= nums[left];
                left ++;
                len --;
            }
            
            ans += right - left + 1;
            
            right ++;
        }

        return (ans > 0) ? ans : 0;
    }
}