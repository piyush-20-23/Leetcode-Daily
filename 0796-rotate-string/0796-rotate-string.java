class Solution {
    public boolean rotateString(String s, String goal) {
        String ss = s + s;
        return ss.contains(goal);
    }
}