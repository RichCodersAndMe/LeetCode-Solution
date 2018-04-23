/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    var len = nums.length
    for(var i = 0; i < len; i++) {
        if (nums[i] === val) {
            nums.splice(i, 1)
            i = i - 1
        }
    }
    return nums.length
};
