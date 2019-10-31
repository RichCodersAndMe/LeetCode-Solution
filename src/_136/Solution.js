/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  var x = 0
  for(let i = 0; i < nums.length; i++) {
      x = x^nums[i]
  }
  return x
};