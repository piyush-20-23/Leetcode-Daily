class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int i = 1;
        int count = 0;
        while(n > 8){
            count += 8 * i;
            n -= 8;
            i ++;
        }

        count += n * i;

        return count;
    }
}