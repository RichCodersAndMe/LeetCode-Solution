# [Diameter of Binary Tree][title]

## Description

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the **longest** path between any two nodes in a tree. This path may or may not pass through the root.

**Example:**

Given a binary tree

```
          1
         / \
        2   3
       / \     
      4   5    

```

Return **3**, which is the length of the path [4,2,1,3] or [5,2,1,3].

**Note:** The length of path between two nodes is represented by the number of edges between them.

**Tags:** Tree


## 思路

题意是让你算出二叉树中最远的两个节点的距离，分别计算左右子树的最大高度，然后不断迭代出其和的最大值就是最终结果。

java:
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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l + r > max) max = l + r;
        return Math.max(l, r) + 1;
    }
}
```

不用全局变量的写法(性能较差, 两重递归)
kotlin(264ms/100.00%):
```kotlin
class Solution {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null || root.left == null && root.right == null) return 0
        val height = depth(root.left) + depth(root.right)
        return maxOf(height, maxOf(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)))
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(depth(root.left), depth(root.right))
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/diameter-of-binary-tree
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
