# [Roman to Integer][title]

## Description

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

**Tags:** Math, String


## 思路

题意是罗马数字转整型数，范围从 1 到 3999，查看下百度百科的罗马数字介绍如下：

* 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；

* 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；

* 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9。

那么我们可以利用 map 来完成罗马数字的 7 个数字符号：I、V、X、L、C、D、M 和整数的映射关系，然后根据上面的解释来模拟完成即可。

由此可见, 罗马数字从右往左的单个数字是不单调的非递减的(总体递增,局部递减),大致如下图所示(以两个数字举例):
![img][img]
也就是说倒着遍历这个罗马数字,遇到某个罗马数字比前一个数字小的,就做减法;否则(>=)做加法。

java:
```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
```
kotlin:
```kotlin
class Solution {
    fun romanToInt(s: String): Int {
        var sum = 0
        val map = HashMap<Char, Int>()
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
        var prev = 0
        for (i in s.length - 1 downTo 0) {
            val curr = map[s[i]]
            sum += curr!! * (if (curr < prev) -1 else 1)
            prev = curr
        }
        return sum
    }
}
```


## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/roman-to-integer
[ls]: https://github.com/SDE603/LeetCode-Solution
[img]: ./013.gif