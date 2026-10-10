class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int insert = 0;

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if(ch == ')'){
                if(open == 0){
                    insert ++;
                }
                else{
                    open --;
                }
            }
            else{
                open ++;
            }
        }

        insert += open;

        return insert;
    }
}