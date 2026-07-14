class Solution {
    // bottom up sol with O(1) space
    public int fib(int n) {
        if(n <= 1) 
            return n;
            

        int first = 0;
        int second = 1;

        for(int i = 2; i < n + 1; i ++){
            int temp = second;
            second = first + second;
            first = temp;
        }   

        return second;
    }
}