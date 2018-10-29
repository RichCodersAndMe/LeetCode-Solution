[Base 7][title]

## Description

Given an integer, return its base 7 string representation.


**Example 1:**

```
Input: 100
Output: "202"
```

**Example 2:**

```Input: -7
   Output: "-10"
```

**Note:**
The input will be in range of [-1e7, 1e7].

**Tags:** [no tags]


## 思路 1
判断一下0的情况和负数的符号
kotlin(192ms/100.00%):
```kotlin
class Solution {
    fun convertToBase7(num: Int): String {
        if (num == 0) return "0"
        val isPositive = num >= 0
        var n = Math.abs(num)
        val sb = StringBuilder()
        while (n > 0) {
            sb.append(n % 7)
            n /= 7
        }
        sb.append(if (isPositive) "" else "-")
        return sb.reverse().toString()
    }
}
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/base-7/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution