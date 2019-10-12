# [Balanced Binary Tree][title]

## Description

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Tags:** Tree, Depth-first Search


## 思路

题意是判断一棵二叉树是否是高度平衡的，所谓二叉树高度平衡指的是二叉树的每个节点的两棵子树的高度差都不超过 1，那么我们只需计算左右子树的高度，判断其高度差是否不超过 1 即可，如果超过 1，就代表其不是高度平衡的，立即返回不是即可，我这里用返回 `-1` 代表不是。

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
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        if (l == -1) return -1;
        int r = helper(node.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
```

遍历每个节点,只要有一个节点的左右子树深度差超过1(大于等于2), 则这个二叉树就不是平衡平衡的
kotlin(228ms/100.00%):
```kotlin
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        val left = depth(root.left)
        val right = depth(root.right)
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    private fun depth(node: TreeNode?): Int {
        return if (node == null) 0 else 1 + Math.max(depth(node.left), depth(node.right))
    }
}
```


```
var isBalanced = function(root) {
  if(root == null) return true
  var treeDeep = function(root) {
      if(root == null) return 0
      return 1 + Math.max(treeDeep(root.left),treeDeep(root.right))
  }
  leftDeep = treeDeep(root.left)
  rightDeep = treeDeep(root.right)
  if(Math.abs(leftDeep - rightDeep) > 1) {
      return false   
  }
  return isBalanced(root.left) && isBalanced(root.right)
};
```
## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/balanced-binary-tree
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
