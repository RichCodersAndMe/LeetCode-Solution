[Flood Fill ][title]

## Description

An `image` is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate `(sr, sc)` representing the starting pixel (row and column) of the flood fill, and a pixel value `newColor`, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

**Example 1:**

```
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
```

**Note:**

The length of `image` and `image[0]` will be in the range `[1, 50]`.

The given starting pixel will satisfy `0 <= sr < image.length` and `0 <= sc < image[0].length`.

The value of each color in `image[i][j]` and `newColor` will be an integer in `[0, 65535]`.

**Tags:** [Depth-first Search](https://leetcode.com/tag/depth-first-search/)

## 思路

题目给出一个二维数组来表示一张图像，数组里的值对应每个像素的值。指定一个目标像素，要求将所有和此像素连通（连通方向为上下左右四个方向）或间接连通的像素都更改为新的像素值`newColor`。

简单的通过深度优先遍历将所有连通的像素改变即可。

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            if (sr > 0) dfs(image, sr - 1, sc, oldColor, newColor);
            if (sr + 1 < image.length) dfs(image, sr + 1, sc, oldColor, newColor);
            if (sc > 0) dfs(image, sr, sc - 1, oldColor, newColor);
            if (sc + 1 < image[sr].length) dfs(image, sr, sc + 1, oldColor, newColor);
        }
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/flood-fill/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution