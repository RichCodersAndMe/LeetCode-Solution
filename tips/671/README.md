[Second Minimum Node In a Binary Tree][title]

## Description
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly `two` or `zero` sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the **second minimum** value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

**Example 1:**

```
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
```

**Example 2:**

```
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

**Tags:** [Tree](https://leetcode.com/tag/tree/)

## 思路

题目给出一个特殊的二叉树：任意节点，要么没有子节点，要么有两个子节点，且子节点的值会大于等于他们的根节点。要求找出第二小的节点值。根据此二叉树的特性，根节点的值为最小值。先对树进行先序遍历，当发现比根节点值（最小值）大的节点后，后面的子树就可以进行剪枝了，因为后面的子节点都大于或等于此节点，不会是第二小的节点（或者与第二小的节点值相等）。

**Java:**

```java
public int findSecondMinimumValue(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    int min = root.val;
    int secMin = -1;
    stack.push(root);

    while (!stack.empty()) {
        TreeNode node = stack.pop();

        if (node.val > min) {
             if (node.val < secMin || secMin == -1) {
                 secMin = node.val;
             }
             continue;
        }

        if (node.left != null) {
            stack.push(node.right);
            stack.push(node.left);
        }
    }

    return secMin;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
[ls]: https://github.com/SDE603/LeetCode-Solution