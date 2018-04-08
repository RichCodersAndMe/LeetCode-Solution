/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    var reverse = 0
    var arr = String(x).split('')
    if (x >= 0) {
	    reverse = Number(arr.reverse().join(''))
    } else {
	    reverse = -Number(arr.slice(1,arr.length).reverse().join(''))
    }
    if ((reverse >= Math.pow(2,31) - 1) || (reverse <= -Math.pow(2,31))) {
        reverse = 0
    }
    return reverse
};
