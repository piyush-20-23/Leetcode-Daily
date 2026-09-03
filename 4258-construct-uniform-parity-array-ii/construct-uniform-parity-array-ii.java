class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);

        // check for all even 
        boolean allEven = true;
        for(int elee : nums1){
            if(elee % 2 != 0){
                allEven = false;
            }
        }

        if(allEven){
            return true;
        }

        // all odds

        int prevOdd = Integer.MIN_VALUE;

        for(int i = 0; i < nums1.length; i ++){
            if(nums1[i] % 2 == 0 && prevOdd == Integer.MIN_VALUE){
                return false;
            }
            else{
                prevOdd = nums1[i];
            }
        }

        return true;
    }
}