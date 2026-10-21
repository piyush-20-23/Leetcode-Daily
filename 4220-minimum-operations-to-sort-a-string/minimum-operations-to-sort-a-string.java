class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] org = s.toCharArray();

        boolean sorted = true;
        char minCh = org[0];
        char maxCh = org[0];

        for(int i = 1; i < n; i ++){
            if(org[i] < org[i - 1]){
//System.out.println(org[i]);
                sorted = false;
            }

            minCh = (char)Math.min(minCh, org[i]);
            maxCh = (char)Math.max(maxCh, org[i]);
        }
        if(sorted){
            return 0;
        }

        if(n == 2){
            return -1;
        }

        if(org[0] == minCh || org[n - 1] == maxCh){
            return 1;
        }

        for(int i = 1; i < n - 1; i ++){
            if(org[i] == minCh || org[i] == maxCh){
                return 2;
            }
        }

        return 3;
    }
}