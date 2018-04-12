[Maximum Average Subarray I][title]

## Description
Given an array consisting of `n` integers, find the contiguous subarray of given length `k` that has the maximum average value. And you need to output the maximum average value.

**Example:**

```
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
```

**Note:**

1. 1 <= `k` <= `n` <= 30,000.
2. Elements of the given array will be in the range [-10,000, 10,000].

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路
题目要求，找出规定长度的平均值最大的子数组。对数组进行遍历，计算所有的子数组大小进行比较即可。通过子数组移动的方式可以减少一些重复的计算。

例如：

```
[a, b, c, d], e -> a, [b, c, d, e]
```

用变量sum记录子数组的和，子数组往右移动后，sum=sum-a+e

**Java**

```java
public double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }

    int ans = sum;
    for (int i = k; i < nums.length; i++) {
        sum = sum - nums[i - k] + nums[i];
        if (ans < sum) {
            ans = sum;
        }
    }

    return (double) ans / k;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/maximum-average-subarray-i/description/
[ls]: https://github.com/SDE603/LeetCode-Solution