
//2379. Minimum Recolors to Get K Consecutive Black Blocks
public class March_8 {
    public static int minimumRecolors(String blocks, int k) {
        int minDiff = Integer.MAX_VALUE;
        int start;
        int end = k;

        for (start = 0; end <= blocks.length(); start ++ ,end++){
            String subStr = blocks.substring(start, end);
            int strDiff = checkWhites(subStr);
            minDiff = Math.min(strDiff, minDiff);
        }
        return minDiff;
    }

    public static int checkWhites(String block){
        int whites = 0;

        for (int i = 0; i < block.length(); i++) {
            if (block.charAt(i) == 'W'){
                whites++;
            }
        }
        return whites;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }
}
