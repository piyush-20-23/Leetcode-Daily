class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int pixels = 0;
        int pixelSum = 0;

        for(int i = 0; i < s.length(); i ++){
            pixelSum += widths[s.charAt(i) - 'a'];
            if(pixelSum > 100){
                pixelSum = 0;
                lines ++;
                pixelSum += widths[s.charAt(i) - 'a'];
                
            }
        }

        return new int[]{lines, pixelSum};
    }
}