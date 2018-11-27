/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    for(var i = 0; i <= x; i++) {
        if(i*i === x) {
            return i
        }
        if(i*i > x) {
			return i-1
        }
    }
};

var mySqrt = function(x) {
    return Math.floor(Math.sqrt(x))
};