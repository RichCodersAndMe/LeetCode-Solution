# [Minimum Depth of Binary Tree][title]

## Description

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Tags:** Tree, Depth-first Search, Breadth-first Search


## 思路 0

题意是查找二叉树的最小深度，也就是找到从根结点到叶子节点的最小深度，最容易想到的当然是深搜，如果节点的左右深度都不是 0 的话，说明该节点含有左右子树，所以它的最小高度就是 1 加上其左右子树高度较小者，否则如果左子树为空或者右子树为空或者两者都为空，那么就是 1 加上非空子树高度。

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l != 0 && r != 0) return 1 + Math.min(l, r);
        return l + r + 1;
    }
}
```

kotlin(232ms/83.33%):
```kotlin
class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        if (root.left == null) return minDepth(root.right) + 1
        if (root.right == null) return minDepth(root.left) + 1
        return 1 + Math.min(minDepth(root.left), minDepth(root.right))
    }
}
```

JavaScript：
```JavaScript
var minDepth = function(root) {
  if(root == null) return 0
  if(root.left === null && root.right === null) {return 1}
  if(root.left === null && root.right !== null) {return 1 + minDepth(root.right)}
  if(root.left !== null && root.right === null) {return 1 + minDepth(root.left)}
  return 1 + Math.min(minDepth(root.left),minDepth(root.right))
};
```
## 思路 1

第二种思路就是利用宽搜了，搜索到该层有叶子节点，那就返回该层宽度即可。

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null) {
                    return ans;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ++ans;
        }
        return 520;
    }
}
```


## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/minimum-depth-of-binary-tree
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
