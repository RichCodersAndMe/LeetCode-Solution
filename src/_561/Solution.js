/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    var sum = 0, i, length = nums.length;

    nums.sort(function(a, b) { return a - b; });
    for(i = 0; i < length; i++) {
        if (i % 2 === 0) sum += nums[i];
    }

    return sum;
};

/**
 * 
 * 本来因为耗时问题，想减少循环的次数，结果这个耗时更多233
 * 
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    var sum = 0, i, length = nums.length;

    nums.sort(function(a, b) { return a - b; });
    for(i = 0; i < length; i = i + 2) {
        sum += nums[i];
    }

    return sum;
};
