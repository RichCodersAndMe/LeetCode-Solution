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
var longestUnivaluePath = function(root) {
    var ans = 0;

    function arrowLength(node) {
        var left, right, arrowLeft = 0, arrowRight = 0;

        if (node === null) return 0;
        left = arrowLength(node.left);
        right = arrowLength(node.right);
        if (node.left && node.left.val === node.val) arrowLeft = left + 1;
        if (node.right && node.right.val === node.val) arrowRight = right + 1;
        if (arrowLeft + arrowRight > ans) ans = arrowLeft + arrowRight;
        
        return Math.max(arrowLeft, arrowRight);
    }

    arrowLength(root);

    return ans;
};
