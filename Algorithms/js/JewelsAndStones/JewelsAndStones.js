/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    var reg, result;
    result = S.match(new RegExp('[' + J + ']', 'g'));
    return result === null ? 0 : result.length;
};
