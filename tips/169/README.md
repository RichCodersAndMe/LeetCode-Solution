[Majority Element][title]

## Description
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Example:**

```
    Input: [3,2,3]
    Output: 3

    
    Input: [2,2,1,1,1,2,2]
    Output: 2
```

**Tags:**   
`Array`

## 思路 1

javascript: 
```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let list = [...new Set([...nums])]
    for(let i = 0; i < list.length; i++) {
        let majorityNum = 0
        for(let j = 0; j < nums.length; j++) {
            if(list[i] === nums[j]) {
                majorityNum++
                if(majorityNum > nums.length / 2) {
                    return list[i]
                }
            }
        }
    }
};
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/majority-element/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution