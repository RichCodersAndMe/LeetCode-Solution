[Two Sum II - Input array is sorted][title]

## Description
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**  
 
 - Your returned answers (both index1 and index2) are not zero-based.
 - You may assume that each input would have exactly one solution and you may not use the same element twice.

**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

**Tags:**   
`Array`

## 思路 1

javascript: 
```javascript
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  let number = []
  for(let i = 0; i < Math.floor(numbers.length/2 + 1); i++) {
      if(numbers[i] <= target && numbers[i] !== numbers[i - 1] ) {
          let firstItem = target - numbers[i]
          let index = numbers.findIndex((item, j) => j!== i &&item === firstItem)
          if(index !== -1) {
              number.push(i + 1, index + 1)
              break
          }
      }
  }
  return number
};
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution