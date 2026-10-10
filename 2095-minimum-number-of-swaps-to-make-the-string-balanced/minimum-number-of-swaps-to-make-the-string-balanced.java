class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int swaps = 0;

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if(ch == '['){
                count ++;
            }
            else{
                count --;
            }

            if(count < 0){
                // swap 
                swaps ++;
                count = 1;
            }
        }

        return swaps;

    }
}