class Solution {
    public String removeOuterParentheses(String s) {
        
        int open = 0;
        int close = 0;
        StringBuilder str = new StringBuilder("");
        StringBuilder res = new StringBuilder("");

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            str.append(ch);

            if(ch == '('){
                open ++;
            }
            else{
                close ++;
            }

            // when both are equal it is primitive
            if(open == close){
                res.append(str.substring(1, str.length() - 1));

                // once the primitive is added to res, reset the str for new primitive
                str.setLength(0);
            }
        }

        return res.toString();
    }
}