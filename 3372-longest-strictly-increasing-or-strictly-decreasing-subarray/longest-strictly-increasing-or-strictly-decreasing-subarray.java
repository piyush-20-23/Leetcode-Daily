class Solution {
    public int longestMonotonicSubarray(int[] arr) {

        if(arr.length == 1){
            return 1;
        }

        int maxInc = 0;
        int maxDec = 0;

        int inc = 1;
        int dec = 1;

        for(int i = 1; i < arr.length; i ++){
            if(arr[i] == arr[i-1]){
                dec = 1;
                inc = 1;
            }
            else if(arr[i] < arr[i - 1]){
                dec ++;
                inc = 1;
            }
            else if (arr[i] > arr[i-1]){
                inc ++;
                dec = 1;
            }

            maxDec = Math.max(maxDec, dec);
            maxInc = Math.max(maxInc, inc);
        }

        return Math.max(maxInc, maxDec);
    }
}
