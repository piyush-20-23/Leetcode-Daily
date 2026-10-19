class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int numSmaller = 0;
        int freqTarget = 0;

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target){
                freqTarget ++;
            }

            if(nums[i] < target){
                numSmaller ++;
            }
        }
        
        List<Integer> ls = new ArrayList<>();

        for(int i = 0; i < freqTarget; i ++){
            ls.add(numSmaller + i);
        }
        
        return ls;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Arrays.sort(nums);

        // List<Integer> ls = new ArrayList<>();

        // for(int i = 0; i < nums.length; i ++){
        //     if(nums[i] == target){
        //         ls.add(i);
        //     }
        // }

        // return ls;
    }
}