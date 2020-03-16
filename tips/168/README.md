[Excel Sheet Column Title][title]

## Description
Given a positive integer, return its corresponding column title as appear in an Excel sheet.


**Example:**

```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

    
    Input: 1
    Output: "A"

    Input: 28
    Output: "AB"
    
    Input: 701
    Output: "ZY"
```

**Tags:**   
`Array`

## 思路 1

javascript: 
```javascript
/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
    let letter = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    let lastLetter = n % 26 === 0 ? 'Z' : letter[n % 26 - 1]
    if(n <= 26) {
        return lastLetter
    }
    let nextLetterIndex = (n - (n % 26 === 0 ? 26 : n % 26))/26
    if(Math.floor(nextLetterIndex) <= 26) {
        return letter[Math.floor(nextLetterIndex) - 1] + lastLetter
    } else {
        return convertToTitle(Math.floor(n/26)) + lastLetter
    }
};
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/excel-sheet-column-title/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution