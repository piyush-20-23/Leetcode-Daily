class Solution {
    public int maxNumberOfFamilies(int n, int[][] seats) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < seats.length; i ++){
            if(seats[i][1] == 1 || seats[i][1] == 10){
                continue;
            }

            if(!map.containsKey(seats[i][0])){
                map.put(seats[i][0], new ArrayList<Integer>());
            }
            
            map.get(seats[i][0]).add(seats[i][1]);
        }

    // for printing the map
        map.forEach((key, value) ->
            System.out.println(key + " " + value)
        );

        int totalCount = 2* (n - map.size());

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            
            List<Integer> value = entry.getValue();
            
            if(!value.contains(2) && !value.contains(3) && !value.contains(4) && !value.contains(5)){ 
                totalCount ++;
            }
            else if(!value.contains(4) && !value.contains(5) && !value.contains(6) && !value.contains(7)){ 
                totalCount ++;
            }
            else if(!value.contains(6) && !value.contains(7) && !value.contains(8) && !value.contains(9)){ 
                totalCount ++;
            }


        }

        return totalCount;
    }
}