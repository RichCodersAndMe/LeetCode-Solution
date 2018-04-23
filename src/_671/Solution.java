package _671;

import java.util.Stack;

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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
