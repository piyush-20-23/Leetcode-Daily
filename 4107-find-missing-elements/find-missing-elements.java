class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> hs = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i ++){
            min = (min < arr[i]) ? min : arr[i];
            max = (max > arr[i]) ? max : arr[i];
            hs.add(arr[i]);
        }

        for(int i = min; i <= max; i ++){
            if(!hs.contains(i))
                ls.add(i);
        }

        return ls;
    }
}