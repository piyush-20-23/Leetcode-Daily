class Solution {

    public int solve(int sum){
        if(sum < 10){
            return sum;
        }

        return 9;
    }

    public String maxSumOfSquares(int num, int sum) {

        // invalid cases
        if(sum > num * 9){
            return "";
        }

        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < num; i ++){
            int digitTaken = solve(sum);

            str.append(digitTaken);
            sum -= digitTaken;
        }


        return str.toString();
    }
}