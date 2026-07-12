class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // s1 sort the array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // s2 initialize the hashmap with ele of arr and rank 
        Map<Integer, Integer> hm = new HashMap<>();

        int rank = 1;
        for(int i = 0; i < sorted.length; i ++){
            // in case of duplicates do not increment rank
            if(hm.containsKey(sorted[i])){
                continue;
            }

            hm.putIfAbsent(sorted[i], rank);
            rank ++;

        }

        // get rank of every ele using hm
        for(int i = 0; i < arr.length; i ++){
            arr[i] = hm.get(arr[i]);
        }
        //System.out.println(Arrays.toString(sorted));
        return arr;
    }
}