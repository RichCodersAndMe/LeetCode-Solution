/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
  let letter = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
  let letterArr = s.split('').reverse()
  let number = 0
  for(let i = 0; i < letterArr.length; i++) {
      let index = letter.findIndex(item => item === letterArr[i]) + 1
      number += i === 0 ? index : index*Math.pow(26,i)
  }
  return number
};