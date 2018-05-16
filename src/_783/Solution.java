package _783;

import structure.TreeNode;

import java.util.Stack;

class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDiffInBST(TreeNode.createTestData("[4,2,6,1,3,null,null]")));
        System.out.println(solution.minDiffInBST(TreeNode.createTestData("[90,69,null,49,89,null,52,null,null,null,null]")));
        System.out.println(solution.minDiffInBST(TreeNode.createTestData("[27,null,34,null,58,50,null,44,null,null,null]")));
    }
}
