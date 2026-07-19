class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        int[] lastSeen = new int[26];
        boolean[] visited = new boolean[26];

        // s1 - fill last seen 
        for (int i = 0; i < n; i++) {
            char currCh = s.charAt(i);
            lastSeen[currCh - 'a'] = i;
        }

        String result = "";
        char lastAppended = 'A';
        for (int i = 0; i < n; i++) {
            char currCh = s.charAt(i);

            if (visited[currCh - 'a'])
                continue;

            while (lastAppended > currCh && lastSeen[lastAppended - 'a'] > i) {
                result = result.substring(0, result.length() - 1);
                visited[lastAppended - 'a'] = false;
                if (result.length() == 0) {
                    lastAppended = 'A';
                } else
                    lastAppended = result.charAt(result.length() - 1);
            }
            
            result += currCh;
            lastAppended = currCh;
            visited[currCh - 'a'] = true;

        }

        return result;
    }
}