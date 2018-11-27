# [Add Binary][title]

## Description

Given two binary strings, return their sum (also a binary string).

For example,

a = `"11"`

b = `"1"`

Return `"100"`.

**Tags:** Math, String


## 思路

题意是给你两个二进制串，求其和的二进制串。我们就按照小学算数那么来做，用 `carry` 表示进位，从后往前算，依次往前，每算出一位就插入到最前面即可，直到把两个二进制串都遍历完即可。

java:
```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
```
kotlin(232ms/92.86%):
````kotlin
class Solution {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        var flag = 0
        var i = a.length - 1
        var j = b.length - 1
        while (i >= 0 || j >= 0) {
            val ta = if (i < 0) 0 else a[i] - '0'
            val tb = if (j < 0) 0 else b[j] - '0'
            val t = ta + tb + flag
            flag = if (t > 1) 1 else 0
            sb.append(if (t > 1) t - 2 else t)
            i--
            j--
        }
        if (flag == 1) {
            sb.append('1')
        }
        return sb.reverse().toString()
    }
}
````
javascript
```javascript
var addBinary = function(a, b) {
    var len1 = a.length - 1,
        len2 = b.length - 1,
        c = '',
        carry = false;
    while(len1 >= 0 && len2 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+a[len1]) + (+b[len2]) >=2) ? true : false
        c =  (x + (+a[len1]) + (+b[len2]) >=2) ? 
        ((x + (+a[len1]) + (+b[len2])) % 2 + c) : 
        (x + (+a[len1]) + (+b[len2])) + c
        len1--;
        len2--;
    }
    while(len2 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+b[len2]) >=2) ? true : false
        c = (x + (+b[len2]) >=2) ? ('0' + c): (x + (+b[len2]) + c)
        len2--;
    }
    while(len1 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+a[len1]) >=2) ? true : false
        c = (x + (+a[len1]) >=2) ? ('0' + c): (x + (+a[len1]) + c)
        len1--;
    }
	c = (carry ? '1' : '') + c
    return c
};
```
## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/add-binary
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
