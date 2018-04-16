[Image Smoother][title]

## Description
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

**Example:**

```
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
```

**Note:**

1. The value in the given matrix is in the range of [0, 255].
2. The length and width of the given matrix are in the range of [1, 150].

**Tags:** [Array](https://leetcode.com/tag/array/)

## 思路

题意为对像素进行平滑化处理。平滑化后的像素值为周围的8个像素加上自己的平均值，再取整。

**Java**

```java
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];

        int sum;
        int count;
        int xLen = M.length;
        int yLen = M[0].length;
        int nx, ny;
        for (int x = 0; x < M.length; x++) {
            for (int y = 0; y < M[x].length; y++) {
                sum = 0;
                count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        nx = x+i;
                        ny = y+j;
                        if (nx >= 0 && nx < xLen && ny >= 0 && ny < yLen) {
                            sum += M[nx][ny];
                            count++;
                        }
                    }
                }
                result[x][y] = sum / count;
            }
        }

        return result;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/image-smoother/description/
[ls]: https://github.com/SDE603/LeetCode-Solution