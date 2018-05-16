[Minimum Distance Between BST Nodes][title]

## Description

Given a Binary Search Tree (BST) with the root node `root`, return the minimum difference between the values of any two different nodes in the tree.

**Example :**

```
Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
```

**Note:**

1. The size of the BST will be between 2 and `100`.
2. The BST is always valid, each node's value is an integer, and each node's value is different.

**Tags:** [Binary Search Tree](https://leetcode.com/tag/binary-search-tree/)

## 思路

给出一个二叉查找树，要求找出此树任意节点之间的最小差值。

二叉查找树的中序遍历结果就是排序的结果，计算中序遍历结果中相邻的数之间的最小差值即可。

**Java:**

```java
public int minDiffInBST(TreeNode root) {
    int minDiff = Integer.MAX_VALUE;
    Stack<TreeNode> s = new Stack<>();
    TreeNode curr = root, prev = null;
    while (curr != null || !s.isEmpty()) {
        while (curr != null) {
            s.push(curr);
            curr = curr.left;
        }
        curr = s.pop();
        if (prev != null)
            minDiff = Math.min(minDiff, Math.abs(curr.val - prev.val));
        prev = curr;
        curr = curr.right;
    }
    return minDiff;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution