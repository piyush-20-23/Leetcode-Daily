class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        List<Boolean> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '0') zeros++;
            else ones++;
        }

        for (String i : strs) {
            int currz = 0;
            int curro = 0;
            int currx = 0;

            for (char ch : i.toCharArray()) {
                if (ch == '0') currz++;
                else if (ch == '1') curro++;
                else currx++;
            }

            if (curro > ones || currz > zeros) {
                list.add(false);
                continue;
            }

            if (curro + currx < ones || currz + currx < zeros) {
                list.add(false);
                continue;
            }

            int needZero = zeros - currz;
            int needOne = ones - curro;

            char[] arr = i.toCharArray();

            for (int j = 0; j < n; j++) {
                if (arr[j] == '?') {
                    if (needZero > 0) {
                        arr[j] = '0';
                        needZero--;
                    } else {
                        arr[j] = '1';
                        needOne--;
                    }
                }
            }

            int cnt = 0;
            boolean flag = false;

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != arr[j]) {
                    if (arr[j] == '0') {
                        cnt++;
                    } else {
                        if (cnt > 0) {
                            cnt--;
                        } else {
                            list.add(false);
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (!flag) list.add(true);
        }

        boolean[] ans = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}