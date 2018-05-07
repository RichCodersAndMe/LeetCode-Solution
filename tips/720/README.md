[Longest Word in Dictionary ][title]

## Description

Given a list of strings `words` representing an English Dictionary, find the longest word in `words` that can be built one character at a time by other words in `words`. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

**Example 1:**

```
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
```

**Example 2:**

```
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
```

**Note:**

All the strings in the input will only contain lowercase letters.

The length of `words` will be in the range `[1, 1000]`.

The length of `words[i]` will be in the range `[1, 30]`.

**Tags:** [Hash Table](https://leetcode.com/tag/hash-table/)、[Trie](https://leetcode.com/tag/trie/)

## 思路 1

我们可以将字符串按长度从小到大依次放入一个集合中，这样可以保证在放入字符串时，所有有可能是此字符串前缀的字符串都在此集合中。当要放入集合中时，我们判断原字符串去掉最后一个字符后的字符串是否存在于集合中，若存在才将此字符串放入集合，这样可以保证，集合中的字符串都可以在集合中找到自己的任意长度前缀。按上述要求将所有字符串放入集合，过程中不断更新较长的符合要求的字符串即可。

```java
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
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/longest-word-in-dictionary/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution