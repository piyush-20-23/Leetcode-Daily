class Solution {
    public int smallestNumber(int n, int t) {
        int pro = -1;
        int i = 0;

        if(t == 1) return n;

        while(pro % t != 0){
            pro = digitPro(n + i);
            i ++;
        }
        return n + i - 1;
    }

    public int digitPro(int n){
        int pro = 1;
        while(n > 0){
            int digit = n % 10;
            pro *= digit;
            n /= 10;
        }
        return pro;
    }
}