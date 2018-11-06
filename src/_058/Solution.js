var lengthOfLastWord = function(s) {
    var len = s.length - 1;
    for (var i = len; i >= 0; i--) {
        if(s[i] == ' ') {
            len--
        } else {
            break;
        }
    }
    var realLen = len
    for (var i = len; i >= 0; i--) {
        if(s[i] == ' ') {
            break;
        } else {
            len--
        }
    }
	return realLen - len
};
var lengthOfLastWord = function(s) {
    var len = s.length - 1;
    while (len >= 0 && s[len] == ' ') len--;
    var realLen = len;
    while (len >= 0 && s[len] != ' ') len--;
    return realLen - len;
};
