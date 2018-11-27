# [Sqrt(x)][title]

## Description

Implement `int sqrt(int x)`.

Compute and return the square root of *x*.

**x** is guaranteed to be a non-negative integer.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
```

**Tags:** Binary Search, Math


## 思路

题意是求平方根，参考 [牛顿迭代法求平方根](https://wenku.baidu.com/view/6b74c622bcd126fff7050bfe.html)，然后再参考维基百科的 [Integer square root](https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division) 即可。

java:
```java
class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }
}
```

kotlin(192ms/78.57%):
```kotlin
class Solution {
    fun mySqrt(x: Int): Int {
        var k = x.toLong()
        while (k * k > x)
            k = (k + x / k) / 2
        return k.toInt()
    }
}
```

javascript:
```javascript
var mySqrt = function(x) {
    for(var i = 0; i <= x; i++) {
        if(i*i === x) {
            return i
        }
        if(i*i > x) {
			return i-1
        }
    }
};
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/sqrtx
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
