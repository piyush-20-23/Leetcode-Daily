class Solution {
    public long getDescentPeriods(int[] prices) {
        long subarrayLength = 1;
        long fullLength = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i - 1] - prices[i] == 1){
                subarrayLength ++;
            }
            else {
                fullLength += subarrayLength * (subarrayLength + 1) / 2 ;
                subarrayLength = 1;
            }
        }
        fullLength += subarrayLength * (subarrayLength + 1) / 2 ;
        return fullLength;
    }
}