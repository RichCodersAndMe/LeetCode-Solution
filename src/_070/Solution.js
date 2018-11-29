/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if(n == 1) {return 1}
    if(n == 2) {return 2}
    
    var step1 = 1, step2 = 2, x;
    for(var i = 2 ; i < n; i++) {
        x = step2
        step2 += step1
        step1 = x
    }
    return step2
};