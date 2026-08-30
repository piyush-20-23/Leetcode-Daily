class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        int before = 0;
        int after = 0;
        int between = 0;

        for(int i = 0; i < nums.length; i ++){
            int ele = nums[i];

            if(ele < min){
                min = ele;
                minIdx = i;
            }
            if(ele > max){
                max = ele;
                maxIdx = i;
            }
        }

        before = Math.min(minIdx, maxIdx) + 1;
        after = nums.length - Math.max(minIdx, maxIdx);
        between = Math.max(minIdx, maxIdx) - Math.min(minIdx, maxIdx);


        return Math.min(
            before + after, Math.min(
            before + between,
            after + between
            )
        );
    }
}