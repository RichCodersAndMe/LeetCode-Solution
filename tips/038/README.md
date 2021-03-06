# [Count and Say][title]

## Description

The count-and-say sequence is the sequence of integers with the first five terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` is read off as `"one 1"` or `11`.

`11` is read off as `"two 1s"` or `21`.

`21` is read off as `"one 2`, then `one 1"` or `1211`.

Given an integer *n*, generate the *n*<sup>th</sup> term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

**Example 1:**

```
Input: 1
Output: "1"
```

**Example 2:**

```
Input: 4
Output: "1211"
```

**Tags:** String


## 思路

题意是数和说，根据如下序列 `1, 11, 21, 1211, 111221, ...`，求第 n 个数，规则很简单,就是数和说，数就是数这个数数字有几个，说就是说这个数，所以 `1` 就是 1 个 1：`11`,`11` 就是有 2 个 1：`21`，`21` 就是 1 个 2、1 个 1：`1211`，可想而知后面就是 `111221`，思路的话就是按这个逻辑模拟出来即可。

Java:
```java
class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        return str;
    }
}
```

kotlin(172ms/100.00%):
```kotlin
class Solution {
    fun countAndSay(n: Int): String {
        var say = "1"
        for (count in 1 until n) {
            say = say(say)
        }
        return say
    }

    private fun say(say: String): String {
        val newSay = StringBuilder()
        var prev = say[0]
        var tCount = 0
        for (i in say.indices) {
            if (say[i] == prev) {
                tCount++
                continue
            }
            newSay.append(tCount).append(prev)
            prev = say[i]
            tCount = 1
        }
        newSay.append(tCount).append(prev)
        return newSay.toString()
    }
}

```

javaScript:
```javascript
var countAndSay = function(n) {
    var str = '1'
    while(--n > 0) {
        var len = str.length
        var resultStr = ''
        var times = 1;
        for(var i = 0; i < len; i++) {
            if(str[i] === str[i + 1]) {
                times++
            } else {
                resultStr += times + str[i]
                times = 1;
            }
        }
        str = resultStr
    }
    return str
};
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/count-and-say
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
