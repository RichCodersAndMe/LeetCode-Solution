/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  let number = []
  for(let i = 0; i < Math.floor(numbers.length/2 + 1); i++) {
      if(numbers[i] <= target && numbers[i] !== numbers[i - 1] ) {
          let firstItem = target - numbers[i]
          let index = numbers.findIndex((item, j) => j!== i &&item === firstItem)
          if(index !== -1) {
              number.push(i + 1, index + 1)
              break
          }
      }
  }
  return number
};