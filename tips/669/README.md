[Trim a Binary Search Tree][title]

## Description

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

**Example 1:**

```
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
```

**Example 2:**

```
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
```

**Tags:** [Tree](https://leetcode.com/tag/tree/)

## 思路

题目要求剪去搜索二叉树中不在所给区间的节点。此题主要考察搜索二叉树的特性，即在任意节点作为根节点，左侧子树的所有节点均小于根节点，右侧子树的所有节点均大于根节点。可以进行深搜，若发现节点值在所给区间左边，则可以剪去此节点的左子树，同理，节点值在区间右边则可以减掉右子树，接着将另一侧的子树根节点代替此节点即可。

**Java:**

```java
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
        return null;
    }
    if (root.val < L) {
        return trimBST(root.right, L, R);
    }
    if (root.val > R) {
        return trimBST(root.left, L, R);
    }
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
}
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/trim-a-binary-search-tree/description/
[ls]: https://github.com/SDE603/LeetCode-Solution