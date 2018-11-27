/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    var len1 = a.length - 1,
        len2 = b.length - 1,
        c = '',
        carry = false;
    while(len1 >= 0 && len2 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+a[len1]) + (+b[len2]) >=2) ? true : false
        c =  (x + (+a[len1]) + (+b[len2]) >=2) ? 
        ((x + (+a[len1]) + (+b[len2])) % 2 + c) : 
        (x + (+a[len1]) + (+b[len2])) + c
        len1--;
        len2--;
    }
    while(len2 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+b[len2]) >=2) ? true : false
        c = (x + (+b[len2]) >=2) ? ('0' + c): (x + (+b[len2]) + c)
        len2--;
    }
    while(len1 >= 0) {
        var x = carry ? 1 : 0
        carry = (x + (+a[len1]) >=2) ? true : false
        c = (x + (+a[len1]) >=2) ? ('0' + c): (x + (+a[len1]) + c)
        len1--;
    }
	c = (carry ? '1' : '') + c
    return c
};