class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int op1 = 0;
        int op2 = 0;

        for(int i = 0; i < tokens.length; i ++){

            switch (tokens[i]){

            case "+" : 
                op1 = Integer.valueOf(stack.pop());
                op2 = Integer.valueOf(stack.pop());
                stack.push("" + (op1 + op2));
                break;

            case "-" : 
                op1 = Integer.valueOf(stack.pop());
                op2 = Integer.valueOf(stack.pop());
                stack.push("" + (op2 - op1));
                break;

            case "*" : 
                op1 = Integer.valueOf(stack.pop());
                op2 = Integer.valueOf(stack.pop());
                stack.push("" + (op2 * op1));
                break;

            case "/" : 
                op1 = Integer.valueOf(stack.pop());
                op2 = Integer.valueOf(stack.pop());
                stack.push("" + (op2 / op1));
                break;

            default : 
                stack.push(tokens[i]);
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}