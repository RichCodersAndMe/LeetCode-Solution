[Largest Number At Least Twice of Others][title]

## Description

In a given integer array `nums`, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the **index** of the largest element, otherwise return -1.

**Example 1:**

```
Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
```

**Example 2:**

```
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
```

**Note:**

1. `nums` will have a length in the range `[1, 50]`.
2. Every `nums[i]` will be an integer in the range `[0, 99]`.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

给出一个数组，此数组必定有一个最大值。要求判断此最大值是否是其他数的至少两倍大。

遍历找出最大值，再遍历进行比较即可。

**Java:**

```
public int dominantIndex(int[] nums) {
    int max = 0;
    int second = 0;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            second = max;
            max = nums[i];
            index = i;
        } else if (nums[i] > second) {
            second = nums[i];
        }
    }
    return max >= second + second ? index : -1;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution