/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function(words) {
    var ans = '', stack = [''], length = words.length, i, reg, wLength;

    words.sort();
    for(i = 0; i < length; i++) {
        wLength = words[i].length;
        if (wLength > stack.length) continue;
        while(wLength < stack.length) stack.pop();
        reg = new RegExp('^' + stack[stack.length - 1]);
        if (reg.test(words[i])) {
            stack.push(words[i]);
            if (wLength > ans.length) ans = words[i]; 
        }
    }

    return ans;
};
