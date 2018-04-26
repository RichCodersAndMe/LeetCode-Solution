[Binary Number with Alternating Bits][title]

## Description

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

**Example 1:**

```
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
```

**Example 2:**

```
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
```

**Example 3:**

```
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
```

**Example 4:**

```
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
```

**Tags:** [Bit Manipulation](https://leetcode.com/tag/bit-manipulation/)

## 思路

判断所给数字的二进制形式是否是0、1交错的。

**Java:**

```java
public boolean hasAlternatingBits(int n) {
    int op = ((n >> 1) ^ n);
    return (op & (op + 1)) == 0;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/binary-number-with-alternating-bits/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution