class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();

        map.forEach((key, value) -> list.add(new int[]{key, value}));
        
        list.sort((a,b) -> (a[1] == b[1]) ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        
        int pos = 0;
        for(int[] arr : list){
            for(int j = 0; j < arr[1]; j ++){
                nums[pos] = arr[0];
                pos ++;
            }
        }

        return nums;
    }
}