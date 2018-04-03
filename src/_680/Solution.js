/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    var length = s.length, half = length / 2, i;

    function isPalindrome(str) {
        var length = str.length, half = length / 2, i;

        for(i = 0; i < half; i++) {
            if (str[i] !== str[length - i - 1]) return false; 
        }

        return true;
    }

    for(i = 0; i < half; i++) {
        if (s[i] !== s[length - i - 1]) return isPalindrome(s.slice(i, length - i - 1)) || isPalindrome(s.slice(i + 1, length - i));
    }

    return true;
};
