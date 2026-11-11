class Solution {
    public long minimumCost(int c1, int c2, int cB, int n1, int n2) {
        long totalCost = 0l;

        long min = Math.min(n1, n2);

        totalCost += (long) (Math.min(cB, c1 + c2) * min);

        n1 -= min;
        n2 -= min;

        if(n1 > 0){
            totalCost += (long)n1 * Math.min(cB, c1);
        }

        if(n2 > 0){
            totalCost += (long)n2 * Math.min(cB, c2);
        }

        return totalCost;
    }
}