/**
 * @param {number} n
 * @return {boolean}
 */
var hasAlternatingBits = function(n) {
    var prev = -1, cur;

    while (n) {
        cur = n % 2;
        if (prev === cur) return false;
        n = Math.floor(n / 2);
        prev = cur;
    }

    return true;
};

/**
 * @param {number} n
 * @return {boolean}
 */
var hasAlternatingBits = function(n) {
    var i, length, s;

    s = n.toString(2);
    length = s.length - 1;
    for (i = 0; i < length; i++) {
        if (s[i] === s[i + 1]) return false;
    }

    return true;
};
