class Solution {

    public boolean isSequential(long n){
        long prevDigit = n % 10;
        n /= 10;

        while(n > 0){
            long digit = n % 10;
            if(prevDigit != digit + 1){
                return false;
            }
            prevDigit = digit;
            n /= 10;
        }
        return true;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> ans = new ArrayList<>();

        int[] start = {12,23,34,45,56,67,78,89};

        for(int i = 0; i < 8; i ++){
            long num = (long)start[i];
            long digit;
            
            // start is lower than range
            while(num < low){
                digit = num % 10;
                num = num * 10 + (digit + 1);
            }

            // increment num until it is out of range
            while(num <= high){
                if(isSequential(num))
                    ans.add((int)num);
                digit = num % 10;
                num = num * 10 + (digit + 1);
            }

        }


        Collections.sort(ans);
        
        return ans;
    }
}