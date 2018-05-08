package _744;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int left = 0;
        int right = letters.length;
        int mi;
        while (left < right) {
            mi = left + (right - left) / 2;
            if (letters[mi] <= target) {
                left = mi + 1;
            } else {
                right = mi;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(new char[] {'a', 'b'}, 'a'));
    }
}
