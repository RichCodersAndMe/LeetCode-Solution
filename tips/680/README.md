[Valid Palindrome II][title]

## Description
Given a non-empty string `s`, you may delete **at most** one character. Judge whether you can make it a palindrome.

**Example 1:**

```
Input: "aba"
Output: True
```

**Example 2:**

```
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
```

**Note:**

1. The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

**Tags:** [String](https://leetcode.com/tag/string/)

## 思路

给出一个字符串，要求判断是否可以通过删除最多一个字符来使得原字符串变成回文字符串。对原字符串进行回文判断，若发现左右不匹配的情况下，尝试删除左边或右边的字符，再进行判断，只要其中一种删除方式能使原字符串成为回文字符串则判断可行，若两种删除方式均不行则判断为不可行。

**Java:**

```java
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return l >= r;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/valid-palindrome-ii/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution