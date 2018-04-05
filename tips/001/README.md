# [Two Sum][title]

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Tags:** Array, Hash Table


## 思路 0

题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，最容易的当然是循环两次，复杂度为 `O(n^2)`，首次提交居然是 2ms，打败了 100% 的提交，谜一样的结果，之后再次提交就再也没跑到过 2ms 了。
java:
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```
javascript
```javascript
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length - 1; i++) {
        res = target - nums[i]
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[j] === res) {
                return [i, j]
            }
        }
    }
}
```
kotlin:
```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val arr: IntArray = intArrayOf(0, 0)
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i
                    arr[1] = j
                    return arr
                }
            }
        }
        return arr
    }
}
```

## 思路 1

利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 `i = 0` 时，此时首先要判断 `nums[0] = 2` 是否在 map 中，如果不存在，那么插入键值对 `key = 9 - 2 = 7, value = 0`，之后当 `i = 1` 时，此时判断 `nums[1] = 7` 已存在于 map 中，那么取出该 `value = 0` 作为第一个返回值，当前 `i` 作为第二个返回值，具体代码如下所示。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
```


## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/two-sum
[ls]: https://github.com/SDE603/LeetCode-Solution
