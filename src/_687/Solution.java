package _687;

class Solution {
    private int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val + 1);
        return maxLen;
    }

    private int dfs(TreeNode node, int rootVal) {
        if (node == null) return 0;

        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);

        if (node.val == rootVal) {
            return Math.max(left, right) + 1;
        }

        maxLen = Math.max(maxLen, left + right);

        return 0;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}