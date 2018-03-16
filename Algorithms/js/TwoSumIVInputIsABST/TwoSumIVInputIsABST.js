/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
    var stack = [], length, lengthInner, i, j;

    function dfs(node) {
        if (node === null) return;
        dfs(node.left);
        stack.push(node.val);
        dfs(node.right);
    }

    dfs(root);
    for (i = 0, length = stack.length - 1; i < length; i++) {
        for (j = i + 1, lengthInner = stack.length; j < lengthInner; j++) {
            if (stack[i] + stack[j] === k) {
                console.log(stack[i]);
                return true;
            }
        }
    }

    return false;
};

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
    var s = new Set();

    function dfs(node) {
        if (node === null) return false;
        if (s.has(k - node.val)) return true;
        s.add(node.val);

        return dfs(node.left) || dfs(node.right);
    }

    return dfs(root);
};

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
    var stack = [], length, lengthInner, i, j;

    function dfs(node) {
        if (node === null) return;
        dfs(node.left);
        stack.push(node.val);
        dfs(node.right);
    }

    dfs(root);
    i = 0;
    j = stack.length - 1;
    while(i < j) {
        if (stack[i] + stack[j] === k) {
            return true;   
        } else if (stack[i] + stack[j] > k) {
            j--;
        } else {
            i++;
        }
    }

    return false;
};
