[Set Mismatch][title]

## Description
The set `S` originally contains numbers from 1 to `n`. But unfortunately, due to the data error, one of the numbers in the set got duplicated to **another** number in the set, which results in repetition of one number and loss of another number.

Given an array `nums` representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

**Example:**

```
Input: nums = [1,2,2,4]
Output: [2,3]
```

**Note:**

1. The given array size will in the range [2, 10000].
2. The given array's numbers won't have any order.

**Tags:** [Hash Table](https://leetcode.com/tag/hash-table/)

## 思路
所给数组包括1到n。数组其中一个数由于出错变成了数组中的另一个数。题意要求找出数组中重复的数，并找出缺失的数。数组大小为2到20000，可以通过一个数组来记录每个数字的个数，通过此数组可以比较轻松的找到重复和缺失的数字，时间和空间复杂度都为O(n)。

**Java**

```java
public int[] findErrorNums(int[] nums) {
    int[] pos = new int[nums.length + 1];
    int[] ans = new int[2];
    
    // Find error number.
    for (int i : nums) {
        if ((++pos[i]) > 1) {
            ans[0] = i;
        }
    }

    // Find Missing number.
    for (int i = 0; i < pos.length; i++) {
        if (pos[i] == 0) {
            ans[1] = i;
        }
    }

    return ans;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/xxxx
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution