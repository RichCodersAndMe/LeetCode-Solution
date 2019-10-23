/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
  var str = s.toLowerCase()
  let str1 = []
  for(var i = 0; i < str.length; i++) {
    if(/[a-z0-9]/ig.test(str[i])) {
        str1.push(str[i])
    }
  }
  return str1.join('') === str1.reverse().join('')
};