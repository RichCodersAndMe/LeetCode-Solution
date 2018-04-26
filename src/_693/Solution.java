package _693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        int op = ((n >> 1) ^ n);
        return (op & (op + 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
    }
}
