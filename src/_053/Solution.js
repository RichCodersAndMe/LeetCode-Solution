/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
	var max = nums[0]
    var sum = 0
	for (let i = 0; i < nums.length; i++) {
		for (let j = i;j < nums.length; j++){
			sum = sum + nums[j]
			if (sum >= max) {
				max = sum
			}
		}
		sum = 0
	}
	return max
};