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
var findSecondMinimumValue = function(root) {
    var ans = -1, min = root.val;

    function scan(node) {
        if (node.val > min) {
            if (ans === -1) ans = node.val;
            if (ans > node.val) ans = node.val;
        } else {
            if (node.left) scan(node.left);
            if (node.right) scan(node.right);
        }
    }
    
    scan(root);

    return ans;
};
