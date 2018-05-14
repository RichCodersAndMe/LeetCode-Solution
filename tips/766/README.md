[Toeplitz Matrix][title]

## Description

A matrix is *Toeplitz* if every diagonal from top-left to bottom-right has the same element.

Now given an `M x N` matrix, return `True` if and only if the matrix is *Toeplitz*.

**Example 1:**

```
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
```

**Example 2:**

```
Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
```

**Note:**

1. `matrix` will be a 2D array of integers.
2. `matrix` will have a number of rows and columns in range `[1, 20]`.
3. `matrix[i][j]` will be integers in range `[0, 99]`.

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

给出一个二维数组，判断每一条左上至右下的对角线上的数是否是一致的。

遍历数组，判断每个数是否与其右下角的数一致即可。注意边界判断。

**Java:**

```java
public boolean isToeplitzMatrix(int[][] matrix) {
    int h = matrix.length - 1;
    int w = matrix[0].length - 1;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (matrix[i][j] != matrix[i + 1][j + 1]) {
                return false;
            }
        }
    }
    return true;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/toeplitz-matrix/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution