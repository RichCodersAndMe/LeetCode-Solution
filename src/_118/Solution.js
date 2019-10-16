/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
  let arr = []
  for(var i = 1; i <= numRows; i++) {
      if(i === 1) {
          arr.push([1])
          continue
      }
      if(i === 2) {
          arr.push([1, 1])
          continue
      }
      let innerArr = [1]
      for(var j = 2; j < i; j++) {
          innerArr.push(arr[i-2][j-2] + arr[i-2][j-1])
      }
      innerArr.push(1)
      arr.push(innerArr)
  }
  return arr
};