# [Pascal's Triangle II][title]

## Description

Given an index *k*, return the *k*<sup>th</sup> row of the Pascal's triangle.

For example, given *k* = 3,

Return `[1,3,3,1]`.

**Note:**

Could you optimize your algorithm to use only *O*(*k*) extra space?

**Tags:** Array


## 思路0

题意是指定输出帕斯卡尔三角形的某一行，模拟即可，优化后的代码如下所示。

java:
```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
```
## 思路1

题目提示我们可以思考一下时间复杂度为O(n)的算法。仔细观察每一行数字即可找出规律。 
kotlin(184ms/66.67%):
```kotlin
class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val res = Array(rowIndex + 1, { 1 })
        for (i in 1 until rowIndex + 1) {
            if (i > (rowIndex + 1) / 2) {
                res[i] = res[rowIndex - i]
                continue
            }
            res[i] = ((res[i - 1]) * (rowIndex - i + 1).toLong() / i).toInt()
        }
        return res.asList()
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/pascals-triangle-ii
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
