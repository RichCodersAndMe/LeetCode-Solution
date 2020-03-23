[Excel Sheet Column Number][title]

## Description
Given a column title as appear in an Excel sheet, return its corresponding column number.

**Example:**

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

    
    Input: "A"
    Output: 1

    Input: "AB"
    Output: 28
    
    Input: "ZY"
    Output: 701
```

**Tags:**   
`Array`

## 思路 1

javascript: 
```javascript
/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
  let letter = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
  let letterArr = s.split('').reverse()
  let number = 0
  for(let i = 0; i < letterArr.length; i++) {
      let index = letter.findIndex(item => item === letterArr[i]) + 1
      number += i === 0 ? index : index*Math.pow(26,i)
  }
  return number
};
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/excel-sheet-column-number/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution