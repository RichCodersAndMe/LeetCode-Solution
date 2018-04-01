import java.util.HashSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codeArray = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<Long> set = new HashSet<>();
        int ans = 0;
        for (String s : words) {
            long key = 0;
            for (char c : s.toCharArray()) {
                String code = codeArray[c - 'a'];
                for (char digit : code.toCharArray()) {
                    key <<= 1;
                    key |= (digit == '.' ? 0 : 1);
                }
            }
            if (!set.contains(key)) {
                set.add(key);
                ans++;
            }
        }
        return ans;
    }
}