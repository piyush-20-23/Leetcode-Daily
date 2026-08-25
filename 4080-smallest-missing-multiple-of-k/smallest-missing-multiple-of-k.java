class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int ele : nums){
            hs.add(ele);
        }

        for(int i = 1; true; i ++){
            if(!hs.contains(k*i)){
                return k * i;
            }
        }
    }
}