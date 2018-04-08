# [Reverse Integer][title]

## Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output:  321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

**Note:**

Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

**Tags:** Math


## 思路0

题意是给你一个整型数，求它的逆序整型数，而且有个小坑点，当它的逆序整型数溢出的话，那么就返回 0，用我们代码表示的话可以求得结果保存在 long 中，最后把结果和整型的两个范围比较即可。

```java
class Solution {
    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
```

## 思路1
记录**正/负**,通过**字符串倒序**,**字符串转int**,溢出必定会进入异常,则在catch处`return 0`即可。
```kotlin
class Solution {
    fun reverse(x: Int): Int {
        val symbol = if (x > 0) 1 else -1
        val absX = Math.abs(x)
        return try {
            Integer.parseInt(StringBuilder(String.format("%d", absX)).reverse().toString()) * symbol
        }catch(e: Exception) {
            0
        }
    }
}
```

```JavaScript
var reverse = function(x) {
    var reverse = 0
    var arr = String(x).split('')
    if (x >= 0) {
	    reverse = Number(arr.reverse().join(''))
    } else {
	    reverse = -Number(arr.slice(1,arr.length).reverse().join(''))
    }
    if ((reverse >= Math.pow(2,31) - 1) || (reverse <= -Math.pow(2,31))) {
        reverse = 0
    }
    return reverse
};
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/reverse-integer
[ls]: https://github.com/SDE603/LeetCode-Solution
