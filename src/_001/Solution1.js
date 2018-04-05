/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length - 1; i++) {
        res = target - nums[i]
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[j] === res) {
                return [i, j]
            }
        }
        if (i === nums.length) {
            return []
        }
    }
}