class Solution {

    public int digitSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }

        return sum;
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
    public boolean checkDivisibility(int n) {
        if(n % (digitSum(n) + digitPro(n)) == 0)
            return true;
        else
            return false;
    }
}