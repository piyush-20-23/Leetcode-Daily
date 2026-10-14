class Solution {

    public String maxSumOfSquares(int num, int sum) {

        // invalid cases
        if(sum > num * 9){
            return "";
        }

        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < num; i ++){
            int digitTaken = 9;

            if(sum < 10){
                digitTaken = sum;
            }

            str.append(digitTaken);
            sum -= digitTaken;
        }


        return str.toString();
    }
}