class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insert = 0;

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if(ch == '('){
                open ++;
            }
            else{
                // check if next is also closing 
                if(i < s.length() - 1 && s.charAt(i + 1) == ')'){
                    i ++;
                }
                else{
                    insert ++;
                }


                if(open > 0){
                    // because now we accounted for an open 
                    open --;
                }
                else{
                    insert ++;
                }
            }
        }

        insert += open * 2;

        return insert;
    }
}