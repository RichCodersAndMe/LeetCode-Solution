[Find Pivot Index ][title]

## Description

Given an array of integers `nums`, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

**Example 1:**

```
Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
```

**Example 2:**

```
Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
```

**Note:**

The length of `nums` will be in the range `[0, 10000]`.

Each element `nums[i]` will be an integer in the range `[-1000, 1000]`.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

在所给整型数组中寻找枢纽点（枢纽点左侧数字的和等于右侧数字的和），若有多个枢纽点，仅返回最左边的，若没有枢纽点则返回`-1`。

我们通过一遍循环就可以获得所有数字的左右两侧的和，将其记录下来就可以轻松的得出枢纽点的位置。不过一次性记录下来需要额外的申请两个等大的数组。实际上我们只需要通过整个数组的和，就可以简单的推算出左右两边的和。假使我们从左往右遍历，每遍历到一个数都将其当做枢纽点，将枢纽左侧的数依次相加就等于左边的和，将数组的和依次减去枢纽的值就等于右边的和。 

**Java:**

```java
public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int leftSum = 0;
    int rightSum = 0;
    
    for (int i = nums.length - 1; i > 0; i--) {
        rightSum += nums[i];
    }

    if (rightSum == 0) {
        return 0;
    }
    
    for (int i = 1; i < nums.length; i++) {
        leftSum += nums[i - 1];
        rightSum -= nums[i];
        if (leftSum == rightSum) {
            return i;
        }
    }

    return -1;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/find-pivot-index/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution

