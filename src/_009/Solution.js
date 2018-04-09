/**
 * @param {number} x
 * @return {boolean}
 */
var reverse = function(x) {
    var reverse = 0
    var arr = String(x).split('')
    if (x >= 0) {
	    return Number(arr.reverse().join(''))
    } else {
	    return -Number(arr.slice(1,arr.length).reverse().join(''))
    }
    if (reverse >= 0x7fffffff ||reverse < -0x80000000) {
        reverse = 0
    }
    return reverse
};
var isPalindrome = function(x) {
    if (x < 0 ) {
        return false
    }
    if (reverse(x) === x) {
        return true
    } else {
        return false
    }
}; 
