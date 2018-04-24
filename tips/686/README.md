[Repeated String Match][title]

## Description

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

**Note:**

The length of `A` and `B` will be between 1 and 10000.

**Tags:** [String](https://leetcode.com/tag/string/)

## 思路

判断重复的A字符串能否使B字符串成为子字符串，若能，计算出至少需要重复几次。使用A字符串对B字符串重复进行匹配即可。但在匹配之前可通过一些已知条件减少一些计算：

- 如果A的长度大于B，假如重复A字符串能使B成为子字符串，那么至多只需重复两次。因为如果重复三次才行，那么B的长度肯定大于A，就矛盾了。
- 如果A的长度小于B，用`IndexOf()`方法计算字符串A在B中首次匹配的位置，记作`aInB`。
    - 如果`aInB`>=`A.length()`，则说明在B的前面一段（比A长或相等）字符串中，没有和A匹配的子字符串，这跟连续的A字符串这个要求不符，因此可以排除。
    - 如果`aInB`==`-1`，则B字符串只有可能是两个连续A字符串的子字符串。
    - 接着循环用A字符串对B字符串进行匹配。

**Java:**

```java
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
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/repeated-string-match/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution