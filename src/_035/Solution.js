/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    if (nums.length === 1) {
        return nums[0] >= target?0:1
    }
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] === target) {
            return i
        }
        if (nums[i] < target && target <= nums[i + 1]) {
            return i+1
        }
        if (nums[i] > target) {
            return 0
        }
    }
    return nums.length
};
