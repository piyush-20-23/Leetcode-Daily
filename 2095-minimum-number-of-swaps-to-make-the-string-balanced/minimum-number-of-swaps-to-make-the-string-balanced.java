class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int swaps = 0;

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder str = new StringBuilder(s);

        for(int i = s.length() - 1; i >= 0; i --){
            char ch = s.charAt(i);

            if(ch == '['){
                q.offer(i);
            }
        }

       // System.out.println(q);

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if(ch == '['){
                count ++;
            }
            else{
                count --;
            }

            if(count < 0){
                // swap 
                swaps ++;
                str.setCharAt(i, '[');
                str.setCharAt(q.poll(), ']');
                count = 1;
            }
        }

        return swaps;

    }
}