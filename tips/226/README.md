[Invert Binary Tree][title]

## Description

Invert a binary tree.

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

to

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**Trivia:**
This problem was inspired by this original tweet by Max Howell:

> Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

**Tags:** 
[tree](https://leetcode.com/tag/tree/)

## 思路
反转二叉树。通过前序遍历，依次调换每个节点的两个子节点即可。
```java
public TreeNode invertTree(TreeNode root) {
	if (root == null || (root.left == null && root.right == null)) {
		return root;
	}

	TreeNode tmpNode = root.left;
	root.left = invertTree(root.right);
	root.right = invertTree(tmpNode);

	return root;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/invert-binary-tree/description/
[ls]: https://github.com/SDE603/LeetCode-Solution

