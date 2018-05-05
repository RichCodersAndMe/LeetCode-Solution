package _720;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        HashSet<String> set = new HashSet<>(words.length);
        Arrays.sort(words);
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length()-1))) {
                if (ans.length() < s.length()) {
                    ans = s;
                }
                set.add(s);
            }
        }
        return ans;
    }
}