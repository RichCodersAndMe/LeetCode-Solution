[Degree of an Array][title]

## Description
Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.

**Example 1:**

```
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
```

**Example 2:**

```
Input: [1,2,2,3,1,4,2]
Output: 6
```

**Note:**

`nums.length` will be between 1 and 50,000.

`nums[i]` will be an integer between 0 and 49,999.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

题目给出一个非负的整型数组，设定数组中最多的重复数字的个数为degree，要求找出最短的与原字符串有相同的degree的子字符串。遍历数组，将每个数字出现的个数、长度进行记录即可。

**Java:**

```java
public int findShortestSubArray(int[] nums) {
    int max = 0;
    for (int num : nums) {
        max = Math.max(num, max);
    }

    HashMap<Integer, Integer> firstPositions = new HashMap<>(max);
    HashMap<Integer, Integer> degrees = new HashMap<>(max);
    int maxDegree = 1;
    int minLen = 1;

    int degree;
    int len;
    for (int i = 0; i < nums.length; i++) {
        firstPositions.putIfAbsent(nums[i], i);
        degree = degrees.getOrDefault(nums[i], 0);
        degrees.put(nums[i], ++degree);
        if (degree < maxDegree) {
            continue;
        }

        len = i - firstPositions.get(nums[i]) + 1;
        if (degree > maxDegree) {
            maxDegree = degree;
            minLen = len;
        } else if (degree == maxDegree && minLen > len) {
            minLen = len;
        }
    }

    return minLen;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/degree-of-an-array/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution