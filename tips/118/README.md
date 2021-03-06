# [Pascal's Triangle][title]

## Description

Given *numRows*, generate the first *numRows* of Pascal's triangle.

For example, given *numRows* = 5,

Return

```
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

**Tags:** Array


## 思路

题意是给出行数，输出帕斯卡尔三角形，很简单的模拟，就不多说了。

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> upSub = list.get(i - 1);
                    sub.add(upSub.get(j - 1) + upSub.get(j));
                }
            }
            list.add(sub);
        }
        return list;
    }
}
```

kotlin(208ms/91.67%):
```kotlin
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0 until numRows) {
            val item = ArrayList<Int>()
            item.add(1)
            if (i > 1) {
                for (j in 1 until i) {
                    val prev = list[i - 1]
                    item.add(prev[j - 1] + prev[j])
                }
            }
            if (i > 0) item.add(1)
            list.add(item)
        }
        return list
    }
}
```

JavaScript：
```JavaScript
var generate = function(numRows) {
  let arr = []
  for(var i = 1; i <= numRows; i++) {
      if(i === 1) {
          arr.push([1])
          continue
      }
      if(i === 2) {
          arr.push([1, 1])
          continue
      }
      let innerArr = [1]
      for(var j = 2; j < i; j++) {
          innerArr.push(arr[i-2][j-2] + arr[i-2][j-1])
      }
      innerArr.push(1)
      arr.push(innerArr)
  }
  return arr
};
```
## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/pascals-triangle
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
