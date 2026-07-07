class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;

        while(n > 0){
            int digit = n % 10;
            
            if(digit != 0){
                x = x * 10 + digit;
            }

            sum += digit;
            

            n /= 10;
        }
        

        // reverse the x
        long revX = 0;
        while(x > 0){
            int digit = (int)x % 10;
            revX = revX * 10 + digit;

            x /= 10;
        }

        return sum * revX;
    }
}