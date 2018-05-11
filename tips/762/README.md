[Prime Number of Set Bits in Binary Representation][title]

## Description

Given two integers `L` and `R`, find the count of numbers in the range `[L, R]` (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of `1`s present when written in binary. For example, `21` written in binary is `10101` which has 3 set bits. Also, 1 is not a prime.)

**Example 1:**

```
Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
```

**Example 2:**

```
Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
```

**Note:**

1. `L, R` will be integers `L <= R` in the range `[1, 10^6]`.
2. `R - L` will be at most 10000.

**Tags:** [Bit Manipulation](https://leetcode.com/tag/bit-manipulation/)

## 思路

求在所给范围的数中，其二进制形式的1的个数为素数的数，共有多少个。

题目所给的最大范围为`[1, 10^6]`，因为`10^6`<`2^20`，所以可以判定所有范围内的数的二进制形式中，`1`的个数不会超过20，20以内的素数仅有2, 3, 5, 7, 11, 13, 17, 19。我们直接循环遍历范围内的数，计算其二进制形式中`1`的个数即可。

**Java:**

```java
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(Integer.bitCount(i))) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isPrime(int num) {
        return num == 2 || num == 3 || num == 5 ||
                num == 7 || num == 11 || num == 13 ||
                num == 17 || num == 19;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution