/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
  let letter = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
  let lastLetter = n % 26 === 0 ? 'Z' : letter[n % 26 - 1]
  if(n <= 26) {
      return lastLetter
  }
  let nextLetterIndex = (n - (n % 26 === 0 ? 26 : n % 26))/26
  if(Math.floor(nextLetterIndex) <= 26) {
      return letter[Math.floor(nextLetterIndex) - 1] + lastLetter
  } else {
      return convertToTitle(Math.floor(n/26)) + lastLetter
  }
};