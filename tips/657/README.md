[Judge Route Circle][title]

## Description

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to **the original place**.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are `R` (Right), `L`(Left), `U` (Up) and `D` (down). The output should be true or false representing whether the robot makes a circle.

**Example 1:**

```
Input: "UD"
Output: true
```

**Example 2:**

```
Input: "LL"
Output: false
```

**Tags:** [String](https://leetcode.com/tag/string/)

## 思路
如题意，机器人会按照所给指令`U`、`D`、`L`、`R`进行上下左右移动。题目要求根据所给指令，计算机器人是否能走回原点。遍历指令数组，分别记录`U`、`D`、`L`、`R`的个数，若U=D且L=R则能走回远点。

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[128];
        for (char c : moves.toCharArray()) {
            count[c]++;
        }
        return count['U'] == count['D'] && count['L'] == count['R'];
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/judge-route-circle/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution