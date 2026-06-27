class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        Set<Integer> hs = new HashSet<>();
        
        for(int ele : nums){
            hs.add(ele);
        }

        int res = 0;
        for(int ele : hs){
            int temp = 1;
            if(!hs.contains(ele - 1)){
                int j = ele;
                while(hs.contains(j + 1)){
                    temp ++;
                    j += 1;
                }
            }
            res = (res > temp) ? res : temp;
        }
        return res;
    }
}