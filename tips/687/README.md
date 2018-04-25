[Longest Univalue Path][title]

## Description

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

**Note:** The length of path between two nodes is represented by the number of edges between them.

**Example 1:**

Input:

```
              5
             / \
            4   5
           / \   \
          1   1   5
```

Output:

```
2
```

**Example 2:**

Input:

```
              1
             / \
            4   5
           / \   \
          4   4   5
```

Output:

```
2
```

**Note:** The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

**Tags:** [Tree](https://leetcode.com/tag/tree/)、[Recursion](https://leetcode.com/tag/recursion/)


## 思路

计算二叉树中最长的连续相同节点所形成的的路径的长度（节点之间边的数量代表长度）。根据二叉树的特性，用深度优先搜索，对连续相同的节点进行计数即可，需要遵循以下原则：

- 当遇到两条相同的路径可以连接至同一个父节点时，选择较长的路径即可。例如：

```
      1
     / \
   [1]  2
   / \
  1   1
 /
1
```

在所框选的节点上有两条路径连接着。即：

```
      1            1
     /            /
   [1]          [1]
   /      或      \
  1                1
 /
1
```

当然，是选择左边的这条较长的路径。

- 当遇到两条相同的路径可以连接至同一个父节点，且此父节点不能继续向上连接时，可以将两个子节点路径连接起来。例如：

```
   [1]
   / \
  1   1
 /
1
```

此时的路径长度等于左边的两条加上右边的一条，总长度为三。

**Java:**

```java
class Solution {
    private int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val + 1);
        return maxLen;
    }

    private int dfs(TreeNode node, int rootVal) {
        if (node == null) return 0;

        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);

        if (node.val == rootVal) {
            return Math.max(left, right) + 1;
        }

        maxLen = Math.max(maxLen, left + right);

        return 0;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/longest-univalue-path/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution