# [Implement strStr()][title]

## Description

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

Tags:** Two Pointers, String


## 思路

题意是从主串中找到子串的索引，如果找不到则返回-1，当子串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。
Java:
```java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            if (i + l2 > l1) return -1;
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
```
kotlin(200ms/87.50%):
```kotlin
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        
        if (haystack.isEmpty()) {
            return if (needle.isEmpty()) haystack.length else -1
        }
        if (needle.isEmpty()) {
            return 0
        }

        val first = needle[0]
        val max = 0 + (haystack.length - needle.length)

        var i = 0 + 0
        while (i <= max) {
            /* Look for first character. */
            if (haystack[i] != first) {
                while (++i <= max && haystack[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                var j = i + 1
                val end = j + needle.length - 1
                var k = 0 + 1
                while (j < end && haystack[j] == needle[k]) {
                    j++
                    k++
                }

                if (j == end) {
                    /* Found whole string. */
                    return i - 0
                }
            }
            i++
        }
        return -1
    }
}
```


## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/implement-strstr
[ls]: https://github.com/SDE603/LeetCode-Solution
