class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        for(int i = 0; i <= 2*n; i ++){
            if(i % 2 == 1)
                oddSum += i;
            else 
                evenSum += i;
        }

        return gcd(oddSum, evenSum);
    }
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        
        return gcd(b, a % b);
    }
}