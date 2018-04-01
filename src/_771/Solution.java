public class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                sum++;
            }
        }
        return sum;
    }
}