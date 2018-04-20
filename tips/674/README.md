[Longest Continuous Increasing Subsequence][title]

## Description
Given an unsorted array of integers, find the length of longest `continuous` increasing subsequence (subarray).

**Example:**

```
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
```

**Example 2:**

```
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
```

**Note:**

Length of the array will not exceed 10,000.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

找出所给数组中的最长连续递增子数组的长度。

**Java:**

```java
public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    int len = 1;
    int maxLen = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i-1]) {
            len++;
            if (len > maxLen) {
                maxLen = len;
            }
        } else {
            len = 1;
        }
    }
    return maxLen;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
[ls]: https://github.com/SDE603/LeetCode-Solution