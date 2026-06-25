class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {

        int count = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i ++){
            count = 0;
            for(int j = i; j < nums.length; j ++){
                if(nums[j] == target){
                    count ++;
                }
                
                if(2 * count > (j + 1 - i)){
                    //System.out.println("count : " + count + " i : " + i + " j : " + j);
                    result ++;
                }
                
            }
        }

        return result;
    }
}