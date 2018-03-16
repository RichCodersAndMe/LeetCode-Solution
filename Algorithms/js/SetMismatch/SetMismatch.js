/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    var ans = [], i, length = nums.length, s = new Set();

    for (i = 0; i < length; i++) {
        if (s.has(nums[i])) ans.push(nums[i]);
        s.add(nums[i]);
    }
    for (i = 1; i <= length; i++) {
        if (!s.has(i)) ans.push(i);
    }

    return ans;
};

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    var ans = [], i, length = nums.length, prev;

    nums.sort(function(a, b) {
        return a - b;
    });
    for (i = 0; i < length; i++) {
        if (i > 0 && prev === nums[i]) {
            ans.push(nums[i]);
            break;
        }
        prev = nums[i];
    }
    nums.splice(i, 1);
    for (i = 0; i < length; i++) {
        if (nums[i] !== i + 1) {
            ans.push(i + 1);
            break;
        }
    }

    return ans;
};
