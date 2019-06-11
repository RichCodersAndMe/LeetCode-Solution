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
var isSymmetric = function(root) {
    if(root == null) return true
    var x = function(left, right) {
        if(left == null && right == null) return true
        if(left == null || right == null) return false
        if (left.val !== right.val) return false;
        return x(left.left, right.right) && x(left.right, right.left) 
    }
    return x(root.left, root.right)
};