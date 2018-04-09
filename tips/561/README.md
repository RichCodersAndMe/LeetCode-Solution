[Array Partition I][title]

## Description
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

**Example:**

```
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
```

**Note:**

1. **n** is a positive integer, which is in the range of [1, 10000].
2. All the integers in the array will be in the range of [-10000, 10000].

**Tags:** [Array](https://leetcode.com/tag/array/)


## 思路 1

题目要求将所给数组两两分组为(a1, b1), (a2, b2), ..., (an, bn)，使得min(ai, bi)的和最大。

了解题目可知，对数组进行排序，取出奇数位的数字相加即可。题目限制数组中的数字范围为[-10000, 10000]，适合使用桶排序提高排序的速度。

```java
public class Solution {
    public int arrayPairSum(int[] nums) {
        // 使用桶排序
        // 创建map数组，map数组下标对应nums数组内的数字，存的是对应数字的数量
        int[] map = new int[20001];
        for (int num : nums) {
            map[num + 10000]++;
        }

        // 遍历，取出奇数位的数并相加即可
        int ans = 0;
        boolean odd = false;
        for (int i = 0; i < map.length; i++) {
            while (map[i] != 0) {
                if (odd = !odd) {
                    ans += i - 10000;
                }
                map[i]--;
            }
        }
        return ans;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/array-partition-i/description/
[ls]: https://github.com/SDE603/LeetCode-Solution