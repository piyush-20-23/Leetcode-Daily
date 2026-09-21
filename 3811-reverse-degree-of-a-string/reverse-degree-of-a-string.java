class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i = 0; i < s.length(); i ++){
            int pos = i + 1;

            int revPos = 26 - (s.charAt(i) - 'a');
//System.out.println("revPos : " + revPos + " pos : "  + pos);
            sum += pos*revPos; 
        }

        return sum;
    }
}