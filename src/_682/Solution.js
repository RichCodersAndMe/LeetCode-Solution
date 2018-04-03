/**
 * @param {string[]} ops
 * @return {number}
 */
var calPoints = function(ops) {
    var length = ops.length, i, ans = 0, stack = [];

    for(i = 0; i < length; i++) {
        switch(ops[i]) {
            case '+':
                if (stack.length === 1) stack.push(stack[0]);
                else if (stack.length > 1) stack.push(stack[stack.length - 1] + stack[stack.length - 2]);
                break;
            case 'D':
                if (stack.length) stack.push(stack[stack.length - 1] * 2);
                break;
            case 'C':
                stack.pop();
                break;
            default:
                stack.push(Number.parseInt(ops[i], 10));
                break;
        }
    }
    for(i = 0, length= stack.length; i < length; i++) ans += stack[i];

    return ans;
};
