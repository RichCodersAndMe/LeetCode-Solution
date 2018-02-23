/**
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function(S) {
    var arr, i, j, result = [''], tmp = [], c1, c2, code;

    arr = S.split('');
    for(i = 0; i < arr.length; i++) {
        code = arr[i].charCodeAt();
        for (j = 0; j < result.length; j++) {
            tmp.push(result[j] + arr[i]);
            if (code > 64 && code < 91) tmp.push(result[j] + String.fromCharCode(code + 32));
            if (code > 90 && code < 123) tmp.push(result[j] + String.fromCharCode(code - 32));
        }
        result = tmp;
        tmp = [];
    }

    return result;
};
