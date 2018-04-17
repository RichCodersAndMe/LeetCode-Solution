package _657;

class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[128];
        for (char c : moves.toCharArray()) {
            count[c]++;
        }
        return count['U'] == count['D'] && count['L'] == count['R'];
    }
}