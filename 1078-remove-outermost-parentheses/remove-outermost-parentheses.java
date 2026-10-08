class Solution {
    public String removeOuterParentheses(String s) {
        List<String> ls = new ArrayList<>();
        int open = 0;
        int close = 0;
        StringBuilder str = new StringBuilder("");

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
                ls.add(str.toString());
                str.setLength(0);
            }
        }

        //System.out.println(ls);

        StringBuilder res = new StringBuilder("");

        for(String pri : ls){
            if(pri.length() == 2){
                res.append("");
            }

            res.append(pri.substring(1, pri.length() - 1));
        }

        return res.toString();
    }
}