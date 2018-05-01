package _696;

class Solution {
    public int countBinarySubstrings(String s) {
        int sum = 0;
        int len = s.length();
        char[] chs = s.toCharArray();

        int frontLen = 0;
        while (frontLen < len && chs[frontLen] == chs[0]) {
            frontLen++;
        }
        int behindLen;

        int i = frontLen;
        char c;
        while (i < len) {
            c = chs[i];
            behindLen = 0;
            while (i < len && chs[i] == c) {
                i++;
                behindLen++;
            }
            sum += Math.min(frontLen, behindLen);
            frontLen = behindLen;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBinarySubstrings("00110011"));
        System.out.println(solution.countBinarySubstrings("111000011"));
        System.out.println(solution.countBinarySubstrings("00110"));
        System.out.println(solution.countBinarySubstrings("0"));
    }
}
