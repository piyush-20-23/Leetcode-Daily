class Solution {


    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < num.length(); i ++){
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0){
                stack.pop();

                k--;
            }

            stack.push(num.charAt(i));
        }
        //System.out.println("Before while : \n" + stack);

        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k --;
        }

        //System.out.println("After While : " + stack + "\n");        

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        
        // reverse
        ans.reverse();
        
        // remove all leading zeros
        int idx = 0;
        while(ans.length() > idx && ans.charAt(idx) == '0'){
            idx ++;
        }
        
        String result = ans.substring(idx);
        // ans.toString().substring(idx)
        return (result.length() > 0) ? result : "0";
    }
}