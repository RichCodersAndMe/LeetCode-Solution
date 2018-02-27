/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    var suml = 0, sumr = 0, i, length = nums.length;

    for(i = 0; i < length; i++) {
        sumr += nums[i];
    }
    for(i = 0; i < length; i++) {
        if (i > 0) suml += nums[i-1];
        sumr -= nums[i];
        if (suml === sumr) return i;
    }

    return -1;
};
