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
var minDiffInBST = function(root) { 
    var ans = Infinity, prev = null;
    
    function scan(node) {
        if (node === null) return;
        scan(node.left);
        if (prev !== null) ans = Math.min(ans, node.val - prev);
        prev = node.val;
        scan(node.right);
    }

    scan(root);
    return ans;
};
