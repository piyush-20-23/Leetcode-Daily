class Solution {
    public long maxAlternatingSum(int[] nums) {
        // do not need negative numbers
        // we only need the square of numbers 

        for(int i = 0; i < nums.length; i ++){
            nums[i] = nums[i] * nums[i];
        }

        //System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);

        long sum = 0;

        for(int i = 0; i < nums.length; i ++){
            //System.out.println(sum);
            if (i < nums.length / 2){
                sum -= nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        return sum;
    }
}