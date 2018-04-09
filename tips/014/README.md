# [Longest Common Prefix][title]

## Description

Write a function to find the longest common prefix string amongst an array of strings.

**Tags:** String


## 思路

题意是让你从字符串数组中找出公共前缀，我的想法是找出最短的那个字符串的长度 `minLen`，然后在 `0...minLen` 的范围比较所有字符串，如果比较到有不同的字符，那么直接返回当前索引长度的字符串即可，否则最后返回最短的字符串即可。

java:
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        for (int j = 0; j < minLen; ++j)
            for (int i = 1; i < len; ++i)
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    return strs[0].substring(0, j);
        return strs[0].substring(0, minLen);
    }
}
```

与java的解法思路大致相同, 不过少了`找出最短的那个字符串的长度 minLen`这个环节。
我直接假定字符串数组里的第一个字符串的长度是最短的,->`for (i in 0 until strs[0].length) {`  
后面在遍历时遇到长度小于等于index的字符串时，直接返回结果.->`if (str.length <= i) return ret`  
(也有可能在此之前就返回了结果)。->`if (ch != str[i]) return ret`  
kotlin:
```kotlin
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var ret = ""
        for (i in 0 until strs[0].length) {
            val ch = strs[0][i]
            for (str in strs) {
                if (str.length <= i) return ret
                if (ch != str[i]) return ret
            }
            ret += ch
        }
        return ret
    }
}
```


## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/longest-common-prefix
[ls]: https://github.com/SDE603/LeetCode-Solution
