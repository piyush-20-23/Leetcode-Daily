class Solution {

    public String compare(String prev, String now){
        if(prev.length() < now.length()){
            return prev;
        }
        else if (prev.length() > now.length()){
            return now;
        }

        for(int i = 0; i < prev.length(); i ++){
            if(prev.charAt(i) == now.charAt(i)){
                continue;
            }
            if(prev.charAt(i) == '1'){
                return now;
            }
            else return prev;
        }

        return prev;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int countOne = 0;
        int len = 0;
        int l = 0;
        String ans = "";

        for(int r = 0; r < s.length(); r ++){
            if(s.charAt(r) == '1'){
                countOne ++;
            }

            while(l < s.length() && countOne >= k){
                if(k == countOne){
                    len = r - l + 1;
                    if(ans.isEmpty()){
                        ans = s.substring(l, r + 1);
                    }
                    else ans = compare(ans, s.substring(l,r + 1));
                }

                if(s.charAt(l) == '1'){
                    countOne --;
                }
                l ++;
            }
        }

        return ans;
    }
}