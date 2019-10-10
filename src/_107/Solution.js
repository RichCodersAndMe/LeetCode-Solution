/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
    if (root === null) { return []; }
    let result = [];
    let queue = [root];
    while(queue.length > 0) {
        let size = queue.length;
        let current = [];
        for (let i = 0; i < size; i++) {
            let head = queue.shift();
            current.push(head.val);
            if(head.left !== null) { queue.push(head.left); }
            if(head.right !== null) { queue.push(head.right); }
        }
        result.unshift(current);
    }
    return result;
};