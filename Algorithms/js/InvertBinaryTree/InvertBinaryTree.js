/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    var stack = [root], point, temp;
    
    while(stack.length) {
        point = stack.pop();
        if (point !== null) {
            temp = point.left;
            point.left = point.right;
            point.right = temp;
            stack.push(point.left);
            stack.push(point.right);
        }
    }

    return root;
};
