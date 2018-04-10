/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let arr = s.split('')
    var obj = {
        I: 1,
        V: 5,
        X: 10,
        L: 50,
        C: 100,
        D: 500,
        M: 1000
    }
    var sum = 0
    for (let i = arr.length - 1; i > 0 ; i--) {
		console.log(arr[i])
		console.log(arr[i - 1])
        if (obj[arr[i]] > obj[arr[i - 1]]) {
            sum = sum - obj[arr[i - 1]]
        } else {
            sum = sum + obj[arr[i - 1]]
        }
    }
    return sum + obj[arr[arr.length - 1]]
};
romanToInt('DCXXI')
