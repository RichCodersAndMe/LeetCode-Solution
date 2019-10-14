/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
  if(root == null) return 0
  if(root.left === null && root.right === null) {return 1}
  if(root.left === null && root.right !== null) {return 1 + minDepth(root.right)}
  if(root.left !== null && root.right === null) {return 1 + minDepth(root.left)}
  return 1 + Math.min(minDepth(root.left),minDepth(root.right))
};