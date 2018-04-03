/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var length = nums.length - k + 1, i, ans = Number.NEGATIVE_INFINITY, sum, j;

    for (i = 0; i < length; i++) {
        sum = 0;
        for (j = i; j < k + i; j++) {
            sum += nums[j];
        }
        if (ans < sum / k) ans = sum / k;
    }
    
    return ans;
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var length = nums.length, sum = [], ans;

    for (i = 0; i < length; i++) {
        if (i === 0) sum[i] = nums[i];
        else sum[i] = sum[i - 1] + nums[i];
    }
    ans = sum[k - 1] / k;
    for (i = k; i < length; i++) {
        ans = Math.max(ans, (sum[i] - sum[i - k]) / k);
    }
    
    return ans;
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var length = nums.length, i, sum = 0, ans;

    for (i = 0; i < k; i++) {
        sum += nums[i];
    }
    ans = sum;
    for (i = k; i < length; i++) {
        sum += nums[i] - nums[i - k];
        ans = Math.max(ans, sum);
    }
    ans /= k;

    return ans;
};
