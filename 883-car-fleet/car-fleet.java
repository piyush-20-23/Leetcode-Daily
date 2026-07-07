class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // initialized a number line and placed the time required by each car to reach target
        double[] noLine = new double[target];

        for(int i = 0; i < n; i ++){
            noLine[position[i]] = (double)(target - position[i] ) / speed[i];
        }

        double[] time = new double[n];
        int pos = 0;
        for(double ele : noLine){
            if(ele != 0){
                time[pos] = ele;
                pos ++;
            }
        }


        //System.out.println(Arrays.toString(time));

        // implement a stack 

        // if time required by the cars ahead is more => it will form a car fleet
        int carFleet = 0;
        Deque<Double> stack = new ArrayDeque();
        stack.push(time[n - 1]);

        int uniqueElement = 1;
        for(int i = n - 2; i >= 0; i --){
            if(stack.peek() >= time[i]){
                time[i] = stack.peek();
            }
            else {
                stack.push(time[i]);
                uniqueElement ++;
            }
        }

        return uniqueElement;
    }
}