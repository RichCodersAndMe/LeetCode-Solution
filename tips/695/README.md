[Max Area of Island][title]

## Description

Given a non-empty 2D array `grid` of 0's and 1's, an **island** is a group of `1`'s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

**Example 1:**

```
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
```

Given the above grid, return `6`. Note the answer is not 11, because the island must be connected 4-directionally.

**Example 2:**

```
[[0,0,0,0,0,0,0,0]]
```

Given the above grid, return `0`.

**Note:** The length of each dimension in the given `grid` does not exceed 50.

**Tags:** [Depth-first Search](https://leetcode.com/tag/depth-first-search/)、[Array](https://leetcode.com/tag/array/)

## 思路

题目给出一个二维数组，`0`代表水域，`1`代表陆地，要求找到最大的一块岛屿，并返回岛的面积（陆地的数量代表面积），因此我们需要算出所有岛的面积大小。遍历二维数组，当发现一块陆地时，通过递归的方式遍历与这块陆地相连的其他陆地，并对陆地的数量进行计数便能得出岛的面积。注意将遍历过的陆地进行标记（可将`1`改成其他数字）防止陆地被重复计数。将得到的岛的面积与当前最大面积进行比较、替换，最后就能得出最大岛屿的面积。

**Java:**

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = area(grid, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) {
            return 0;
        }

        grid[x][y] = 2;

        int sum = 1;
        if (x - 1 >= 0) {
            sum += area(grid, x - 1, y);
        }
        if (x + 1 < grid.length) {
            sum += area(grid, x + 1, y);
        }
        if (y - 1 >= 0) {
            sum += area(grid, x, y - 1);
        }
        if (y + 1 < grid[0].length) {
            sum += area(grid, x, y + 1);
        }

        return sum;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/max-area-of-island/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution