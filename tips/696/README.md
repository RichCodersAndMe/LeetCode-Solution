[Count Binary Substrings][title]

## Description

Give a string `s`, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

**Example 1:**

```
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
```

**Example 2:**

```
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
```

**Note:**

`s.length` will be between 1 and 50,000.

`s` will only consist of "0" or "1" characters.

**Tags:** [String](https://leetcode.com/tag/string/)


## 思路

题目给出一个只包含`0`和`1`的字符串，要求找出符合以下条件的子字符串的个数：

- `0`和`1`的个数相等。
- 子字符串中所有的`0`必须是连续的，所有的`1`也必须是连续的。

根据题意可以知道符合要求的子字符串肯定是连续的`0`（或`1`）和相同数量的`1`（或`0`）所组成的，例如`000111`。可以看出，其中的`01`和`0011`也同样符合要求。实际上我们可以判定，当找到连续的a个`0`和连续的b个`1`所组成的字符串时，其中符合要求的子字符串的个数为`min(a, b)`，根据这点可以省略一些匹配操作。例如`111000011`，连续的`1`或`0`的长度分别是3、4、2，那么符合要求的子字符串个数就等于`min(3, 4)+min(4, 2)`。我们通过两个变量来记录上文提到的a和b，通过一次遍历便可以得出符合要求的子字符串的数量。

**Java:**

```java
public int countBinarySubstrings(String s) {
    int sum = 0;
    int len = s.length();
    char[] chs = s.toCharArray();

    int frontLen = 0;
    while (frontLen < len && chs[frontLen] == chs[0]) {
        frontLen++;
    }
    int behindLen;

    int i = frontLen;
    char c;
    while (i < len) {
        c = chs[i];
        behindLen = 0;
        while (i < len && chs[i] == c) {
            i++;
            behindLen++;
        }
        sum += Math.min(frontLen, behindLen);
        frontLen = behindLen;
    }

    return sum;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/count-binary-substrings/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution