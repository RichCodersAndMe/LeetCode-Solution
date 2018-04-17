package _653;

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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num;
        TreeNode next;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();

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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}