package _686;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.length() > B.length()) {
            return A.contains(B) ? 1 : (A + A).contains(B) ? 2 : -1;
        }

        int aInB = B.indexOf(A);

        if (aInB >= A.length()) {
            return -1;
        }
        if (aInB == -1) {
            return (A + A).contains(B) ? 2 : -1;
        }

        int repeatCount = aInB == 0 ? 0 : 1;
        int iA = A.length() - aInB;
        int iB = 0;

        while (iB < B.length()) {
            if (iA == A.length()) {
                iA = 0;
                repeatCount++;
            }

            if (A.charAt(iA) != B.charAt(iB)) {
                return -1;
            }

            iA++;
            iB++;
        }

        return repeatCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(solution.repeatedStringMatch("abcd", "ab"));
        System.out.println(solution.repeatedStringMatch("abcd", "da"));
        System.out.println(solution.repeatedStringMatch("a", "aa"));
    }
}