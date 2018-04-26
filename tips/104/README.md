# [Maximum Depth of Binary Tree][title]

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Tags:** Tree, Depth-first Search


## 思路

题意是找到二叉树的最大深度，很明显，深搜即可，每深入一次节点加一即可，然后取左右子树的最大深度。

Java:
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
 }
```

kotlin(212ms/100.00%):
```kotlin
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null) return 1 + maxDepth(root.right)
        if (root.right == null) return 1 + maxDepth(root.left)
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right))
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
