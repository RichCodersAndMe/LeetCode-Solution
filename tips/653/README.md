[Two Sum IV - Input is a BST][title]

## Description
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

**Example 1:**

```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

**Example 2:**

```
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

**Tags:** [Tree](https://leetcode.com/tag/tree/)

## 思路

题目要求在搜索二叉树中找到两个数，使其和等于所给值。此题主要考验搜索二叉树的用法。先遍历二叉树，在遍历过程中利用搜索二叉树的特性，查找是否存在另一个节点的值使两个节点的和等于所给的值。例如在遍历到节点a时，查找二叉树中是否存在节点b使a+b=k成立。

**Java**

```java
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num;
        TreeNode next;
        
        // 遍历二叉树
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();

            // 查找二叉树
            next = root;
            num = k - node.val;
            while (next != null) {
                if (next.val == num) {
                    if (next == node) {
                        break;
                    } else {
                        return true;
                    }
                } else if (num > next.val) {
                    next = next.right;
                } else {
                    next = next.left;
                }
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
[ls]: https://github.com/SDE603/LeetCode-Solution