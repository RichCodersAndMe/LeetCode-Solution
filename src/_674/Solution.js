/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    var length = nums.length, ans = 0, count = 1, i = 1;

    if (length === 0) return ans;
    do {
        if (nums[i] - nums[i - 1] > 0) count++;
        else count = 1;
        if (count > ans) ans = count;
        i++;
    } while(i < length);

    return ans;
};
