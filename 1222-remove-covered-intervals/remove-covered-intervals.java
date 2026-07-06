class Solution {
    public int removeCoveredIntervals(int[][] it) {
        int removed = 0;

        // sort by start time asc
       
        Arrays.sort(it, (a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Primary sort
            } else {
                return Integer.compare(b[1], a[1]); // Secondary sort (tie-breaker)
            }
        });        

        
        int maxEnd = it[0][1];
        
        for(int i = 0; i < it.length - 1; i ++){
            maxEnd = (maxEnd > it[i][1]) ? maxEnd : it[i][1];
            if(it[i + 1][1] <= maxEnd && it[i + 1][0] >= it[i][0]){
                removed ++;
            }
        }
        return it.length - removed;
    }
}














