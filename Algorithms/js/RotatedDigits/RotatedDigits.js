/**
 * @param {number} N
 * @return {number}
 */
var rotatedDigits = function(N) {
    var i, sum = 0;

    for(i = 0; i <= N; i++) {
        if (!/[^0125689]/.test(i.toString()) && /[2569]/.test(i.toString())) sum++;
    }

    return sum;
};
