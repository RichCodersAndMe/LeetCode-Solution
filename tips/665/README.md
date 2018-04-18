[Non-decreasing Array][title]

## Description

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

**Example 1:**

```
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
```

**Example 2:**

```
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
```

**Note:**

The n belongs to [1, 10,000].

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

题目要求判断所给数组能否能通过最多一次的修改，变为递增数组。

**Java:**

```java
public boolean checkPossibility(int[] nums) {
    if (nums.length < 3) {
        return true;
    }

    int modifyCount = 0;

    if (nums[0] > nums[1]) {
        modifyCount++;
        nums[0] = nums[1];
    }

    for (int i = 1; i < nums.length && modifyCount < 2; i++) {
        if (nums[i] < nums[i-1]) {
            if (nums[i] > nums[i-2]) {
                nums[i-1] = nums[i-2];
            } else {
                nums[i] = nums[i-1];
            }
            modifyCount++;
        }
    }
    return modifyCount < 2;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/non-decreasing-array/description/
[ls]: https://github.com/SDE603/LeetCode-Solution