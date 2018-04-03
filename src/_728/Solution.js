/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
    var ans = [], i, arr, j, check = true;

    for(i = left; i <= right; i++) {
        if (/0/.test(i.toString())) continue;
        arr = i.toString().split('');
        check = true;
        for(j = 0; j < arr.length; j++) {
            if (i % Number.parseInt(arr[j], 10) !== 0) {
                check = false;
                break;
            }
        }
        if (check) ans.push(i);
    }

    return ans;
};
