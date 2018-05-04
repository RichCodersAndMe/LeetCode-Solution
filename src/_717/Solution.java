package _717;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] != 0) i--;
        return ((bits.length - i) & 1) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
