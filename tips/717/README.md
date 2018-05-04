[1-bit and 2-bit Characters][title]

## Description

We have two special characters. The first character can be represented by one bit `0`. The second character can be represented by two bits (`10` or `11`).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

**Example 1:**

```
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
```

**Example 2:**

```
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
```

**Note:**

`1 <= len(bits) <= 1000`.

`bits[i]` is always `0` or `1`.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路 1

观察可以发现，其实每个编码数组都只有一种解码方式，可以直接从头开始解码。

**Java:**

```java
public boolean isOneBitCharacter(int[] bits) {
    int i = 0;
    while (i < bits.length - 1) {
        i += bits[i] + 1;
    }
    return i == bits.length - 1;
}
```

## 思路 2

再观察我们可以发现，`0`肯定是一个字符编码的结尾。且题目指出所给的编码数组的最后一个编码肯定为`0`，那么我们只要找到倒数第二个`0`的位置即可，因为这两个`0`之间的`1`的个数为偶数个时，当且仅当最后一个字符的编码为一个单独的`0`。

**Java:**

```java
public boolean isOneBitCharacter(int[] bits) {
    int i = bits.length - 2;
    while (i >= 0 && bits[i] != 0) i--;
    return ((bits.length - i) & 1) == 0;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution