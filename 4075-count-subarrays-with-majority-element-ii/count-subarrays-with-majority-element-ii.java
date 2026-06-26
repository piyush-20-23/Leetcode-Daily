class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        long validLeftPoints = 0;
        long result = 0;
        int cumSum = 0;
        map.put(cumSum, 1);

        for(int x : nums){
            
            if(x == target){
                validLeftPoints += map.getOrDefault(cumSum, 0);
                cumSum += 1;
            }

            else{
                cumSum -= 1;
                validLeftPoints -= map.getOrDefault(cumSum, 0);
            }

            map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);

            result += validLeftPoints;
            
        }
        return result;
    }
}
