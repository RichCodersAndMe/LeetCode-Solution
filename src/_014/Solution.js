/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (strs.length === 0) {
        return ''
    } else {
        var prefix = strs[0]
        for (var i = 1; i < strs.length; i++) {
            if (strs[i].length < prefix.length){
                prefix = strs[i]
            }
        }
        while(prefix) {
            var b = strs.every(function (item) {
                return (item.indexOf(prefix) === 0)
            })
            if (b) {
                return prefix
            } else {
                prefix = prefix.substring(0, prefix.length - 1)
            }
        }
		return ''
    }
};
