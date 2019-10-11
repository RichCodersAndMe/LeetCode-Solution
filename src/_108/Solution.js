/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
  if (nums == null || !nums.length) {
      return null;
  }
  let mid = Math.floor(nums.length / 2)
  let rootNode = new TreeNode(nums[mid])
  rootNode.left = sortedArrayToBST(nums.slice(0, mid))
  rootNode.right = sortedArrayToBST(nums.slice(mid+1))
  return rootNode
};