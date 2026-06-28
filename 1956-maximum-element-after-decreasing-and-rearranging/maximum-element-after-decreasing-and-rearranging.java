/*
arr : [2,2,1,2,1]
index  0,1,2,3,4
freq: [0,2,3]
+

 */


class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 0;
        int n = arr.length;

        System.out.println(Arrays.toString(arr));

        int[] freq = new int[n + 1];

        for(int i = 0; i < n; i ++){
            if(arr[i] > n){
                freq[n]++;
                continue;
            }
                
            freq[arr[i]] ++;
        }

        int ans = 1;
        for(int i = 2; i <= n; i ++){
            ans = Math.min(ans + freq[i], i);
        }


        return ans;
    }
}