/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
  if(root == null) return true
  var treeDeep = function(root) {
      if(root == null) return 0
      return 1 + Math.max(treeDeep(root.left),treeDeep(root.right))
  }
  leftDeep = treeDeep(root.left)
  rightDeep = treeDeep(root.right)
  if(Math.abs(leftDeep - rightDeep) > 1) {
      return false   
  }
  return isBalanced(root.left) && isBalanced(root.right)
};