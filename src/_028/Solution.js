/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    if (haystack && needle) {
        var x = haystack.split(needle)
        if (x.length > 1) {
            return x[0].length
        } else {
            return -1
        }
    } else if (haystack === '' && needle !== ''){
        return -1
    } else {
        return 0
    }

};
