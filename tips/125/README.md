[125. Valid Palindrome][title]

## Description
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.


**Example 1:**

```
Input: "A man, a plan, a canal: Panama"
Output: true
```
**Example 2:**

```
Input: "race a car"
Output: false
```

**Note:**
For the purpose of this problem, we define empty string as valid palindrome.

**Tags:** 
`Two Pointers`、 `String`



## 思路 1
1 空串为true
2 从两边往中间靠拢, 遇到不是字母也不是数字的就跳过
3 左边游标索引大于右边游标索引则结束遍历
4 遍历过程中一旦发生不相等, 则不是回文
kotlin(228ms/94.44%):
```kotlin
class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s == " ") return true
        val len = s.length
        var i = 0
        var j = len - 1
        while (i <= j) {
            try {
                while (!(s[i] in 'a'..'z' || s[i] in 'A'..'Z' || s[i] in '0'..'9')) i++
                while (!(s[j] in 'a'..'z' || s[j] in 'A'..'Z' || s[j] in '0'..'9')) j--
            } catch (e: Exception) {
                return true
            }
            try {
                if (!s[i++].equals(s[j--], true)) return false
            } catch (e: Exception) {
                return false
            }
        }
        return true
    }
}
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/valid-palindrome/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution