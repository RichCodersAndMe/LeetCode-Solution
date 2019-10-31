[Single Number][title]

## Description
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```
Input: [2,2,1]
Output: 1
```

**Example 1:**

```
Input: [4,1,2,1,2]
Output: 4
```


**Tags:** 
HashTable、 Bit Manipulation


## 思路 1
1 存在`r`内的属于已出现重复的数字
2 存在`c`内的属于可能只出现一次的数字
3 当当前数字存在r中时, 说明是重复数字, 直接跳过进入下个循环;当出现重复数字时, 在r中移除该数字, 在c中加入该数字
4 最后`c`中就只剩下一个数字了
从代码看上去是线性复杂度的, 其实并不是, 因为contains方法里执行了循环操作。因此此解法效率较低。但可以应对其他数字出现2次以上的情况。
kotlin(272ms/62.96%): 
```kotlin
fun singleNumber(nums: IntArray): Int {
    val c = HashSet<Int>()
    val r = HashSet<Int>()
    for (num in nums) {
        if (r.contains(num)) continue
        if (c.contains(num)) {
            c.remove(num)
            r.add(num)
        } else {
            c.add(num)
        }
    }
    return c.single()
}
```

## 思路 2
异或。(一个数字与自己异或为0;任何数与0异或为这个数本身)
kotlin(228ms/100.00%): 
```kotlin
fun singleNumber(nums: IntArray): Int {
    var s = 0
    for (num in nums) {
        s = s.xor(num)
    }
    return s
}
```

```JavaScript
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    var x = 0
    for(let i = 0; i < nums.length; i++) {
        x = x^nums[i]
    }
    return x
};
```
## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/single-number/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution