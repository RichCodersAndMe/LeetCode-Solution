/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
  var result = []
  for (var i = left; i <= right; i++ ) {
    if (i < 10) {
      result.push(i)
    } else {
      if (/0/.test(i.toString())) {
        i = i + 1
      }
      for (var j = 0; j < i.toString().length; j++) {
        if (i % Number(i.toString().split('')[j]) !== 0) {
          break
        }
        if (i % Number(i.toString().split('')[j]) === 0 && j === i.toString().length - 1) {
          console.log(i);
          result.push(i)
        }
      }
    }
  }
  return result
};
