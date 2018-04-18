/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s === '') {
        return true
    }
    if (s.length % 2 !== 0) {
        return false
    } else {
		var strArr1 = []
        var num = 0
        for (var i = 0; i < s.length; i++) {
            if (isLeft(s[i])) {
                strArr1.push(s[i])
            } else {
				var pop = strArr1.pop()
                if (!squre(pop, s[i])) {
					console.log(pop)
                    return false
                }
            }
        }
        return (strArr1.length === 0)

    }
    function isLeft(a) {
        return (a==='{'||a==='['||a==='(')
    }
    function squre(a,b) {
        if ((a ==='[' && b ===']') || (a ==='{' && b ==='}') || (a ==='(' && b ===')')) {
            return true
        } else {
            return false
        }
    }
};
