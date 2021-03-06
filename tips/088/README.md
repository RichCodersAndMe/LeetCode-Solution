# [Merge Sorted Array][title]

## Description

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*. The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.

**Tags:** Array, Two Pointers


## 思路

题意是给两个已排序的数组 `nums1` 和 `nums2`，合并 `nums2` 到 `nums1` 中，两数组元素个数分别为 `m` 和 `n`，而且 `nums1` 数组的长度足够容纳 `m + n` 个元素，如果我们按顺序排下去，那肯定要开辟一个新数组来保存元素，如果我们选择逆序，这样利用 `nums1` 自身空间足矣，不会出现覆盖的情况，依次把大的元素插入到 `nums1` 的末尾，确保 `nums2` 中的元素全部插入到 `nums1` 即可。

Java:
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while (n >= 0)
            nums1[p--] = nums2[n--];
    }
}
```

kotlin(208ms/100.00%)
```kotlin
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index = n + m - 1
        var i = m - 1
        var j = n - 1

        while ((i >= 0 || j >= 0) && index >= 0) {
            if (j < 0 && i in 0..(m - 1)) {
                nums1[index--] = nums1[i--]
                continue
            }
            if (i < 0 && j in 0..(n - 1)) {
                nums1[index--] = nums2[j--]
                continue
            }
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--]
            } else {
                nums1[index--] = nums2[j--]
            }
        }
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/merge-sorted-array
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
