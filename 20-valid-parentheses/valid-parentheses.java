class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
         
        Deque<Character> stack = new ArrayDeque<>();

        for(char br : s.toCharArray()){
            //System.out.println(stack);
            if(br == '(' || br == '{' || br == '['){
                stack.push(br);
            }

            else {
                if(stack.isEmpty()){
                    return false;
                }

                if(br == ']' && stack.peek() == '[')
                    stack.pop();
                else if(br == '}' && stack.peek() == '{')
                    stack.pop();
                else if(br == ')' && stack.peek() == '(')
                    stack.pop();
                else return false;
            }
            

            
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}