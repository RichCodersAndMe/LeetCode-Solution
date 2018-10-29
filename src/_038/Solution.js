var countAndSay = function(n) {
    var str = '1'
    while(--n > 0) {
        var len = str.length
        var resultStr = ''
        var times = 1;
        for(var i = 0; i < len; i++) {
            if(str[i] === str[i + 1]) {
                times++
            } else {
                resultStr += times + str[i]
                times = 1;
            }
        }
        str = resultStr
    }
    return str
};