package _762;

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(Integer.bitCount(i))) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isPrime(int num) {
        return num == 2 || num == 3 || num == 5 ||
                num == 7 || num == 11 || num == 13 ||
                num == 17 || num == 19;
    }
}
