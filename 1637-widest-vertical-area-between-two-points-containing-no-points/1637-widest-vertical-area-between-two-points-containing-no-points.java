class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int maxWidth = 0;

        int[] xAxis = new int[points.length];

        for(int i = 0; i < points.length; i ++){
            xAxis[i] = points[i][0];
        }
        Arrays.sort(xAxis);
        //System.out.println(Arrays.toString(xAxis));

        for(int i = 1; i < xAxis.length; i ++){
            maxWidth = Math.max(maxWidth, xAxis[i] - xAxis[i-1]);
        }

        return maxWidth;

        
    }
}